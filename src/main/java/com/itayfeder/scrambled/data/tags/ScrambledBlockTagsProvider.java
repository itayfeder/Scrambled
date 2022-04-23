package com.itayfeder.scrambled.data.tags;

import com.itayfeder.scrambled.ScrambledMod;
import com.itayfeder.scrambled.init.BlockInit;
import com.itayfeder.scrambled.utils.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ScrambledBlockTagsProvider extends BlockTagsProvider {
    public ScrambledBlockTagsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, ScrambledMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(BlockTags.PLANKS).add(BlockInit.MAHOGANY_PLANKS.get());
        this.tag(BlockTags.SAPLINGS).add(BlockInit.MAHOGANY_SAPLING.get());
        this.tag(BlockTags.WOODEN_STAIRS).add(BlockInit.MAHOGANY_STAIRS.get());
        this.tag(BlockTags.WOODEN_SLABS).add(BlockInit.MAHOGANY_SLAB.get());
        this.tag(BlockTags.LOGS_THAT_BURN).addTag(ModTags.BlockTags.MAHOGANY_LOGS);
        this.tag(BlockTags.LEAVES).add(BlockInit.MAHOGANY_LEAVES.get());
        this.tag(BlockTags.STANDING_SIGNS).add(BlockInit.MAHOGANY_SIGN.get());
        this.tag(BlockTags.WALL_SIGNS).add(BlockInit.MAHOGANY_WALL_SIGN.get());
        this.tag(BlockTags.WOODEN_FENCES).add(BlockInit.MAHOGANY_FENCE.get());
        this.tag(BlockTags.WOODEN_FENCES).add(BlockInit.MAHOGANY_FENCE_GATE.get());
        this.tag(BlockTags.WOODEN_BUTTONS).add(BlockInit.MAHOGANY_BUTTON.get());
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(BlockInit.MAHOGANY_PRESSURE_PLATE.get());

        this.tag(BlockTags.CLIMBABLE).add(BlockInit.CLOUD_CHUNK.get(), BlockInit.SOGGY_CLOUD_CHUNK.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL).add(BlockInit.CONDUCTOR.get(), BlockInit.GINGERBREAD_BRICKS.get(), BlockInit.GINGERBREAD_BRICK_SLAB.get(), BlockInit.GINGERBREAD_BRICK_STAIRS.get(), BlockInit.ROCK_SALT.get());
        this.tag(BlockTags.MINEABLE_WITH_HOE).add(BlockInit.MAHOGANY_LEAVES.get());
        this.tag(BlockTags.MINEABLE_WITH_AXE).add(BlockInit.GINGERBREAD_BRICKS.get(), BlockInit.GINGERBREAD_BRICK_SLAB.get(), BlockInit.GINGERBREAD_BRICK_STAIRS.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(BlockInit.CONDUCTOR.get(), BlockInit.ROCK_SALT.get());

        this.tag(ModTags.BlockTags.MAHOGANY_LOGS).add(BlockInit.MAHOGANY_LOG.get(), BlockInit.MAHOGANY_WOOD.get(), BlockInit.STRIPPED_MAHOGANY_LOG.get(), BlockInit.STRIPPED_MAHOGANY_WOOD.get());

    }
}
