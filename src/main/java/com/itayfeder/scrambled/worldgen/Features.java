package com.itayfeder.scrambled.worldgen;

import com.itayfeder.scrambled.init.BlockInit;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;

import java.util.List;
import java.util.OptionalInt;

public class Features {
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ROCK_SALT_FEATURE = FeatureUtils.register("rock_salt_feature",
            Feature.ORE, new OreConfiguration(List.of(
                    OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlockInit.ROCK_SALT.get().defaultBlockState())), 9));

    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> MAHOGANY_TREE = FeatureUtils.register("mahogany_tree", Feature.TREE, createFancyMahogany().build());

    private static TreeConfiguration.TreeConfigurationBuilder createFancyMahogany() {
        return (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(BlockInit.MAHOGANY_LOG.get()), new FancyTrunkPlacer(5, 9, 0), BlockStateProvider.simple(BlockInit.MAHOGANY_LEAVES.get()), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines();
    }
}
