package com.itayfeder.scrambled.events;

import com.itayfeder.scrambled.ScrambledMod;
import com.itayfeder.scrambled.loot.GingerDungeonModifier;
import com.itayfeder.scrambled.loot.SwordfishFishingModifier;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = ScrambledMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LootModifierEvents {
    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
        event.getRegistry().register(register(new SwordfishFishingModifier.Serializer().setRegistryName(new ResourceLocation(ScrambledMod.MOD_ID,"swordfish_fishing"))));
        event.getRegistry().register(register(new GingerDungeonModifier.Serializer().setRegistryName(new ResourceLocation(ScrambledMod.MOD_ID,"ginger_dungeon"))));
    }

    public static GlobalLootModifierSerializer<?> register(GlobalLootModifierSerializer<?> modifier) {
        return modifier;
    }

}
