package com.itayfeder.scrambled.init;

import com.itayfeder.scrambled.ScrambledMod;
import com.itayfeder.scrambled.blockentities.ConductorBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityTypeInit {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, ScrambledMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<ConductorBlockEntity>> CONDUCTOR = BLOCK_ENTITY_TYPES.register("conductor",
            () -> BlockEntityType.Builder.of(ConductorBlockEntity::new, BlockInit.CONDUCTOR.get()).build(null));

}