package com.itayfeder.scrambled.items.charged;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

public interface IChargedTool {
    public static final int MAX_CHARGE = 10 * 60 * 20;

    public static int getChargeBarColor() {
        return Mth.hsvToRgb(0.5F, 0.4F, 1.0F);
    }

    public static int getChargeBarWidth(ItemStack item) {
        return Math.round((float)getChargeTimer(item.getOrCreateTag()) * 13.0F / (float)MAX_CHARGE);
    }

    public static boolean isChargeBarVisible(ItemStack item) {
        return getChargeTimer(item.getOrCreateTag()) > 0;
    }

    public static ItemStack setChargeTimer(ItemStack p_43550_, int chargeTimer) {
        if (chargeTimer <= 0) {
            p_43550_.removeTagKey("ChargeTimer");
            p_43550_.getOrCreateTag().putBoolean("Charged", false);

        } else {
            p_43550_.getOrCreateTag().putInt("ChargeTimer", chargeTimer);
            p_43550_.getOrCreateTag().putBoolean("Charged", true);
        }

        return p_43550_;
    }

    public static int getChargeTimer(@Nullable CompoundTag p_43578_) {
        if (p_43578_ == null) return 0;
        else {
            return p_43578_.getInt("ChargeTimer");
        }
    }


}
