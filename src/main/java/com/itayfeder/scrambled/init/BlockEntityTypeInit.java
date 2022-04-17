package com.itayfeder.scrambled.init;

import com.itayfeder.scrambled.ScrambledMod;
import com.itayfeder.scrambled.blockentities.ConductorBlockEntity;
import com.itayfeder.scrambled.blockentities.ScrambledSignBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityTypeInit {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, ScrambledMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<ConductorBlockEntity>> CONDUCTOR = BLOCK_ENTITY_TYPES.register("conductor",
            () -> BlockEntityType.Builder.of(ConductorBlockEntity::new, BlockInit.CONDUCTOR.get()).build(null));

    public static final RegistryObject<BlockEntityType<ScrambledSignBlockEntity>> SCRAMBLED_SIGN = BLOCK_ENTITY_TYPES.register("scrambled_sign",
            () -> BlockEntityType.Builder.of(ScrambledSignBlockEntity::new, BlockInit.MAHOGANY_SIGN.get(), BlockInit.MAHOGANY_WALL_SIGN.get()).build(null));
}