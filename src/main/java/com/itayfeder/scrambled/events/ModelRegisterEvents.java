package com.itayfeder.scrambled.events;

import com.itayfeder.scrambled.ScrambledMod;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ForgeModelBakery;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ScrambledMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModelRegisterEvents {

    @SubscribeEvent
    public static void modelRegistry(ModelRegistryEvent event) {
        ForgeModelBakery.addSpecialModel(new ModelResourceLocation(ScrambledMod.MOD_ID + ":phantom_item_frame_block", "inventory"));
        ForgeModelBakery.addSpecialModel(new ModelResourceLocation(ScrambledMod.MOD_ID + ":phantom_item_frame_map_block", "inventory"));
        //ForgeModelBakery.addSpecialModel(new ModelResourceLocation(RandomMod.MOD_ID + ":phantom_item_frame", "map=false"));
        //ForgeModelBakery.addSpecialModel(new ModelResourceLocation(RandomMod.MOD_ID + ":phantom_item_frame", "map=true"));
    }
}
