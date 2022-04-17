package com.itayfeder.scrambled.worldgen;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class PlacedFeatures {
    public static final Holder<PlacedFeature> ROCK_SALT_PLACED = PlacementUtils.register("rock_salt_placed",
            Features.ROCK_SALT_FEATURE, Placements.commonOrePlacement(5,
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(10), VerticalAnchor.absolute(100))));

    public static final Holder<PlacedFeature> ROCK_SALT_WATER_PLACED = PlacementUtils.register("rock_salt_water_placed",
            Features.ROCK_SALT_FEATURE, Placements.commonOrePlacement(10,
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(30), VerticalAnchor.absolute(80))));

    public static final Holder<PlacedFeature> MAHOGANY_TREE_CHECKED = PlacementUtils.register("mahogany_tree_checked", Features.MAHOGANY_TREE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
    public static final Holder<PlacedFeature> MAHOGANY_TREE_WILD = PlacementUtils.register("mahogany_tree_wild", Features.MAHOGANY_TREE, List.of(PlacementUtils.countExtra(0, 0.5F, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)), BiomeFilter.biome()));

}
