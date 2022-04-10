package com.itayfeder.scrambled.recipes;

import com.itayfeder.scrambled.init.ItemInit;
import com.itayfeder.scrambled.init.RecipeInit;
import com.itayfeder.scrambled.items.FlowerCrownItem;
import com.itayfeder.scrambled.utils.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FlowerBlock;

public class FlowerCrownRecipe extends CustomRecipe {
    public FlowerCrownRecipe(ResourceLocation p_44503_) {
        super(p_44503_);
    }

    public boolean matches(CraftingContainer p_44515_, Level p_44516_) {
        if (p_44515_.getWidth() == 3 && p_44515_.getHeight() == 3) {
            for(int i = 0; i < p_44515_.getWidth(); ++i) {
                for(int j = 0; j < p_44515_.getHeight(); ++j) {
                    ItemStack itemstack = p_44515_.getItem(i + j * p_44515_.getWidth());

                    if (j == 0) {
                        if (!itemstack.is(Items.STRING)) {
                            return false;
                        }
                    }
                    else if (j == 1) {
                        if (!itemstack.is(ModTags.CROWN_FLOWERS)) {
                            return false;
                        }
                    }
                }
            }

            return true;
        } else {
            return false;
        }
    }

    public ItemStack assemble(CraftingContainer p_44513_) {
        ItemStack flower1 = p_44513_.getItem(p_44513_.getWidth());
        ItemStack flower2 = p_44513_.getItem(1 + p_44513_.getWidth());
        ItemStack flower3 = p_44513_.getItem(2 + p_44513_.getWidth());
        if (!flower1.is(ModTags.CROWN_FLOWERS) || !flower2.is(ModTags.CROWN_FLOWERS) || !flower3.is(ModTags.CROWN_FLOWERS)) {
            return ItemStack.EMPTY;
        } else {
            ItemStack itemstack1 = new ItemStack(ItemInit.FLOWER_CROWN.get(), 1);
            int[] colors = new int[3];
            colors[0] = FlowerCrownItem.FLOWER_TO_COLOR.get(((FlowerBlock)((BlockItem)flower1.getItem()).getBlock()));
            colors[1] = FlowerCrownItem.FLOWER_TO_COLOR.get(((FlowerBlock)((BlockItem)flower2.getItem()).getBlock()));
            colors[2] = FlowerCrownItem.FLOWER_TO_COLOR.get(((FlowerBlock)((BlockItem)flower3.getItem()).getBlock()));
            FlowerCrownItem.setColor(itemstack1, colors);
            return itemstack1;
        }
    }

    public boolean canCraftInDimensions(int p_44505_, int p_44506_) {
        return p_44505_ >= 2 && p_44506_ >= 2;
    }

    public RecipeSerializer<?> getSerializer() {
        return RecipeInit.FLOWER_CROWN.get();
    }
}
