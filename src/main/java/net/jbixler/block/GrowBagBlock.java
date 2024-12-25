package net.jbixler.block;

import net.jbixler.block.enums.MushroomType;
import net.jbixler.block.enums.Substrate;
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
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class GrowBagBlock extends Block {
    /** Probability of the GrowBagBlock aging for each random tick **/
    public static final float AGE_GROWTH_PROB = 0.1f;
    /** Probability of a mushroom growing out of the bag for each random tick **/
    public static final float MUSHROOM_GROWTH_PROB = 0.1f;
    /** Maximum age for a growth bag **/
    public static final int MAX_AGE = 4;
    public static final IntProperty AGE = Properties.AGE_4;
    public static final BooleanProperty INOCULATED = BooleanProperty.of("inoculated");
    public static final EnumProperty<Substrate> SUBSTRATE = EnumProperty.of("substrate", Substrate.class);
    public static final EnumProperty<MushroomType> MUSHROOM_TYPE = EnumProperty.of("mushroom_type", MushroomType.class);

    public GrowBagBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState((BlockState) ((BlockState) ((BlockState) ((BlockState) ((BlockState) this.stateManager.getDefaultState()).with(AGE, 0)).with(INOCULATED, false)).with(SUBSTRATE, Substrate.STRAW)).with(MUSHROOM_TYPE, MushroomType.NONE));
//        this.setDefaultState(((BlockState) ((BlockState) this.stateManager.getDefaultState()).with(AGE, 0)).with(INOCULATED, false));
    }

    /** Disable dropping items upon expoding **/
    @Override
    public boolean shouldDropItemsOnExplosion(Explosion explosion) {
        return false;
    }

    /** Adds FACING and AGE properties to all mushroom blocks **/
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{AGE, INOCULATED, SUBSTRATE, MUSHROOM_TYPE});
    }

    @Override
    protected boolean hasRandomTicks(BlockState state) {
        return true;
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!(world.getRandom().nextFloat() >= AGE_GROWTH_PROB)) {
            if (state.get(AGE) == MAX_AGE) {
                if (!(world.getRandom().nextFloat() >= MUSHROOM_GROWTH_PROB)) {
                    spawnBlock(world, pos);
                }
            }
        }
    }

    private void spawnBlock(World world, BlockPos pos) {
        List<BlockPos> validSides = Stream.of(pos.north(), pos.east(), pos.south(), pos.west(), pos.up()).filter(world::isAir).toList();
        if (!validSides.isEmpty()) {
            Random random = world.getRandom();
            BlockPos side = validSides.get(random.nextInt(validSides.size()));
            world.setBlockState(side, MUSHROOM_NAME_BLOCK_MAP.get(MUSHROOM_TYPE.getName()).getDefaultState());
        }
    }

    static Map<String, Block> MUSHROOM_NAME_BLOCK_MAP = Map.ofEntries(
            Map.entry("chanterelle", ModBlocks.CHANTERELLE_BLOCK)
    );
}
