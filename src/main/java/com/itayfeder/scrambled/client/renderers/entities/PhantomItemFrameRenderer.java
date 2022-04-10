package com.itayfeder.scrambled.client.renderers.entities;

import com.itayfeder.scrambled.ScrambledMod;
import com.itayfeder.scrambled.entities.decoration.PhantomItemFrame;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MapItem;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import net.minecraft.world.phys.Vec3;

public class PhantomItemFrameRenderer<T extends PhantomItemFrame> extends EntityRenderer<T> {
    private static final ModelResourceLocation FRAME_LOCATION = new ModelResourceLocation(ScrambledMod.MOD_ID + ":phantom_item_frame_block", "inventory");
    private static final ModelResourceLocation MAP_FRAME_LOCATION = new ModelResourceLocation(ScrambledMod.MOD_ID + ":phantom_item_frame_map_block", "inventory");
    private final Minecraft minecraft = Minecraft.getInstance();
    private final ItemRenderer itemRenderer;

    public PhantomItemFrameRenderer(EntityRendererProvider.Context p_174204_) {
        super(p_174204_);
        this.itemRenderer = p_174204_.getItemRenderer();
    }

    public void render(T p_115076_, float p_115077_, float p_115078_, PoseStack p_115079_, MultiBufferSource p_115080_, int p_115081_) {
        super.render(p_115076_, p_115077_, p_115078_, p_115079_, p_115080_, p_115081_);
        p_115079_.pushPose();
        Direction direction = p_115076_.getDirection();
        Vec3 vec3 = this.getRenderOffset(p_115076_, p_115078_);
        p_115079_.translate(-vec3.x(), -vec3.y(), -vec3.z());
        double d0 = 0.46875D;
        p_115079_.translate((double)direction.getStepX() * 0.46875D, (double)direction.getStepY() * 0.46875D, (double)direction.getStepZ() * 0.46875D);
        p_115079_.mulPose(Vector3f.XP.rotationDegrees(p_115076_.getXRot()));
        p_115079_.mulPose(Vector3f.YP.rotationDegrees(180.0F - p_115076_.getYRot()));
        boolean flag = p_115076_.isInvisible();
        ItemStack itemstack = p_115076_.getItem();
        if (!flag) {
            BlockRenderDispatcher blockrenderdispatcher = this.minecraft.getBlockRenderer();
            ModelManager modelmanager = blockrenderdispatcher.getBlockModelShaper().getModelManager();
            ModelResourceLocation modelresourcelocation = p_115076_.getItem().getItem() instanceof MapItem ? MAP_FRAME_LOCATION : FRAME_LOCATION;
            p_115079_.pushPose();
            p_115079_.translate(-0.5D, -0.5D, -0.5D);
            blockrenderdispatcher.getModelRenderer().renderModel(p_115079_.last(), p_115080_.getBuffer(Sheets.solidBlockSheet()), (BlockState)null, modelmanager.getModel(modelresourcelocation), 1.0F, 1.0F, 1.0F, p_115081_, OverlayTexture.NO_OVERLAY);
            p_115079_.popPose();
        }

        if (!itemstack.isEmpty()) {
            MapItemSavedData mapitemsaveddata = MapItem.getSavedData(itemstack, p_115076_.level);
            p_115079_.translate(0.0D, 0.0D, 0.47875D);


            int j = mapitemsaveddata != null ? p_115076_.getRotation() % 4 * 2 : p_115076_.getRotation();
            p_115079_.mulPose(Vector3f.ZP.rotationDegrees((float)j * 360.0F / 8.0F));
            if (mapitemsaveddata != null) {
                p_115079_.mulPose(Vector3f.ZP.rotationDegrees(180.0F));
                float f = 0.0078125F;
                p_115079_.scale(0.0078125F, 0.0078125F, 0.0078125F);
                p_115079_.translate(-64.0D, -64.0D, 0.0D);
                Integer integer = MapItem.getMapId(itemstack);
                p_115079_.translate(0.0D, 0.0D, -1.0D);
                if (mapitemsaveddata != null) {
                    int i = p_115081_;
                    this.minecraft.gameRenderer.getMapRenderer().render(p_115079_, p_115080_, integer, mapitemsaveddata, true, i);
                }
            } else {
                int k = p_115081_;
                p_115079_.scale(0.5F, 0.5F, 0.5F);
                this.itemRenderer.renderStatic(itemstack, ItemTransforms.TransformType.FIXED, k, OverlayTexture.NO_OVERLAY, p_115079_, p_115080_, p_115076_.getId());
            }
        }

        p_115079_.popPose();
    }

    @Override
    public ResourceLocation getTextureLocation(T p_115071_) {
        return TextureAtlas.LOCATION_BLOCKS;
    }

}
