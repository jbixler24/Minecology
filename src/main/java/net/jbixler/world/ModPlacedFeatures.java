package net.jbixler.world;

import net.jbixler.Minecology;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.List;

public class ModPlacedFeatures {

//    public static final RegistryKey<PlacedFeature> CHANTERELLE_PLACED_KEY = registerKey("chanterelle_placed");

    public static final RegistryKey<PlacedFeature> CHICKEN_OF_THE_WOODS_OAK_PLACED_KEY = registerKey("chicken_of_the_woods_oak_placed");
    public static final RegistryKey<PlacedFeature> CHICKEN_OF_THE_WOODS_FANCY_OAK_PLACED_KEY = registerKey("chicken_of_the_woods_fancy_oak_placed");
    public static final RegistryKey<PlacedFeature> CHICKEN_OF_THE_WOODS_CHERRY_PLACED_KEY = registerKey("chicken_of_the_woods_cherry_placed");

    public static final RegistryKey<PlacedFeature> FLY_AGARIC_PLACED_KEY = registerKey("fly_agaric_placed");

    public static final RegistryKey<PlacedFeature> HONEY_MUSHROOM_OAK_PLACED_KEY = registerKey("honey_mushroom_oak_placed");

    public static final RegistryKey<PlacedFeature> LIONS_MANE_OAK_PLACED_KEY = registerKey("lions_mane_oak_placed");
    public static final RegistryKey<PlacedFeature> LIONS_MANE_FANCY_OAK_PLACED_KEY = registerKey("lions_mane_fancy_oak_placed");
    public static final RegistryKey<PlacedFeature> LIONS_MANE_BIRCH_PLACED_KEY = registerKey("lions_mane_birch_placed");
    public static final RegistryKey<PlacedFeature> LIONS_MANE_SUPER_BIRCH_PLACED_KEY = registerKey("lions_mane_super_birch_placed");

    public static final RegistryKey<PlacedFeature> MOREL_PLACED_KEY = registerKey("morel_placed");

    public static final RegistryKey<PlacedFeature> OYSTER_MUSHROOM_OAK_PLACED_KEY = registerKey("oyster_mushroom_oak_placed");
    public static final RegistryKey<PlacedFeature> OYSTER_MUSHROOM_FANCY_OAK_PLACED_KEY = registerKey("oyster_mushroom_fancy_oak_placed");
    public static final RegistryKey<PlacedFeature> OYSTER_MUSHROOM_BIRCH_PLACED_KEY = registerKey("oyster_mushroom_birch_placed");
    public static final RegistryKey<PlacedFeature> OYSTER_MUSHROOM_SUPER_BIRCH_PLACED_KEY = registerKey("oyster_mushroom_super_birch_placed");

//    public static final RegistryKey<PlacedFeature> PORCINI_PLACED_KEY = registerKey("porcini_placed");

    public static final RegistryKey<PlacedFeature> REISHI_OAK_PLACED_KEY = registerKey("reishi_oak_placed");
    public static final RegistryKey<PlacedFeature> REISHI_FANCY_OAK_PLACED_KEY = registerKey("reishi_fancy_oak_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        RegistryEntryLookup<ConfiguredFeature<?, ?>> configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
//        registerChanterellePF(context, configuredFeatures);
        registerChickenOfTheWoodsPF(context, configuredFeatures);
        registerFlyAgaricPF(context, configuredFeatures);
        registerHoneyMushroomPF(context, configuredFeatures);
        registerLionsManePF(context, configuredFeatures);
//        registerMorelPF(context, configuredFeatures);
        registerOysterMushroomPF(context, configuredFeatures);
//        registerPorciniPF(context, configuredFeatures);
        registerReishiPF(context, configuredFeatures);
    }

    // TODO: implement
    /** Registers Chanterelle placed features
     *
     * @param context Registerable context
     * @param configuredFeatures RegistryLookup of all registered configured features
     */
    public static void registerChanterellePF(Registerable<PlacedFeature> context, RegistryEntryLookup<ConfiguredFeature<?, ?>> configuredFeatures) {

    }

