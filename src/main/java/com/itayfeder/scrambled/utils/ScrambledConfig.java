package com.itayfeder.scrambled.utils;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

public class ScrambledConfig {
    public static class Common
    {
        public final List<ForgeConfigSpec.BooleanValue> values = new ArrayList<>();

        public final ForgeConfigSpec.BooleanValue enableFlowerCrownRecipes;
        public final ForgeConfigSpec.BooleanValue addFlowerCrownToTab;

        public final ForgeConfigSpec.BooleanValue fishSwordfish;
        public final ForgeConfigSpec.BooleanValue addSwordfishToTab;

        public final ForgeConfigSpec.BooleanValue findGinger;
        public final ForgeConfigSpec.BooleanValue enableGingerbreadRecipes;
        public final ForgeConfigSpec.BooleanValue addGingerbreadToTab;

        public final ForgeConfigSpec.BooleanValue enableCopperConductorRecipes;
        public final ForgeConfigSpec.BooleanValue addCopperConductorToTab;

        public final ForgeConfigSpec.BooleanValue spawnSnail;
        public final ForgeConfigSpec.BooleanValue addSnailToTab;

        public final ForgeConfigSpec.BooleanValue spawnRockSalt;
        public final ForgeConfigSpec.BooleanValue enableSaltRecipes;
        public final ForgeConfigSpec.BooleanValue addSaltToTab;

        public final ForgeConfigSpec.BooleanValue enableRingOfAttractionRecipes;
        public final ForgeConfigSpec.BooleanValue addRingOfAttractionToTab;

        public final ForgeConfigSpec.BooleanValue spawnMahoganyTrees;
        public final ForgeConfigSpec.BooleanValue enableMahoganyRecipes;
        public final ForgeConfigSpec.BooleanValue addMahoganyToTab;

        public final ForgeConfigSpec.BooleanValue addCloudTrades;
        public final ForgeConfigSpec.BooleanValue enableCloudRecipes;
        public final ForgeConfigSpec.BooleanValue addCloudToTab;

