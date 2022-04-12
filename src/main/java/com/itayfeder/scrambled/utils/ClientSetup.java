package com.itayfeder.scrambled.utils;

import com.itayfeder.scrambled.ScrambledMod;
import com.itayfeder.scrambled.client.gui.ConductorScreen;
import com.itayfeder.scrambled.client.models.entities.SnailModel;
import com.itayfeder.scrambled.client.renderers.entities.SnailRenderer;
import com.itayfeder.scrambled.init.EntityTypeInit;
import com.itayfeder.scrambled.init.ItemInit;
import com.itayfeder.scrambled.init.MenuInit;
import com.itayfeder.scrambled.items.charged.IChargedTool;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ScrambledMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {
    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void init(final FMLClientSetupEvent event) {
        EntityRenderers.register(EntityTypeInit.LIGHTNING_IN_A_BOTTLE.get(), ThrownItemRenderer::new);
        EntityRenderers.register(EntityTypeInit.SNAIL.get(), SnailRenderer::new);

        MenuScreens.register(MenuInit.CONDUCTOR.get(), ConductorScreen::new);

        ItemProperties.register(ItemInit.COPPER_SWORD.get(), new ResourceLocation("charged"), (p_174610_, p_174611_, p_174612_, p_174613_) -> {
            return IChargedTool.isChargeBarVisible(p_174610_) ? 1.0F : 0.0F;
        });
        ItemProperties.register(ItemInit.COPPER_SHOVEL.get(), new ResourceLocation("charged"), (p_174610_, p_174611_, p_174612_, p_174613_) -> {
            return IChargedTool.isChargeBarVisible(p_174610_) ? 1.0F : 0.0F;
        });
        ItemProperties.register(ItemInit.COPPER_PICKAXE.get(), new ResourceLocation("charged"), (p_174610_, p_174611_, p_174612_, p_174613_) -> {
            return IChargedTool.isChargeBarVisible(p_174610_) ? 1.0F : 0.0F;
        });
        ItemProperties.register(ItemInit.COPPER_AXE.get(), new ResourceLocation("charged"), (p_174610_, p_174611_, p_174612_, p_174613_) -> {
            return IChargedTool.isChargeBarVisible(p_174610_) ? 1.0F : 0.0F;
        });
        ItemProperties.register(ItemInit.COPPER_HOE.get(), new ResourceLocation("charged"), (p_174610_, p_174611_, p_174612_, p_174613_) -> {
            return IChargedTool.isChargeBarVisible(p_174610_) ? 1.0F : 0.0F;
        });
    }

    @SubscribeEvent
    public static void onLayerRenderer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(SnailModel.LAYER_LOCATION, SnailModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void addLayers(EntityRenderersEvent.AddLayers event) {

    }
}
