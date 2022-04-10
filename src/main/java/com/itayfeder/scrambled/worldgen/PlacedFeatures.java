package com.itayfeder.scrambled.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class PlacedFeatures {
    public static final Holder<PlacedFeature> ROCK_SALT_PLACED = PlacementUtils.register("rock_salt_placed",
            Features.ROCK_SALT_FEATURE, Placements.commonOrePlacement(5,
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(10), VerticalAnchor.absolute(100))));

    public static final Holder<PlacedFeature> ROCK_SALT_WATER_PLACED = PlacementUtils.register("rock_salt_water_placed",
            Features.ROCK_SALT_FEATURE, Placements.commonOrePlacement(10,
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(30), VerticalAnchor.absolute(80))));
}
