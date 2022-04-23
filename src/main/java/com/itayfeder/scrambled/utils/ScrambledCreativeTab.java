package com.itayfeder.scrambled.utils;

import com.itayfeder.scrambled.ScrambledMod;
import com.itayfeder.scrambled.init.EnchantmentInit;
import com.itayfeder.scrambled.init.ItemInit;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.RegistryObject;
import vazkii.patchouli.common.item.ItemModBook;
import vazkii.patchouli.common.item.PatchouliItems;

public class ScrambledCreativeTab extends CreativeModeTab {
    public ScrambledCreativeTab() {
        super("scrambled");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ItemInit.SWORDFISH.get());
    }

    @Override
    public void fillItemList(NonNullList<ItemStack> p_40778_) {
        if (ModList.get().isLoaded("patchouli")) {
            p_40778_.add(ItemModBook.forBook(new ResourceLocation(ScrambledMod.MOD_ID, "book_of_randomness")));
        }

        if (ScrambledConfig.COMMON.addFlowerCrownToTab.get()) {
            p_40778_.add(ItemInit.FLOWER_CROWN.get().getDefaultInstance());
        }

        if (ScrambledConfig.COMMON.addSwordfishToTab.get()) {
            p_40778_.add(ItemInit.SWORDFISH.get().getDefaultInstance());
        }

        if (ScrambledConfig.COMMON.addGingerbreadToTab.get()) {
            p_40778_.add(ItemInit.GINGER_ROOT.get().getDefaultInstance());
            p_40778_.add(ItemInit.GROUND_GINGER.get().getDefaultInstance());
            p_40778_.add(ItemInit.GINGERBREAD.get().getDefaultInstance());
            p_40778_.add(ItemInit.COOKIE_CUTTER_CIRCLE.get().getDefaultInstance());
            p_40778_.add(ItemInit.COOKIE_CUTTER_STAR.get().getDefaultInstance());
            p_40778_.add(ItemInit.COOKIE_CUTTER_SNOWMAN.get().getDefaultInstance());
            p_40778_.add(ItemInit.COOKIE_CUTTER_CANE.get().getDefaultInstance());
            p_40778_.add(ItemInit.COOKIE_CUTTER_MAN.get().getDefaultInstance());
            p_40778_.add(ItemInit.COOKIE_CUTTER_CREEPER.get().getDefaultInstance());
            p_40778_.add(ItemInit.GINGERBREAD_COOKIE_CIRCLE.get().getDefaultInstance());
            p_40778_.add(ItemInit.GINGERBREAD_COOKIE_STAR.get().getDefaultInstance());
            p_40778_.add(ItemInit.GINGERBREAD_COOKIE_SNOWMAN.get().getDefaultInstance());
            p_40778_.add(ItemInit.GINGERBREAD_COOKIE_CANE.get().getDefaultInstance());
            p_40778_.add(ItemInit.GINGERBREAD_COOKIE_MAN.get().getDefaultInstance());
            p_40778_.add(ItemInit.GINGERBREAD_COOKIE_CREEPER.get().getDefaultInstance());
            p_40778_.add(ItemInit.GINGERBREAD_BRICKS.get().getDefaultInstance());
            p_40778_.add(ItemInit.GINGERBREAD_BRICK_SLAB.get().getDefaultInstance());
            p_40778_.add(ItemInit.GINGERBREAD_BRICK_STAIRS.get().getDefaultInstance());
        }

        if (ScrambledConfig.COMMON.addCopperConductorToTab.get()) {
            p_40778_.add(ItemInit.CONDUCTOR.get().getDefaultInstance());
            p_40778_.add(ItemInit.LIGHTNING_IN_A_BOTTLE.get().getDefaultInstance());
            p_40778_.add(ItemInit.COPPER_SWORD.get().getDefaultInstance());
            p_40778_.add(ItemInit.COPPER_SHOVEL.get().getDefaultInstance());
            p_40778_.add(ItemInit.COPPER_PICKAXE.get().getDefaultInstance());
            p_40778_.add(ItemInit.COPPER_AXE.get().getDefaultInstance());
            p_40778_.add(ItemInit.COPPER_HOE.get().getDefaultInstance());
        }

        if (ScrambledConfig.COMMON.addSnailToTab.get()) {
            p_40778_.add(ItemInit.SNAIL_SPAWN_EGG.get().getDefaultInstance());
        }

        if (ScrambledConfig.COMMON.addSaltToTab.get()) {
            p_40778_.add(ItemInit.SALT.get().getDefaultInstance());
            p_40778_.add(ItemInit.ROCK_SALT.get().getDefaultInstance());
            p_40778_.add(ItemInit.JERKY.get().getDefaultInstance());
        }

        if (ScrambledConfig.COMMON.addRingOfAttractionToTab.get()) {
            p_40778_.add(ItemInit.RING_OF_ATTRACTION.get().getDefaultInstance());
            for (RegistryObject<Enchantment> enchant : EnchantmentInit.ENCHANTMENTS.getEntries().stream().toList()) {
                p_40778_.add(EnchantedBookItem.createForEnchantment(new EnchantmentInstance(enchant.get(), enchant.get().getMaxLevel())));
            }
        }

        if (ScrambledConfig.COMMON.addMahoganyToTab.get()) {
            p_40778_.add(ItemInit.MAHOGANY_PLANKS.get().getDefaultInstance());
            p_40778_.add(ItemInit.MAHOGANY_SAPLING.get().getDefaultInstance());
            p_40778_.add(ItemInit.MAHOGANY_LOG.get().getDefaultInstance());
            p_40778_.add(ItemInit.STRIPPED_MAHOGANY_LOG.get().getDefaultInstance());
            p_40778_.add(ItemInit.STRIPPED_MAHOGANY_WOOD.get().getDefaultInstance());
            p_40778_.add(ItemInit.MAHOGANY_WOOD.get().getDefaultInstance());
            p_40778_.add(ItemInit.MAHOGANY_SLAB.get().getDefaultInstance());
            p_40778_.add(ItemInit.MAHOGANY_STAIRS.get().getDefaultInstance());
            p_40778_.add(ItemInit.MAHOGANY_LEAVES.get().getDefaultInstance());
            p_40778_.add(ItemInit.MAHOGANY_FENCE.get().getDefaultInstance());
            p_40778_.add(ItemInit.MAHOGANY_FENCE_GATE.get().getDefaultInstance());
            p_40778_.add(ItemInit.MAHOGANY_SIGN.get().getDefaultInstance());
            p_40778_.add(ItemInit.MAHOGANY_BUTTON.get().getDefaultInstance());
            p_40778_.add(ItemInit.MAHOGANY_PRESSURE_PLATE.get().getDefaultInstance());
        }

        if (ScrambledConfig.COMMON.addCloudToTab.get()) {
            p_40778_.add(ItemInit.BOTTLED_CLOUD.get().getDefaultInstance());
            p_40778_.add(ItemInit.BOTTLED_SOGGY_CLOUD.get().getDefaultInstance());
        }

    }
}
