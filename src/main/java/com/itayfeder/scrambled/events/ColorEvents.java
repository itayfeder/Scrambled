package com.itayfeder.scrambled.events;

import com.itayfeder.scrambled.ScrambledMod;
import com.itayfeder.scrambled.init.BlockInit;
import com.itayfeder.scrambled.init.ItemInit;
import com.itayfeder.scrambled.items.FlowerCrownItem;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ScrambledMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ColorEvents {
    @SubscribeEvent
    public static void registerColorHandlers(ColorHandlerEvent.Item event) {
        registerItemColorHandlers(event.getItemColors(), event.getBlockColors());
        registerBlockColorHandlers(event.getBlockColors());
    }

    private static void registerItemColorHandlers(final ItemColors itemColors, final BlockColors blockColors) {
        itemColors.register(ColorEvents::getColor, ItemInit.FLOWER_CROWN.get());
        itemColors.register((p_92687_, p_92688_) -> {
            BlockState blockstate = ((BlockItem)p_92687_.getItem()).getBlock().defaultBlockState();
            return blockColors.getColor(blockstate, (BlockAndTintGetter)null, (BlockPos)null, p_92688_);
        }, ItemInit.MAHOGANY_LEAVES.get());
    }

    private static void registerBlockColorHandlers(final BlockColors blockColors) {
        blockColors.register((p_92641_, p_92642_, p_92643_, p_92644_) -> {
            return p_92642_ != null && p_92643_ != null ? BiomeColors.getAverageGrassColor(p_92642_, p_92643_) : GrassColor.get(0.5D, 1.0D);
        }, BlockInit.MAHOGANY_LEAVES.get());
    }

    private static int getColor(ItemStack stack, int id) {
        if (id >= 1 && id <= 3) return FlowerCrownItem.getColor(stack, id-1);
        return -1;
    }
}
