package com.itayfeder.scrambled.events;

import com.itayfeder.scrambled.ScrambledMod;
import com.itayfeder.scrambled.init.ItemInit;
import com.itayfeder.scrambled.items.FlowerCrownItem;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ScrambledMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ColorEvents {
    @SubscribeEvent
    public static void registerColorHandlers(ColorHandlerEvent.Item event) {

        registerItemColorHandlers(event.getItemColors());
    }

    private static void registerItemColorHandlers(final ItemColors itemColors) {
        itemColors.register(ColorEvents::getColor, ItemInit.FLOWER_CROWN.get());
    }

    private static int getColor(ItemStack stack, int id) {
        if (id >= 1 && id <= 3) return FlowerCrownItem.getColor(stack, id-1);
        return -1;
    }
}
