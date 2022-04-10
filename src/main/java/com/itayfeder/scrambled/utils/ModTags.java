package com.itayfeder.scrambled.utils;

import com.itayfeder.scrambled.ScrambledMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {
    public static final TagKey<Item> CROWN_FLOWERS = createItemTag("crown_flowers");
    public static final TagKey<Item> SALTABLE = createItemTag("saltable");

    private static TagKey<Item> createItemTag(String name) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(ScrambledMod.MOD_ID, name));
    }
}
