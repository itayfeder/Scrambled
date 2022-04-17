package com.itayfeder.scrambled.items;

import com.itayfeder.scrambled.ScrambledMod;
import net.minecraft.Util;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class FlowerCrownItem extends ArmorItem {
    public static final Map<Block, Integer> FLOWER_TO_COLOR = Util.make(new HashMap<>(), (p_29841_) -> {
        p_29841_.put(Blocks.DANDELION, 16700985);
        p_29841_.put(Blocks.POPPY, 15544364);
        p_29841_.put(Blocks.BLUE_ORCHID, 2801661);
        p_29841_.put(Blocks.ALLIUM, 12089581);

        p_29841_.put(Blocks.CORNFLOWER, 4614891);
        p_29841_.put(Blocks.LILY_OF_THE_VALLEY, 15198183);
        p_29841_.put(Blocks.WITHER_ROSE, 4338990);
    });

    public FlowerCrownItem(Properties p_40388_) {
        super(ArmorMaterials.LEATHER, EquipmentSlot.HEAD, p_40388_);
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        String s1 = String.format(java.util.Locale.ROOT, ScrambledMod.MOD_ID + ":textures/models/armor/%s_layer_%d%s.png", "flower_crown", (slot == EquipmentSlot.LEGS ? 2 : 1), type == null ? "" : String.format(java.util.Locale.ROOT, "_%s", type));
        return s1;
    }

    @Override
    public void fillItemCategory(CreativeModeTab p_41391_, NonNullList<ItemStack> p_41392_) {
        if (this.allowdedIn(p_41391_)) {
            ItemStack stack = new ItemStack(this);
            int[] colors = {FLOWER_TO_COLOR.get(Blocks.DANDELION), FLOWER_TO_COLOR.get(Blocks.DANDELION), FLOWER_TO_COLOR.get(Blocks.POPPY)};
            setColor(stack, colors);
            p_41392_.add(stack);
        }
    }

    @Override
    public ItemStack getDefaultInstance() {
        ItemStack stack = new ItemStack(this);
        int[] colors = {FLOWER_TO_COLOR.get(Blocks.DANDELION), FLOWER_TO_COLOR.get(Blocks.DANDELION), FLOWER_TO_COLOR.get(Blocks.POPPY)};
        setColor(stack, colors);
        return stack;
    }

    public static boolean hasCustomColor(ItemStack p_41114_) {
        CompoundTag compoundtag = p_41114_.getTagElement("display");
        return compoundtag != null && compoundtag.contains("colors", 11);
    }

    public static int getColor(ItemStack p_41122_, int id) {
        CompoundTag compoundtag = p_41122_.getTagElement("display");
        if (compoundtag != null && compoundtag.contains("colors", 11)) {
            int[] colors = compoundtag.getIntArray("colors");
            return colors.length > id ? colors[id] : 10511680;
        } else
            return 10511680;
    }

    public static void clearColor(ItemStack p_41124_, int id) {
        CompoundTag compoundtag = p_41124_.getTagElement("display");
        if (compoundtag != null && compoundtag.contains("colors")) {
            int[] colors = compoundtag.getIntArray("colors");
            colors[id] = 10511680;
            compoundtag.putIntArray("colors", colors);
        }

    }

    public static void setColor(ItemStack p_41116_, int[] p_41117_) {
        p_41116_.getOrCreateTagElement("display").putIntArray("colors", p_41117_);
    }
}
