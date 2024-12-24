package net.jbixler.world.gen.treedecorator;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.jbixler.block.ModBlocks;
import net.jbixler.util.WorldGenUtil;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

import java.util.List;

public class LionsManeTreeDecorator extends TreeDecorator {
    public static final MapCodec<LionsManeTreeDecorator> CODEC = Codec.floatRange(0.0F, 1.0F).fieldOf("probability").xmap(LionsManeTreeDecorator::new, (decorator) -> {
        return decorator.probability;
    });

    private final float probability;

    public LionsManeTreeDecorator(float probability) {
        this.probability = probability;
    }

    @Override
    protected TreeDecoratorType<?> getType() {
        return ModTreeDecoratorTypes.LIONS_MANE_TREE_DECORATOR_TYPE;
    }

    @Override
    public void generate(Generator generator) {
        String blockName = "lion's mane";
        Random random = generator.getRandom();
        if (!(random.nextFloat() >= this.probability)) {
            System.out.println("Trying to generate lions mane log");
            List<BlockPos> logPositions = WorldGenUtil.getValidLogPositions(generator);
            System.out.println(String.format("logPositions size: %d", logPositions.size()));
            if (!logPositions.isEmpty()) {
                int numLogs = Math.max(1, Math.floorDiv(logPositions.size(), 4));
                for (int i = 0; i < numLogs; i++) {
                    BlockPos logChoice = logPositions.get(random.nextInt(logPositions.size()));
                    float placement = random.nextFloat();
                    if (generator.isAir(logChoice.north()) && placement < 0.25f) {
                        WorldGenUtil.replaceAir(generator, ModBlocks.LIONS_MANE_BLOCK, logChoice.north(), Direction.NORTH, blockName);
                    } else if (generator.isAir(logChoice.east()) && placement >= 0.25f && placement < 0.5f) {
                        WorldGenUtil.replaceAir(generator, ModBlocks.LIONS_MANE_BLOCK, logChoice.east(), Direction.EAST, blockName);
                    } else if (generator.isAir(logChoice.south()) && placement >= 0.5f && placement < 0.75f) {
                        WorldGenUtil.replaceAir(generator, ModBlocks.LIONS_MANE_BLOCK, logChoice.south(), Direction.SOUTH, blockName);
                    } else if (generator.isAir(logChoice.west()) && placement < 1.0f) {
                        WorldGenUtil.replaceAir(generator, ModBlocks.LIONS_MANE_BLOCK, logChoice.west(), Direction.WEST, blockName);
                    }
                }
            }
        }
    }
}
