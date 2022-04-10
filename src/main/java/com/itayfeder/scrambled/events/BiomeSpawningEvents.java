package com.itayfeder.scrambled.events;

import com.itayfeder.scrambled.ScrambledMod;
import com.itayfeder.scrambled.entities.Snail;
import com.itayfeder.scrambled.init.EntityTypeInit;
import com.itayfeder.scrambled.worldgen.PlacedFeatures;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = ScrambledMod.MOD_ID)
public class BiomeSpawningEvents {
    public static void Setup() {
        SpawnPlacements.register(EntityTypeInit.SNAIL.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Snail::checkSnailSpawnRules);
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void modifyBiomes(BiomeLoadingEvent event) {
        if (event.getName() != null) {
            if (event.getCategory() == Biome.BiomeCategory.SWAMP) {
                event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityTypeInit.SNAIL.get(), 25, 2, 4));

            }
        }

        if (event.getCategory() != Biome.BiomeCategory.THEEND && event.getCategory() != Biome.BiomeCategory.NETHER) {
            if (event.getCategory() != Biome.BiomeCategory.RIVER || event.getCategory() != Biome.BiomeCategory.OCEAN)
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(PlacedFeatures.ROCK_SALT_WATER_PLACED);
            else
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(PlacedFeatures.ROCK_SALT_PLACED);
        }
    }
}
