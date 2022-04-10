package com.itayfeder.scrambled.menus;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;

public class OneItemSlot extends Slot {
    private final ConductorMenu menu;

    public OneItemSlot(ConductorMenu p_39520_, Container p_39521_, int p_39522_, int p_39523_, int p_39524_) {
        super(p_39521_, p_39522_, p_39523_, p_39524_);
        this.menu = p_39520_;
    }

    @Override
    public int getMaxStackSize() {
        return 1;
    }
}