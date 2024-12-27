package net.jbixler.block;

import net.jbixler.item.ModItems;
import net.minecraft.block.Blocks;

import java.util.List;

public class ChickenOfTheWoodsBlock extends MushroomBlock {
    public ChickenOfTheWoodsBlock(Settings settings) {
        super(settings, 1, 1, 0.1f, List.of(Blocks.OAK_LOG, Blocks.CHERRY_LOG), ModItems.CHICKEN_OF_THE_WOODS);
    }
}
