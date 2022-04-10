package com.itayfeder.scrambled.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CookieCutterItem extends Item {
    private CookieType cookieType;

    public CookieCutterItem(Properties p_41383_, CookieType c) {
        super(p_41383_);
        this.cookieType = c;
    }

    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
        p_41423_.add((new TranslatableComponent("item.scrambled.gingerbread." + this.cookieType.name).withStyle(ChatFormatting.GRAY)));
    }

    @Override
    public boolean hasCraftingRemainingItem() {
        return true;
    }

    @Override
    public boolean isEnchantable(ItemStack p_41456_) {
        return false;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemstack) {
        ItemStack retval = new ItemStack(this);
        retval.setDamageValue(itemstack.getDamageValue() + 1);
        if (retval.getDamageValue() >= retval.getMaxDamage()) {
            return ItemStack.EMPTY;
        }
        return retval;
    }

    @Override
    public boolean isRepairable(ItemStack itemstack) {
        return false;
    }



    public enum CookieType implements StringRepresentable {
        CIRCLE(0, "circle"),
        STAR(1, "star"),
        SNOWMAN(2, "snowman"),
        CANE(3, "cane"),
        MAN(4, "man"),
        CREEPER(5, "creeper");

        private final int id;
        private final String name;

        private CookieType(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return name;
        }
    }
}
