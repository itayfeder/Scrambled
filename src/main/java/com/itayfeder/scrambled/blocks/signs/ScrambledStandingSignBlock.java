package com.itayfeder.scrambled.blocks.signs;

import com.itayfeder.scrambled.blockentities.ScrambledSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

public class ScrambledStandingSignBlock extends StandingSignBlock {
    public static final IntegerProperty ROTATION = BlockStateProperties.ROTATION_16;

    public ScrambledStandingSignBlock(BlockBehaviour.Properties p_56990_, WoodType p_56991_) {
        super(p_56990_, p_56991_);
    }

    public BlockEntity newBlockEntity(BlockPos p_154556_, BlockState p_154557_) {
        return new ScrambledSignBlockEntity(p_154556_, p_154557_);
    }
}
