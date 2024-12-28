package net.jbixler.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.jbixler.block.ModBlocks;
import net.jbixler.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagEntry;
import net.minecraft.registry.tag.TagKey;

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
                /* ARMOR RECIPES */

                /* Crown of the Mushroom Forest */
                createShaped(RecipeCategory.COMBAT,ModItems.CROWN_OF_THE_MUSHROOM_FOREST, 1)
                        .pattern("FFF")
                        .pattern("F F")
                        .pattern("   ")
                        .input('F', ModItems.DEHYDRATED_FLY_AGARIC_CAP)
                        .criterion(hasItem(ModItems.DEHYDRATED_FLY_AGARIC_CAP), conditionsFromItem(ModItems.DEHYDRATED_FLY_AGARIC_CAP))
                        .offerTo(exporter);

                /* FOOD RECIPES */

                /* Cooked Lion's Mane recipe */
                offerSmelting(List.of(ModItems.LIONS_MANE), RecipeCategory.FOOD, ModItems.COOKED_LIONS_MANE, 0.25f, 200, "cooked_lions_mane");
                /* Cooked Oyster Mushroom */
                offerSmelting(List.of(ModItems.OYSTER_MUSHROOM), RecipeCategory.FOOD, ModItems.COOKED_OYSTER_MUSHROOM, 0.25f, 200, "cooked_oyster_mushroom");
                /* Cream of Oyster Mushroom Soup */
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

                /* CULTIVATION SYSTEM RECIPES */

                /* Honey Mushroom spore print and liquid culture */
                createSporePrintAndLiquidCultureRecipes(ModItems.HONEY_MUSHROOM, ModItems.HONEY_MUSHROOM_SPORE_PRINT, ModItems.HONEY_MUSHROOM_LIQUID_CULTURE);
                /* Lion's Mane spore print and liquid culture */
                createSporePrintAndLiquidCultureRecipes(ModItems.LIONS_MANE, ModItems.LIONS_MANE_SPORE_PRINT, ModItems.LIONS_MANE_LIQUID_CULTURE);
                /* Oyster Mushroom spore print and liquid culture */
                createSporePrintAndLiquidCultureRecipes(ModItems.OYSTER_MUSHROOM, ModItems.OYSTER_MUSHROOM_SPORE_PRINT, ModItems.OYSTER_MUSHROOM_LIQUID_CULTURE);
                /* Reishi spore print and liquid culture */
                createSporePrintAndLiquidCultureRecipes(ModItems.REISHI, ModItems.REISHI_SPORE_PRINT, ModItems.REISHI_LIQUID_CULTURE);

                /* Grain */
                createShaped(RecipeCategory.MISC, ModItems.GRAIN, 4)
                        .pattern("WW")
                        .pattern("WW")
                        .input('W', Items.WHEAT)
                        .criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
                        .offerTo(exporter);

                /* Wood Chips */
                createShaped(RecipeCategory.MISC, ModItems.WOOD_CHIPS, 9)
                        .pattern("LLL")
                        .pattern("LLL")
                        .pattern("LLL")
                        .input('L', ItemTags.LOGS)
                        .criterion("has_log", conditionsFromTag(ItemTags.LOGS))
                        .offerTo(exporter);

                /* Grain Grow Bag */
                createShaped(RecipeCategory.MISC, ModBlocks.GRAIN_GROW_BAG_BLOCK)
                        .pattern("WWW")
                        .pattern("WGW")
                        .pattern("WWW")
                        .input('W', Items.WHITE_WOOL)
                        .input('G', ModItems.STERILIZED_GRAIN)
                        .criterion(hasItem(ModItems.GRAIN), conditionsFromItem(ModItems.GRAIN))
                        .offerTo(exporter);

                /* Wood Chips Grow Bag */
                createShaped(RecipeCategory.MISC, ModBlocks.WOOD_CHIPS_GROW_BAG_BLOCK)
                        .pattern("WWW")
                        .pattern("WGW")
                        .pattern("WWW")
                        .input('W', Items.WHITE_WOOL)
                        .input('G', ModItems.STERILIZED_WOOD_CHIPS)
                        .criterion(hasItem(ModItems.WOOD_CHIPS), conditionsFromItem(ModItems.WOOD_CHIPS))
                        .offerTo(exporter);

                /* MISC RECIPES */

                /* Fly Agaric Cap */
                createShapeless(RecipeCategory.MISC, ModItems.FLY_AGARIC_CAP)
                        .input(ModItems.FLY_AGARIC)
                        .criterion(hasItem(ModItems.FLY_AGARIC), conditionsFromItem(ModItems.FLY_AGARIC))
                        .offerTo(exporter);
                /* Dehydrated Fly Agaric Cap */
                offerSmelting(List.of(ModItems.FLY_AGARIC_CAP), RecipeCategory.MISC, ModItems.DEHYDRATED_FLY_AGARIC_CAP, 0.25f, 200, "dehydrated_fly_agaric");
                /* Dehydrator Block */
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

            private void createSporePrintAndLiquidCultureRecipes(Item mushroomItem, Item sporePrintItem, Item liquidCultureItem) {
                createShaped(RecipeCategory.MISC, sporePrintItem)
                        .pattern("   ")
                        .pattern(" M ")
                        .pattern(" P ")
                        .input('M', mushroomItem)
                        .input('P', Items.PAPER)
                        .criterion(hasItem(mushroomItem), conditionsFromItem(mushroomItem))
                        .criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, liquidCultureItem)
                        .pattern("GSG")
                        .pattern("GWG")
                        .pattern(" I ")
                        .input('G', Blocks.GLASS)
                        .input('S', sporePrintItem)
                        .input('W', ModItems.STERILIZED_WATER_BOTTLE)
                        .input('I', Items.IRON_INGOT)
                        .criterion(hasItem(Blocks.GLASS), conditionsFromItem(Blocks.GLASS))
                        .criterion(hasItem(sporePrintItem), conditionsFromItem(sporePrintItem))
                        .criterion(hasItem(ModItems.STERILIZED_WATER_BOTTLE), conditionsFromItem(ModItems.STERILIZED_WATER_BOTTLE))
                        .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "Minecology Recipes";
    }
}
