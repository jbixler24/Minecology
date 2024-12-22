package net.jbixler.item;

import net.jbixler.effects.ModEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class CrownOfTheMushroomForest extends ArmorItem {

    public CrownOfTheMushroomForest(Item.Settings settings) {
        super(ModArmorMaterials.FLY_AGARIC_ARMOR_MATERIAL, EquipmentType.HELMET, settings);
    }

    // TODO: replace wither death sound with custom sound
    @Override
    public void onItemEntityDestroyed(ItemEntity entity) {
        World world = entity.getWorld();
        if (!world.isClient) {
            world.playSound(
                    null, // Player - if non-null, will play sound for every nearby player *except* the specified player
                    entity.getBlockPos(), // The position of where the sound will come from
                    SoundEvents.ENTITY_WITHER_DEATH, // The sound that will play, in this case, the sound the anvil plays when it lands.
                    SoundCategory.PLAYERS, // This determines which of the volume sliders affect this sound
                    1f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
                    1f // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
            );
        }
    }

    /** Apply Beserker status effect when the helmet is equipped **/
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient()) {
            if (entity instanceof PlayerEntity player && hasCrownEquipped(player)) {
                player.setStatusEffect(new StatusEffectInstance(
                        Registries.STATUS_EFFECT.getEntry(ModEffects.BERSERKER), 15, 1, false, false, true), player);
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    /** Checks if the player has the CrownOfTheMushroomForest helmet equipped
     * @param player Player to check
     * @return True iff the player has the helmet equipped
     */
    public static boolean hasCrownEquipped(PlayerEntity player) {
        ItemStack helmetSlot = player.getInventory().getArmorStack(3);
        if (!(helmetSlot.getItem() instanceof ArmorItem)) {
            return false;
        }

        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmorStack(3).getItem());

        return helmet.getClass().getName().equals("net.jbixler.item.CrownOfTheMushroomForest");
    }
}
