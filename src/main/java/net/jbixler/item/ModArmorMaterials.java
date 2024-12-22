package net.jbixler.item;

import net.jbixler.Minecology;
import net.jbixler.util.ModTags;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.*;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class ModArmorMaterials {
    // TODO: change SoundEvent to be goat horn sound
    public static final ArmorMaterial FLY_AGARIC_ARMOR_MATERIAL = new ArmorMaterial(250, Util.make(
            new EnumMap<>(EquipmentType.class), map -> {
                map.put(EquipmentType.HELMET, 2);
            }), 20, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0, 0, ModTags.ModItemTags.MUSHROOM_CROWN_REPAIR,
            RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(Minecology.MOD_ID, "dehydrated_fly_agaric")));


    public static void registerMaterials() {
        List<ArmorMaterial> allArmorMaterials = getArmorMaterials();
        Minecology.log(String.format("Registering %d armor materials", allArmorMaterials.size()));
    }

    public static List<ArmorMaterial> getArmorMaterials() {
        List<ArmorMaterial> allArmorMaterials = new ArrayList<>();
        allArmorMaterials.add(FLY_AGARIC_ARMOR_MATERIAL);
        return allArmorMaterials;
    }
}
