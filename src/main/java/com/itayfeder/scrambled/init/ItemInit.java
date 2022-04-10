package com.itayfeder.scrambled.init;

import com.itayfeder.scrambled.ScrambledMod;
import com.itayfeder.scrambled.items.*;
import com.itayfeder.scrambled.items.charged.*;
import com.itayfeder.scrambled.utils.ModdedTiers;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
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
    public static final RegistryObject<Item> GINGERBREAD_COOKIE_CIRCLE = ITEMS.register("gingerbread_cookie_circle", () -> new GingerbreadCookieItem((new Item.Properties()).tab(ScrambledMod.TAB_MOD).stacksTo(64).food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.1F).fast().build()), CookieCutterItem.CookieType.CIRCLE));
    public static final RegistryObject<Item> GINGERBREAD_COOKIE_STAR = ITEMS.register("gingerbread_cookie_star", () -> new GingerbreadCookieItem((new Item.Properties()).tab(ScrambledMod.TAB_MOD).stacksTo(64).food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.1F).fast().build()), CookieCutterItem.CookieType.STAR));
    public static final RegistryObject<Item> GINGERBREAD_COOKIE_SNOWMAN = ITEMS.register("gingerbread_cookie_snowman", () -> new GingerbreadCookieItem((new Item.Properties()).tab(ScrambledMod.TAB_MOD).stacksTo(64).food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.1F).fast().build()), CookieCutterItem.CookieType.SNOWMAN));
    public static final RegistryObject<Item> GINGERBREAD_COOKIE_CANE = ITEMS.register("gingerbread_cookie_cane", () -> new GingerbreadCookieItem((new Item.Properties()).tab(ScrambledMod.TAB_MOD).stacksTo(64).food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.1F).fast().build()), CookieCutterItem.CookieType.CANE));
    public static final RegistryObject<Item> GINGERBREAD_COOKIE_MAN = ITEMS.register("gingerbread_cookie_man", () -> new GingerbreadCookieItem((new Item.Properties()).tab(ScrambledMod.TAB_MOD).stacksTo(64).food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.1F).fast().build()), CookieCutterItem.CookieType.MAN));
    public static final RegistryObject<Item> GINGERBREAD_COOKIE_CREEPER = ITEMS.register("gingerbread_cookie_creeper", () -> new GingerbreadCookieItem((new Item.Properties()).tab(ScrambledMod.TAB_MOD).stacksTo(64).food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.1F).fast().build()), CookieCutterItem.CookieType.CREEPER));
    public static final RegistryObject<Item> GINGERBREAD_BRICKS = ITEMS.register("gingerbread_bricks", () -> new BlockItem(BlockInit.GINGERBREAD_BRICKS.get(), (new Item.Properties()).tab(ScrambledMod.TAB_MOD)));
    public static final RegistryObject<Item> GINGERBREAD_BRICK_STAIRS = ITEMS.register("gingerbread_brick_stairs", () -> new BlockItem(BlockInit.GINGERBREAD_BRICK_STAIRS.get(), (new Item.Properties()).tab(ScrambledMod.TAB_MOD)));
    public static final RegistryObject<Item> GINGERBREAD_BRICK_SLAB = ITEMS.register("gingerbread_brick_slab", () -> new BlockItem(BlockInit.GINGERBREAD_BRICK_SLAB.get(), (new Item.Properties()).tab(ScrambledMod.TAB_MOD)));

    public static final RegistryObject<Item> PHANTOM_ITEM_FRAME = ITEMS.register("phantom_item_frame", () -> new PhantomItemFrameItem(EntityTypeInit.PHANTOM_ITEM_FRAME, (new Item.Properties()).tab(ScrambledMod.TAB_MOD)));

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

}
