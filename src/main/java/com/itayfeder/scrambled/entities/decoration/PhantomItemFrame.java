package com.itayfeder.scrambled.entities.decoration;

import com.itayfeder.scrambled.init.EntityTypeInit;
import com.itayfeder.scrambled.init.ItemInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.ItemFrame;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MapItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import net.minecraftforge.network.PlayMessages;

public class PhantomItemFrame extends ItemFrame {
    private boolean fixed;

    public PhantomItemFrame(EntityType<? extends ItemFrame> p_149607_, Level p_149608_) {
        super(p_149607_, p_149608_);
    }

    public PhantomItemFrame(Level p_149610_, BlockPos p_149611_, Direction p_149612_) {
        super(EntityTypeInit.PHANTOM_ITEM_FRAME.get(), p_149610_, p_149611_, p_149612_);
    }

    public PhantomItemFrame(PlayMessages.SpawnEntity spawnEntity, Level level) {
        this(EntityTypeInit.PHANTOM_ITEM_FRAME.get(), level);
    }

    protected ItemStack getFrameItemStack() {
        return new ItemStack(ItemInit.PHANTOM_ITEM_FRAME.get());
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getItem() != ItemStack.EMPTY)
            this.setInvisible(true);
        else
            this.setInvisible(false);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag p_31795_) {
        super.readAdditionalSaveData(p_31795_);
        this.fixed = p_31795_.getBoolean("Fixed");

    }

    public InteractionResult interact(Player p_31787_, InteractionHand p_31788_) {
        ItemStack itemstack = p_31787_.getItemInHand(p_31788_);
        boolean flag = !this.getItem().isEmpty();
        boolean flag1 = !itemstack.isEmpty();
        if (this.fixed) {
            return InteractionResult.PASS;
        } else if (!this.level.isClientSide) {
            if (!flag) {
                if (flag1 && !this.isRemoved()) {
                    if (itemstack.is(Items.FILLED_MAP)) {
                        MapItemSavedData mapitemsaveddata = MapItem.getSavedData(itemstack, this.level);
                        if (mapitemsaveddata != null && mapitemsaveddata.isTrackedCountOverLimit(256)) {
                            return InteractionResult.FAIL;
                        }
                    }

                    this.setItem(itemstack);
                    this.setInvisible(true);
                    if (this.level instanceof ServerLevel serverLevel) {
                        if (this.getXRot() == 0) {
                            Direction d = Direction.from2DDataValue((int)this.getYRot() / 90);
                            if (d.getAxis() == Direction.Axis.X) {
                                serverLevel.sendParticles(ParticleTypes.MYCELIUM, this.getX(), this.getY(), this.getZ(), 100, 0.2 * 0.5, 0.2, 0.2, 0.1);
                            }
                            if (d.getAxis() == Direction.Axis.Z) {
                                serverLevel.sendParticles(ParticleTypes.MYCELIUM, this.getX(), this.getY(), this.getZ() , 100, 0.2, 0.2, 0.2 * 0.5, 0.1);
                            }
                        } else if (this.getYRot() == 0 && this.getXRot() != 0) {
                            serverLevel.sendParticles(ParticleTypes.MYCELIUM, this.getX(), this.getY(), this.getZ(), 100, 0.2, 0.2 * 0.5, 0.2, 0.1);
                        }
                    }
                    if (!p_31787_.getAbilities().instabuild) {
                        itemstack.shrink(1);
                    }
                }
            } else {
                this.playSound(this.getRotateItemSound(), 1.0F, 1.0F);
                this.setRotation(this.getRotation() + 1);
            }

            return InteractionResult.CONSUME;
        } else {
            return !flag && !flag1 ? InteractionResult.PASS : InteractionResult.SUCCESS;
        }
    }
}
