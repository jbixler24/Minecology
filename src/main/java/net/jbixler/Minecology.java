package net.jbixler;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.jbixler.potion.ModPotions;
import net.jbixler.block.ModBlocks;
import net.jbixler.block.entity.ModBlockEntityTypes;
import net.jbixler.effects.ModEffects;
import net.jbixler.item.ModArmorMaterials;
import net.jbixler.item.ModItemGroups;
import net.jbixler.item.ModItems;
import net.jbixler.world.ModConfiguredFeatures;
import net.jbixler.world.gen.ModWorldGeneration;
import net.minecraft.potion.Potions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class Minecology implements ModInitializer {
	public static final String MOD_ID = "minecology";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModEffects.registerEffects();
		ModArmorMaterials.registerMaterials();
		ModItems.registerItems();
		ModBlocks.registerBlocks();
		ModBlockEntityTypes.registerBlockEntityTypes();
		ModItemGroups.registerItemGroups();
		ModPotions.registerPotions();

//		ModWorldGeneration.generateModWorldGen();

		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD, ModItems.DEHYDRATED_FLY_AGARIC_CAP, ModPotions.AMANITA_EXTRACT);
		});
	}

	/** Logs a formatted message to the system console
	 *
	 * @param message Message to be logged
	 */
	public static void log(String message) {
		LOGGER.info("[{}] {}", MOD_ID.toUpperCase(), message);
	}
}