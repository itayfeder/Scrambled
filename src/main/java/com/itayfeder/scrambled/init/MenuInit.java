package com.itayfeder.scrambled.init;

import com.itayfeder.scrambled.ScrambledMod;
import com.itayfeder.scrambled.menus.ConductorMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MenuInit {
    public static final DeferredRegister<MenuType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, ScrambledMod.MOD_ID);

    public static final RegistryObject<MenuType<ConductorMenu>> CONDUCTOR = CONTAINER_TYPES
            .register("conductor", () -> IForgeMenuType.create(ConductorMenu::new));

}
