package com.itayfeder.scrambled.data.loot_tables;

import com.itayfeder.scrambled.init.BlockInit;
import com.itayfeder.scrambled.init.ItemInit;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

public class ScrambledBlockLoot extends BlockLoot {
    @Override
    protected void addTables() {
        this.dropSelf(BlockInit.GINGERBREAD_BRICKS.get());
        this.dropSelf(BlockInit.GINGERBREAD_BRICK_SLAB.get());
        this.dropSelf(BlockInit.GINGERBREAD_BRICK_STAIRS.get());
        this.add(BlockInit.CONDUCTOR.get(), BlockLoot::createNameableBlockEntityTable);
        this.add(BlockInit.ROCK_SALT.get(), ScrambledBlockLoot::createRockSaltDrops);
        this.dropSelf(BlockInit.MAHOGANY_PLANKS.get());
        this.dropSelf(BlockInit.MAHOGANY_SAPLING.get());
        this.dropSelf(BlockInit.MAHOGANY_LOG.get());
        this.dropSelf(BlockInit.STRIPPED_MAHOGANY_LOG.get());
        this.dropSelf(BlockInit.MAHOGANY_WOOD.get());
        this.dropSelf(BlockInit.STRIPPED_MAHOGANY_WOOD.get());
        this.dropSelf(BlockInit.MAHOGANY_SIGN.get());
        this.dropSelf(BlockInit.MAHOGANY_WALL_SIGN.get());
        this.dropSelf(BlockInit.MAHOGANY_STAIRS.get());
        this.add(BlockInit.MAHOGANY_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(BlockInit.MAHOGANY_LEAVES.get(), (p_124106_) -> {
            return createLeavesDrops(p_124106_, BlockInit.MAHOGANY_SAPLING.get(), new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F});
        });
        this.dropSelf(BlockInit.MAHOGANY_FENCE.get());
        this.dropSelf(BlockInit.MAHOGANY_FENCE_GATE.get());
        this.dropSelf(BlockInit.MAHOGANY_BUTTON.get());
        this.dropSelf(BlockInit.MAHOGANY_PRESSURE_PLATE.get());

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

    protected static LootTable.Builder createRockSaltDrops(Block p_176049_) {
        return createSilkTouchDispatchTable(p_176049_, applyExplosionDecay(p_176049_, LootItem.lootTableItem(ItemInit.SALT.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }
}
