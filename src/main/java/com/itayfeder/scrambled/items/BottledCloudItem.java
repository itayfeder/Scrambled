package com.itayfeder.scrambled.items;

import com.mojang.math.Vector3d;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class BottledCloudItem extends Item {
    Block placedBlock;
    public BottledCloudItem(Properties p_41383_, Block block) {
        super(p_41383_);
        this.placedBlock = block;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        HitResult result = rayTrace(world, player, ClipContext.Fluid.NONE);

        if (result instanceof BlockHitResult) {
            BlockHitResult bresult = (BlockHitResult) result;
            BlockPos pos = bresult.getBlockPos();
            if(!world.isEmptyBlock(pos))
                pos = pos.relative(bresult.getDirection());
            if(world.isEmptyBlock(pos)) {
                if(!world.isClientSide) {
                    world.setBlockAndUpdate(pos, this.placedBlock.defaultBlockState());

                }

                stack.shrink(1);
                if(!player.isCreative()) {
                    ItemStack returnStack = new ItemStack(Items.GLASS_BOTTLE);
                    if(stack.isEmpty())
                        stack = returnStack;
                    else if(!player.addItem(returnStack))
                        player.drop(returnStack, false);
                }

                player.getCooldowns().addCooldown(this, 10);
                return new InteractionResultHolder<ItemStack>(InteractionResult.SUCCESS, stack);
            }
        }

        return new InteractionResultHolder<ItemStack>(InteractionResult.PASS, stack);

    }

    protected static HitResult rayTrace(Level worldIn, Player player, ClipContext.Fluid fluidMode) {
        float f = player.xRotO;
        float f1 = player.yRotO;
        Vec3 vector3d = player.getEyePosition(1.0F);
        float f2 = Mth.cos(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f3 = Mth.sin(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f4 = -Mth.cos(-f * ((float)Math.PI / 180F));
        float f5 = Mth.sin(-f * ((float)Math.PI / 180F));
        float f6 = f3 * f4;
        float f7 = f2 * f4;
        double d0 = 4;
        Vec3 vector3d1 = vector3d.add((double)f6 * d0, (double)f5 * d0, (double)f7 * d0);
        return worldIn.clip(new ClipContext(vector3d, vector3d1, ClipContext.Block.OUTLINE, fluidMode, player));
    }
}
