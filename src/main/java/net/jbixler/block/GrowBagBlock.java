package net.jbixler.block;

import net.jbixler.block.enums.MushroomType;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

import java.util.List;
import java.util.stream.Stream;

public class GrowBagBlock extends Block {
    /** Probability of the GrowBagBlock aging for each random tick **/
    public final float ageGrowthProb;
    /** Probability of a mushroom growing out of the bag for each random tick **/
    public final float mushroomGrowthProb;
    /** Maximum age for a grow bag **/
    public static final int MAX_AGE = 4;
    /** Growth stage (age) for a grow bag **/
    public static final IntProperty AGE = Properties.AGE_4;
    /** Whether the grow bag is inoculated **/
    public static final BooleanProperty INOCULATED = BooleanProperty.of("inoculated");
    /** The mushroom type which the bag is inoculated with, if any. Defaults to "none" **/
    public static final EnumProperty<MushroomType> MUSHROOM_TYPE = EnumProperty.of("mushroom_type", MushroomType.class);

    public GrowBagBlock(AbstractBlock.Settings settings, float ageGrowthProb, float mushroomGrowthProb) {
        super(settings);
        this.ageGrowthProb = ageGrowthProb;
        this.mushroomGrowthProb = mushroomGrowthProb;
        this.setDefaultState(this.getDefaultState().with(AGE, 0).with(INOCULATED, false).with(MUSHROOM_TYPE, MushroomType.NONE));
    }

    /** Disable dropping items upon exploding **/
    @Override
    public boolean shouldDropItemsOnExplosion(Explosion explosion) {
        return false;
    }

    /** Adds FACING and AGE properties to all mushroom blocks **/
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{AGE, INOCULATED, MUSHROOM_TYPE});
    }

    /** Enable random ticking **/
    @Override
    protected boolean hasRandomTicks(BlockState state) {
        return true;
    }

    /** Logic for handling spawning a block **/
    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!world.isClient) {
            if (state.get(INOCULATED)) {
                if (!(world.getRandom().nextFloat() >= ageGrowthProb)) {
                    if (state.get(AGE) == MAX_AGE) {
                        if (!(world.getRandom().nextFloat() >= mushroomGrowthProb)) {
                            spawnBlock(state, world, pos);
                        }
                    } else {
                        world.setBlockState(pos, state.with(AGE, state.get(AGE) + 1));
                    }
                }
            }
        }
    }

    /** Spawns a block of the appropriate type at age 0 **/
    protected void spawnBlock(BlockState state, World world, BlockPos pos) {
        List<BlockPos> validSides = Stream.of(pos.north(), pos.east(), pos.south(), pos.west()).filter(world::isAir).toList();
        if (!validSides.isEmpty()) {
            Random random = world.getRandom();
            BlockPos side = validSides.get(random.nextInt(validSides.size()));
            Direction dir = Direction.NORTH;
            if (pos.getX() < side.getX()) {
                dir = Direction.EAST;
            } else if (pos.getZ() < side.getZ()) {
                dir = Direction.SOUTH;
            } else if (pos.getZ() > side.getZ()) {
                dir = Direction.WEST;
            }
            world.setBlockState(side, state.get(MUSHROOM_TYPE).getMushroomBlock().getDefaultState().with(MushroomBlock.FACING, dir));
        }
    }
}
