package com.itayfeder.scrambled.init;

import com.itayfeder.scrambled.ScrambledMod;
import com.itayfeder.scrambled.entities.LightningInABottle;
import com.itayfeder.scrambled.entities.Snail;
import com.itayfeder.scrambled.entities.decoration.PhantomItemFrame;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = ScrambledMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityTypeInit {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, ScrambledMod.MOD_ID);

    public static final RegistryObject<EntityType<PhantomItemFrame>> PHANTOM_ITEM_FRAME = ENTITY_TYPES.register("phantom_item_frame",
            () -> EntityType.Builder.<PhantomItemFrame>of(PhantomItemFrame::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F).clientTrackingRange(10).updateInterval(Integer.MAX_VALUE)
                    .setCustomClientFactory(PhantomItemFrame::new)
                    .build(new ResourceLocation(ScrambledMod.MOD_ID, "phantom_item_frame").toString()));

    public static final RegistryObject<EntityType<LightningInABottle>> LIGHTNING_IN_A_BOTTLE = ENTITY_TYPES.register("lightning_in_a_bottle",
            () -> EntityType.Builder.<LightningInABottle>of(LightningInABottle::new, MobCategory.MISC)
                    .sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10)
                    .build(new ResourceLocation(ScrambledMod.MOD_ID, "lightning_in_a_bottle").toString()));

    public static final RegistryObject<EntityType<Snail>> SNAIL = ENTITY_TYPES.register("snail",
            () -> EntityType.Builder.<Snail>of(Snail::new, MobCategory.CREATURE)
                    .sized(0.3F, 0.3F).clientTrackingRange(10)
                    .build(new ResourceLocation(ScrambledMod.MOD_ID, "snail").toString()));

    @SubscribeEvent
    public static void registerEntityAttribute(EntityAttributeCreationEvent event) {
        event.put(SNAIL.get(), Snail.createAttributes().build());
    }

}
