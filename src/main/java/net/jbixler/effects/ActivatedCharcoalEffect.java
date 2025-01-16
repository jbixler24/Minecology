package net.jbixler.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.Registries;
import net.minecraft.server.world.ServerWorld;

import java.util.List;

public class ActivatedCharcoalEffect extends StatusEffect {
    protected ActivatedCharcoalEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        List<StatusEffectInstance> poisonEffects =  entity.getStatusEffects().stream().filter(e -> e.getTranslationKey() == "amatoxin_poisoning").toList();
        if (!poisonEffects.isEmpty()) {
            entity.removeStatusEffect(Registries.STATUS_EFFECT.getEntry(ModEffects.AMATOXIN_POISONING));
        }
        return true;
    }
}
