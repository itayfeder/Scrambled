package com.itayfeder.scrambled.recipes.energizing;

import com.google.gson.JsonObject;
import com.itayfeder.scrambled.ScrambledMod;
import com.itayfeder.scrambled.init.BlockInit;
import com.itayfeder.scrambled.init.RecipeInit;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class EnergizingRecipe implements Recipe<Container> {
    public static final Serializer SERIALIZER = new Serializer();

    public final Ingredient item;
    public final ItemStack result;
    private final ResourceLocation id;

    public EnergizingRecipe(ResourceLocation p_i231600_1_, Ingredient p_i231600_2_, ItemStack p_i231600_3_) {
        this.id = p_i231600_1_;
        this.item = p_i231600_2_;
        this.result = p_i231600_3_;
    }

    @Override
    public boolean matches(Container p_44002_, Level p_44003_) {
        return this.item.test(p_44002_.getItem(0));
    }

    public ItemStack assemble(Container p_44531_) {
        ItemStack itemstack = this.result.copy();
        CompoundTag compoundtag = p_44531_.getItem(0).getTag();
        int count = p_44531_.getItem(0).getCount();
        if (compoundtag != null) {
            itemstack.setTag(compoundtag.copy());
        }
        itemstack.setCount(count);
        return itemstack;

    }

    public ItemStack getToastSymbol() {
        return new ItemStack(BlockInit.CONDUCTOR.get());
    }

    public boolean canCraftInDimensions(int p_44528_, int p_44529_) {
        return true;
    }

    public ItemStack getResultItem() {
        return this.result;
    }

    public ResourceLocation getId() {
        return this.id;
    }

    public RecipeSerializer<?> getSerializer() {
        return SERIALIZER;
    }

    public RecipeType<?> getType() {
        return RecipeInit.ENERGIZING_RECIPE;
    }

    public static class Serializer extends net.minecraftforge.registries.ForgeRegistryEntry<RecipeSerializer<?>> implements RecipeSerializer<EnergizingRecipe> {
        Serializer() {
            this.setRegistryName(new ResourceLocation(ScrambledMod.MOD_ID, "energizing"));
        }

        public EnergizingRecipe fromJson(ResourceLocation p_199425_1_, JsonObject p_199425_2_) {
            Ingredient ingredient = Ingredient.fromJson(GsonHelper.getAsJsonObject(p_199425_2_, "item"));
            ItemStack itemstack = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(p_199425_2_, "result"));
            return new EnergizingRecipe(p_199425_1_, ingredient, itemstack);
        }

        public EnergizingRecipe fromNetwork(ResourceLocation p_199426_1_, FriendlyByteBuf p_199426_2_) {
            Ingredient ingredient = Ingredient.fromNetwork(p_199426_2_);
            ItemStack itemstack = p_199426_2_.readItem();
            return new EnergizingRecipe(p_199426_1_, ingredient, itemstack);
        }

        public void toNetwork(FriendlyByteBuf p_199427_1_, EnergizingRecipe p_199427_2_) {
            p_199427_2_.item.toNetwork(p_199427_1_);
            p_199427_1_.writeItem(p_199427_2_.result);
        }
    }
}
