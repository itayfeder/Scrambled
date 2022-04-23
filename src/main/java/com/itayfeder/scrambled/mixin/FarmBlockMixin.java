package com.itayfeder.scrambled.mixin;

import com.itayfeder.scrambled.blocks.SoggyCloudChunkBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FarmBlock.class)
public class FarmBlockMixin {
    @Inject(method = "isNearWater",
            at = @At(value = "TAIL"),
            cancellable = true
    )
    private static void isNearWaterInject(LevelReader blockpos, BlockPos p_53259_, CallbackInfoReturnable<Boolean> cir) {
        for (int i = 1; i <= 10; i++) {
            BlockState blockstate = blockpos.getBlockState(p_53259_.above(i));
            if (blockstate.getBlock() instanceof SoggyCloudChunkBlock) {
                cir.setReturnValue(Boolean.valueOf(true));
                return;
            }
        }
    }


}
