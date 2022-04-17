package com.itayfeder.scrambled.data.tags;

import com.itayfeder.scrambled.ScrambledMod;
import com.itayfeder.scrambled.utils.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class ScrambledItemTagsProvider extends ItemTagsProvider {
    public ScrambledItemTagsProvider(DataGenerator p_126530_, BlockTagsProvider p_126531_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_126530_, p_126531_, ScrambledMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.copy(BlockTags.PLANKS, ItemTags.PLANKS);
        this.copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);
        this.copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);
        this.copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);
        this.copy(BlockTags.LOGS_THAT_BURN, ItemTags.LOGS_THAT_BURN);
        this.copy(BlockTags.STANDING_SIGNS, ItemTags.SIGNS);
        this.copy(ModTags.BlockTags.MAHOGANY_LOGS, ModTags.ItemTags.MAHOGANY_LOGS);
        this.copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);
        this.copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);
        this.copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);

        this.tag(ModTags.ItemTags.CROWN_FLOWERS).add(Items.DANDELION, Items.POPPY, Items.BLUE_ORCHID, Items.ALLIUM, Items.CORNFLOWER, Items.WITHER_ROSE, Items.LILY_OF_THE_VALLEY);
        this.tag(ModTags.ItemTags.SALTABLE).add(Items.COOKED_PORKCHOP, Items.COOKED_BEEF, Items.COOKED_COD, Items.COOKED_CHICKEN, Items.COOKED_MUTTON, Items.COOKED_RABBIT, Items.COOKED_SALMON, Items.BAKED_POTATO);

    }
}
