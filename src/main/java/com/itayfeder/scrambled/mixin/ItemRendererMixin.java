package com.itayfeder.scrambled.mixin;

import com.itayfeder.scrambled.items.charged.IChargedTool;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {

    @Inject(locals = LocalCapture.NO_CAPTURE,
            method = "renderGuiItemDecorations(Lnet/minecraft/client/gui/Font;Lnet/minecraft/world/item/ItemStack;IILjava/lang/String;)V",
            at = @At(value = "TAIL"),
            cancellable = true
    )
    private void renderGuiItemDecorationsInject(Font multibuffersource$buffersource, ItemStack item, int i2, int j2, String str, CallbackInfo ci) {
        if (item.getItem() instanceof IChargedTool && IChargedTool.isChargeBarVisible(item)) {
            RenderSystem.disableDepthTest();
            RenderSystem.disableTexture();
            RenderSystem.disableBlend();
            Tesselator tesselator = Tesselator.getInstance();
            BufferBuilder bufferbuilder = tesselator.getBuilder();
            int i = IChargedTool.getChargeBarWidth(item);
            int j = IChargedTool.getChargeBarColor();
            if (item.isBarVisible()) {
                this.fillRect(bufferbuilder, i2 + 2, j2 + 11, 13, 2, 0, 0, 0, 255);
                this.fillRect(bufferbuilder, i2 + 2, j2 + 11, i, 1, j >> 16 & 255, j >> 8 & 255, j & 255, 255);
            } else {
                this.fillRect(bufferbuilder, i2 + 2, j2 + 13, 13, 2, 0, 0, 0, 255);
                this.fillRect(bufferbuilder, i2 + 2, j2 + 13, i, 1, j >> 16 & 255, j >> 8 & 255, j & 255, 255);
            }
            RenderSystem.enableBlend();
            RenderSystem.enableTexture();
            RenderSystem.enableDepthTest();
        }
    }

    private void fillRect(BufferBuilder p_115153_, int p_115154_, int p_115155_, int p_115156_, int p_115157_, int p_115158_, int p_115159_, int p_115160_, int p_115161_) {
        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        p_115153_.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
        p_115153_.vertex((double)(p_115154_ + 0), (double)(p_115155_ + 0), 0.0D).color(p_115158_, p_115159_, p_115160_, p_115161_).endVertex();
        p_115153_.vertex((double)(p_115154_ + 0), (double)(p_115155_ + p_115157_), 0.0D).color(p_115158_, p_115159_, p_115160_, p_115161_).endVertex();
        p_115153_.vertex((double)(p_115154_ + p_115156_), (double)(p_115155_ + p_115157_), 0.0D).color(p_115158_, p_115159_, p_115160_, p_115161_).endVertex();
        p_115153_.vertex((double)(p_115154_ + p_115156_), (double)(p_115155_ + 0), 0.0D).color(p_115158_, p_115159_, p_115160_, p_115161_).endVertex();
        p_115153_.end();
        BufferUploader.end(p_115153_);
    }
}
