package net.jbixler.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;

public class CognitionEffect extends StatusEffect {
    protected CognitionEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    // TODO: implement; consume less experience when enchanting and gain more experience from smelting, fighting, etc.
    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        return super.applyUpdateEffect(world, entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return super.canApplyUpdateEffect(duration, amplifier);
    }

}
