package net.jbixler.effects;

import net.jbixler.Minecology;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final StatusEffect AMATOXIN_POISONING = registerStatusEffect("amatoxin_poisoning", new AmatoxinPoisoningEffect(StatusEffectCategory.HARMFUL, 0x000000FF));
    public static final StatusEffect BERSERKER = registerStatusEffect("berserker", new BerserkerEffect(StatusEffectCategory.BENEFICIAL, 0x00FF0000).addAttributeModifier(EntityAttributes.ATTACK_DAMAGE, Identifier.ofVanilla("effect.strength"), 1.0, EntityAttributeModifier.Operation.ADD_VALUE));
    // TODO: replace color with good color
    public static final StatusEffect COGNITION = registerStatusEffect("cognition", new CognitionEffect(StatusEffectCategory.BENEFICIAL, 0x00FF0000));

    /** Registers a custom status effect
     * @param name Name of custom status effect
     * @param effect Status effect object
     * @return
     */
    private static StatusEffect registerStatusEffect(String name, StatusEffect effect) {
        return Registry.register(Registries.STATUS_EFFECT, Identifier.of(Minecology.MOD_ID, name), effect);
    }

    /** Called on mod initialization to register custom effects **/
    public static void registerEffects() {
        Minecology.log("Registering status effects");
    }
}
