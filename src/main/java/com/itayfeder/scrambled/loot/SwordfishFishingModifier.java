package com.itayfeder.scrambled.loot;

import com.google.gson.JsonObject;
import com.itayfeder.scrambled.init.ItemInit;
import com.mojang.realmsclient.util.JsonUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.List;

public class SwordfishFishingModifier extends LootModifier {

    protected SwordfishFishingModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Nonnull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        if (context.getRandom().nextFloat() < 0.1) {
            generatedLoot.clear();
            generatedLoot.add(new ItemStack(ItemInit.SWORDFISH.get(), 1));
        }
        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<SwordfishFishingModifier> {

        @Override
        public SwordfishFishingModifier read(ResourceLocation name, JsonObject object, LootItemCondition[] conditionsIn) {
            return new SwordfishFishingModifier(conditionsIn);
        }

        @Override
        public JsonObject write(SwordfishFishingModifier instance) {
            JsonObject json = makeConditions(instance.conditions);
            return json;
        }
    }
}
