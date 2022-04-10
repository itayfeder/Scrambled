package com.itayfeder.scrambled.items;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;

public class SaltItem extends Item {
    public SaltItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public InteractionResult useOn(UseOnContext p_41427_) {
        if (p_41427_.getLevel().getBlockState(p_41427_.getClickedPos()).getBlock() instanceof WeatheringCopper) {
            BlockState state = p_41427_.getLevel().getBlockState(p_41427_.getClickedPos());
            Optional<Block> next = WeatheringCopper.getNext(state.getBlock());
            if (!next.isEmpty()) {
                Block nextBlock = next.get();
                p_41427_.getLevel().playSound(p_41427_.getPlayer(), p_41427_.getClickedPos(), SoundEvents.SOUL_SAND_HIT, SoundSource.BLOCKS, 1.0F, 1.0F);
                ParticleUtils.spawnParticlesOnBlockFaces(p_41427_.getLevel(), p_41427_.getClickedPos(), ParticleTypes.WAX_OFF, UniformInt.of(3, 5));
                if (!p_41427_.getLevel().isClientSide)
                    p_41427_.getItemInHand().shrink(1);
                if (p_41427_.getPlayer().getRandom().nextInt(5) == 3) {
                    p_41427_.getLevel().setBlock(p_41427_.getClickedPos(), nextBlock.defaultBlockState(), 11);

                }
                return InteractionResult.sidedSuccess(p_41427_.getLevel().isClientSide);
            }
        }
        return InteractionResult.PASS;
    }

    public ItemStack finishUsingItem(ItemStack p_41348_, Level p_41349_, LivingEntity p_41350_) {
        super.finishUsingItem(p_41348_, p_41349_, p_41350_);
        if (p_41350_ instanceof ServerPlayer) {
            ServerPlayer serverplayer = (ServerPlayer)p_41350_;
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, p_41348_);
            serverplayer.awardStat(Stats.ITEM_USED.get(this));
        }

        if (!p_41349_.isClientSide) {
            p_41350_.setTicksFrozen(0);
        }

        return p_41348_;
    }

    public int getUseDuration(ItemStack p_41360_) {
        return 20;
    }

    public UseAnim getUseAnimation(ItemStack p_41358_) {
        return UseAnim.EAT;
    }

    public SoundEvent getDrinkingSound() {
        return SoundEvents.GENERIC_EAT;
    }

    public SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_EAT;
    }

    public InteractionResultHolder<ItemStack> use(Level p_41352_, Player p_41353_, InteractionHand p_41354_) {
        return ItemUtils.startUsingInstantly(p_41352_, p_41353_, p_41354_);
    }
}
