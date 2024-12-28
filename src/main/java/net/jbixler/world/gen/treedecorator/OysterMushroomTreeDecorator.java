package net.jbixler.world.gen.treedecorator;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.jbixler.block.ModBlocks;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

public class OysterMushroomTreeDecorator extends ShelfMushroomTreeDecorator {

    public static final MapCodec<OysterMushroomTreeDecorator> CODEC = RecordCodecBuilder.mapCodec((instance) -> {
        return instance.group(Codec.floatRange(0.0F, 1.0F).fieldOf("probability").forGetter((decorator) -> {
            return decorator.probability;
        }), Codec.intRange(0, 10).fieldOf("logsRatio").forGetter((decorator) -> {
            return decorator.logsRatio;
        })).apply(instance, OysterMushroomTreeDecorator::new);
    });

    public OysterMushroomTreeDecorator(float probability, int logsRatio) {
        super(probability, logsRatio, ModBlocks.OYSTER_MUSHROOM_BLOCK);
    }

    @Override
    protected TreeDecoratorType<?> getType() {
        return ModTreeDecoratorTypes.OYSTER_MUSHROOM_TREE_DECORATOR_TYPE;
    }

}
