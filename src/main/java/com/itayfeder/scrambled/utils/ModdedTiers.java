package com.itayfeder.scrambled.utils;

import net.minecraft.tags.BlockTags;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModdedTiers implements Tier {
    SWORDFISH(2, 250, 10.0F, 2.5F, 20, () -> {
        return Ingredient.of();
    }),
    COPPER(1, 223, 5.0F, 1.5F, 7, () -> {
        return Ingredient.of(Items.COPPER_INGOT);
    });

    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    private ModdedTiers(int p_43332_, int p_43333_, float p_43334_, float p_43335_, int p_43336_, Supplier<Ingredient> p_43337_) {
        this.level = p_43332_;
        this.uses = p_43333_;
        this.speed = p_43334_;
        this.damage = p_43335_;
        this.enchantmentValue = p_43336_;
        this.repairIngredient = new LazyLoadedValue<>(p_43337_);
    }

    public int getUses() {
        return this.uses;
    }

    public float getSpeed() {
        return this.speed;
    }

    public float getAttackDamageBonus() {
        return this.damage;
    }

    public int getLevel() {
        return this.level;
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @javax.annotation.Nullable public net.minecraft.tags.TagKey<net.minecraft.world.level.block.Block> getTag() {
        return switch(this)
            {
                case SWORDFISH -> BlockTags.NEEDS_IRON_TOOL;
                case COPPER -> BlockTags.NEEDS_IRON_TOOL;
            };
    }

}
