package net.jbixler.block;

import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class OysterMushroomBlock extends AbstractMushroomBlock {
    public static final float WILD_GROWTH_PROBABILITY = 0.1f;
    public static final int MAX_AGE = 2;
    public static final List<Block> PLACEABLE_BLOCKS = List.of(Blocks.OAK_LOG, Blocks.DARK_OAK_LOG, Blocks.BIRCH_LOG);

    public OysterMushroomBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        Direction newDirection = Direction.NORTH;

        Block northBlock = world.getBlockState(pos.north()).getBlock();
        Block eastBlock = world.getBlockState(pos.east()).getBlock();
        Block westBlock = world.getBlockState(pos.west()).getBlock();

        if (PLACEABLE_BLOCKS.contains(northBlock)) {
            newDirection = Direction.SOUTH;
        } else if (PLACEABLE_BLOCKS.contains(eastBlock)) {
            newDirection = Direction.WEST;
        } else if (PLACEABLE_BLOCKS.contains(westBlock)) {
            newDirection = Direction.EAST;
        }

        world.setBlockState(pos, state.with(FACING, newDirection));
    }

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

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.random.nextInt(Math.round(1 / WILD_GROWTH_PROBABILITY)) == 0) {
            int i = state.get(AGE);
            if (i < MAX_AGE) {
                world.setBlockState(pos, state.with(AGE, i + 1), 2);
            }
        }
    }

    // TODO: make smaller voxel shapes for age=0, age=1
    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state == state.with(AGE, 0)) {
            if (state == state.with(FACING, Direction.NORTH)) {
                return VoxelShapes.cuboid(0.25f, 0.25f, 0.5f, 0.75f, 0.75f, 1.0f);
            }
            if (state == state.with(FACING, Direction.EAST)) {
                return VoxelShapes.cuboid(0.0f, 0.25f, 0.25f, 0.5f, 0.75f, 0.75f);
            }
            if (state == state.with(FACING, Direction.WEST)) {
                return VoxelShapes.cuboid(0.5f, 0.25f, 0.25f, 1.0f, 0.75f, 0.75f);
            }
            if (state == state.with(FACING, Direction.SOUTH)) {
                return VoxelShapes.cuboid(0.25f, 0.25f, 0.0f, 0.75f, 0.75f, 0.5f);
            }
            return VoxelShapes.fullCube();
        } else if (state == state.with(AGE, 1)) {
            if (state == state.with(FACING, Direction.NORTH)) {
                return VoxelShapes.cuboid(0.25f, 0.25f, 0.5f, 0.75f, 0.75f, 1.0f);
            }
            if (state == state.with(FACING, Direction.EAST)) {
                return VoxelShapes.cuboid(0.0f, 0.25f, 0.25f, 0.5f, 0.75f, 0.75f);
            }
            if (state == state.with(FACING, Direction.WEST)) {
                return VoxelShapes.cuboid(0.5f, 0.25f, 0.25f, 1.0f, 0.75f, 0.75f);
            }
            if (state == state.with(FACING, Direction.SOUTH)) {
                return VoxelShapes.cuboid(0.25f, 0.25f, 0.0f, 0.75f, 0.75f, 0.5f);
            }
        } else if (state == state.with(AGE, 2)) {
            if (state == state.with(FACING, Direction.NORTH)) {
                return VoxelShapes.cuboid(0.25f, 0.25f, 0.5f, 0.75f, 0.75f, 1.0f);
            }
            if (state == state.with(FACING, Direction.EAST)) {
                return VoxelShapes.cuboid(0.0f, 0.25f, 0.25f, 0.5f, 0.75f, 0.75f);
            }
            if (state == state.with(FACING, Direction.WEST)) {
                return VoxelShapes.cuboid(0.5f, 0.25f, 0.25f, 1.0f, 0.75f, 0.75f);
            }
            if (state == state.with(FACING, Direction.SOUTH)) {
                return VoxelShapes.cuboid(0.25f, 0.25f, 0.0f, 0.75f, 0.75f, 0.5f);
            }
        }
        return VoxelShapes.fullCube();
    }
}
