package com.itayfeder.scrambled.utils;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

public class SaltyUtils {

    public static boolean IsSaltable(ItemStack stack) {
        return stack.is(ModTags.SALTABLE);
    }

    public static boolean IsSalted(@Nullable CompoundTag p_43578_) {
        if (p_43578_ == null) return false;
        else {
            return p_43578_.getBoolean("Salted");
        }
    }

    public static ItemStack setSalted(ItemStack p_43550_, boolean salted) {
        p_43550_.getOrCreateTag().putBoolean("Salted", salted);
        return p_43550_;
    }
}
