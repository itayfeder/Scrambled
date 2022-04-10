package com.itayfeder.scrambled;

import com.itayfeder.scrambled.events.BiomeSpawningEvents;
import com.itayfeder.scrambled.init.*;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ScrambledMod.MOD_ID)
public class ScrambledMod
{
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "scrambled";
    public static final CreativeModeTab TAB_MOD = new CreativeModeTab( "scrambled") {
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.SWORDFISH.get());
        }
    };

    public ScrambledMod()
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);

        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(RecipeSerializer.class, RecipeInit::registerRecipeSerializers);
        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        BlockEntityTypeInit.BLOCK_ENTITY_TYPES.register(bus);
        MenuInit.CONTAINER_TYPES.register(bus);
        EntityTypeInit.ENTITY_TYPES.register(bus);
        RecipeInit.RECIPE_TYPES.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            BiomeSpawningEvents.Setup();
        });
    }
}
