package net.jbixler.world;

import com.google.common.collect.ImmutableList;
import net.jbixler.Minecology;
import net.jbixler.block.FlyAgaricBlock;
import net.jbixler.block.ModBlocks;
import net.jbixler.world.gen.treedecorator.OysterMushroomTreeDecorator;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> FLY_AGARIC_KEY = registerKey("fly_agaric_configured");
    public static final RegistryKey<ConfiguredFeature<?, ?>> OYSTER_MUSHROOM_TREE_DECORATOR_KEY = registerKey("oyster_mushroom_tree_decorator");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        register(context, FLY_AGARIC_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.FLY_AGARIC_BLOCK)),
                        FlyAgaricBlock.PLACEABLE_BLOCKS
                ));

        register(context, OYSTER_MUSHROOM_TREE_DECORATOR_KEY, Feature.TREE,
                (new TreeFeatureConfig.Builder(BlockStateProvider.of(Blocks.OAK_LOG.getDefaultState()),
                        new StraightTrunkPlacer(5, 2, 0),
                        BlockStateProvider.of(Blocks.OAK_LEAVES.getDefaultState()),
                        new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1))
                        .decorators(ImmutableList.of(new OysterMushroomTreeDecorator(0.2f))).build()));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Minecology.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(
            Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
        context.register(key, new ConfiguredFeature<>(feature, config));
    }
}
