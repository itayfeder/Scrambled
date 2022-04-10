package com.itayfeder.scrambled.recipes.energizing;

import com.itayfeder.scrambled.ScrambledMod;
import net.minecraft.world.item.crafting.RecipeType;

public class EnergizingRecipeType implements RecipeType<EnergizingRecipe> {

    @Override
    public String toString () {
        return ScrambledMod.MOD_ID + ":energizing";
    }
}