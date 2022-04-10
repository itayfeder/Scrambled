package com.itayfeder.scrambled.worldgen;

import com.itayfeder.scrambled.init.BlockInit;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

import java.util.List;

public class Features {
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ROCK_SALT_FEATURE = FeatureUtils.register("rock_salt_feature",
            Feature.ORE, new OreConfiguration(List.of(
                    OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlockInit.ROCK_SALT.get().defaultBlockState())), 9));
}
