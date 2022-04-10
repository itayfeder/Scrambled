package com.itayfeder.scrambled.loot;

import com.google.gson.JsonObject;
import com.itayfeder.scrambled.init.ItemInit;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;

import javax.annotation.Nonnull;
import java.util.List;

public class GingerDungeonModifier extends LootModifier {

    protected GingerDungeonModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Nonnull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        if (context.getRandom().nextFloat() < 0.2) {
            generatedLoot.remove(context.getRandom().nextInt(generatedLoot.size()));
            generatedLoot.add(new ItemStack(ItemInit.GINGER_ROOT.get(), context.getRandom().nextInt(3, 12)));
        }
        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<GingerDungeonModifier> {

        @Override
        public GingerDungeonModifier read(ResourceLocation name, JsonObject object, LootItemCondition[] conditionsIn) {
            return new GingerDungeonModifier(conditionsIn);
        }

        @Override
        public JsonObject write(GingerDungeonModifier instance) {
            JsonObject json = makeConditions(instance.conditions);
            return json;
        }
    }
}
