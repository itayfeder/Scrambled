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

public class CopperAxeItem extends AxeItem implements IChargedTool {
    private final Multimap<Attribute, AttributeModifier> chargedModifiers;

    public CopperAxeItem(Tier p_42961_, float p_42962_, float p_42963_, Properties p_42964_) {
        super(p_42961_, p_42962_, p_42963_, p_42964_);
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", (double)p_42962_ + p_42961_.getAttackDamageBonus() + 2, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", (double)p_42963_ + 0.75, AttributeModifier.Operation.ADDITION));
        this.chargedModifiers = builder.build();
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        if (slot == EquipmentSlot.MAINHAND && (IChargedTool.getChargeTimer(stack.getOrCreateTag()) > 0)) {
            return this.chargedModifiers;
        }
        return super.getAttributeModifiers(slot, stack);
    }

    @Override
    public float getDestroySpeed(ItemStack p_41004_, BlockState p_41005_) {
        if (p_41005_.is(BlockTags.MINEABLE_WITH_AXE)) {
            if (IChargedTool.getChargeTimer(p_41004_.getOrCreateTag()) > 0) {
                return this.speed + 5F;
            }
            return this.speed;
        }
        return super.getDestroySpeed(p_41004_,p_41005_);
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
