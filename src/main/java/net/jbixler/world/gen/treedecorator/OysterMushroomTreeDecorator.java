package net.jbixler.world.gen.treedecorator;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.jbixler.block.ModBlocks;
import net.jbixler.block.OysterMushroomBlock;
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

    @Override
    public void generate(Generator generator) {
        Random random = generator.getRandom();
        if (!(random.nextFloat() >= this.probability)) {
            List<BlockPos> logPositions = generator.getLogPositions();
            if (!logPositions.isEmpty()) {
                for (BlockPos log : logPositions) {
                    if (!(random.nextFloat() >= 0.25f)) {
                        float placement = random.nextFloat();
                        if (generator.isAir(log.north()) && placement < 0.25f) {
                            replaceAir(generator, log.north(), Direction.NORTH);
                        } else if (generator.isAir(log.east()) && placement >= 0.25f && placement < 0.5f) {
                            replaceAir(generator, log.east(), Direction.EAST);
                        } else if (generator.isAir(log.south()) && placement >= 0.5f && placement < 0.75f) {
                            replaceAir(generator, log.south(), Direction.SOUTH);
                        } else if (generator.isAir(log.west()) && placement < 1.0f) {
                            replaceAir(generator, log.west(), Direction.WEST);
                        }
                    }
                }
            }
        }
    }

    private void replaceAir(Generator generator, BlockPos pos, Direction direction) {
        System.out.println(String.format("Trying to generate oyster mushroom at %d, %d, %d", pos.getX(), pos.getY(), pos.getZ()));
        generator.replace(pos, ModBlocks.OYSTER_MUSHROOM_BLOCK.getDefaultState().with(OysterMushroomBlock.AGE,
                generator.getRandom().nextInt(OysterMushroomBlock.MAX_AGE)).with(OysterMushroomBlock.FACING, direction));
    }
}