    /** Registers Chicken of the Woods placed features
     *
     * @param context Registerable context
     * @param configuredFeatures RegistryLookup of all registered configured features
     */
    public static void registerChickenOfTheWoodsPF(Registerable<PlacedFeature> context, RegistryEntryLookup<ConfiguredFeature<?, ?>> configuredFeatures) {
        int defaultChance = 128;

        /* Chicken of the Woods oak tree placed feature */
        register(context, CHICKEN_OF_THE_WOODS_OAK_PLACED_KEY, configuredFeatures.getOrThrow(
                        ModConfiguredFeatures.CHICKEN_OF_THE_WOODS_OAK_DECORATOR_KEY),
                RarityFilterPlacementModifier.of(defaultChance),
                PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP,
                BiomePlacementModifier.of()
        );

        /* Chicken of the Woods fancy oak tree placed feature */
        register(context, CHICKEN_OF_THE_WOODS_FANCY_OAK_PLACED_KEY, configuredFeatures.getOrThrow(
                        ModConfiguredFeatures.CHICKEN_OF_THE_WOODS_FANCY_OAK_DECORATOR_KEY),
                RarityFilterPlacementModifier.of(defaultChance * 2),
                PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP,
                BiomePlacementModifier.of()
        );

        /* Chicken of the Woods fancy oak tree placed feature */
        register(context, CHICKEN_OF_THE_WOODS_CHERRY_PLACED_KEY, configuredFeatures.getOrThrow(
                        ModConfiguredFeatures.CHICKEN_OF_THE_WOODS_CHERRY_DECORATOR_KEY),
                RarityFilterPlacementModifier.of(defaultChance),
                PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP,
                BiomePlacementModifier.of()
        );
    }

    /** Registers Fly Agaric placed features
     *
     * @param context Registerable context
     * @param configuredFeatures RegistryLookup of all registered configured features
     */
    public static void registerFlyAgaricPF(Registerable<PlacedFeature> context, RegistryEntryLookup<ConfiguredFeature<?, ?>> configuredFeatures) {
        int defaultChance = 64;

        /* Fly Agaric patch placed feature */
        register(context, FLY_AGARIC_PLACED_KEY, configuredFeatures.getOrThrow(
                        ModConfiguredFeatures.FLY_AGARIC_PATCH_KEY),
                        RarityFilterPlacementModifier.of(defaultChance),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()
        );
    }

    /** Registers Honey Mushroom placed features
     *
     * @param context Registerable context
     * @param configuredFeatures RegistryLookup of all registered configured features
     */
    public static void registerHoneyMushroomPF(Registerable<PlacedFeature> context, RegistryEntryLookup<ConfiguredFeature<?, ?>> configuredFeatures) {
        int defaultChance = 32;

        /* Honey Mushroom oak tree placed feature */
        register(context, HONEY_MUSHROOM_OAK_PLACED_KEY, configuredFeatures.getOrThrow(
                        ModConfiguredFeatures.HONEY_MUSHROOM_OAK_DECORATOR_KEY),
                        RarityFilterPlacementModifier.of(defaultChance),
                        PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP,
                        BiomePlacementModifier.of()
        );
    }

    /** Registers Lion's Mane placed features
     *
     * @param context Registerable context
     * @param configuredFeatures RegistryLookup of all registered configured features
     */
    public static void registerLionsManePF(Registerable<PlacedFeature> context, RegistryEntryLookup<ConfiguredFeature<?, ?>> configuredFeatures) {
        int defaultChance = 64;

        /* Lion's Mane oak tree placed feature */
        register(context, LIONS_MANE_OAK_PLACED_KEY, configuredFeatures.getOrThrow(
                        ModConfiguredFeatures.LIONS_MANE_OAK_DECORATOR_KEY),
                        RarityFilterPlacementModifier.of(defaultChance),
                        PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP,
                        BiomePlacementModifier.of()
        );

        /* Lion's Mane fancy oak tree placed feature */
        register(context, LIONS_MANE_FANCY_OAK_PLACED_KEY, configuredFeatures.getOrThrow(
                        ModConfiguredFeatures.LIONS_MANE_FANCY_OAK_DECORATOR_KEY),
                        RarityFilterPlacementModifier.of(defaultChance * 2),
                        PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP,
                        BiomePlacementModifier.of()
        );

        /* Lion's Mane large oak tree placed feature */
        register(context, LIONS_MANE_BIRCH_PLACED_KEY, configuredFeatures.getOrThrow(
                        ModConfiguredFeatures.LIONS_MANE_BIRCH_DECORATOR_KEY),
                        RarityFilterPlacementModifier.of(defaultChance),
                        PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP,
                        BiomePlacementModifier.of()
        );

        /* Lion's Mane super birch tree placed feature */
        register(context, LIONS_MANE_SUPER_BIRCH_PLACED_KEY, configuredFeatures.getOrThrow(
                        ModConfiguredFeatures.LIONS_MANE_SUPER_BIRCH_DECORATOR_TREE),
                    RarityFilterPlacementModifier.of(defaultChance),
                    PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP,
                    BiomePlacementModifier.of()
        );
    }

