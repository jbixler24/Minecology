package net.jbixler.world.gen.treedecorator;

import net.jbixler.Minecology;
import net.jbixler.block.MushroomBlock;
import net.jbixler.util.WorldGenUtil;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

import java.util.List;

public class ShelfMushroomTreeDecorator extends TreeDecorator {

    /** Probability for this decorator to generate on a given tree **/
    public final float probability;
    /** Ratio of logs to number of mushroom blocks generated **/
    public final int logsRatio;
    /** Mushroom block to generate on trees **/
    public final Block mushroomBlock;

    public ShelfMushroomTreeDecorator(float probability, int logsRatio, Block mushroomBlock) {
        this.probability = probability;
        this.logsRatio = logsRatio;
        this.mushroomBlock = mushroomBlock;
    }

    @Override
    protected TreeDecoratorType<?> getType() {
        return null;
    }

    /** Generates this tree decorator **/
    @Override
    public void generate(Generator generator) {
        Random random = generator.getRandom();
        if (!(random.nextFloat() >= this.probability)) {
            List<BlockPos> logPositions = WorldGenUtil.getValidLogPositions(generator);
            if (!logPositions.isEmpty()) {
                int numLogs = Math.max(1, Math.floorDiv(logPositions.size(), this.logsRatio));
                for (int i = 0; i < numLogs; i++) {
                    BlockPos logChoice = logPositions.get(random.nextInt(logPositions.size()));
                    float placement = random.nextFloat();
                    if (generator.isAir(logChoice.north()) && placement < 0.25f) {
                        replaceAir(generator, logChoice.north(), Direction.NORTH);
                    } else if (generator.isAir(logChoice.east()) && placement >= 0.25f && placement < 0.5f) {
                        replaceAir(generator, logChoice.east(), Direction.EAST);
                    } else if (generator.isAir(logChoice.south()) && placement >= 0.5f && placement < 0.75f) {
                        replaceAir(generator, logChoice.south(), Direction.SOUTH);
                    } else if (generator.isAir(logChoice.west()) && placement < 1.0f) {
                        replaceAir(generator, logChoice.west(), Direction.WEST);
                    }
                }
            }
        }
    }

    /** Replaces air with a mushroom block
     *
     * @param generator Tree decorator generator
     * @param pos Air BlockPos
     * @param direction Direction of Lion's Mane block
     */
    protected void replaceAir(TreeDecorator.Generator generator, BlockPos pos, Direction direction) {
        Minecology.debug(String.format("Trying to generate %s at %d, %d, %d", mushroomBlock.getName(), pos.getX(), pos.getY(), pos.getZ()));
        generator.replace(pos, this.mushroomBlock.getDefaultState().with(MushroomBlock.AGE,
                generator.getRandom().nextInt(2)).with(MushroomBlock.FACING, direction));
    }
}
