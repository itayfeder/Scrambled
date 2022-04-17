package com.itayfeder.scrambled.utils;

import com.google.gson.JsonObject;
import com.itayfeder.scrambled.ScrambledMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public record ConfigEnabledCondition(String condition) implements ICondition {

    private static final String CONDITION_NAME = "config_enabled";
    public static final ResourceLocation ID = new ResourceLocation(ScrambledMod.MOD_ID, CONDITION_NAME);

    @Override
    public ResourceLocation getID() {
        return ID;
    }

    public boolean test() {
        return ScrambledConfig.COMMON.getBoolValue(this.condition);
    }

    public static class Serializer implements IConditionSerializer<ConfigEnabledCondition> {

        public Serializer() {
        }

        @Override
        public void write(JsonObject json, ConfigEnabledCondition value) {
            json.addProperty(CONDITION_NAME, value.condition);
        }

        @Override
        public ConfigEnabledCondition read(JsonObject json) {
            return new ConfigEnabledCondition(json.getAsJsonPrimitive(CONDITION_NAME).getAsString());
        }

        @Override
        public ResourceLocation getID() {
            return ID;
        }
    }
}