package net.jbixler.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;

import java.util.List;

public class LionsManeBlock extends AbstractMushroomBlock {
    public static final int MAX_AGE = 2;
    public static final List<Block> PLACEABLE_BLOCKS = List.of(Blocks.OAK_LOG, Blocks.DARK_OAK_LOG, Blocks.BIRCH_LOG);

    public LionsManeBlock(Settings settings) {
        super(settings);
    }

//    @Override
//    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
//        builder.add(AGE);
//        setDefaultState(this.getDefaultState().with(AGE, 2));
//    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        List<BlockPos> adjacentBlocks = List.of(pos.up(), pos.north(), pos.east(), pos.west(), pos.south());
        for (BlockPos blockPos : adjacentBlocks) {
            if (PLACEABLE_BLOCKS.contains(world.getBlockState(blockPos).getBlock())) {
                return true;
            }
        }
        return false;
    }

    public static List<Block> getPlaceableBlocks() {
        return PLACEABLE_BLOCKS;
    }
}
