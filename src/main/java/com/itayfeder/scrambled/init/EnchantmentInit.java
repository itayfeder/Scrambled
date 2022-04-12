package com.itayfeder.scrambled.init;

import com.itayfeder.scrambled.ScrambledMod;
import com.itayfeder.scrambled.enchantments.PotentEnchantment;
import com.itayfeder.scrambled.items.RingOfAttractionItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EnchantmentInit {
    public static final EnchantmentCategory RING_CATEGORY = EnchantmentCategory.create("ring_of_attraction", (item) -> {
        return item instanceof RingOfAttractionItem;
    });

    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, ScrambledMod.MOD_ID);

    public static final RegistryObject<Enchantment> POTENT = ENCHANTMENTS.register("potent", () -> new PotentEnchantment(Enchantment.Rarity.UNCOMMON, EquipmentSlot.MAINHAND));

}
