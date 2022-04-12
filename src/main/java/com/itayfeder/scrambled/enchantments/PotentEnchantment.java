package com.itayfeder.scrambled.enchantments;

import com.itayfeder.scrambled.init.EnchantmentInit;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class PotentEnchantment extends Enchantment {
    public PotentEnchantment(Enchantment.Rarity p_44648_, EquipmentSlot... p_44649_) {
        super(p_44648_, EnchantmentInit.RING_CATEGORY, p_44649_);
    }

    public int getMinCost(int p_44666_) {
        return 1 + 10 * (p_44666_ - 1);
    }

    public int getMaxCost(int p_44670_) {
        return super.getMinCost(p_44670_) + 50;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
}