    // TODO: implement

    /** Registers Morel placed features
     *
     * @param context Registerable context
     * @param configuredFeatures RegistryLookup of all registered configured features
     */
    public static void registerMorelPF(Registerable<PlacedFeature> context, RegistryEntryLookup<ConfiguredFeature<?, ?>> configuredFeatures) {

    }

    /** Registers Oyster Mushroom placed features
     *
     * @param context Registerable context
     */
    public static void registerOysterMushroomPF(Registerable<PlacedFeature> context, RegistryEntryLookup<ConfiguredFeature<?, ?>> configuredFeatures) {
        int defaultChance = 64;

        /* Oyster Mushroom oak tree placed feature */
        register(context, OYSTER_MUSHROOM_OAK_PLACED_KEY, configuredFeatures.getOrThrow(
                        ModConfiguredFeatures.OYSTER_MUSHROOM_OAK_DECORATOR_KEY),
                        RarityFilterPlacementModifier.of(defaultChance),
                        PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP,
                        BiomePlacementModifier.of());

        /* Oyster Mushroom fancy oak tree placed feature */
        register(context, OYSTER_MUSHROOM_FANCY_OAK_PLACED_KEY, configuredFeatures.getOrThrow(
                        ModConfiguredFeatures.OYSTER_MUSHROOM_FANCY_OAK_DECORATOR_KEY),
                        RarityFilterPlacementModifier.of(defaultChance * 2),
                        PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP,
                        BiomePlacementModifier.of());

        /* Oyster Mushroom birch tree placed feature */
        register(context, OYSTER_MUSHROOM_BIRCH_PLACED_KEY, configuredFeatures.getOrThrow(
                        ModConfiguredFeatures.OYSTER_MUSHROOM_BIRCH_DECORATOR_KEY),
                        RarityFilterPlacementModifier.of(defaultChance),
                        PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP,
                        BiomePlacementModifier.of());

        /* Oyster Mushroom super birch tree placed feature */
        register(context, OYSTER_MUSHROOM_SUPER_BIRCH_PLACED_KEY, configuredFeatures.getOrThrow(
                        ModConfiguredFeatures.OYSTER_MUSHROOM_SUPER_BIRCH_DECORATOR_TREE),
                        RarityFilterPlacementModifier.of(defaultChance),
                        PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP,
                        BiomePlacementModifier.of());
    }

    // TODO: implement
    /** Registers Porcini placed features
     *
     * @param context Registerable context
     */
    public static void registerPorciniPF(Registerable<PlacedFeature> context, RegistryEntryLookup<ConfiguredFeature<?, ?>> configuredFeatures) {

    }

    // TODO: implement
    /** Registers Reishi Mushroom placed features
     *
     * @param context Registerable context
     */
    public static void registerReishiPF(Registerable<PlacedFeature> context, RegistryEntryLookup<ConfiguredFeature<?, ?>> configuredFeatures) {
        int defaultChance = 128;

        /* Reishi oak tree placed feature */
        register(context, REISHI_OAK_PLACED_KEY, configuredFeatures.getOrThrow(
                        ModConfiguredFeatures.REISHI_OAK_DECORATOR_KEY),
                        RarityFilterPlacementModifier.of(defaultChance),
                        PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP,
                        BiomePlacementModifier.of());

        /* Reishi fancy oak tree placed feature */
        register(context, REISHI_FANCY_OAK_PLACED_KEY, configuredFeatures.getOrThrow(
                        ModConfiguredFeatures.REISHI_FANCY_OAK_DECORATOR_KEY),
                        RarityFilterPlacementModifier.of(defaultChance * 2),
                        PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP,
                        BiomePlacementModifier.of());
    }

    /** Creates a RegistryKey for the configured feature
     *
     * @param name Name of ConfiguredFeature
     * @return Created RegistryKey
     */
    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(Minecology.MOD_ID, name));
    }

    /** Registers a placed feature under the given RegistryKey
     *
     * @param context Registerable context
     * @param key Created RegistryKey
     * @param config Associated configured feature RegistryEntry
     * @param modifiers Placed feature modifiers
     */
    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> config, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(config, List.copyOf(modifiers)));
    }

    /** Registers a placed feature under the given RegistryKey
     *
     * @param context Registerable context
     * @param key Created RegistryKey
     * @param config Associated configured feature RegistryEntry
     * @param modifiers Placed feature modifiers
     */
    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> config, PlacementModifier... modifiers) {
        register(context, key, config, List.of(modifiers));
    }
}
