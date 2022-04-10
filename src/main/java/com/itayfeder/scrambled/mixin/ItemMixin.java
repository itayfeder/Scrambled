package com.itayfeder.scrambled.mixin;

import com.itayfeder.scrambled.utils.SaltyUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.List;

@Mixin(Item.class)
public class ItemMixin {
    @Inject(locals = LocalCapture.NO_CAPTURE,
            method = "appendHoverText",
            at = @At(value = "TAIL"),
            cancellable = true
    )
    private void appendHoverTextInject(ItemStack p_41421_, Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_, CallbackInfo ci) {
        if (SaltyUtils.IsSaltable(p_41421_) && SaltyUtils.IsSalted(p_41421_.getTag())) {
            p_41423_.add((new TranslatableComponent("scrambled.salted")).withStyle(ChatFormatting.GRAY));
        }
    }
}
