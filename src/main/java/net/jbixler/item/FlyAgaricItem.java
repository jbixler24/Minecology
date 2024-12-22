package net.jbixler.item;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.List;

public class FlyAgaricItem extends Item {
    public FlyAgaricItem(Settings settings) {
        super(settings);
    }

    // TODO: fix
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();

        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if (clickedBlock instanceof FlowerPotBlock) {
            if (!world.isClient()) {
                if (((FlowerPotBlock) clickedBlock).getContent() == Blocks.AIR) {
                    context.getStack().useOnBlock(context);
                    return ActionResult.SUCCESS;
                }
            }
        }
        return super.useOnBlock(context);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.minecology.fly_agaric.tooltip"));
    }
}
