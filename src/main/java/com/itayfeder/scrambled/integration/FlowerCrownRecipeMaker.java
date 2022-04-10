package com.itayfeder.scrambled.integration;

import com.itayfeder.scrambled.ScrambledMod;
import com.itayfeder.scrambled.init.ItemInit;
import com.itayfeder.scrambled.items.FlowerCrownItem;
import com.itayfeder.scrambled.utils.ModTags;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.FlowerBlock;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class FlowerCrownRecipeMaker {
    public static List<CraftingRecipe> createRecipes() {
        String group = "jei.flower.crown";
        Ingredient string = Ingredient.of(new ItemLike[]{Items.STRING.asItem()});
        Ingredient flowers = Ingredient.of(ModTags.CROWN_FLOWERS);
        Objects.requireNonNull(BlockItem.class);
        NonNullList<Ingredient> inputs = NonNullList.of(Ingredient.EMPTY, new Ingredient[]{string, string, string, flowers, flowers, flowers});
        ItemStack output = new ItemStack(ItemInit.FLOWER_CROWN.get(), 1);
        int[] colors = new int[3];

        Random rnd = new Random();
        ItemStack flower1 = flowers.getItems()[rnd.nextInt(flowers.getItems().length)];
        ItemStack flower2 = flowers.getItems()[rnd.nextInt(flowers.getItems().length)];
        ItemStack flower3 = flowers.getItems()[rnd.nextInt(flowers.getItems().length)];

        colors[0] = FlowerCrownItem.FLOWER_TO_COLOR.get(((FlowerBlock)((BlockItem)flower1.getItem()).getBlock()));
        colors[1] = FlowerCrownItem.FLOWER_TO_COLOR.get(((FlowerBlock)((BlockItem)flower2.getItem()).getBlock()));
        colors[2] = FlowerCrownItem.FLOWER_TO_COLOR.get(((FlowerBlock)((BlockItem)flower3.getItem()).getBlock()));
        FlowerCrownItem.setColor(output, colors);
        ResourceLocation id = new ResourceLocation(ScrambledMod.MOD_ID, "jei.flower.crown");
        List<CraftingRecipe> recipe = new ArrayList<>();
        recipe.add(new ShapedRecipe(id, group, 3, 3, inputs, output));
        return recipe;
    }
}
