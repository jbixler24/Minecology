package net.jbixler.world.gen.treedecorator;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.jbixler.Minecology;
import net.jbixler.block.ModBlocks;
import net.jbixler.block.OysterMushroomBlock;
import net.jbixler.util.WorldGenUtil;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

import java.util.List;

public class OysterMushroomTreeDecorator extends TreeDecorator {
    public static final MapCodec<OysterMushroomTreeDecorator> CODEC = Codec.floatRange(0.0F, 1.0F).fieldOf("probability").xmap(OysterMushroomTreeDecorator::new, (decorator) -> {
        return decorator.probability;
    });

    private final float probability;

    public OysterMushroomTreeDecorator(float probability) {
        this.probability = probability;
    }

    @Override
    protected TreeDecoratorType<?> getType() {
        return ModTreeDecoratorTypes.OYSTER_MUSHROOM_TREE_DECORATOR_TYPE;
    }

    /** Generates this tree decorator **/
    @Override
    public void generate(Generator generator) {
        Random random = generator.getRandom();
        if (!(random.nextFloat() >= this.probability)) {
            List<BlockPos> logPositions = WorldGenUtil.getValidLogPositions(generator);
            if (!logPositions.isEmpty()) {
                int numLogs = Math.max(1, Math.floorDiv(logPositions.size(), 2));
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

    /** Replaces air with an Oyster Mushroom block
     *
     * @param generator Tree decorator generator
     * @param pos Air BlockPos
     * @param direction Direction of Oyster Mushroom block
     */
    private void replaceAir(TreeDecorator.Generator generator, BlockPos pos, Direction direction) {
        Minecology.debug(String.format("Trying to generate oyster mushroom at %d, %d, %d", pos.getX(), pos.getY(), pos.getZ()));
        generator.replace(pos, ModBlocks.OYSTER_MUSHROOM_BLOCK.getDefaultState().with(OysterMushroomBlock.AGE,
                generator.getRandom().nextInt(2)).with(OysterMushroomBlock.FACING, direction));
    }
}
