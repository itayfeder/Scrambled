package com.itayfeder.scrambled.init;

import com.itayfeder.scrambled.ScrambledMod;
import com.itayfeder.scrambled.recipes.FlowerCrownRecipe;
import com.itayfeder.scrambled.recipes.SaltingRecipe;
import com.itayfeder.scrambled.recipes.energizing.EnergizingRecipe;
import com.itayfeder.scrambled.recipes.energizing.EnergizingRecipeType;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SimpleRecipeSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RecipeInit {
    public static DeferredRegister<RecipeSerializer<?>> RECIPE_TYPES = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ScrambledMod.MOD_ID);

    public static final RegistryObject<RecipeSerializer<FlowerCrownRecipe>> FLOWER_CROWN = RECIPE_TYPES.register("special_flowercrown", () -> new SimpleRecipeSerializer<>(FlowerCrownRecipe::new));
    public static final RegistryObject<RecipeSerializer<SaltingRecipe>> SALTING = RECIPE_TYPES.register("special_salting", () -> new SimpleRecipeSerializer<>(SaltingRecipe::new));

    public static final RecipeType<EnergizingRecipe> ENERGIZING_RECIPE = new EnergizingRecipeType();

    public static void registerRecipeSerializers(RegistryEvent.Register<RecipeSerializer<?>> event) {
        Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(ENERGIZING_RECIPE.toString()), ENERGIZING_RECIPE);
        event.getRegistry().register(EnergizingRecipe.SERIALIZER);
    }
}
