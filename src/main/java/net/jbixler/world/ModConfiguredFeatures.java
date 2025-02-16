package net.jbixler.world;

import com.google.common.collect.ImmutableList;
import net.jbixler.Minecology;
import net.jbixler.block.FlyAgaricBlock;
import net.jbixler.block.ModBlocks;
import net.jbixler.world.gen.treedecorator.ChickenOfTheWoodsTreeDecorator;
import net.jbixler.world.gen.treedecorator.HoneyMushroomTreeDecorator;
import net.jbixler.world.gen.treedecorator.LionsManeTreeDecorator;
import net.jbixler.world.gen.treedecorator.OysterMushroomTreeDecorator;
import net.jbixler.world.gen.treedecorator.ReishiTreeDecorator;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.intprovider.WeightedListIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.CherryFoliagePlacer;
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.CherryTrunkPlacer;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.OptionalInt;

public class ModConfiguredFeatures {

//    public static final RegistryKey<ConfiguredFeature<?, ?>> CHANTERELLE_PATCH_KEY = registerKey("chanterelle_configured");

    public static final RegistryKey<ConfiguredFeature<?, ?>> CHICKEN_OF_THE_WOODS_OAK_DECORATOR_KEY = registerKey("chicken_of_the_woods_oak_decorator");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CHICKEN_OF_THE_WOODS_FANCY_OAK_DECORATOR_KEY = registerKey("chicken_of_the_woods_fancy_oak_decorator");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CHICKEN_OF_THE_WOODS_CHERRY_DECORATOR_KEY = registerKey("chicken_of_the_woods_cherry_decorator");

    public static final RegistryKey<ConfiguredFeature<?, ?>> FLY_AGARIC_PATCH_KEY = registerKey("fly_agaric_configured");

    public static final RegistryKey<ConfiguredFeature<?, ?>> HONEY_MUSHROOM_OAK_DECORATOR_KEY = registerKey("honey_mushroom_oak_decorator");

    public static final RegistryKey<ConfiguredFeature<?, ?>> LIONS_MANE_OAK_DECORATOR_KEY = registerKey("lions_mane_oak_decorator");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LIONS_MANE_FANCY_OAK_DECORATOR_KEY = registerKey("lions_mane_large_oak_decorator");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LIONS_MANE_BIRCH_DECORATOR_KEY = registerKey("lions_mane_birch_decorator");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LIONS_MANE_SUPER_BIRCH_DECORATOR_TREE = registerKey("lions_mane_super_birch_decorator");

//    public static final RegistryKey<ConfiguredFeature<?, ?>> MOREL_PATCH_KEY = registerKey("morel_configured");

    public static final RegistryKey<ConfiguredFeature<?, ?>> OYSTER_MUSHROOM_OAK_DECORATOR_KEY = registerKey("oyster_mushroom_oak_decorator");
    public static final RegistryKey<ConfiguredFeature<?, ?>> OYSTER_MUSHROOM_FANCY_OAK_DECORATOR_KEY = registerKey("oyster_mushroom_large_oak_decorator");
    public static final RegistryKey<ConfiguredFeature<?, ?>> OYSTER_MUSHROOM_BIRCH_DECORATOR_KEY = registerKey("oyster_mushroom_birch_decorator");
    public static final RegistryKey<ConfiguredFeature<?, ?>> OYSTER_MUSHROOM_SUPER_BIRCH_DECORATOR_TREE = registerKey("oyster_mushroom_super_birch_decorator");

//    public static final RegistryKey<ConfiguredFeature<?, ?>> PORCINI_PATCH_KEY = registerKey("porcini_configured");

