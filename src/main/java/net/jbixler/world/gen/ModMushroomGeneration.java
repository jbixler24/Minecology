package net.jbixler.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.jbixler.world.ModPlacedFeatures;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

import java.util.List;

public class ModMushroomGeneration {

    public static final List<RegistryKey<Biome>> OAK_BIOME_KEYS = List.of(BiomeKeys.PLAINS, BiomeKeys.OCEAN, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST);
    public static final List<RegistryKey<Biome>> FANCY_OAK_BIOME_KEYS = List.of(BiomeKeys.PLAINS, BiomeKeys.OCEAN, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST);
    public static final List<RegistryKey<Biome>> BIRCH_BIOME_KEYS = List.of(BiomeKeys.PLAINS, BiomeKeys.OCEAN, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST);
    public static final List<RegistryKey<Biome>> SUPER_BIRCH_BIOME_KEYS = List.of(BiomeKeys.PLAINS, BiomeKeys.OCEAN, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST);
    public static final List<RegistryKey<Biome>> CHERRY_BIOME_KEYS = List.of(BiomeKeys.PLAINS, BiomeKeys.OCEAN, BiomeKeys.CHERRY_GROVE);
    public static final List<RegistryKey<Biome>> DARK_OAK_BIOME_KEYS = List.of(BiomeKeys.PLAINS, BiomeKeys.OCEAN, BiomeKeys.DARK_FOREST);

    /** Generates all mushroom biome modifications **/
    public static void generateMushrooms() {
//        generateChanterelle();
        generateChickenOfTheWoods();
        generateFlyAgaric();
        generateHoneyMushroom();
        generateLionsMane();
//        generateMorel();
        generateOysterMushroom();
//        generatePorcini();
        generateReishi();
    }

    // TODO: implement
    /** Generates Chanterelle biome modifications **/
    public static void generateChanterelle() {

    }

    /** Generates Chicken of the Woods biome modifications **/
    public static void generateChickenOfTheWoods() {
        /* Chicken of the Woods oak biome modification */
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(OAK_BIOME_KEYS),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.CHICKEN_OF_THE_WOODS_OAK_PLACED_KEY);

        /* Chicken of the Woods fancy oak biome modification */
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(FANCY_OAK_BIOME_KEYS),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.CHICKEN_OF_THE_WOODS_FANCY_OAK_PLACED_KEY);

        /* Chicken of the Woods cherry biome modification */
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(CHERRY_BIOME_KEYS),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.CHICKEN_OF_THE_WOODS_CHERRY_PLACED_KEY);
    }

    /** Generates Fly Agaric biome modifications **/
    public static void generateFlyAgaric() {
        /* Fly Agaric patch biome modification */
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(BiomeKeys.TAIGA, BiomeKeys.SNOWY_TAIGA, BiomeKeys.OLD_GROWTH_PINE_TAIGA, BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.FLY_AGARIC_PLACED_KEY);
    }

    /** Generates Honey Mushroom biome modifications **/
    public static void generateHoneyMushroom() {
        /* Honey Mushroom oak biome modification */
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(OAK_BIOME_KEYS),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.HONEY_MUSHROOM_OAK_PLACED_KEY
        );
    }

    /** Generates Lion's Mane biome modifications **/
    public static void generateLionsMane() {
        /* Lion's mane oak biome modification */
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(OAK_BIOME_KEYS),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.LIONS_MANE_OAK_PLACED_KEY);

        /* Lion's mane fancy oak biome modification */
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(FANCY_OAK_BIOME_KEYS),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.LIONS_MANE_FANCY_OAK_PLACED_KEY);

        /* Lion's mane birch biome modification */
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(BIRCH_BIOME_KEYS),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.LIONS_MANE_BIRCH_PLACED_KEY);

        /* Lion's mane super birch biome modification */
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(SUPER_BIRCH_BIOME_KEYS),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.LIONS_MANE_SUPER_BIRCH_PLACED_KEY);
    }

    // TODO: implement
    /** Generates Morel biome modifications **/
    public static void generateMorel() {

    }

    /** Generates Oyster Mushroom biome modifications **/
    public static void generateOysterMushroom() {
        /* Oyster Mushroom oak biome modification */
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(OAK_BIOME_KEYS),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.OYSTER_MUSHROOM_OAK_PLACED_KEY);

        /* Oyster Mushroom fancy oak biome modification */
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(FANCY_OAK_BIOME_KEYS),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.OYSTER_MUSHROOM_FANCY_OAK_PLACED_KEY);

        /* Oyster Mushroom birch biome modification */
        BiomeModifications.addFeature(
            BiomeSelectors.includeByKey(BIRCH_BIOME_KEYS),
            GenerationStep.Feature.VEGETAL_DECORATION,
            ModPlacedFeatures.OYSTER_MUSHROOM_BIRCH_PLACED_KEY);

        /* Oyster Mushroom super birch biome modification */
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(SUPER_BIRCH_BIOME_KEYS),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.OYSTER_MUSHROOM_SUPER_BIRCH_PLACED_KEY);
    }

    // TODO: implement
    /** Generates Porcini biome modifications **/
    public static void generatePorcini() {

    }

    /** Generates Reishi biome modifications **/
    public static void generateReishi() {
        /* Reishi oak biome modification */
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(OAK_BIOME_KEYS),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.REISHI_OAK_PLACED_KEY);

        /* Reishi fancy oak biome modification */
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(FANCY_OAK_BIOME_KEYS),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.REISHI_FANCY_OAK_PLACED_KEY);
    }
}
