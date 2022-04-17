package com.itayfeder.scrambled.init;

import com.itayfeder.scrambled.ScrambledMod;
import com.itayfeder.scrambled.blocks.ConductorBlock;
import com.itayfeder.scrambled.blocks.grower.MahoganyTreeGrower;
import com.itayfeder.scrambled.blocks.signs.ScrambledStandingSignBlock;
import com.itayfeder.scrambled.blocks.signs.ScrambledWallSignBlock;
import com.itayfeder.scrambled.utils.ModdedWoodTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.data.BlockFamilies;
import net.minecraft.data.BlockFamily;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.OakTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ScrambledMod.MOD_ID);

    public static final RegistryObject<Block> GINGERBREAD_BRICKS = BLOCKS.register("gingerbread_bricks", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PODZOL).strength(2.0F, 4.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> GINGERBREAD_BRICK_STAIRS = BLOCKS.register("gingerbread_brick_stairs", () -> new StairBlock(GINGERBREAD_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(GINGERBREAD_BRICKS.get())));
    public static final RegistryObject<Block> GINGERBREAD_BRICK_SLAB = BLOCKS.register("gingerbread_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(GINGERBREAD_BRICKS.get())));

    public static final RegistryObject<Block> CONDUCTOR = BLOCKS.register("conductor", () -> new ConductorBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER)));

    public static final RegistryObject<Block> ROCK_SALT = BLOCKS.register("rock_salt", () ->  new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));

    public static final RegistryObject<Block> MAHOGANY_PLANKS = BLOCKS.register("mahogany_planks", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.NETHER).strength(4.0F, 6.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> MAHOGANY_LOG = BLOCKS.register("mahogany_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (p_152624_) -> {
        return p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.NETHER : MaterialColor.STONE;
    }).strength(4.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_MAHOGANY_LOG = BLOCKS.register("stripped_mahogany_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (p_152624_) -> {
        return p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.NETHER : MaterialColor.NETHER;
    }).strength(4.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> MAHOGANY_WOOD = BLOCKS.register("mahogany_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.STONE).strength(4.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_MAHOGANY_WOOD = BLOCKS.register("stripped_mahogany_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.NETHER).strength(4.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> MAHOGANY_STAIRS = BLOCKS.register("mahogany_stairs", () -> new StairBlock(MAHOGANY_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(MAHOGANY_PLANKS.get())));
    public static final RegistryObject<Block> MAHOGANY_SLAB = BLOCKS.register("mahogany_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.NETHER).strength(4.0F, 6.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> MAHOGANY_LEAVES = BLOCKS.register("mahogany_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(BlockInit::ocelotOrParrot).isSuffocating(BlockInit::never).isViewBlocking(BlockInit::never)));
    public static final RegistryObject<Block> MAHOGANY_FENCE = BLOCKS.register("mahogany_fence", () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD, MAHOGANY_PLANKS.get().defaultMaterialColor()).strength(4.0F, 6.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> MAHOGANY_FENCE_GATE = BLOCKS.register("mahogany_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD, MAHOGANY_PLANKS.get().defaultMaterialColor()).strength(4.0F, 6.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> MAHOGANY_SIGN = BLOCKS.register("mahogany_sign", () -> new ScrambledStandingSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(2.0F).sound(SoundType.WOOD), ModdedWoodTypes.MAHOGANY));
    public static final RegistryObject<Block> MAHOGANY_WALL_SIGN = BLOCKS.register("mahogany_wall_sign", () -> new ScrambledWallSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(2.0F).sound(SoundType.WOOD), ModdedWoodTypes.MAHOGANY));
    public static final RegistryObject<Block> MAHOGANY_BUTTON = BLOCKS.register("mahogany_button", () -> new WoodButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(1F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> MAHOGANY_PRESSURE_PLATE = BLOCKS.register("mahogany_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().noCollission().strength(1F)));
    public static final RegistryObject<Block> MAHOGANY_SAPLING = BLOCKS.register("mahogany_sapling", () -> new SaplingBlock(new MahoganyTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));

    private static Boolean ocelotOrParrot(BlockState p_50822_, BlockGetter p_50823_, BlockPos p_50824_, EntityType<?> p_50825_) {
        return p_50825_ == EntityType.OCELOT || p_50825_ == EntityType.PARROT;
    }

    private static boolean never(BlockState p_50806_, BlockGetter p_50807_, BlockPos p_50808_) {
        return false;
    }

    public static class ModBlockFamilies {
        public static final BlockFamily MAHOGANY_PLANKS = BlockFamilies.familyBuilder(BlockInit.MAHOGANY_PLANKS.get()).sign(BlockInit.MAHOGANY_SIGN.get(), BlockInit.MAHOGANY_WALL_SIGN.get()).slab(BlockInit.MAHOGANY_SLAB.get()).stairs(BlockInit.MAHOGANY_STAIRS.get()).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();
    }
}
