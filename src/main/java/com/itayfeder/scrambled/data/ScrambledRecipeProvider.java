package com.itayfeder.scrambled.data;

import com.itayfeder.scrambled.ScrambledMod;
import com.itayfeder.scrambled.init.BlockInit;
import com.itayfeder.scrambled.init.ItemInit;
import com.itayfeder.scrambled.items.GingerbreadCookieItem;
import com.itayfeder.scrambled.utils.ConfigEnabledCondition;
import com.itayfeder.scrambled.utils.ModTags;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.ConditionalRecipe;

import java.util.function.Consumer;

public class ScrambledRecipeProvider extends RecipeProvider {
    public ScrambledRecipeProvider(DataGenerator p_125973_) {
        super(p_125973_);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> p_176532_) {
        makeConditionalRec(ShapelessRecipeBuilder.shapeless(ItemInit.GROUND_GINGER.get(), 2).requires(ItemInit.GINGER_ROOT.get()).unlockedBy("has_ginger_root", has(ItemInit.GINGER_ROOT.get())), p_176532_,  "enableGingerbreadRecipes");
        makeConditionalRec(ShapelessRecipeBuilder.shapeless(ItemInit.GINGERBREAD.get(), 2).requires(Items.SUGAR).requires(Items.EGG, 2).requires(ItemInit.GROUND_GINGER.get()).unlockedBy("has_sugar", has(Items.SUGAR)).unlockedBy("has_egg", has(Items.EGG)).unlockedBy("has_ground_ginger", has(ItemInit.GROUND_GINGER.get())), p_176532_,  "enableGingerbreadRecipes");
        makeConditionalRec(ShapedRecipeBuilder.shaped(ItemInit.COOKIE_CUTTER_CIRCLE.get(), 2).define('#', Items.IRON_INGOT).define('X', Items.IRON_NUGGET).pattern("X#X").pattern("# #").pattern("X#X").unlockedBy("has_iron_ingot", has(Items.IRON_INGOT)).unlockedBy("has_iron_nugget", has(Items.IRON_NUGGET)), p_176532_,  "enableGingerbreadRecipes");
        //stonecutterResultFromBase(p_176532_, ItemInit.COOKIE_CUTTER_STAR.get(), ItemInit.COOKIE_CUTTER_CIRCLE.get());
        for (Item cutter : GingerbreadCookieItem.CUTTER_TO_COOKIE.keySet()) {
            if (cutter != ItemInit.COOKIE_CUTTER_CIRCLE.get()) {
                stonecutterResultBase(p_176532_, cutter, ItemInit.COOKIE_CUTTER_CIRCLE.get(), 1,"enableGingerbreadRecipes", getDefaultRecipeId(cutter).getPath());
            }
        }
        for (Item cutter : GingerbreadCookieItem.CUTTER_TO_COOKIE.keySet()) {
            Item result = GingerbreadCookieItem.CUTTER_TO_COOKIE.get(cutter);
            makeConditionalRec(ShapelessRecipeBuilder.shapeless(result, 4).requires(ItemInit.GINGERBREAD.get()).requires(Items.SUGAR, 2).requires(cutter).unlockedBy("has_sugar", has(Items.SUGAR)).unlockedBy(getHasName(cutter), has(cutter)).unlockedBy(getHasName(result), has(result)), p_176532_,  "enableGingerbreadRecipes");

        }
        makeConditionalRec(ShapedRecipeBuilder.shaped(BlockInit.GINGERBREAD_BRICKS.get()).define('#', ItemInit.GINGERBREAD.get()).pattern("##").pattern("##").unlockedBy(getHasName(ItemInit.GINGERBREAD.get()), has(ItemInit.GINGERBREAD.get())), p_176532_,  "enableGingerbreadRecipes");
        makeConditionalRec(slabBuilder(BlockInit.GINGERBREAD_BRICK_SLAB.get(), Ingredient.of(BlockInit.GINGERBREAD_BRICKS.get())).unlockedBy(getHasName(BlockInit.GINGERBREAD_BRICKS.get()), has(BlockInit.GINGERBREAD_BRICKS.get())), p_176532_,  "enableGingerbreadRecipes");
        makeConditionalRec(stairBuilder(BlockInit.GINGERBREAD_BRICK_STAIRS.get(), Ingredient.of(BlockInit.GINGERBREAD_BRICKS.get())).unlockedBy(getHasName(BlockInit.GINGERBREAD_BRICKS.get()), has(BlockInit.GINGERBREAD_BRICKS.get())), p_176532_,  "enableGingerbreadRecipes");
        stonecutterResultBase(p_176532_, BlockInit.GINGERBREAD_BRICK_SLAB.get(), BlockInit.GINGERBREAD_BRICKS.get(), 2,  "enableGingerbreadRecipes", "gingerbread_brick_slab_stonecutting");
        stonecutterResultBase(p_176532_, BlockInit.GINGERBREAD_BRICK_STAIRS.get(), BlockInit.GINGERBREAD_BRICKS.get(),  1,"enableGingerbreadRecipes", "gingerbread_brick_stairs_stonecutting");

        makeConditionalRec(ShapedRecipeBuilder.shaped(ItemInit.COPPER_AXE.get()).define('#', Items.STICK).define('X', Items.COPPER_INGOT).pattern("XX").pattern("X#").pattern(" #").unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT)), p_176532_,  "enableCopperConductorRecipes");
        makeConditionalRec(ShapedRecipeBuilder.shaped(ItemInit.COPPER_HOE.get()).define('#', Items.STICK).define('X', Items.COPPER_INGOT).pattern("XX").pattern(" #").pattern(" #").unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT)), p_176532_,  "enableCopperConductorRecipes");
        makeConditionalRec(ShapedRecipeBuilder.shaped(ItemInit.COPPER_PICKAXE.get()).define('#', Items.STICK).define('X', Items.COPPER_INGOT).pattern("XXX").pattern(" # ").pattern(" # ").unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT)), p_176532_,  "enableCopperConductorRecipes");
        makeConditionalRec(ShapedRecipeBuilder.shaped(ItemInit.COPPER_SHOVEL.get()).define('#', Items.STICK).define('X', Items.COPPER_INGOT).pattern("X").pattern("#").pattern("#").unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT)), p_176532_,  "enableCopperConductorRecipes");
        makeConditionalRec(ShapedRecipeBuilder.shaped(ItemInit.COPPER_SWORD.get()).define('#', Items.STICK).define('X', Items.COPPER_INGOT).pattern("X").pattern("X").pattern("#").unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT)), p_176532_,  "enableCopperConductorRecipes");
        makeConditionalRec(ShapedRecipeBuilder.shaped(ItemInit.CONDUCTOR.get()).define('#', Items.COPPER_INGOT).define('R', Items.REDSTONE).define('A', Items.AMETHYST_SHARD).pattern("#R#").pattern("#A#").pattern("###").unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT)).unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD)).unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE)), p_176532_,  "enableCopperConductorRecipes");

        makeConditionalRec(ShapelessRecipeBuilder.shapeless(ItemInit.JERKY.get(), 2).requires(Items.ROTTEN_FLESH, 3).requires(ItemInit.SALT.get()).unlockedBy(getHasName(Items.ROTTEN_FLESH), has(Items.ROTTEN_FLESH)).unlockedBy(getHasName(ItemInit.SALT.get()), has(ItemInit.SALT.get())), p_176532_,  "enableSaltRecipes");

        makeConditionalRec(ShapedRecipeBuilder.shaped(ItemInit.RING_OF_ATTRACTION.get(), 1).define('#', Items.NETHERITE_INGOT).define('X', Items.COPPER_INGOT).pattern("X#X").pattern("# #").pattern("X#X").unlockedBy(getHasName(Items.NETHERITE_INGOT), has(Items.NETHERITE_INGOT)).unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT)), p_176532_,  "enableRingOfAttractionRecipes");

        makeConditionalRec(planksFromLogsCond(p_176532_, BlockInit.MAHOGANY_PLANKS.get(), ModTags.ItemTags.MAHOGANY_LOGS), p_176532_,  "enableMahoganyRecipes");
        makeConditionalRec(woodFromLogsCond(p_176532_, BlockInit.MAHOGANY_WOOD.get(), BlockInit.MAHOGANY_LOG.get()), p_176532_,  "enableMahoganyRecipes");
        makeConditionalRec(woodFromLogsCond(p_176532_, BlockInit.STRIPPED_MAHOGANY_WOOD.get(), BlockInit.STRIPPED_MAHOGANY_LOG.get()), p_176532_,  "enableMahoganyRecipes");
        makeConditionalRec(slabCond(p_176532_, BlockInit.MAHOGANY_SLAB.get(), BlockInit.MAHOGANY_PLANKS.get()), p_176532_,  "enableMahoganyRecipes");
        //slab(p_176532_, BlockInit.MAHOGANY_SLAB.get(), BlockInit.MAHOGANY_PLANKS.get());
        makeConditionalRec(stairCond(p_176532_, BlockInit.MAHOGANY_STAIRS.get(), BlockInit.MAHOGANY_PLANKS.get()), p_176532_,  "enableMahoganyRecipes");
        makeConditionalRec(fenceCond(p_176532_, BlockInit.MAHOGANY_FENCE.get(), BlockInit.MAHOGANY_PLANKS.get()), p_176532_,  "enableMahoganyRecipes");
        makeConditionalRec(fenceGateCond(p_176532_, BlockInit.MAHOGANY_FENCE_GATE.get(), BlockInit.MAHOGANY_PLANKS.get()), p_176532_,  "enableMahoganyRecipes");
        makeConditionalRec(signCond(p_176532_, BlockInit.MAHOGANY_SIGN.get(), BlockInit.MAHOGANY_PLANKS.get()), p_176532_,  "enableMahoganyRecipes");
        makeConditionalRec(buttonCond(p_176532_, BlockInit.MAHOGANY_BUTTON.get(), BlockInit.MAHOGANY_PLANKS.get()), p_176532_,  "enableMahoganyRecipes");
        makeConditionalRec(pressurePlateCond(p_176532_, BlockInit.MAHOGANY_PRESSURE_PLATE.get(), BlockInit.MAHOGANY_PLANKS.get()), p_176532_,  "enableMahoganyRecipes");

        makeConditionalRec(SimpleCookingRecipeBuilder.smelting(Ingredient.of(ItemInit.BOTTLED_SOGGY_CLOUD.get()), ItemInit.BOTTLED_CLOUD.get(), 0.15F, 200).unlockedBy("has_bottled_soggy_cloud", has(ItemInit.BOTTLED_SOGGY_CLOUD.get())), p_176532_,  "enableCloudRecipes");

    }

    static ResourceLocation getDefaultRecipeId(ItemLike p_176494_) {
        return Registry.ITEM.getKey(p_176494_.asItem());
    }

    protected static RecipeBuilder planksFromLogsCond(Consumer<FinishedRecipe> p_206413_, ItemLike p_206414_, TagKey<Item> p_206415_) {
        return ShapelessRecipeBuilder.shapeless(p_206414_, 4).requires(p_206415_).group("planks").unlockedBy("has_logs", has(p_206415_));
    }

    protected static RecipeBuilder woodFromLogsCond(Consumer<FinishedRecipe> p_126003_, ItemLike p_126004_, ItemLike p_126005_) {
        return ShapedRecipeBuilder.shaped(p_126004_, 3).define('#', p_126005_).pattern("##").pattern("##").group("bark").unlockedBy("has_log", has(p_126005_));
    }

    protected static RecipeBuilder slabCond(Consumer<FinishedRecipe> p_176701_, ItemLike p_176702_, ItemLike p_176703_) {
        return slabBuilder(p_176702_, Ingredient.of(p_176703_)).unlockedBy(getHasName(p_176703_), has(p_176703_));
    }

    private static void stair(Consumer<FinishedRecipe> consumer, ItemLike stair, ItemLike planks) {
        stairBuilder(stair, Ingredient.of(planks)).unlockedBy(getHasName(planks), has(planks)).save(consumer);
    }

    private static RecipeBuilder stairCond(Consumer<FinishedRecipe> consumer, ItemLike stair, ItemLike planks) {
        return stairBuilder(stair, Ingredient.of(planks)).unlockedBy(getHasName(planks), has(planks));
    }

    private static void sign(Consumer<FinishedRecipe> consumer, ItemLike stair, ItemLike planks) {
        signBuilder(stair, Ingredient.of(planks)).unlockedBy(getHasName(planks), has(planks)).save(consumer);
    }

    private static RecipeBuilder signCond(Consumer<FinishedRecipe> consumer, ItemLike stair, ItemLike planks) {
        return signBuilder(stair, Ingredient.of(planks)).unlockedBy(getHasName(planks), has(planks));
    }

    private static void fence(Consumer<FinishedRecipe> consumer, ItemLike fence, ItemLike planks) {
        fenceBuilder(fence, Ingredient.of(planks)).unlockedBy(getHasName(planks), has(planks)).save(consumer);
    }

    private static RecipeBuilder fenceCond(Consumer<FinishedRecipe> consumer, ItemLike stair, ItemLike planks) {
        return fenceBuilder(stair, Ingredient.of(planks)).unlockedBy(getHasName(planks), has(planks));
    }

    private static void fenceGate(Consumer<FinishedRecipe> consumer, ItemLike fence, ItemLike planks) {
        fenceGateBuilder(fence, Ingredient.of(planks)).unlockedBy(getHasName(planks), has(planks)).save(consumer);
    }

    private static RecipeBuilder fenceGateCond(Consumer<FinishedRecipe> consumer, ItemLike stair, ItemLike planks) {
        return fenceGateBuilder(stair, Ingredient.of(planks)).unlockedBy(getHasName(planks), has(planks));
    }

    private static void button(Consumer<FinishedRecipe> consumer, ItemLike stair, ItemLike planks) {
        buttonBuilder(stair, Ingredient.of(planks)).unlockedBy(getHasName(planks), has(planks)).save(consumer);
    }

    private static RecipeBuilder buttonCond(Consumer<FinishedRecipe> consumer, ItemLike stair, ItemLike planks) {
        return buttonBuilder(stair, Ingredient.of(planks)).unlockedBy(getHasName(planks), has(planks));
    }

    private static RecipeBuilder pressurePlateCond(Consumer<FinishedRecipe> consumer, ItemLike stair, ItemLike planks) {
        return pressurePlateBuilder(stair, Ingredient.of(planks)).unlockedBy(getHasName(planks), has(planks));
    }

    protected static void stonecutterResultBase(Consumer<FinishedRecipe> consumer, ItemLike p_176548_, ItemLike p_176549_, int p_176550_, String configName, String path) {
        ConditionalRecipe.builder()
                .addCondition(new ConfigEnabledCondition(configName))
                .addRecipe((c) -> SingleItemRecipeBuilder.stonecutting(Ingredient.of(p_176549_), p_176548_, p_176550_).unlockedBy(getHasName(p_176549_), has(p_176549_)).save(c))
                .build(consumer, ScrambledMod.MOD_ID, path);
        //SingleItemRecipeBuilder.stonecutting(Ingredient.of(p_176549_), p_176548_, p_176550_).unlockedBy(getHasName(p_176549_), has(p_176549_)).save(consumer);
    }

    public static void makeConditionalRec(RecipeBuilder r, Consumer<FinishedRecipe> consumer, String configName) {
        ConditionalRecipe.builder()
                .addCondition(new ConfigEnabledCondition(configName))
                .addRecipe((c) -> r.save(c))
                .build(consumer, getDefaultRecipeId(r.getResult()));
    }
}
