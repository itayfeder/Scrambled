package com.itayfeder.scrambled.client.gui;

import com.itayfeder.scrambled.ScrambledMod;
import com.itayfeder.scrambled.menus.ConductorMenu;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class ConductorScreen extends AbstractContainerScreen<ConductorMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(ScrambledMod.MOD_ID, "textures/gui/conductor.png");

    public ConductorScreen(ConductorMenu p_97825_, Inventory p_97827_, Component p_97828_) {
        super(p_97825_, p_97827_, p_97828_);
    }

    public void render(PoseStack p_98341_, int p_98342_, int p_98343_, float p_98344_) {
        this.renderBackground(p_98341_);
        super.render(p_98341_, p_98342_, p_98343_, p_98344_);
        this.renderTooltip(p_98341_, p_98342_, p_98343_);
    }

    protected void renderBg(PoseStack p_97853_, float p_97854_, int p_97855_, int p_97856_) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        this.blit(p_97853_, i, j, 0, 0, this.imageWidth, this.imageHeight);
    }
}
