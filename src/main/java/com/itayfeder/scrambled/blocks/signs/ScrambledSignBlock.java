package com.itayfeder.scrambled.blocks.signs;

import com.itayfeder.scrambled.blockentities.ScrambledSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.SignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public abstract class ScrambledSignBlock extends SignBlock {
    protected ScrambledSignBlock(Properties p_56273_, WoodType p_56274_) {
        super(p_56273_, p_56274_);
    }

    public BlockEntity newBlockEntity(BlockPos p_154556_, BlockState p_154557_) {
        return new ScrambledSignBlockEntity(p_154556_, p_154557_);
    }
}
