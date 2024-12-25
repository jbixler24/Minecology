package net.jbixler.util;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.treedecorator.TreeDecorator;

import java.util.List;

public class WorldGenUtil {

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
