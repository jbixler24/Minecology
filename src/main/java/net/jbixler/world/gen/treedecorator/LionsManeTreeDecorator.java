package net.jbixler.world.gen.treedecorator;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.jbixler.block.ModBlocks;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

public class LionsManeTreeDecorator extends ShelfMushroomTreeDecorator {

    public static final MapCodec<LionsManeTreeDecorator> CODEC = RecordCodecBuilder.mapCodec((instance) -> {
        return instance.group(Codec.floatRange(0.0F, 1.0F).fieldOf("probability").forGetter((decorator) -> {
            return decorator.probability;
        }), Codec.intRange(0, 10).fieldOf("logsRatio").forGetter((decorator) -> {
            return decorator.logsRatio;
        })).apply(instance, LionsManeTreeDecorator::new);
    });

    public LionsManeTreeDecorator(float probability, int logsRatio) {
        super(probability, logsRatio, ModBlocks.LIONS_MANE_BLOCK);
    }

    @Override
    protected TreeDecoratorType<?> getType() {
        return ModTreeDecoratorTypes.LIONS_MANE_TREE_DECORATOR_TYPE;
    }
}
