package net.jbixler.block;

import net.jbixler.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LionsManeBlock extends MushroomBlock {

    public LionsManeBlock(Settings settings) {
        super(settings, 1, 1, 0.05f, List.of(Blocks.OAK_LOG, Blocks.DARK_OAK_LOG, Blocks.BIRCH_LOG), ModItems.LIONS_MANE);
    }


    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        Direction newDirection = Direction.NORTH;

        Block northBlock = world.getBlockState(pos.north()).getBlock();
        Block eastBlock = world.getBlockState(pos.east()).getBlock();
        Block westBlock = world.getBlockState(pos.west()).getBlock();

        if (this.placeableBlocks.contains(northBlock)) {
            newDirection = Direction.SOUTH;
        } else if (this.placeableBlocks.contains(eastBlock)) {
            newDirection = Direction.WEST;
        } else if (this.placeableBlocks.contains(westBlock)) {
            newDirection = Direction.EAST;
        }

        world.setBlockState(pos, state.with(FACING, newDirection));
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return getDefaultShelfShape(state);
    }
}
