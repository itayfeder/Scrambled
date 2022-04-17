package com.itayfeder.scrambled.blocks.grower;

import com.itayfeder.scrambled.worldgen.Features;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.util.Random;

public class MahoganyTreeGrower extends AbstractTreeGrower {
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random p_204310_, boolean p_204311_) {
        return Features.MAHOGANY_TREE;
    }
}