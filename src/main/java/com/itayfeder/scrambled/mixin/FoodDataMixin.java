package com.itayfeder.scrambled.mixin;

import com.itayfeder.scrambled.utils.SaltyUtils;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(FoodData.class)
public abstract class FoodDataMixin {
    @Shadow public abstract void eat(int p_38708_, float p_38709_);

    @Inject(locals = LocalCapture.CAPTURE_FAILSOFT,
            method = "eat(Lnet/minecraft/world/item/Item;Lnet/minecraft/world/item/ItemStack;)V",
            at = @At(value = "INVOKE", shift = At.Shift.AFTER, target = "Lnet/minecraft/world/food/FoodData;eat(IF)V")
    )
    public void eatInject(Item p_38713_, ItemStack p_38714_, CallbackInfo ci) {
        if (SaltyUtils.IsSalted(p_38714_.getTag())) {
            this.eat(3, 0.3F);
        }
    }
}
