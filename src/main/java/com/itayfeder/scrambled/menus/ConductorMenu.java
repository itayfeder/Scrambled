package com.itayfeder.scrambled.menus;

import com.itayfeder.scrambled.init.MenuInit;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ConductorMenu extends AbstractContainerMenu {
    private final Container container;
    private final ContainerData data;
    protected final Level level;

    public ConductorMenu(int p_39532_, Inventory p_39533_, FriendlyByteBuf friendlyByteBuf) {
        this(MenuInit.CONDUCTOR.get(), p_39532_, p_39533_);
    }

    public ConductorMenu(int p_39535_, Inventory p_39536_, Container p_39537_, ContainerData p_39538_) {
        this(MenuInit.CONDUCTOR.get(), p_39535_, p_39536_, p_39537_, p_39538_);
    }

    protected ConductorMenu(MenuType<?> p_38960_, int p_38963_, Inventory p_38964_) {
        this(p_38960_, p_38963_, p_38964_, new SimpleContainer(1), new SimpleContainerData(0));
    }

    protected ConductorMenu(MenuType<?> p_38966_, int p_38969_, Inventory p_38970_, Container p_38971_, ContainerData p_38972_) {
        super(p_38966_, p_38969_);
        checkContainerSize(p_38971_, 1);
        checkContainerDataCount(p_38972_, 0);
        this.container = p_38971_;
        this.data = p_38972_;
        this.level = p_38970_.player.level;
        this.addSlot(new OneItemSlot(this, p_38971_, 0, 80, 36));
        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(p_38970_, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(p_38970_, k, 8 + k * 18, 142));
        }

        this.addDataSlots(p_38972_);
    }

    @Override
    public boolean stillValid(Player p_38874_) {
        return this.container.stillValid(p_38874_);
    }

    public ItemStack quickMoveStack(Player p_39651_, int p_39652_) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(p_39652_);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (p_39652_ < this.container.getContainerSize()) {
                if (!this.moveItemStackTo(itemstack1, this.container.getContainerSize(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 0, this.container.getContainerSize(), false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemstack;
    }
}
