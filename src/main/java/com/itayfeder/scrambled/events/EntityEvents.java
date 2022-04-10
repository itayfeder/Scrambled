package com.itayfeder.scrambled.events;

import com.itayfeder.scrambled.ScrambledMod;
import com.itayfeder.scrambled.entities.goals.TemptByCrownGoal;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Bee;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ScrambledMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EntityEvents {
    @SubscribeEvent
    public static void onEntityJoin(EntityJoinWorldEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof Bee animal) {
            EntityType<?> type = event.getEntity().getType();
            animal.goalSelector.addGoal(3,
                    new TemptByCrownGoal(animal, 1.25D, false));
        }
    }
}
