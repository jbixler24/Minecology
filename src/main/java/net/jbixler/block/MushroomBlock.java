package net.jbixler.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.explosion.Explosion;

import java.util.List;

public class MushroomBlock extends HorizontalFacingBlock {

    /* Default settings for a mushroom block */
    public static final IntProperty AGE = Properties.AGE_2;
    /** Maximum age of block **/
    public final int maxAge = 2;
    /** Minimum number of blocks upon breaking at maxAge **/
    public final int minDrops;
    /** Maxmimum number of blocks upon breaking at maxAge **/
    public final int maxDrops;
    /** Probability of advancing in age by one **/
    public final float wildGrowthProbability;
    /** All blocks this mushroom block can grow on **/
    public final List<Block> placeableBlocks;
    /** Item dropped on non-explosion breaking **/
    public final Item itemDrop;

    public MushroomBlock(Settings settings, int minDrops, int maxDrops, float wildGrowthProbability, List<Block> placeableBlocks, Item itemDrop) {
        super(settings.breakInstantly().sounds(BlockSoundGroup.NETHER_WART));
        this.minDrops = minDrops;
        this.maxDrops = maxDrops;
        this.wildGrowthProbability = wildGrowthProbability;
        this.placeableBlocks = placeableBlocks;
        this.itemDrop = itemDrop;
        this.setDefaultState((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState()).with(FACING, Direction.NORTH)).with(AGE, 0));
    }

    /** Adds FACING and AGE properties to all mushroom blocks **/
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING, AGE});
    }

    /** Disable pathfinding through the block **/
    @Override
    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        return false;
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        List<BlockPos> adjacentBlocks = List.of(pos.up(), pos.north(), pos.east(), pos.west(), pos.south());
        for (BlockPos blockPos : adjacentBlocks) {
            if (this.placeableBlocks.contains(world.getBlockState(blockPos).getBlock())) {
                return true;
            }
        }
        return false;
    }

    /** Disable dropping items upon expoding **/
    @Override
    public boolean shouldDropItemsOnExplosion(Explosion explosion) {
        return false;
    }

    /* Enables random ticking for child classes */
    @Override
    protected boolean hasRandomTicks(BlockState state) {
        return true;
    }

    /** Grows with probability wildGrowthProbability on each random tick **/
    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.random.nextFloat() > this.wildGrowthProbability) {
            int i = state.get(AGE);
            if (i < this.maxAge) {
                world.setBlockState(pos, state.with(AGE, i + 1), 2);
            }
        }
    }

    // TODO: test this
    /** Breaks mushroom block when hit by a projectile **/
    @Override
    protected void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile) {
        onBreak(world, hit.getBlockPos(), world.getBlockState(hit.getBlockPos()), (PlayerEntity) projectile.getOwner());
    }

    /** Default onBreak method for mushrooms; drops one item upon breaking **/
    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        this.spawnBreakParticles(world, player, pos, state);
        int itemCount = state.get(AGE) == maxAge ? world.getRandom().nextBetween(minDrops, maxDrops) : 0;
        if (itemCount > 0) {
            ItemEntity itemEntity = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(this.itemDrop, itemCount));
            world.spawnEntity(itemEntity);
        }
        world.emitGameEvent(GameEvent.BLOCK_DESTROY, pos, GameEvent.Emitter.of(player, state));
        return state;
    }


    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return null;
    }

    // TODO: make smaller voxel shapes for age=0, age=1
    /** Returns correctly oriented voxel depending on age and direction the block is facing for shelf fungi **/
    protected VoxelShape getDefaultShelfShape(BlockState state) {
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

    public static final List<Block> ECTOMYCORRHIZAL_BLOCKS = List.of(Blocks.GRASS_BLOCK, Blocks.PODZOL, Blocks.DIRT, Blocks.COARSE_DIRT, Blocks.ROOTED_DIRT);
//    public static final List<Block> SUBSTRATES = List.of(ModBlocks.GRAIN_GROW_BAG_BLOCK, ModBlocks.WOOD_CHIPS_GROW_BAG_BLOCK);
}