    public static final RegistryKey<ConfiguredFeature<?, ?>> REISHI_OAK_DECORATOR_KEY = registerKey("reishi_oak_decorator");
    public static final RegistryKey<ConfiguredFeature<?, ?>> REISHI_FANCY_OAK_DECORATOR_KEY = registerKey("reishi_fancy_oak_decorator");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
//        registerChanterelleCF(context);
        registerChickenOfTheWoodsCF(context);
        registerFlyAgaricCF(context);
        registerHoneyMushroomCF(context);
        registerLionsManeCF(context);
//        registerMorelCF(context);
        registerOysterMushroomCF(context);
//        registerPorciniCF(context);
        registerReishiCF(context);
    }

    // TODO: implement
    /** Registers Chanterelle configured features
     *
     * @param context Registerable context
     */
    public static void registerChanterelleCF(Registerable<ConfiguredFeature<?, ?>> context) {

    }

    // TODO: implement
    /** Registers Chicken of the Woods configured features
     *
     * @param context Registerable context
     */
    public static void registerChickenOfTheWoodsCF(Registerable<ConfiguredFeature<?, ?>> context) {
        /* Chicken of the Woods oak tree CF */
        register(context, CHICKEN_OF_THE_WOODS_OAK_DECORATOR_KEY, Feature.TREE,
                (new TreeFeatureConfig.Builder(BlockStateProvider.of(Blocks.OAK_LOG.getDefaultState()),
                        new StraightTrunkPlacer(4, 2, 0),
                        BlockStateProvider.of(Blocks.OAK_LEAVES.getDefaultState()),
                        new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1))
                        .decorators(ImmutableList.of(new ChickenOfTheWoodsTreeDecorator(1.0f, 5))).build())
        );

        /* Chicken of the Woods fancy oak tree CF */
        register(context, CHICKEN_OF_THE_WOODS_FANCY_OAK_DECORATOR_KEY, Feature.TREE,
                (new TreeFeatureConfig.Builder(BlockStateProvider.of(Blocks.OAK_LOG),
                        new LargeOakTrunkPlacer(3, 11, 0),
                        BlockStateProvider.of(Blocks.OAK_LEAVES),
                        new LargeOakFoliagePlacer(ConstantIntProvider.create(2),ConstantIntProvider.create(4), 4),
                        new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines().decorators(ImmutableList.of(new ChickenOfTheWoodsTreeDecorator(1.0f, 5))).build()
        );

        /* Chicken of the Woods cherry tree CF */
        register(context, CHICKEN_OF_THE_WOODS_CHERRY_DECORATOR_KEY, Feature.TREE,
                (new TreeFeatureConfig.Builder(BlockStateProvider.of(Blocks.CHERRY_LOG),
                        new CherryTrunkPlacer(7, 1, 0,
                                new WeightedListIntProvider(DataPool.<IntProvider>builder()
                                .add(ConstantIntProvider.create(1), 1)
                                .add(ConstantIntProvider.create(2), 1)
                                .add(ConstantIntProvider.create(3), 1).build()),
                                UniformIntProvider.create(2, 4), UniformIntProvider.create(-4, -3), UniformIntProvider.create(-1, 0)),
                        BlockStateProvider.of(Blocks.CHERRY_LEAVES), new CherryFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0), ConstantIntProvider.create(5), 0.25F, 0.5F, 0.16666667F, 0.33333334F),
                        new TwoLayersFeatureSize(1, 0, 2))).ignoreVines().decorators(ImmutableList.of(new ChickenOfTheWoodsTreeDecorator(1.0f, 5))).build()
        );

    }

    /** Registers Fly Agaric configured features
     *
     * @param context Registerable context
     */
    public static void registerFlyAgaricCF(Registerable<ConfiguredFeature<?, ?>> context) {
        // TODO: implement custom (more sparse) random patch feature (possibly as tree decorator?)
        /* Fly Agaric patch CF */
        register(context, FLY_AGARIC_PATCH_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.FLY_AGARIC_BLOCK)),
                        FlyAgaricBlock.PLACEABLE_BLOCKS)
        );
    }

    public static void registerHoneyMushroomCF(Registerable<ConfiguredFeature<?, ?>> context) {
        register(context, HONEY_MUSHROOM_OAK_DECORATOR_KEY, Feature.TREE,
                (new TreeFeatureConfig.Builder(BlockStateProvider.of(Blocks.OAK_LOG.getDefaultState()),
                        new StraightTrunkPlacer(4, 2, 0),
                        BlockStateProvider.of(Blocks.OAK_LEAVES.getDefaultState()),
                        new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1))
                        .decorators(ImmutableList.of(new HoneyMushroomTreeDecorator(1.0f))).build())
        );
    }

    /** Registers Lion's Mane configured features
     *
     * @param context Registerable context
     */
    public static void registerLionsManeCF(Registerable<ConfiguredFeature<?, ?>> context) {
        /* Lion's Mane oak tree CF */
        register(context, LIONS_MANE_OAK_DECORATOR_KEY, Feature.TREE,
                (new TreeFeatureConfig.Builder(BlockStateProvider.of(Blocks.OAK_LOG.getDefaultState()),
                        new StraightTrunkPlacer(4, 2, 0),
                        BlockStateProvider.of(Blocks.OAK_LEAVES.getDefaultState()),
                        new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1))
                        .decorators(ImmutableList.of(new LionsManeTreeDecorator(1.0f, 4))).build())
        );

        /* Lion's Mane fancy oak tree CF */
        register(context, LIONS_MANE_FANCY_OAK_DECORATOR_KEY, Feature.TREE,
                (new TreeFeatureConfig.Builder(BlockStateProvider.of(Blocks.OAK_LOG),
                        new LargeOakTrunkPlacer(3, 11, 0),
                        BlockStateProvider.of(Blocks.OAK_LEAVES),
                        new LargeOakFoliagePlacer(ConstantIntProvider.create(2),ConstantIntProvider.create(4), 4),
                        new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines().decorators(ImmutableList.of(new LionsManeTreeDecorator(1.0f, 4))).build()
        );

        /* Lion's Mane birch tree CF */
        register(context, LIONS_MANE_BIRCH_DECORATOR_KEY, Feature.TREE,
                (new TreeFeatureConfig.Builder(BlockStateProvider.of(Blocks.BIRCH_LOG.getDefaultState()),
                        new StraightTrunkPlacer(5, 2, 0),
                        BlockStateProvider.of(Blocks.BIRCH_LEAVES.getDefaultState()),
                        new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1))
                        .decorators(ImmutableList.of(new LionsManeTreeDecorator(1.0f, 4))).build())
        );

        /* Lion's Mane super birch tree CF */
        register(context, LIONS_MANE_SUPER_BIRCH_DECORATOR_TREE, Feature.TREE,
                (new TreeFeatureConfig.Builder(BlockStateProvider.of(Blocks.BIRCH_LOG.getDefaultState()),
                        new StraightTrunkPlacer(5, 2, 6),
                        BlockStateProvider.of(Blocks.BIRCH_LEAVES.getDefaultState()),
                        new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1))
                        .decorators(ImmutableList.of(new LionsManeTreeDecorator(1.0f, 4))).build())
        );
    }

    // TODO: implement
    /** Registers Morel configured features
     *
     * @param context Registerable context
     */
    public static void registerMorelCF(Registerable<ConfiguredFeature<?, ?>> context) {

    }

    /** Registers Oyster Mushroom configured features
     *
     * @param context Registerable context
     */
    public static void registerOysterMushroomCF(Registerable<ConfiguredFeature<?, ?>> context) {
        /* Oyster Mushroom oak tree CF */
        register(context, OYSTER_MUSHROOM_OAK_DECORATOR_KEY, Feature.TREE,
                (new TreeFeatureConfig.Builder(BlockStateProvider.of(Blocks.OAK_LOG.getDefaultState()),
                        new StraightTrunkPlacer(4, 2, 0),
                        BlockStateProvider.of(Blocks.OAK_LEAVES.getDefaultState()),
                        new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1))
                        .decorators(ImmutableList.of(new OysterMushroomTreeDecorator(1.0f, 3))).build())
        );

        /* Oyster Mushroom fancy oak tree CF */
        register(context, OYSTER_MUSHROOM_FANCY_OAK_DECORATOR_KEY, Feature.TREE,
                (new TreeFeatureConfig.Builder(BlockStateProvider.of(Blocks.OAK_LOG),
                        new LargeOakTrunkPlacer(3, 11, 0),
                        BlockStateProvider.of(Blocks.OAK_LEAVES),
                        new LargeOakFoliagePlacer(ConstantIntProvider.create(2),ConstantIntProvider.create(4), 4),
                        new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines().decorators(ImmutableList.of(new OysterMushroomTreeDecorator(1.0f, 3))).build()
        );

        /* Oyster Mushroom birch tree CF */
        register(context, OYSTER_MUSHROOM_BIRCH_DECORATOR_KEY, Feature.TREE,
                (new TreeFeatureConfig.Builder(BlockStateProvider.of(Blocks.BIRCH_LOG.getDefaultState()),
                        new StraightTrunkPlacer(5, 2, 0),
                        BlockStateProvider.of(Blocks.BIRCH_LEAVES.getDefaultState()),
                        new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1))
                        .decorators(ImmutableList.of(new OysterMushroomTreeDecorator(1.0f, 3))).build())
        );

        /* Oyster Mushroom super birch tree CF */
        register(context, OYSTER_MUSHROOM_SUPER_BIRCH_DECORATOR_TREE, Feature.TREE,
                (new TreeFeatureConfig.Builder(BlockStateProvider.of(Blocks.BIRCH_LOG.getDefaultState()),
                        new StraightTrunkPlacer(5, 2, 6),
                        BlockStateProvider.of(Blocks.BIRCH_LEAVES.getDefaultState()),
                        new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1))
                        .decorators(ImmutableList.of(new OysterMushroomTreeDecorator(1.0f, 3))).build())
        );
    }

    // TODO: implement
    /** Registers Porcini configured features
     *
     * @param context Registerable context
     */
    public static void registerPorciniCF(Registerable<ConfiguredFeature<?, ?>> context) {

    }

    // TODO: implement
    /** Registers Reishi configured features
     *
     * @param context Registerable context
     */
    public static void registerReishiCF(Registerable<ConfiguredFeature<?, ?>> context) {
        /* Oyster Mushroom oak tree CF */
        register(context, REISHI_OAK_DECORATOR_KEY, Feature.TREE,
                (new TreeFeatureConfig.Builder(BlockStateProvider.of(Blocks.OAK_LOG.getDefaultState()),
                        new StraightTrunkPlacer(4, 2, 0),
                        BlockStateProvider.of(Blocks.OAK_LEAVES.getDefaultState()),
                        new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1))
                        .decorators(ImmutableList.of(new ReishiTreeDecorator(1.0f, 4))).build())
        );

        /* Oyster Mushroom fancy oak tree CF */
        register(context, REISHI_FANCY_OAK_DECORATOR_KEY, Feature.TREE,
                (new TreeFeatureConfig.Builder(BlockStateProvider.of(Blocks.OAK_LOG),
                        new LargeOakTrunkPlacer(3, 11, 0),
                        BlockStateProvider.of(Blocks.OAK_LEAVES),
                        new LargeOakFoliagePlacer(ConstantIntProvider.create(2),ConstantIntProvider.create(4), 4),
                        new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines().decorators(ImmutableList.of(new ReishiTreeDecorator(1.0f, 4))).build()
        );
    }

    /** Creates a RegistryKey for the configured feature
     * @param name Name of ConfiguredFeature
     * @return Created RegistryKey
     */
    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Minecology.MOD_ID, name));
    }

    /** Registers a configured feature under the given RegistryKey
     * @param context Registrerable context
     * @param key Created RegistryKey
     * @param feature Feature
     * @param config Feature configuration
     * @param <FC> Feature configuration type
     * @param <F> Ex
     */
    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(
            Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
        context.register(key, new ConfiguredFeature<>(feature, config));
    }
}
