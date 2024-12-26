package net.jbixler.block;

import com.mojang.serialization.MapCodec;
import net.jbixler.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.explosion.Explosion;

public class MushroomBlock extends HorizontalFacingBlock {

    /* Default settings for a mushroom block */
    public static final IntProperty AGE = Properties.AGE_2;
    public static final int MAX_AGE = 2;
    public static final int MIN_DROPS = 1;
    public static final int MAX_DROPS = 1;

    public MushroomBlock(Settings settings) {
        super(settings.breakInstantly().sounds(BlockSoundGroup.NETHER_WART));
        this.setDefaultState((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState()).with(FACING, Direction.NORTH)).with(AGE, 0));
    }

    /** Disable dropping items upon expoding **/
    @Override
    public boolean shouldDropItemsOnExplosion(Explosion explosion) {
        return false;
    }

    /** Adds FACING and AGE properties to all mushroom blocks **/
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING, AGE});
    }

    /** Default onBreak method for mushrooms; drops one item upon breaking **/
    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        this.spawnBreakParticles(world, player, pos, state);
        int itemCount = state.get(AGE) == MAX_AGE ? world.getRandom().nextBetween(MIN_DROPS, MAX_DROPS) : 0;
        if (itemCount > 0) {
            ItemEntity itemEntity = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.LIONS_MANE, itemCount));
            world.spawnEntity(itemEntity);
        }

        world.emitGameEvent(GameEvent.BLOCK_DESTROY, pos, GameEvent.Emitter.of(player, state));
        return state;
    }

    // TODO: test this
    /** Breaks mushroom block when hit by a projectile **/
    @Override
    protected void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile) {
        onBreak(world, hit.getBlockPos(), world.getBlockState(hit.getBlockPos()), (PlayerEntity) projectile.getOwner());
    }


    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return null;
    }

    @Override
    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        return false;
    }

    /* Enables random ticking for child classes */
    @Override
    protected boolean hasRandomTicks(BlockState state) {
        return true;
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
}
