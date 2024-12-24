package net.jbixler.item;

import net.jbixler.effects.ModEffects;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.registry.Registries;

public class ModFoodComponents {
    public static final FoodComponent FLY_AGARIC_CAP = new FoodComponent.Builder().alwaysEdible().nutrition(2).saturationModifier(0.1f).build();
    public static final FoodComponent DEHYDRATED_FLY_AGARIC_CAP = new FoodComponent.Builder().alwaysEdible().nutrition(2).saturationModifier(0.1f).build();

    public static final FoodComponent LIONS_MANE = new FoodComponent.Builder().nutrition(4).saturationModifier(0.1f).build();
    public static final FoodComponent COOKED_LIONS_MANE = new FoodComponent.Builder().nutrition(8).saturationModifier(0.25f).build();
    public static final FoodComponent OYSTER_MUSHROOM = new FoodComponent.Builder().nutrition(3).saturationModifier(0.1f).build();
    public static final FoodComponent COOKED_OYSTER_MUSHROOM = new FoodComponent.Builder().nutrition(6).saturationModifier(0.25f).build();
    public static final FoodComponent CREAM_OF_OYSTER_MUSHROOM_SOUP = new FoodComponent.Builder().nutrition(12).saturationModifier(0.5f).build();

    public static final ConsumableComponent FLY_AGARIC_CAP_EFFECT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 1200, 0, false, false), 0.5f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(Registries.STATUS_EFFECT.getEntry(ModEffects.BERSERKER), 1200), 0.5f))
            .build();

    public static final ConsumableComponent DEHYDRATED_FLY_AGARIC_CAP_EFFECT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(Registries.STATUS_EFFECT.getEntry(ModEffects.BERSERKER), 1200), 1.0f))
            .build();

    public static final ConsumableComponent LIONS_MANE_EFFECT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 1200, 0, false, false), 0.5f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(Registries.STATUS_EFFECT.getEntry(ModEffects.COGNITION), 600), 1.0f))
            .build();
    public static final ConsumableComponent COOKED_LIONS_MANE_EFFECT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(Registries.STATUS_EFFECT.getEntry(ModEffects.COGNITION), 600), 1.0f))
            .build();
}
