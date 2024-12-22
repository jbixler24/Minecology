package net.jbixler.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import java.util.List;

public class FlyAgaricBlock extends AbstractMushroomBlock {
    public static final int MAX_AGE = 2;
    public static final List<Block> PLACEABLE_BLOCKS = List.of(Blocks.GRASS_BLOCK, Blocks.PODZOL, Blocks.COARSE_DIRT, Blocks.DIRT);


    public FlyAgaricBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state == state.with(AGE, 2)) {
            return VoxelShapes.cuboid(0.25f, 0.0f, 0.25f, 0.75f, 0.3f, 0.75f);
        }
        return VoxelShapes.fullCube();
    }
    public static List<Block> getPlaceableBlocks() {
        return PLACEABLE_BLOCKS;
    }
}
