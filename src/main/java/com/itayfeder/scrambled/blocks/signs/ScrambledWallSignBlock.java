package com.itayfeder.scrambled.blocks.signs;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.itayfeder.scrambled.blockentities.ScrambledSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.Map;

public class ScrambledWallSignBlock extends WallSignBlock {

    public ScrambledWallSignBlock(BlockBehaviour.Properties p_58068_, WoodType p_58069_) {
        super(p_58068_, p_58069_);
    }

    public BlockEntity newBlockEntity(BlockPos p_154556_, BlockState p_154557_) {
        return new ScrambledSignBlockEntity(p_154556_, p_154557_);
    }
}
