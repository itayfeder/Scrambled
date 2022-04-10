package com.itayfeder.scrambled.items;

import com.itayfeder.scrambled.entities.decoration.PhantomItemFrame;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.function.Supplier;

public class PhantomItemFrameItem extends Item {
    private final Supplier<? extends EntityType<? extends HangingEntity>> type;

    public PhantomItemFrameItem(Supplier<? extends EntityType<? extends HangingEntity>> p_41324_, Item.Properties p_41325_) {
        super(p_41325_);
        this.type = p_41324_;
    }

    public InteractionResult useOn(UseOnContext p_41331_) {
        BlockPos blockpos = p_41331_.getClickedPos();
        Direction direction = p_41331_.getClickedFace();
        BlockPos blockpos1 = blockpos.relative(direction);
        Player player = p_41331_.getPlayer();
        ItemStack itemstack = p_41331_.getItemInHand();
        if (player != null && !this.mayPlace(player, direction, itemstack, blockpos1)) {
            return InteractionResult.FAIL;
        } else {
            Level level = p_41331_.getLevel();
            HangingEntity hangingentity;
            hangingentity = new PhantomItemFrame(level, blockpos1, direction);

            CompoundTag compoundtag = itemstack.getTag();
            if (compoundtag != null) {
                EntityType.updateCustomEntityTag(level, player, hangingentity, compoundtag);
            }

            if (hangingentity.survives()) {
                if (!level.isClientSide) {
                    hangingentity.playPlacementSound();
                    level.gameEvent(player, GameEvent.ENTITY_PLACE, blockpos);
                    level.addFreshEntity(hangingentity);
                }

                itemstack.shrink(1);
                return InteractionResult.sidedSuccess(level.isClientSide);
            } else {
                return InteractionResult.CONSUME;
            }
        }
    }

    protected boolean mayPlace(Player p_41551_, Direction p_41552_, ItemStack p_41553_, BlockPos p_41554_) {
        return !p_41551_.level.isOutsideBuildHeight(p_41554_) && p_41551_.mayUseItemAt(p_41554_, p_41552_, p_41553_);
    }
}