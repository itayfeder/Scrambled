package com.itayfeder.scrambled.init;

import com.itayfeder.scrambled.ScrambledMod;
import com.itayfeder.scrambled.blocks.ConductorBlock;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
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

}
