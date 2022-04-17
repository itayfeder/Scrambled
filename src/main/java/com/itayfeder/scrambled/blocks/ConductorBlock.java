package com.itayfeder.scrambled.blocks;

import com.itayfeder.scrambled.blockentities.ConductorBlockEntity;
import com.itayfeder.scrambled.init.BlockEntityTypeInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LightningRodBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HopperBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class ConductorBlock extends BaseEntityBlock {
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

    public ConductorBlock(Properties p_49224_) {
        super(p_49224_);
        this.registerDefaultState(this.defaultBlockState().setValue(POWERED, Boolean.valueOf(false)));
    }

    public InteractionResult use(BlockState p_54787_, Level p_54788_, BlockPos p_54789_, Player p_54790_, InteractionHand p_54791_, BlockHitResult p_54792_) {
        if (p_54788_.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            BlockEntity blockentity = p_54788_.getBlockEntity(p_54789_);
            if (blockentity instanceof ConductorBlockEntity) {
                p_54790_.openMenu((MenuProvider)blockentity);
            }
            return InteractionResult.CONSUME;
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
        return new ConductorBlockEntity(p_153215_, p_153216_);
    }

    @Override
    public RenderShape getRenderShape(BlockState p_49232_) {
        return RenderShape.MODEL;
    }

    @Override
    public void neighborChanged(BlockState p_60509_, Level p_60510_, BlockPos p_60511_, Block p_60512_, BlockPos p_60513_, boolean p_60514_) {
        if (p_60512_ instanceof LightningRodBlock && compareBlockPos(p_60511_.above(), p_60513_)) {
            if (p_60510_.getBlockState(p_60513_).getValue(LightningRodBlock.POWERED)) {
                if (p_60510_.getBlockEntity(p_60511_) instanceof ConductorBlockEntity conductor) {
                    conductor.energize(p_60511_);
                }
            }
        }
        super.neighborChanged(p_60509_, p_60510_, p_60511_, p_60512_, p_60513_, p_60514_);
    }

    private static boolean compareBlockPos(BlockPos p1, BlockPos p2) {
        return p1.getX() == p2.getX() && p1.getY() == p2.getY() && p1.getZ() == p2.getZ();
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_55673_) {
        p_55673_.add(POWERED);
    }

    public void onRemove(BlockState p_54085_, Level p_54086_, BlockPos p_54087_, BlockState p_54088_, boolean p_54089_) {
        if (!p_54085_.is(p_54088_.getBlock())) {
            BlockEntity blockentity = p_54086_.getBlockEntity(p_54087_);
            if (blockentity instanceof ConductorBlockEntity) {
                Containers.dropContents(p_54086_, p_54087_, (ConductorBlockEntity)blockentity);
                p_54086_.updateNeighbourForOutputSignal(p_54087_, this);
            }

            super.onRemove(p_54085_, p_54086_, p_54087_, p_54088_, p_54089_);
        }
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_153273_, BlockState p_153274_, BlockEntityType<T> p_153275_) {
        return p_153273_.isClientSide ? null : createTickerHelper(p_153275_, BlockEntityTypeInit.CONDUCTOR.get(), ConductorBlockEntity::serverTick);
    }
}
