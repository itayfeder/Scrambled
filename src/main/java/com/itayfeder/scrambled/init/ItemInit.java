package com.itayfeder.scrambled.init;

import com.itayfeder.scrambled.ScrambledMod;
import com.itayfeder.scrambled.items.*;
import com.itayfeder.scrambled.items.charged.*;
import com.itayfeder.scrambled.utils.ModdedTiers;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ScrambledMod.MOD_ID);

    public static final RegistryObject<Item> FLOWER_CROWN = ITEMS.register("flower_crown", () -> new FlowerCrownItem((new Item.Properties()).tab(ScrambledMod.TAB_MOD).stacksTo(1)));

    public static final RegistryObject<Item> SWORDFISH = ITEMS.register("swordfish", () -> new SwordfishItem(ModdedTiers.SWORDFISH, 3, -1.8F, (new Item.Properties()).tab(ScrambledMod.TAB_MOD).rarity(Rarity.UNCOMMON)
            .food((new FoodProperties.Builder()).nutrition(5).saturationMod(0.25F).build())));

    public static final RegistryObject<Item> GINGER_ROOT = ITEMS.register("ginger_root", () -> new Item((new Item.Properties()).tab(ScrambledMod.TAB_MOD)));
    public static final RegistryObject<Item> GROUND_GINGER = ITEMS.register("ground_ginger", () -> new Item((new Item.Properties()).tab(ScrambledMod.TAB_MOD)));
    public static final RegistryObject<Item> GINGERBREAD = ITEMS.register("gingerbread", () -> new Item((new Item.Properties()).tab(ScrambledMod.TAB_MOD)));
    public static final RegistryObject<Item> COOKIE_CUTTER_CIRCLE = ITEMS.register("cookie_cutter_circle", () -> new CookieCutterItem((new Item.Properties()).tab(ScrambledMod.TAB_MOD).stacksTo(1).durability(25), CookieCutterItem.CookieType.CIRCLE));
    public static final RegistryObject<Item> COOKIE_CUTTER_STAR = ITEMS.register("cookie_cutter_star", () -> new CookieCutterItem((new Item.Properties()).tab(ScrambledMod.TAB_MOD).stacksTo(1).durability(25), CookieCutterItem.CookieType.STAR));
    public static final RegistryObject<Item> COOKIE_CUTTER_SNOWMAN = ITEMS.register("cookie_cutter_snowman", () -> new CookieCutterItem((new Item.Properties()).tab(ScrambledMod.TAB_MOD).stacksTo(1).durability(25), CookieCutterItem.CookieType.SNOWMAN));
    public static final RegistryObject<Item> COOKIE_CUTTER_CANE = ITEMS.register("cookie_cutter_cane", () -> new CookieCutterItem((new Item.Properties()).tab(ScrambledMod.TAB_MOD).stacksTo(1).durability(25), CookieCutterItem.CookieType.CANE));
    public static final RegistryObject<Item> COOKIE_CUTTER_MAN = ITEMS.register("cookie_cutter_man", () -> new CookieCutterItem((new Item.Properties()).tab(ScrambledMod.TAB_MOD).stacksTo(1).durability(25), CookieCutterItem.CookieType.MAN));
    public static final RegistryObject<Item> COOKIE_CUTTER_CREEPER = ITEMS.register("cookie_cutter_creeper", () -> new CookieCutterItem((new Item.Properties()).tab(ScrambledMod.TAB_MOD).stacksTo(1).durability(25), CookieCutterItem.CookieType.CREEPER));
    public static final RegistryObject<Item> GINGERBREAD_COOKIE_CIRCLE = ITEMS.register("gingerbread_cookie_circle", () -> new GingerbreadCookieItem((new Item.Properties()).tab(ScrambledMod.TAB_MOD).stacksTo(64).food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.1F).fast().build()), CookieCutterItem.CookieType.CIRCLE, COOKIE_CUTTER_CIRCLE.get()));
    public static final RegistryObject<Item> GINGERBREAD_COOKIE_STAR = ITEMS.register("gingerbread_cookie_star", () -> new GingerbreadCookieItem((new Item.Properties()).tab(ScrambledMod.TAB_MOD).stacksTo(64).food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.1F).fast().build()), CookieCutterItem.CookieType.STAR, COOKIE_CUTTER_STAR.get()));
    public static final RegistryObject<Item> GINGERBREAD_COOKIE_SNOWMAN = ITEMS.register("gingerbread_cookie_snowman", () -> new GingerbreadCookieItem((new Item.Properties()).tab(ScrambledMod.TAB_MOD).stacksTo(64).food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.1F).fast().build()), CookieCutterItem.CookieType.SNOWMAN, COOKIE_CUTTER_SNOWMAN.get()));
    public static final RegistryObject<Item> GINGERBREAD_COOKIE_CANE = ITEMS.register("gingerbread_cookie_cane", () -> new GingerbreadCookieItem((new Item.Properties()).tab(ScrambledMod.TAB_MOD).stacksTo(64).food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.1F).fast().build()), CookieCutterItem.CookieType.CANE, COOKIE_CUTTER_CANE.get()));
    public static final RegistryObject<Item> GINGERBREAD_COOKIE_MAN = ITEMS.register("gingerbread_cookie_man", () -> new GingerbreadCookieItem((new Item.Properties()).tab(ScrambledMod.TAB_MOD).stacksTo(64).food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.1F).fast().build()), CookieCutterItem.CookieType.MAN, COOKIE_CUTTER_MAN.get()));
    public static final RegistryObject<Item> GINGERBREAD_COOKIE_CREEPER = ITEMS.register("gingerbread_cookie_creeper", () -> new GingerbreadCookieItem((new Item.Properties()).tab(ScrambledMod.TAB_MOD).stacksTo(64).food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.1F).fast().build()), CookieCutterItem.CookieType.CREEPER, COOKIE_CUTTER_CREEPER.get()));
    public static final RegistryObject<Item> GINGERBREAD_BRICKS = ITEMS.register("gingerbread_bricks", () -> new BlockItem(BlockInit.GINGERBREAD_BRICKS.get(), (new Item.Properties()).tab(ScrambledMod.TAB_MOD)));
    public static final RegistryObject<Item> GINGERBREAD_BRICK_STAIRS = ITEMS.register("gingerbread_brick_stairs", () -> new BlockItem(BlockInit.GINGERBREAD_BRICK_STAIRS.get(), (new Item.Properties()).tab(ScrambledMod.TAB_MOD)));
    public static final RegistryObject<Item> GINGERBREAD_BRICK_SLAB = ITEMS.register("gingerbread_brick_slab", () -> new BlockItem(BlockInit.GINGERBREAD_BRICK_SLAB.get(), (new Item.Properties()).tab(ScrambledMod.TAB_MOD)));

    public static final RegistryObject<Item> CONDUCTOR = ITEMS.register("conductor", () -> new BlockItem(BlockInit.CONDUCTOR.get(), (new Item.Properties()).tab(ScrambledMod.TAB_MOD)));
    public static final RegistryObject<Item> LIGHTNING_IN_A_BOTTLE = ITEMS.register("lightning_in_a_bottle", () -> new LightningInABottleItem((new Item.Properties()).tab(ScrambledMod.TAB_MOD).stacksTo(1).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> COPPER_SWORD = ITEMS.register("copper_sword", () -> new CopperSwordItem(ModdedTiers.COPPER, 3, -2.4F, (new Item.Properties()).tab(ScrambledMod.TAB_MOD)));
    public static final RegistryObject<Item> COPPER_SHOVEL = ITEMS.register("copper_shovel", () -> new CopperShovelItem(ModdedTiers.COPPER, 1.5F, -3.0F, (new Item.Properties()).tab(ScrambledMod.TAB_MOD)));
    public static final RegistryObject<Item> COPPER_PICKAXE = ITEMS.register("copper_pickaxe", () -> new CopperPickaxeItem(ModdedTiers.COPPER, 1, -2.8F, (new Item.Properties()).tab(ScrambledMod.TAB_MOD)));
    public static final RegistryObject<Item> COPPER_AXE = ITEMS.register("copper_axe", () -> new CopperAxeItem(ModdedTiers.COPPER, 6.0F, -3.1F, (new Item.Properties()).tab(ScrambledMod.TAB_MOD)));
    public static final RegistryObject<Item> COPPER_HOE = ITEMS.register("copper_hoe", () -> new CopperHoeItem(ModdedTiers.COPPER, -2, -1.0F, (new Item.Properties()).tab(ScrambledMod.TAB_MOD)));

    public static final RegistryObject<Item> SNAIL_SPAWN_EGG = ITEMS.register("snail_spawn_egg", () -> new ForgeSpawnEggItem(EntityTypeInit.SNAIL, 14203801, 7028001, (new Item.Properties()).tab(ScrambledMod.TAB_MOD)));

    public static final RegistryObject<Item> SALT = ITEMS.register("salt", () -> new SaltItem((new Item.Properties()).tab(ScrambledMod.TAB_MOD).food((new FoodProperties.Builder()).nutrition(1).saturationMod(2F).fast().build())));
    public static final RegistryObject<Item> ROCK_SALT = ITEMS.register("rock_salt", () -> new BlockItem(BlockInit.ROCK_SALT.get(), (new Item.Properties()).tab(ScrambledMod.TAB_MOD)));
    public static final RegistryObject<Item> JERKY = ITEMS.register("jerky", () -> new Item((new Item.Properties()).tab(ScrambledMod.TAB_MOD).stacksTo(64).food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.5F).fast().build())));

    public static final RegistryObject<Item> RING_OF_ATTRACTION = ITEMS.register("ring_of_attraction", () -> new RingOfAttractionItem((new Item.Properties().stacksTo(1).durability(500)).tab(ScrambledMod.TAB_MOD)));

    public static final RegistryObject<Item> MAHOGANY_PLANKS = ITEMS.register("mahogany_planks", () -> new BlockItem(BlockInit.MAHOGANY_PLANKS.get(), (new Item.Properties()).tab(ScrambledMod.TAB_MOD)));
    public static final RegistryObject<Item> MAHOGANY_SAPLING = ITEMS.register("mahogany_sapling", () -> new BlockItem(BlockInit.MAHOGANY_SAPLING.get(), (new Item.Properties()).tab(ScrambledMod.TAB_MOD)));
    public static final RegistryObject<Item> MAHOGANY_LOG = ITEMS.register("mahogany_log", () -> new BlockItem(BlockInit.MAHOGANY_LOG.get(), (new Item.Properties()).tab(ScrambledMod.TAB_MOD)));
    public static final RegistryObject<Item> STRIPPED_MAHOGANY_LOG = ITEMS.register("stripped_mahogany_log", () -> new BlockItem(BlockInit.STRIPPED_MAHOGANY_LOG.get(), (new Item.Properties()).tab(ScrambledMod.TAB_MOD)));
    public static final RegistryObject<Item> STRIPPED_MAHOGANY_WOOD = ITEMS.register("stripped_mahogany_wood", () -> new BlockItem(BlockInit.STRIPPED_MAHOGANY_WOOD.get(), (new Item.Properties()).tab(ScrambledMod.TAB_MOD)));
    public static final RegistryObject<Item> MAHOGANY_WOOD = ITEMS.register("mahogany_wood", () -> new BlockItem(BlockInit.MAHOGANY_WOOD.get(), (new Item.Properties()).tab(ScrambledMod.TAB_MOD)));
    public static final RegistryObject<Item> MAHOGANY_SLAB = ITEMS.register("mahogany_slab", () -> new BlockItem(BlockInit.MAHOGANY_SLAB.get(), (new Item.Properties()).tab(ScrambledMod.TAB_MOD)));
    public static final RegistryObject<Item> MAHOGANY_STAIRS = ITEMS.register("mahogany_stairs", () -> new BlockItem(BlockInit.MAHOGANY_STAIRS.get(), (new Item.Properties()).tab(ScrambledMod.TAB_MOD)));
    public static final RegistryObject<Item> MAHOGANY_LEAVES = ITEMS.register("mahogany_leaves", () -> new BlockItem(BlockInit.MAHOGANY_LEAVES.get(), (new Item.Properties()).tab(ScrambledMod.TAB_MOD)));
    public static final RegistryObject<Item> MAHOGANY_FENCE = ITEMS.register("mahogany_fence", () -> new BlockItem(BlockInit.MAHOGANY_FENCE.get(), (new Item.Properties()).tab(ScrambledMod.TAB_MOD)));
    public static final RegistryObject<Item> MAHOGANY_FENCE_GATE = ITEMS.register("mahogany_fence_gate", () -> new BlockItem(BlockInit.MAHOGANY_FENCE_GATE.get(), (new Item.Properties()).tab(ScrambledMod.TAB_MOD)));
    public static final RegistryObject<Item> MAHOGANY_SIGN = ITEMS.register("mahogany_sign", () -> new SignItem((new Item.Properties()).stacksTo(16).tab(ScrambledMod.TAB_MOD), BlockInit.MAHOGANY_SIGN.get(), BlockInit.MAHOGANY_WALL_SIGN.get()));
    public static final RegistryObject<Item> MAHOGANY_BUTTON = ITEMS.register("mahogany_button", () -> new BlockItem(BlockInit.MAHOGANY_BUTTON.get(), (new Item.Properties()).tab(ScrambledMod.TAB_MOD)));
    public static final RegistryObject<Item> MAHOGANY_PRESSURE_PLATE = ITEMS.register("mahogany_pressure_plate", () -> new BlockItem(BlockInit.MAHOGANY_PRESSURE_PLATE.get(), (new Item.Properties()).tab(ScrambledMod.TAB_MOD)));

    public static final RegistryObject<Item> BOTTLED_CLOUD = ITEMS.register("bottled_cloud", () -> new BottledCloudItem((new Item.Properties()).tab(ScrambledMod.TAB_MOD).stacksTo(1), BlockInit.CLOUD_CHUNK.get()));
    public static final RegistryObject<Item> BOTTLED_SOGGY_CLOUD = ITEMS.register("bottled_soggy_cloud", () -> new BottledCloudItem((new Item.Properties()).tab(ScrambledMod.TAB_MOD).stacksTo(1), BlockInit.SOGGY_CLOUD_CHUNK.get()));

}
