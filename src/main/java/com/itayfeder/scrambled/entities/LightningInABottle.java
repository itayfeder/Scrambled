package com.itayfeder.scrambled.entities;

import com.itayfeder.scrambled.init.EntityTypeInit;
import com.itayfeder.scrambled.init.ItemInit;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class LightningInABottle extends ThrowableItemProjectile {
    public LightningInABottle(EntityType<? extends LightningInABottle> p_37510_, Level p_37511_) {
        super(p_37510_, p_37511_);
    }

    public LightningInABottle(Level p_37518_, LivingEntity p_37519_) {
        super(EntityTypeInit.LIGHTNING_IN_A_BOTTLE.get(), p_37519_, p_37518_);
    }

    public LightningInABottle(Level p_37513_, double p_37514_, double p_37515_, double p_37516_) {
        super(EntityTypeInit.LIGHTNING_IN_A_BOTTLE.get(), p_37514_, p_37515_, p_37516_, p_37513_);
    }

    protected Item getDefaultItem() {
        return ItemInit.LIGHTNING_IN_A_BOTTLE.get();
    }

    protected float getGravity() {
        return 0.05F;
    }

    protected void onHit(HitResult p_37521_) {
        super.onHit(p_37521_);
        if (this.level instanceof ServerLevel) {
            LightningBolt lightningbolt = EntityType.LIGHTNING_BOLT.create(this.level);
            lightningbolt.moveTo(Vec3.atBottomCenterOf(this.blockPosition()));
            lightningbolt.setCause(this.getOwner() instanceof ServerPlayer ? (ServerPlayer)this.getOwner() : null);
            this.level.addFreshEntity(lightningbolt);
            for (int i = 0; i < 50; i++) {
                double x = this.getX() + (this.random.nextFloat() * 3) * (this.random.nextBoolean() ? 1 : -1);
                double y = this.getY() + (this.random.nextFloat() * 2);
                double z = this.getZ() + (this.random.nextFloat() * 3) * (this.random.nextBoolean() ? 1 : -1);
                ((ServerLevel) this.level).sendParticles(ParticleTypes.ELECTRIC_SPARK, x, y, z, 1, 0.0D, 0.0D, 0.0D, 0.1D);
            }
            this.discard();
        }

    }
}