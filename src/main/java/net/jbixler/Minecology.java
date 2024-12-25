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
import net.jbixler.world.gen.ModWorldGeneration;
import net.jbixler.world.gen.treedecorator.ModTreeDecoratorTypes;
import net.minecraft.potion.Potions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

		ModWorldGeneration.generateModWorldGen();

		ModTreeDecoratorTypes.registerTreeDecoratorTypes();

		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD, ModItems.DEHYDRATED_FLY_AGARIC_CAP, ModPotions.AMANITA_EXTRACT);
		});
	}

	/** Logs a formatted message to the system console
	 *
	 * @param message Message to be logged
	 */
	public static void log(String message, Object... args) {
		LOGGER.info("[{}] {}", MOD_ID.toUpperCase(), String.format(message, args));
	}

	/** Logs a debug message to the system console
	 *
	 * @param message Message (formatted or not) to be logged as a debug message
	 * @param args Formatting arguments
	 */
	public static void debug(String message, Object... args) {
		LOGGER.info("[{}|DEBUG] {}", MOD_ID.toUpperCase(), String.format(message, args));
	}
}