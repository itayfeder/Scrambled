package com.itayfeder.scrambled.blocks;

import com.itayfeder.scrambled.init.BlockInit;
import com.itayfeder.scrambled.init.ItemInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class SoggyCloudChunkBlock extends HalfTransparentBlock {
    public static final BooleanProperty PERSISTENT = BlockStateProperties.PERSISTENT;

    public SoggyCloudChunkBlock(Properties p_53970_) {
        super(p_53970_);
        this.registerDefaultState(this.stateDefinition.any().setValue(PERSISTENT, Boolean.valueOf(false)));
    }

    public void entityInside(BlockState p_58180_, Level p_58181_, BlockPos p_58182_, Entity p_58183_) {
        p_58183_.makeStuckInBlock(p_58180_, new Vec3(0.45D, (double)0.45F, 0.45D));
    }

    @Override
    public boolean propagatesSkylightDown(BlockState p_49928_, BlockGetter p_49929_, BlockPos p_49930_) {
        return true;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_54447_) {
        p_54447_.add(PERSISTENT);
    }

    public BlockState getStateForPlacement(BlockPlaceContext p_54424_) {
        return this.defaultBlockState().setValue(PERSISTENT, Boolean.valueOf(true));
    }

    @Override
    public void animateTick(BlockState p_49888_, Level p_49889_, BlockPos p_49890_, Random p_49891_) {
        double d0 = 0.5625D;
        Random random = p_49889_.random;

        for(Direction direction : Direction.values()) {
            BlockPos blockpos = p_49890_.relative(direction);
            if (!p_49889_.getBlockState(blockpos).isSolidRender(p_49889_, blockpos) && !p_49889_.getBlockState(blockpos).is(BlockInit.SOGGY_CLOUD_CHUNK.get())) {
                Direction.Axis direction$axis = direction.getAxis();
                double d1 = direction$axis == Direction.Axis.X ? 0.5D + 0.5625D * (double)direction.getStepX() : (double)random.nextFloat();
                double d2 = direction$axis == Direction.Axis.Y ? 0.5D + 0.5625D * (double)direction.getStepY() : (double)random.nextFloat();
                double d3 = direction$axis == Direction.Axis.Z ? 0.5D + 0.5625D * (double)direction.getStepZ() : (double)random.nextFloat();
                p_49889_.addParticle(ParticleTypes.RAIN, (double)p_49890_.getX() + d1, (double)p_49890_.getY() + d2, (double)p_49890_.getZ() + d3, 0.0D, 0.0D, 0.0D);
            }
        }
    }

    public VoxelShape getCollisionShape(BlockState p_154285_, BlockGetter p_154286_, BlockPos p_154287_, CollisionContext p_154288_) {
        if (p_154288_ instanceof EntityCollisionContext) {
            EntityCollisionContext entitycollisioncontext = (EntityCollisionContext)p_154288_;
            Entity entity = entitycollisioncontext.getEntity();
            if (entity instanceof LivingEntity living && !living.isCrouching() && p_154288_.isAbove(Shapes.block(), p_154287_, true)) {
                if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FALL_PROTECTION, living) > 0) {
                    return Shapes.box(0D, 0.99D, 0D, 1D, 1D, 1D);
                }

            }
        }

        return Shapes.empty();
    }

    public void randomTick(BlockState p_55488_, ServerLevel p_55489_, BlockPos p_55490_, Random p_55491_) {
        for (int i = 1; i <= 10; i++) {
            BlockPos pos = p_55490_.below(i);
            BlockState blockstate = p_55489_.getBlockState(pos);
            if (blockstate.getBlock() instanceof CauldronBlock || blockstate.getBlock() instanceof LayeredCauldronBlock) {
                blockstate.getBlock().handlePrecipitation(blockstate, p_55489_, pos, Biome.Precipitation.RAIN);
                i = 56;
            }

        }

    }

    @Override
    public Item asItem() {
        return ItemInit.BOTTLED_SOGGY_CLOUD.get();
    }

    @Override
    public InteractionResult use(BlockState p_60503_, Level p_60504_, BlockPos p_60505_, Player p_60506_, InteractionHand p_60507_, BlockHitResult p_60508_) {
        if (p_60506_.getItemInHand(p_60507_).is(Items.GLASS_BOTTLE)) {
            ItemStack stack = p_60506_.getItemInHand(p_60507_);
            if (!p_60504_.isClientSide) {
                Random random = p_60504_.random;
                this.turnBottleIntoItem(stack, p_60506_, ItemInit.BOTTLED_SOGGY_CLOUD.get().getDefaultInstance());
                for(Direction direction : Direction.values()) {
                    BlockPos blockpos = p_60505_.relative(direction);
                    if (!p_60504_.getBlockState(blockpos).isSolidRender(p_60504_, blockpos)) {
                        Direction.Axis direction$axis = direction.getAxis();
                        double d1 = direction$axis == Direction.Axis.X ? 0.5D + 0.5625D * (double)direction.getStepX() : (double)random.nextFloat();
                        double d2 = direction$axis == Direction.Axis.Y ? 0.5D + 0.5625D * (double)direction.getStepY() : (double)random.nextFloat();
                        double d3 = direction$axis == Direction.Axis.Z ? 0.5D + 0.5625D * (double)direction.getStepZ() : (double)random.nextFloat();
                        p_60504_.addParticle(ParticleTypes.RAIN, (double)p_60505_.getX() + d1, (double)p_60505_.getY() + d2, (double)p_60505_.getZ() + d3, 0.0D, 0.0D, 0.0D);
                    }
                }
                p_60504_.setBlockAndUpdate(p_60505_, Blocks.AIR.defaultBlockState());

            }
            return InteractionResult.sidedSuccess(p_60504_.isClientSide());
        }
        return super.use(p_60503_, p_60504_, p_60505_, p_60506_, p_60507_, p_60508_);
    }

    protected ItemStack turnBottleIntoItem(ItemStack p_40652_, Player p_40653_, ItemStack p_40654_) {
        return ItemUtils.createFilledResult(p_40652_, p_40653_, p_40654_);
    }
}