package com.itayfeder.scrambled.utils;

import com.itayfeder.scrambled.ScrambledMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class ItemTags {
        public static final TagKey<Item> CROWN_FLOWERS = createItemTag("crown_flowers");
        public static final TagKey<Item> SALTABLE = createItemTag("saltable");
        public static final TagKey<Item> MAHOGANY_LOGS = createItemTag("mahogany_logs");

        private static TagKey<Item> createItemTag(String name) {
            return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(ScrambledMod.MOD_ID, name));
        }
    }

    public static class BlockTags {
        public static final TagKey<Block> MAHOGANY_LOGS = createBlockTag("mahogany_logs");

        private static TagKey<Block> createBlockTag(String name) {
            return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(ScrambledMod.MOD_ID, name));
        }
    }

}
