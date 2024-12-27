package net.jbixler;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.jbixler.block.MushroomBlock;
import net.jbixler.potion.ModPotions;
import net.jbixler.block.ModBlocks;
import net.jbixler.effects.ModEffects;
import net.jbixler.item.ModArmorMaterials;
import net.jbixler.item.ModItemGroups;
import net.jbixler.item.ModItems;
import net.jbixler.world.gen.ModWorldGeneration;
import net.jbixler.world.gen.treedecorator.ModTreeDecoratorTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Potions;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Minecology implements ModInitializer {
	public static final String MOD_ID = "minecology";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModEffects.registerEffects();
		ModArmorMaterials.registerMaterials();
		ModBlocks.registerBlocks();
		ModItems.registerItems();
		ModItemGroups.registerItemGroups();
		ModPotions.registerPotions();
		ModTreeDecoratorTypes.registerTreeDecoratorTypes();

//		ModBlockEntities.registerBlockEntities();

		ModWorldGeneration.generateModWorldGen();

		PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, blockEntity) -> breakAdjacentMushroomBlocks(world, player, pos));

		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD, ModItems.DEHYDRATED_FLY_AGARIC_CAP, ModPotions.AMANITA_EXTRACT);
		});
	}

	/** Breaks mushroom blocks if the block they are connected to is destroyed
	 *
	 * @param world World
	 * @param player Player breaking the block
	 * @param pos BlockPos
	 */
	private void breakAdjacentMushroomBlocks(World world, PlayerEntity player, BlockPos pos) {
		BlockState northBlockState = world.getBlockState(pos.north());
		BlockState eastBlockState = world.getBlockState(pos.east());
		BlockState southBlockState = world.getBlockState(pos.south());
		BlockState westBlockState = world.getBlockState(pos.west());
		if (northBlockState.getBlock() instanceof MushroomBlock && northBlockState.get(MushroomBlock.FACING) == Direction.NORTH) {
			northBlockState.getBlock().onBreak(world, pos.north(), northBlockState, player);
			world.setBlockState(pos.north(), Blocks.AIR.getDefaultState());
		}
		if (eastBlockState.getBlock() instanceof MushroomBlock && eastBlockState.get(MushroomBlock.FACING) == Direction.EAST) {
			eastBlockState.getBlock().onBreak(world, pos.east(), eastBlockState, player);
			world.setBlockState(pos.east(), Blocks.AIR.getDefaultState());
		}
		if (southBlockState.getBlock() instanceof MushroomBlock && southBlockState.get(MushroomBlock.FACING) == Direction.SOUTH) {
			southBlockState.getBlock().onBreak(world, pos.south(), southBlockState, player);
			world.setBlockState(pos.south(), Blocks.AIR.getDefaultState());
		}
		if (westBlockState.getBlock() instanceof MushroomBlock && westBlockState.get(MushroomBlock.FACING) == Direction.WEST) {
			westBlockState.getBlock().onBreak(world, pos.west(), westBlockState, player);

			world.setBlockState(pos.west(), Blocks.AIR.getDefaultState());
		}
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