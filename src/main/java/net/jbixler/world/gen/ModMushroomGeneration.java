package net.jbixler.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.jbixler.world.ModPlacedFeatures;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModMushroomGeneration {
    /** Generates all mushroom biome modifications **/
    public static void generateMushrooms() {
//        generateChanterelle();
        generateFlyAgaric();
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

    /** Generates Fly Agaric biome modifications **/
    public static void generateFlyAgaric() {
        /* Fly Agaric patch biome modification */
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(BiomeKeys.TAIGA, BiomeKeys.SNOWY_TAIGA, BiomeKeys.OLD_GROWTH_PINE_TAIGA, BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.FLY_AGARIC_PLACED_KEY);
    }

    /** Generates Lion's Mane biome modifications **/
    public static void generateLionsMane() {
        /* Lion's mane oak biome modification */
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(BiomeKeys.OCEAN, BiomeKeys.FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.LIONS_MANE_OAK_PLACED_KEY);

        /* Lion's mane fancy oak biome modification */
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(BiomeKeys.OCEAN, BiomeKeys.FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.LIONS_MANE_FANCY_OAK_PLACED_KEY);

        /* Lion's mane birch biome modification */
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(BiomeKeys.OCEAN, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.LIONS_MANE_BIRCH_PLACED_KEY);

        /* Lion's mane super birch biome modification */
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(BiomeKeys.OCEAN, BiomeKeys.FOREST, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST),
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
                BiomeSelectors.includeByKey(BiomeKeys.OCEAN, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.OYSTER_MUSHROOM_OAK_PLACED_KEY);

        /* Oyster Mushroom fancy oak biome modification */
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(BiomeKeys.OCEAN, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.OYSTER_MUSHROOM_FANCY_OAK_PLACED_KEY);

        /* Oyster Mushroom birch biome modification */
        BiomeModifications.addFeature(
            BiomeSelectors.includeByKey(BiomeKeys.OCEAN, BiomeKeys.FOREST, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST),
            GenerationStep.Feature.VEGETAL_DECORATION,
            ModPlacedFeatures.OYSTER_MUSHROOM_BIRCH_PLACED_KEY);

        /* Oyster Mushroom super birch biome modification */
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(BiomeKeys.OCEAN, BiomeKeys.FOREST, BiomeKeys.OCEAN, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.OYSTER_MUSHROOM_SUPER_BIRCH_PLACED_KEY);
    }

    // TODO: implement
    /** Generates Porcini biome modifications **/
    public static void generatePorcini() {

    }

    // TODO: implement
    /** Generates Reishi biome modifications **/
    public static void generateReishi() {
        /* Reishi oak biome modification */
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(BiomeKeys.OCEAN, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.REISHI_OAK_PLACED_KEY);

        /* Reishi fancy oak biome modification */
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(BiomeKeys.OCEAN, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.REISHI_FANCY_OAK_PLACED_KEY);
    }
}
