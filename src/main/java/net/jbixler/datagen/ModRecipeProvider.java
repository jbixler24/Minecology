package net.jbixler.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.jbixler.block.ModBlocks;
import net.jbixler.item.ModItems;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                /* FOOD RECIPES */

                /* Cooked Lion's Mane recipe */
                offerSmelting(List.of(ModItems.LIONS_MANE), RecipeCategory.FOOD, ModItems.COOKED_LIONS_MANE, 0.25f, 200, "cooked_lions_mane");
                /* Cooked Oyster Mushroom recipe */
                offerSmelting(List.of(ModItems.OYSTER_MUSHROOM), RecipeCategory.FOOD, ModItems.COOKED_OYSTER_MUSHROOM, 0.25f, 200, "cooked_oyster_mushroom");
                /* Cream of Oyster Mushroom Soup recipe */
                createShaped(RecipeCategory.FOOD, ModItems.CREAM_OF_OYSTER_MUSHROOM_SOUP, 3)
                        .pattern("OOO")
                        .pattern("CMC")
                        .pattern("BBB")
                        .input('O', ModItems.COOKED_OYSTER_MUSHROOM)
                        .input('C', Items.COOKED_CHICKEN)
                        .input('M', Items.MILK_BUCKET)
                        .input('B', Items.BOWL)
                        .criterion(hasItem(ModItems.COOKED_OYSTER_MUSHROOM), conditionsFromItem(ModItems.COOKED_OYSTER_MUSHROOM))
                        .criterion(hasItem(Items.COOKED_CHICKEN), conditionsFromItem(Items.COOKED_CHICKEN))
                        .criterion(hasItem(Items.MILK_BUCKET), conditionsFromItem(Items.MILK_BUCKET))
                        .criterion(hasItem(Items.BOWL), conditionsFromItem(Items.BOWL))
                        .offerTo(exporter);

                /* MISC RECIPES */

                /* Fly Agaric Cap recipe */
                createShapeless(RecipeCategory.MISC, ModItems.FLY_AGARIC_CAP)
                        .input(ModItems.FLY_AGARIC)
                        .criterion(hasItem(ModItems.FLY_AGARIC), conditionsFromItem(ModItems.FLY_AGARIC))
                        .offerTo(exporter);
                /* Dehydrated Fly Agaric Cap recipe */
                offerSmelting(List.of(ModItems.FLY_AGARIC_CAP), RecipeCategory.MISC, ModItems.DEHYDRATED_FLY_AGARIC_CAP, 0.25f, 200, "dehydrated_fly_agaric");
                /* Dehydrator Block recipe */
                createShaped(RecipeCategory.MISC, ModBlocks.DEHYDRATOR_BLOCK, 1)
                        .pattern("GGG")
                        .pattern("IWI")
                        .pattern("III")
                        .input('G', Items.GLASS)
                        .input('I', Items.IRON_BLOCK)
                        .input('W', Items.WIND_CHARGE)
                        .criterion(hasItem(Items.GLASS), conditionsFromItem(Items.GLASS))
                        .criterion(hasItem(Items.IRON_BLOCK), conditionsFromItem(Items.IRON_BLOCK))
                        .criterion(hasItem(Items.WIND_CHARGE), conditionsFromItem(Items.WIND_CHARGE))
                        .offerTo(exporter);

            }
        };
    }

    @Override
    public String getName() {
        return "Minecology Recipes";
    }
}
