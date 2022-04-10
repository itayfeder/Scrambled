package com.itayfeder.scrambled.integration;

import com.itayfeder.scrambled.ScrambledMod;
import com.itayfeder.scrambled.items.FlowerCrownItem;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.ingredients.subtypes.IIngredientSubtypeInterpreter;
import mezz.jei.api.ingredients.subtypes.UidContext;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.ISubtypeRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;

@JeiPlugin
public class JEIAddon implements IModPlugin {
    private static final ResourceLocation ID = new ResourceLocation(ScrambledMod.MOD_ID, "jei_plugin");

    @Override
    public ResourceLocation getPluginUid() {
        return ID;
    }

    @Override
    public void registerItemSubtypes(ISubtypeRegistration registration) {
        //registration.registerSubtypeInterpreter(ItemInit.FLOWER_CROWN.get(), FlowerCrownSubtypeInterpreter.INSTANCE);
    }

    @Override
    public void registerRecipes(@Nonnull IRecipeRegistration registry) {
        registry.addRecipes(RecipeTypes.CRAFTING, FlowerCrownRecipeMaker.createRecipes());
    }

    public static class FlowerCrownSubtypeInterpreter implements IIngredientSubtypeInterpreter<ItemStack> {
        public static final FlowerCrownSubtypeInterpreter INSTANCE = new FlowerCrownSubtypeInterpreter();

        private FlowerCrownSubtypeInterpreter() {
        }

        public String apply(ItemStack itemStack, UidContext uidContext) {

            int[] color = {FlowerCrownItem.getColor(itemStack, 0), FlowerCrownItem.getColor(itemStack, 1), FlowerCrownItem.getColor(itemStack, 2)};
            StringBuilder stringBuilder = new StringBuilder("");
            stringBuilder.append(";").append(color);

            return stringBuilder.toString();
        }
    }
}
