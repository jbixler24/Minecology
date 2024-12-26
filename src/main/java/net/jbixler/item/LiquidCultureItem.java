package net.jbixler.item;

import net.jbixler.block.GrowBagBlock;
import net.jbixler.block.enums.MushroomType;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

public class LiquidCultureItem extends Item {
    public final MushroomType mushroomType;

    public LiquidCultureItem(Settings settings, MushroomType mushroomType) {
        super(settings);
        this.mushroomType = mushroomType;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        if (!world.isClient()) {
            BlockState clickedBlockState = world.getBlockState(context.getBlockPos());
            if (clickedBlockState.getBlock() instanceof GrowBagBlock) {
                if (!clickedBlockState.get(GrowBagBlock.INOCULATED)) {
                    world.setBlockState(context.getBlockPos(), clickedBlockState.with(GrowBagBlock.AGE, 0).with(GrowBagBlock.INOCULATED, true).with(GrowBagBlock.MUSHROOM_TYPE, this.mushroomType));
                    context.getStack().decrement(1);
                }
            }
        }
        return ActionResult.SUCCESS;
    }
}
