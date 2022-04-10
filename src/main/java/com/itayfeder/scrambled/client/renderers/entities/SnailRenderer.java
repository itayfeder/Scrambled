package com.itayfeder.scrambled.client.renderers.entities;

import com.itayfeder.scrambled.ScrambledMod;
import com.itayfeder.scrambled.client.models.entities.SnailModel;
import com.itayfeder.scrambled.entities.Snail;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SnailRenderer extends MobRenderer<Snail, SnailModel<Snail>> {
    private static final ResourceLocation SNAIL_LOCATION = new ResourceLocation(ScrambledMod.MOD_ID, "textures/entity/snail/snail.png");
    private static final ResourceLocation GARY_LOCATION = new ResourceLocation(ScrambledMod.MOD_ID, "textures/entity/snail/gary.png");

    public SnailRenderer(EntityRendererProvider.Context p_174304_, SnailModel<Snail> p_174305_, float p_174306_) {
        super(p_174304_, p_174305_, p_174306_);
    }

    public SnailRenderer(EntityRendererProvider.Context p_173956_) {
        super(p_173956_, new SnailModel<>(p_173956_.bakeLayer(SnailModel.LAYER_LOCATION)), 0.25F);
    }

    @Override
    public ResourceLocation getTextureLocation(Snail p_110775_1_) {
        if ("Gary".equals(p_110775_1_.getName().getString())) {
            return GARY_LOCATION;
        } else {
            return SNAIL_LOCATION;
        }
    }
}
