package com.itayfeder.scrambled;

import com.google.common.collect.ImmutableMap;
import com.itayfeder.scrambled.data.ScrambledRecipeProvider;
import com.itayfeder.scrambled.data.loot_tables.ScrambledLootTableProvider;
import com.itayfeder.scrambled.data.tags.ScrambledBlockTagsProvider;
import com.itayfeder.scrambled.data.tags.ScrambledItemTagsProvider;
import com.itayfeder.scrambled.events.BiomeSpawningEvents;
import com.itayfeder.scrambled.init.*;
import com.itayfeder.scrambled.utils.ConfigEnabledCondition;
import com.itayfeder.scrambled.utils.ScrambledConfig;
import com.itayfeder.scrambled.utils.ScrambledCreativeTab;
import com.mojang.logging.LogUtils;
import net.minecraft.core.NonNullList;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ScrambledMod.MOD_ID)
@Mod.EventBusSubscriber(modid = ScrambledMod.MOD_ID)
public class ScrambledMod
{
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "scrambled";
    public static final CreativeModeTab TAB_MOD = new ScrambledCreativeTab();

    public ScrambledMod()
    {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ScrambledConfig.commonSpec);

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);
        bus.addListener(this::dataSetup);

        CraftingHelper.register(new ConfigEnabledCondition.Serializer());

        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(RecipeSerializer.class, RecipeInit::registerRecipeSerializers);
        ItemInit.ITEMS.register(bus);
        EnchantmentInit.ENCHANTMENTS.register(bus);
        BlockInit.BLOCKS.register(bus);
        BlockEntityTypeInit.BLOCK_ENTITY_TYPES.register(bus);
        MenuInit.CONTAINER_TYPES.register(bus);
        EntityTypeInit.ENTITY_TYPES.register(bus);
        RecipeInit.RECIPE_TYPES.register(bus);

        MinecraftForge.EVENT_BUS.register(this);

    }

    private void setup(final FMLCommonSetupEvent event)
    {
        AxeItem.STRIPPABLES = new ImmutableMap.Builder<Block, Block>().putAll(AxeItem.STRIPPABLES)
                .put(BlockInit.MAHOGANY_LOG.get(), BlockInit.STRIPPED_MAHOGANY_LOG.get())
                .put(BlockInit.MAHOGANY_WOOD.get(), BlockInit.STRIPPED_MAHOGANY_WOOD.get()).build();

        event.enqueueWork(() -> {
            BiomeSpawningEvents.Setup();
        });
    }

    private void dataSetup(GatherDataEvent event) {
        DataGenerator dataGenerator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        if (event.includeServer()) {
            ScrambledBlockTagsProvider blockTags = new ScrambledBlockTagsProvider(dataGenerator, existingFileHelper);
            dataGenerator.addProvider(blockTags);
            dataGenerator.addProvider(new ScrambledItemTagsProvider(dataGenerator, blockTags, existingFileHelper));


            dataGenerator.addProvider(new ScrambledRecipeProvider(dataGenerator));
            dataGenerator.addProvider(new ScrambledLootTableProvider(dataGenerator));
        }
    }
}
