package net.jbixler.potion;

import net.jbixler.Minecology;
import net.jbixler.effects.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class ModPotions {
    public static final RegistryEntry<Potion> AMANITA_EXTRACT = registerPotion("amanita_extract", new Potion("amanita_extract", new StatusEffectInstance(Registries.STATUS_EFFECT.getEntry(ModEffects.BERSERKER), 1200, 0)));

    /** Registers a potion
     * @param name Namespace of the potion to register
     * @param potion Potion to register
     * @return
     */
    public static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(Minecology.MOD_ID, name), potion);
    }

    /** Called on mod initialization to register potions **/
    public static void registerPotions() {
        List<Potion> allPotions = getPotions();
        Minecology.log(String.format("Registering %d mod potions", allPotions.size()));
    }

    public static List getPotions() {
        List<RegistryEntry<Potion>> allPotions = new ArrayList<>();
        allPotions.add(AMANITA_EXTRACT);
        return allPotions;
    }
}
