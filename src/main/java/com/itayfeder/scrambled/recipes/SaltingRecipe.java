package com.itayfeder.scrambled.recipes;

import com.itayfeder.scrambled.init.RecipeInit;
import com.itayfeder.scrambled.items.SaltItem;
import com.itayfeder.scrambled.utils.SaltyUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;

public class SaltingRecipe extends CustomRecipe {
    public SaltingRecipe(ResourceLocation p_43833_) {
        super(p_43833_);
    }

    @Override
    public boolean matches(CraftingContainer p_44308_, Level p_44309_) {
        ItemStack itemstack = ItemStack.EMPTY;
        ItemStack itemstack1 = ItemStack.EMPTY;

        for(int i = 0; i < p_44308_.getContainerSize(); ++i) {
            ItemStack itemstack2 = p_44308_.getItem(i);
            if (!itemstack2.isEmpty()) {
                if (itemstack2.getItem() instanceof SaltItem) {
                    if (!itemstack1.isEmpty()) {
                        return false;
                    }

                    itemstack1 = itemstack2;
                } else {
                    if (!SaltyUtils.IsSaltable(itemstack2) || SaltyUtils.IsSalted(itemstack2.getTag())) {
                        return false;
                    }

                    if (!itemstack.isEmpty()) {
                        return false;
                    }

                    if (BlockItem.getBlockEntityData(itemstack2) != null) {
                        return false;
                    }

                    itemstack = itemstack2;
                }
            }
        }

        return !itemstack.isEmpty() && !itemstack1.isEmpty();
    }

    @Override
    public ItemStack assemble(CraftingContainer p_44001_) {
        ItemStack itemstack = ItemStack.EMPTY;
        ItemStack itemstack1 = ItemStack.EMPTY;

        for(int i = 0; i < p_44001_.getContainerSize(); ++i) {
            ItemStack itemstack2 = p_44001_.getItem(i);
            if (!itemstack2.isEmpty()) {
                if (itemstack2.getItem() instanceof SaltItem) {
                    itemstack = itemstack2;
                } else if (SaltyUtils.IsSaltable(itemstack2)) {
                    itemstack1 = itemstack2.copy();
                }
            }
        }
        ItemStack itemstack1copy = itemstack1.copy();
        if (itemstack1copy.isEmpty()) {
            return itemstack1copy;
        } else {
            itemstack1copy.setCount(1);
            SaltyUtils.setSalted(itemstack1copy, true);
            return itemstack1copy;
        }
    }

    public boolean canCraftInDimensions(int p_43759_, int p_43760_) {
        return p_43759_ * p_43760_ >= 2;
    }

    public RecipeSerializer<?> getSerializer() {
        return RecipeInit.SALTING.get();
    }
}