        public Common(ForgeConfigSpec.Builder builder)
        {
            builder.push("flowerCrownModule");
            this.enableFlowerCrownRecipes = registerBool(builder.comment("Enables recipes relating to the Flower Crown module").translation("scrambled.config.registry.enable_flower_crown_recipes").define("enableFlowerCrownRecipes", true));
            this.addFlowerCrownToTab = registerBool(builder.comment("Enables if Flower Crown related items are added to the Scrambled Tab").translation("scrambled.config.registry.add_flower_crown_to_tab").define("addFlowerCrownToTab", true));
            builder.pop();

            builder.push("swordfishModule");
            this.fishSwordfish = registerBool(builder.comment("Enables if Swordfish can be fished.").translation("scrambled.config.registry.fish_swordfish").define("fishSwordfish", true));
            this.addSwordfishToTab = registerBool(builder.comment("Enables if Swordfish related items are added to the Scrambled Tab").translation("scrambled.config.registry.add_swordfish_to_tab").define("addSwordfishToTab", true));
            builder.pop();

            builder.push("gingerbreadModule");
            this.findGinger = registerBool(builder.comment("Enables if Ginger Root can be found in chests.").translation("scrambled.config.registry.find_ginger").define("findGinger", true));
            this.enableGingerbreadRecipes = registerBool(builder.comment("Enables recipes relating to the Gingerbread module").translation("scrambled.config.registry.enable_gingerbread_recipes").define("enableGingerbreadRecipes", true));
            this.addGingerbreadToTab = registerBool(builder.comment("Enables if Gingerbread related items are added to the Scrambled Tab").translation("scrambled.config.registry.add_gingerbread_to_tab").define("addGingerbreadToTab", true));
            builder.pop();

            builder.push("copperConductorModule");
            this.enableCopperConductorRecipes = registerBool(builder.comment("Enables recipes relating to the Copper Conductor module").translation("scrambled.config.registry.enable_copper_conductor_recipes").define("enableCopperConductorRecipes", true));
            this.addCopperConductorToTab = registerBool(builder.comment("Enables if Copper Conductor related items are added to the Scrambled Tab").translation("scrambled.config.registry.add_copper_conductor_to_tab").define("addCopperConductorToTab", true));
            builder.pop();

            builder.push("snailModule");
            this.spawnSnail = registerBool(builder.comment("Enables if Snails can spawn in swamps").translation("scrambled.config.registry.spawn_snail").define("spawnSnail", true));
            this.addSnailToTab = registerBool(builder.comment("Enables if Snail related items are added to the Scrambled Tab").translation("scrambled.config.registry.add_snail_to_tab").define("addSnailToTab", true));
            builder.pop();

            builder.push("saltModule");
            this.spawnRockSalt = registerBool(builder.comment("Enables if Rock Salt patches can spawn in the world").translation("scrambled.config.registry.spawn_rock_salt").define("spawnRockSalt", true));
            this.enableSaltRecipes = registerBool(builder.comment("Enables recipes relating to the Salt module").translation("scrambled.config.registry.enable_salt_recipes").define("enableSaltRecipes", true));
            this.addSaltToTab = registerBool(builder.comment("Enables if Salt related items are added to the Scrambled Tab").translation("scrambled.config.registry.add_salt_to_tab").define("addSaltToTab", true));
            builder.pop();

            builder.push("ringOfAttractionModule");
            this.enableRingOfAttractionRecipes = registerBool(builder.comment("Enables recipes relating to the Ring of Attraction module").translation("scrambled.config.registry.enable_ring_of_attraction_recipes").define("enableRingOfAttractionRecipes", true));
            this.addRingOfAttractionToTab = registerBool(builder.comment("Enables if Ring of Attraction related items are added to the Scrambled Tab").translation("scrambled.config.registry.add_ring_of_attraction_to_tab").define("addRingOfAttractionToTab", true));
            builder.pop();

            builder.push("mahoganyModule");
            this.spawnMahoganyTrees = registerBool(builder.comment("Enables if Mahogany trees can spawn in the world").translation("scrambled.config.registry.spawn_mahogany_trees").define("spawnMahoganyTrees", true));
            this.enableMahoganyRecipes = registerBool(builder.comment("Enables recipes relating to the Mahogany module").translation("scrambled.config.registry.enable_mahogany_recipes").define("enableMahoganyRecipes", true));
            this.addMahoganyToTab = registerBool(builder.comment("Enables if Mahogany related items are added to the Scrambled Tab").translation("scrambled.config.registry.add_mahogany_to_tab").define("addMahoganyToTab", true));
            builder.pop();

            builder.push("cloudModule");
            this.addCloudTrades = registerBool(builder.comment("Enables if Bottled Clouds can be bought from the Wandering Trader").translation("scrambled.config.registry.add_cloud_trades").define("addCloudTrades", true));
            this.enableCloudRecipes = registerBool(builder.comment("Enables recipes relating to the Cloud module").translation("scrambled.config.registry.enable_cloud_recipes").define("enableCloudRecipes", true));
            this.addCloudToTab = registerBool(builder.comment("Enables if Cloud related items are added to the Scrambled Tab").translation("scrambled.config.registry.add_cloud_to_tab").define("addCloudToTab", true));
            builder.pop();
        }

        private ForgeConfigSpec.BooleanValue registerBool(ForgeConfigSpec.BooleanValue bool) {
            this.values.add(bool);
            return bool;
        }

        public boolean getBoolValue(String name) {
            for (ForgeConfigSpec.BooleanValue spec : values) {
                if (spec.getPath().contains(name)) return spec.get();
            }
            return true;
        }

    }

    public static class Registry {

    }


    public static final ForgeConfigSpec commonSpec;
    public static final Common COMMON;

    static
    {
        final Pair<Common, ForgeConfigSpec> serverSpecPair = new ForgeConfigSpec.Builder().configure(Common::new);
        commonSpec = serverSpecPair.getRight();
        COMMON = serverSpecPair.getLeft();

    }
}
