package net.jbixler.block;

import net.jbixler.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ReishiBlock extends MushroomBlock {
    public static final IntProperty AGE = Properties.AGE_2;
    public static final int MAX_AGE = 2;
    public static final int MIN_DROPS = 1;
    public static final int MAX_DROPS = 1;
    public static final float WILD_GROWTH_PROBABILITY = 0.01f;
    public static final List<Block> PLACEABLE_BLOCKS = List.of(Blocks.OAK_LOG, Blocks.DARK_OAK_LOG);

    public ReishiBlock(Settings settings) {
        super(settings, 1, 1, 0.01f, List.of(Blocks.OAK_LOG, Blocks.DARK_OAK_LOG), ModItems.REISHI);
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
