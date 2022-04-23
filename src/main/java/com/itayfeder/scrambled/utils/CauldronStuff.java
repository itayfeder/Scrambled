package com.itayfeder.scrambled.utils;

import com.itayfeder.scrambled.init.ItemInit;
import com.itayfeder.scrambled.items.BottledCloudItem;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraftforge.registries.ForgeRegistries;

public class CauldronStuff {
    public static void register() {
        CauldronInteraction.WATER.put(ItemInit.BOTTLED_CLOUD.get(), SOGGY_CLOUD);
    }

    static CauldronInteraction SOGGY_CLOUD = (p_175629_, p_175630_, p_175631_, p_175632_, p_175633_, p_175634_) -> {
        Item item = p_175634_.getItem();
        if (!(item instanceof BottledCloudItem)) {
            return InteractionResult.PASS;
        } else {
            if (!p_175630_.isClientSide) {
                p_175632_.setItemInHand(p_175633_,ItemInit.BOTTLED_SOGGY_CLOUD.get().getDefaultInstance());
                p_175632_.awardStat(Stats.CLEAN_ARMOR);
                LayeredCauldronBlock.lowerFillLevel(p_175629_, p_175630_, p_175631_);
            }

            return InteractionResult.sidedSuccess(p_175630_.isClientSide);
        }
    };
}
