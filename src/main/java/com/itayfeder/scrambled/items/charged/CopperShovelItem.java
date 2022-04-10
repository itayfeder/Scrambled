package com.itayfeder.scrambled.items.charged;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.List;

public class CopperShovelItem extends ShovelItem implements IChargedTool {
    private final Multimap<Attribute, AttributeModifier> chargedModifiers;

    public CopperShovelItem(Tier p_43114_, float p_43115_, float p_43116_, Properties p_43117_) {
        super(p_43114_, p_43115_, p_43116_, p_43117_);
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", (double)p_43115_ + p_43114_.getAttackDamageBonus() + 1, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", (double)p_43116_ + 0.75, AttributeModifier.Operation.ADDITION));
        this.chargedModifiers = builder.build();
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        if (slot == EquipmentSlot.MAINHAND && (IChargedTool.getChargeTimer(stack.getOrCreateTag()) > 0)) {
            return this.chargedModifiers;
        }
        return super.getAttributeModifiers(slot, stack);
    }

    public float getDestroySpeed(ItemStack p_41004_, BlockState p_41005_) {
        if (p_41005_.is(BlockTags.MINEABLE_WITH_SHOVEL)) {
            if (IChargedTool.getChargeTimer(p_41004_.getOrCreateTag()) > 0) {
                return this.speed + 5F;
            }
            return this.speed;
        }
        return 1.0F;
    }

    @Override
    public void inventoryTick(ItemStack p_41404_, Level p_41405_, Entity p_41406_, int p_41407_, boolean p_41408_) {
        super.inventoryTick(p_41404_, p_41405_, p_41406_, p_41407_, p_41408_);
        int charge = IChargedTool.getChargeTimer(p_41404_.getOrCreateTag());
        if (charge > 0) IChargedTool.setChargeTimer(p_41404_, charge - 1);
    }

    public void appendHoverText(ItemStack p_42988_, @Nullable Level p_42989_, List<Component> p_42990_, TooltipFlag p_42991_) {
        int charge = IChargedTool.getChargeTimer(p_42988_.getOrCreateTag());
        if (charge > 0) {
            p_42990_.add((new TranslatableComponent("scrambled.charged")).withStyle(ChatFormatting.AQUA));
        }
    }

    @Override
    public boolean shouldCauseBlockBreakReset(ItemStack oldStack, ItemStack newStack) {
        return false;
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return false;
    }
}
