package net.jbixler.util;

import net.jbixler.block.LionsManeBlock;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.gen.treedecorator.TreeDecorator;

import java.util.List;

public class WorldGenUtil {

    /** Tree decorator util method to replace air block with decorator block
     *
     * @param generator Tree decorator generator
     * @param pos Air BlockPos
     * @param direction Side of block to place at
     */
    public static void replaceAir(TreeDecorator.Generator generator, Block block, BlockPos pos, Direction direction, String blockName) {
        System.out.println(String.format("Trying to generate %s at %d, %d, %d", blockName, pos.getX(), pos.getY(), pos.getZ()));
        generator.replace(pos, block.getDefaultState().with(LionsManeBlock.AGE,
                generator.getRandom().nextInt(LionsManeBlock.MAX_AGE)).with(LionsManeBlock.FACING, direction));
    }

    /** Gets log positions with at least one adjacent air block
     *
     * @param generator Tree decorator generator
     * @return List of valid log positions
     */
    public static List<BlockPos> getValidLogPositions(TreeDecorator.Generator generator) {
        List<BlockPos> allLogPositions = generator.getLogPositions();
        return allLogPositions.stream().filter(log -> hasAtLeastOneAdjacentAirBlock(generator, log)).toList();
    }

    /** Returns true iff there is at least one adjacent air block at the given BlockPos
     *
     * @param generator Tree decorator generator
     * @param log BlockPos of log block
     */
    public static boolean hasAtLeastOneAdjacentAirBlock(TreeDecorator.Generator generator, BlockPos log) {
        List<BlockPos> adjacentBlocks = List.of(log.north(), log.east(), log.south(), log.west());
        return !adjacentBlocks.stream().filter(generator::isAir).toList().isEmpty();
    }
}
