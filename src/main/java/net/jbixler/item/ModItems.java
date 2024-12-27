package net.jbixler.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.jbixler.Minecology;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

    /* Mushroom items */
    public static final Item CHANTERELLE = registerItem("chanterelle", new Item.Settings().food(ModFoodComponents.RAW_MUSHROOM, ModFoodComponents.RAW_MUSHROOM_EFFECT), ChanterelleItem.class);

    public static final Item DESTROYING_ANGEL_SPORE_PRINT = registerItem("destroying_angel_spore_print", new Item.Settings(), DestroyingAngelItem.class);
    public static final Item DESTROYING_ANGEL = registerItem("destroying_angel", new Item.Settings().food(ModFoodComponents.RAW_MUSHROOM, ModFoodComponents.DESTROYING_ANGEL_EFFECT), DestroyingAngelItem.class);
    public static final Item DESTROYING_ANGEL_CAP = registerItem("destroying_angel_cap", new Item.Settings().food(ModFoodComponents.RAW_MUSHROOM, ModFoodComponents.DESTROYING_ANGEL_EFFECT), DestroyingAngelCapItem.class);

    public static final Item CHICKEN_OF_THE_WOODS = registerItem("chicken_of_the_woods", new Item.Settings().food(ModFoodComponents.RAW_MUSHROOM), ChickenOfTheWoodsItem.class);

    public static final Item FLY_AGARIC = registerItem("fly_agaric", new Item.Settings().food(ModFoodComponents.FLY_AGARIC_CAP, ModFoodComponents.FLY_AGARIC_CAP_EFFECT), FlyAgaricItem.class);
    public static final Item FLY_AGARIC_CAP = registerItem("fly_agaric_cap", new Item.Settings().food(ModFoodComponents.FLY_AGARIC_CAP, ModFoodComponents.FLY_AGARIC_CAP_EFFECT), Item.class);
    public static final Item DEHYDRATED_FLY_AGARIC_CAP = registerItem("dehydrated_fly_agaric_cap", new Item.Settings().food(ModFoodComponents.DEHYDRATED_FLY_AGARIC_CAP, ModFoodComponents.DEHYDRATED_FLY_AGARIC_CAP_EFFECT), DehydratedFlyAgaricItem.class);
    public static final Item CROWN_OF_THE_MUSHROOM_FOREST = registerItem("crown_of_the_mushroom_forest", new Item.Settings(), CrownOfTheMushroomForest.class);

    public static final Item HONEY_MUSHROOM_SPORE_PRINT = registerItem("honey_mushroom_spore_print", new Item.Settings(), HoneyMushroomSporePrintItem.class);
    public static final Item HONEY_MUSHROOM_LIQUID_CULTURE = registerItem("honey_mushroom_liquid_culture", new Item.Settings(), HoneyMushroomLiquidCultureItem.class);
    public static final Item HONEY_MUSHROOM = registerItem("honey_mushroom", new Item.Settings().food(ModFoodComponents.RAW_MUSHROOM, ModFoodComponents.RAW_MUSHROOM_EFFECT), HoneyMushroomItem.class);

    public static final Item LIONS_MANE_SPORE_PRINT = registerItem("lions_mane_spore_print", new Item.Settings(), LionsManeSporePrintItem.class);
    public static final Item LIONS_MANE_LIQUID_CULTURE = registerItem("lions_mane_liquid_culture", new Item.Settings(), LionsManeLiquidCultureItem.class);
    public static final Item LIONS_MANE = registerItem("lions_mane", new Item.Settings().food(ModFoodComponents.RAW_MUSHROOM, ModFoodComponents.LIONS_MANE_EFFECT), LionsManeItem.class);
    public static final Item COOKED_LIONS_MANE = registerItem("cooked_lions_mane", new Item.Settings().food(ModFoodComponents.COOKED_LIONS_MANE, ModFoodComponents.COOKED_LIONS_MANE_EFFECT), CookedLionsManeItem.class);

    public static final Item MOREL = registerItem("morel", new Item.Settings().food(ModFoodComponents.RAW_MUSHROOM, ModFoodComponents.RAW_MUSHROOM_EFFECT), MorelItem.class);

    public static final Item OYSTER_MUSHROOM_SPORE_PRINT = registerItem("oyster_mushroom_spore_print", new Item.Settings(), OysterMushroomSporePrintItem.class);
    public static final Item OYSTER_MUSHROOM_LIQUID_CULTURE = registerItem("oyster_mushroom_liquid_culture", new Item.Settings(), OysterMushroomLiquidCultureItem.class);
    public static final Item OYSTER_MUSHROOM = registerItem("oyster_mushroom", new Item.Settings().food(ModFoodComponents.RAW_MUSHROOM), OysterMushroomItem.class);
    public static final Item COOKED_OYSTER_MUSHROOM = registerItem("cooked_oyster_mushroom", new Item.Settings().food(ModFoodComponents.COOKED_OYSTER_MUSHROOM), CookedOysterMushroomItem.class);
    public static final Item CREAM_OF_OYSTER_MUSHROOM_SOUP = registerItem("cream_of_oyster_mushroom_soup", new Item.Settings().food(ModFoodComponents.CREAM_OF_OYSTER_MUSHROOM_SOUP), CreamofOysterMushroomSoupItem.class);

    public static final Item PORCINI = registerItem("porcini", new Item.Settings().food(ModFoodComponents.RAW_MUSHROOM, ModFoodComponents.RAW_MUSHROOM_EFFECT), PorciniItem.class);

    public static final Item REISHI_SPORE_PRINT = registerItem("reishi_spore_print", new Item.Settings(), ReishiSporePrintItem.class);
    public static final Item REISHI_LIQUID_CULTURE = registerItem("reishi_liquid_culture", new Item.Settings(), ReishiLiquidCultureItem.class);
    public static final Item REISHI = registerItem("reishi", new Item.Settings().food(ModFoodComponents.RAW_MUSHROOM, ModFoodComponents.RAW_MUSHROOM_EFFECT), ReishiItem.class);

    /* Cultivation system items */
    public static final Item GRAIN = registerItem("grain", new Item.Settings(), GrainItem.class);
    public static final Item STERILIZED_GRAIN = registerItem("sterilized_grain", new Item.Settings(), SterilizedGrainItem.class);
    public static final Item WOOD_CHIPS = registerItem("wood_chips", new Item.Settings(), WoodChipsItem.class);
    public static final Item STERILIZED_WOOD_CHIPS = registerItem("sterilized_wood_chips", new Item.Settings(), SterilizedWoodChipsItem.class);
    public static final Item STERILIZED_WATER_BOTTLE = registerItem("sterilized_water_bottle", new Item.Settings(), SterilizedWaterBottleItem.class);

    /** Registers a single item
     * @param name Name of item to be registered
     * @param settings Settings of item to be registered
     */
    private static Item registerItem(String name, Item.Settings settings, Class<? extends Item> itemClass) {
        Identifier id = Identifier.of(Minecology.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);

        try {
            Item item = itemClass.getDeclaredConstructor(Item.Settings.class).newInstance(settings.registryKey(key));
            return Registry.register(Registries.ITEM, key, item);
        } catch (Exception e) {
            Minecology.log(String.format("Error in registering item %s", name));
            e.printStackTrace();
            Item item = new Item(settings.registryKey(key));
            return Registry.register(Registries.ITEM, key, item);
        }
    }

    /** Registers all mod items **/
    public static void registerItems() {
        List<Item> allItems = getItems();
        Minecology.log(String.format("Registering %d mod items", allItems.size()));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            for (Item item : allItems) {
                entries.add(item);
            }
        });
    }

    /** Get all items in this mod **/
    public static List<Item> getItems() {
        List<Item> allItems = new ArrayList<>();
        allItems.add(CHANTERELLE);

        allItems.add(CHICKEN_OF_THE_WOODS);

        allItems.add(DESTROYING_ANGEL_SPORE_PRINT);
        allItems.add(DESTROYING_ANGEL);
        allItems.add(DESTROYING_ANGEL_CAP);

        allItems.add(FLY_AGARIC);
        allItems.add(FLY_AGARIC_CAP);
        allItems.add(DEHYDRATED_FLY_AGARIC_CAP);
        allItems.add(CROWN_OF_THE_MUSHROOM_FOREST);

        allItems.add(HONEY_MUSHROOM);
        allItems.add(HONEY_MUSHROOM_SPORE_PRINT);
        allItems.add(HONEY_MUSHROOM_LIQUID_CULTURE);

        allItems.add(LIONS_MANE_SPORE_PRINT);
        allItems.add(LIONS_MANE_LIQUID_CULTURE);
        allItems.add(LIONS_MANE);
        allItems.add(COOKED_LIONS_MANE);

        allItems.add(MOREL);

        allItems.add(OYSTER_MUSHROOM_SPORE_PRINT);
        allItems.add(OYSTER_MUSHROOM_LIQUID_CULTURE);
        allItems.add(OYSTER_MUSHROOM);
        allItems.add(COOKED_OYSTER_MUSHROOM);
        allItems.add(CREAM_OF_OYSTER_MUSHROOM_SOUP);

        allItems.add(PORCINI);

        allItems.add(REISHI_SPORE_PRINT);
        allItems.add(REISHI_LIQUID_CULTURE);
        allItems.add(REISHI);

        allItems.add(GRAIN);
        allItems.add(STERILIZED_GRAIN);
        allItems.add(WOOD_CHIPS);
        allItems.add(STERILIZED_WOOD_CHIPS);
        allItems.add(STERILIZED_WATER_BOTTLE);

        return allItems;
    }
}
