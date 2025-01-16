package net.jbixler.world.gen.treedecorator;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.jbixler.Minecology;
import net.jbixler.block.HoneyMushroomBlock;
import net.jbixler.block.ModBlocks;
import net.jbixler.block.MushroomBlock;
import net.jbixler.util.WorldGenUtil;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class HoneyMushroomTreeDecorator extends TreeDecorator {
    public static final MapCodec<HoneyMushroomTreeDecorator> CODEC = Codec.floatRange(0, 10).fieldOf("logsRatio").xmap(HoneyMushroomTreeDecorator::new, (decorator) -> {
        return decorator.probability;
    });

    private final float probability;

    public HoneyMushroomTreeDecorator(float probability) {
        this.probability = probability;
    }

    @Override
    protected TreeDecoratorType<?> getType() {
        return ModTreeDecoratorTypes.HONEY_MUSHROOM_TREE_DECORATOR_TYPE;
    }

    /** Generates at the base of oak trees **/
    // TODO: test implementation
    @Override
    public void generate(Generator generator) {
        Random random = generator.getRandom();
        if (!(random.nextFloat() >= this.probability)) {
            List<BlockPos> positions = generator.getLogPositions();
            if (!positions.isEmpty()) {
                BlockPos groundBlockPos = positions.getFirst();
                int minBlockPos = groundBlockPos.getY();
                for (BlockPos bp : positions) {
                    if (bp.getY() < minBlockPos) {
                        groundBlockPos = bp;
                        minBlockPos = bp.getY();
                    }
                }
                List<BlockPos> validAdjacentBlocks = Stream.of(groundBlockPos.north(), groundBlockPos.east(), groundBlockPos.south(), groundBlockPos.south()).filter(generator::isAir).toList();
                for (BlockPos bp : validAdjacentBlocks) {
                    Minecology.debug(String.format("Trying to generate honey mushroom at %d, %d, %d", bp.getX(), bp.getY(), bp.getZ()));
                    generator.replace(bp, ModBlocks.HONEY_MUSHROOM_BLOCK.getDefaultState().with(HoneyMushroomBlock.AGE, random.nextInt(2)));
                }
            }
        }
    }
}
