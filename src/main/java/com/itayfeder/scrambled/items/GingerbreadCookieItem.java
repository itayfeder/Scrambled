package com.itayfeder.scrambled.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GingerbreadCookieItem extends Item {
    private CookieCutterItem.CookieType cookieType;
    public static final Map<Item, Item> CUTTER_TO_COOKIE = new HashMap<>();

    public GingerbreadCookieItem(Properties p_41383_, CookieCutterItem.CookieType c, Item cutter) {
        super(p_41383_);
        this.cookieType = c;
        CUTTER_TO_COOKIE.put(cutter, this);
    }

    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
        p_41423_.add((new TranslatableComponent("item.scrambled.gingerbread." + this.cookieType.getSerializedName()).withStyle(ChatFormatting.GRAY)));
    }
}
