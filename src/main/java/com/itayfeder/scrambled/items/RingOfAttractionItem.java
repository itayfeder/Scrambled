package com.itayfeder.scrambled.items;

import com.google.common.collect.ImmutableSet;
import com.itayfeder.scrambled.init.EnchantmentInit;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class RingOfAttractionItem extends Item {
    public RingOfAttractionItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level p_41432_, Player p_41433_, InteractionHand p_41434_) {
        ItemStack stack = p_41433_.getItemInHand(p_41434_);
        if (p_41433_ instanceof ServerPlayer player) {
            int potentLevel = EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.POTENT.get(), stack);
            for(ItemEntity itementity : p_41432_.getEntitiesOfClass(ItemEntity.class, player.getBoundingBox().inflate(5.0D + potentLevel, 3.0D + potentLevel, 5.0D + potentLevel))) {
                ItemStack itemstack = itementity.getItem();
                Item item = itemstack.getItem();
                int i = itemstack.getCount();
                int hook = net.minecraftforge.event.ForgeEventFactory.onItemPickup(itementity, player);
                if (hook < 0) return super.use(p_41432_, p_41433_, p_41434_);

                ItemStack copy = itemstack.copy();
                boolean bool2 = (itementity.getOwner() == null || itementity.lifespan - itementity.getAge() <= 200 || itementity.getOwner().equals(player.getUUID()));
                boolean bool3 = (hook == 1 || i <= 0 || player.getInventory().add(itemstack));
                if (!itementity.hasPickUpDelay() && bool2 && bool3) {
                    copy.setCount(copy.getCount() - itemstack.getCount());
                    net.minecraftforge.event.ForgeEventFactory.firePlayerItemPickupEvent(player, itementity, copy);
                    player.take(itementity, i);
                    if (itemstack.isEmpty()) {
                        itementity.discard();
                        itemstack.setCount(i);
                    }

                    player.awardStat(Stats.ITEM_PICKED_UP.get(item), i);
                    player.onItemPickup(itementity);
                }
            }
        }
        stack.hurtAndBreak(1, p_41433_, e -> e.broadcastBreakEvent(p_41434_));
        p_41432_.playSound((Player)p_41433_, p_41433_, SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.BLOCKS, 1.0F,  0.9F);
        return InteractionResultHolder.success(stack);
    }

    @Override
    public int getEnchantmentValue() {
        return Items.NETHERITE_PICKAXE.getEnchantmentValue();
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return super.canApplyAtEnchantingTable(stack, enchantment) || ImmutableSet.of(Enchantments.UNBREAKING, Enchantments.MENDING, Enchantments.VANISHING_CURSE, EnchantmentInit.POTENT.get()).contains(enchantment);
    }
}
