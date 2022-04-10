package com.itayfeder.scrambled.blockentities;

import com.itayfeder.scrambled.blocks.ConductorBlock;
import com.itayfeder.scrambled.init.BlockEntityTypeInit;
import com.itayfeder.scrambled.init.RecipeInit;
import com.itayfeder.scrambled.items.charged.IChargedTool;
import com.itayfeder.scrambled.menus.ConductorMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class ConductorBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer {
    protected NonNullList<ItemStack> items = NonNullList.withSize(1, ItemStack.EMPTY);

    public ConductorBlockEntity(BlockPos p_155077_, BlockState p_155078_) {
        super(BlockEntityTypeInit.CONDUCTOR.get(), p_155077_, p_155078_);
    }

    public int getContainerSize() {
        return this.items.size();
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack itemstack : this.items) {
            if (!itemstack.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public ItemStack getItem(int p_18941_) {
        return this.items.get(p_18941_);
    }

    @Override
    public ItemStack removeItem(int p_18942_, int p_18943_) {
        return ContainerHelper.removeItem(this.items, p_18942_, p_18943_);
    }

    @Override
    public ItemStack removeItemNoUpdate(int p_18951_) {
        return ContainerHelper.takeItem(this.items, p_18951_);
    }

    @Override
    public void setItem(int p_59315_, ItemStack p_59316_) {
        this.items.set(p_59315_, p_59316_);
        if (p_59316_.getCount() > this.getMaxStackSize()) {
            p_59316_.setCount(this.getMaxStackSize());
        }

    }

    @Override
    public boolean stillValid(Player p_58340_) {
        if (this.level.getBlockEntity(this.worldPosition) != this) {
            return false;
        } else {
            return p_58340_.distanceToSqr((double) this.worldPosition.getX() + 0.5D, (double) this.worldPosition.getY() + 0.5D, (double) this.worldPosition.getZ() + 0.5D) <= 64.0D;
        }
    }

    public void load(CompoundTag p_155025_) {
        super.load(p_155025_);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(p_155025_, this.items);
    }

    protected void saveAdditional(CompoundTag p_187452_) {
        super.saveAdditional(p_187452_);
        ContainerHelper.saveAllItems(p_187452_, this.items);
    }

    protected Component getDefaultName() {
        return new TranslatableComponent("container.conductor");
    }

    @Override
    protected AbstractContainerMenu createMenu(int p_58627_, Inventory p_58628_) {
        return new ConductorMenu(p_58627_, p_58628_, this, new SimpleContainerData(0));
    }

    @Override
    public int[] getSlotsForFace(Direction p_19238_) {
        return new int[]{0};
    }

    @Override
    public boolean canPlaceItemThroughFace(int p_19235_, ItemStack p_19236_, @Nullable Direction p_19237_) {
        return true;
    }

    @Override
    public boolean canTakeItemThroughFace(int p_19239_, ItemStack p_19240_, Direction p_19241_) {
        return false;
    }

    @Override
    public void clearContent() {
        this.items.clear();
    }

    public void energize(BlockPos pos) {
        if (!this.getLevel().isClientSide) {
            Recipe<?> recipe = this.getLevel().getRecipeManager().getRecipeFor(RecipeInit.ENERGIZING_RECIPE, this, this.getLevel()).orElse(null);
            if (recipe != null) {
                ItemStack itemstack = ((Recipe<WorldlyContainer>) recipe).assemble(this);
                if (itemstack != null) {
                    this.setItem(0, itemstack.copy());
                    BlockState state = this.getLevel().getBlockState(pos);
                    state = state.setValue(ConductorBlock.POWERED, true);
                    this.getLevel().setBlockAndUpdate(pos, state);
                }
            } else {
                if (this.getItem(0).getItem() instanceof IChargedTool) {
                    IChargedTool.setChargeTimer(this.getItem(0), IChargedTool.MAX_CHARGE);
                    if (this.getItem(0) != null) {
                        this.setItem(0, this.getItem(0).copy());
                        BlockState state = this.getLevel().getBlockState(pos);
                        state = state.setValue(ConductorBlock.POWERED, true);
                        this.getLevel().setBlockAndUpdate(pos, state);
                    }
                }
            }
        }

    }

    public static void serverTick(Level p_155014_, BlockPos p_155015_, BlockState p_155016_, ConductorBlockEntity p_155017_) {
        if (p_155017_.getItem(0).isEmpty()) {
            BlockState state = p_155014_.getBlockState(p_155015_);
            state = state.setValue(ConductorBlock.POWERED, false);
            p_155014_.setBlockAndUpdate(p_155015_, state);
        }
    }
}
