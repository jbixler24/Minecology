package net.jbixler.block;

import net.jbixler.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;

import java.util.List;

public class FlyAgaricBlock extends AbstractMushroomBlock {
    public static final float WILD_GROWTH_PROBABILITY = 0.1f;
    public static final int MAX_AGE = 2;
    public static final List<Block> PLACEABLE_BLOCKS = List.of(Blocks.GRASS_BLOCK, Blocks.PODZOL, Blocks.COARSE_DIRT, Blocks.DIRT);


    public FlyAgaricBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return PLACEABLE_BLOCKS.contains(world.getBlockState(pos.down()).getBlock());
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.random.nextFloat() > WILD_GROWTH_PROBABILITY) {
            int i = state.get(AGE);
            if (i < MAX_AGE) {
                world.setBlockState(pos, state.with(AGE, i + 1), 2);
            }
        }
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        this.spawnBreakParticles(world, player, pos, state);
        int itemCount = state.get(AGE) == MAX_AGE ? 1 : 0;
        if (itemCount > 0) {
            ItemEntity itemEntity = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.FLY_AGARIC, itemCount));
            world.spawnEntity(itemEntity);
        }

        world.emitGameEvent(GameEvent.BLOCK_DESTROY, pos, GameEvent.Emitter.of(player, state));
        return state;
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(0.25f, 0.0f, 0.25f, 0.75f, 0.3f, 0.75f);
    }

    public static List<Block> getPlaceableBlocks() {
        return PLACEABLE_BLOCKS;
    }
}
