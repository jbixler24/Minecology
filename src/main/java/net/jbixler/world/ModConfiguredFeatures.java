package net.jbixler.world;

import net.jbixler.Minecology;
import net.jbixler.block.ModBlocks;
import net.jbixler.block.OysterMushroomBlock;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> FLY_AGARIC_KEY = registerKey("fly_agaric_configured");
    public static final RegistryKey<ConfiguredFeature<?, ?>> OYSTER_MUSHROOM_KEY = registerKey("oyster_mushroom_configured");


    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        register(context, FLY_AGARIC_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.FLY_AGARIC_BLOCK)),
                        List.of(Blocks.GRASS_BLOCK, Blocks.PODZOL)
                ));
        register(context, OYSTER_MUSHROOM_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.OYSTER_MUSHROOM_BLOCK)),
                        OysterMushroomBlock.getPlaceableBlocks()
                ));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Minecology.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(
            Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
        context.register(key, new ConfiguredFeature<>(feature, config));
    }
}
