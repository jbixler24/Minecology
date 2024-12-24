package net.jbixler.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.jbixler.Minecology;
import net.minecraft.block.BeehiveBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;

import java.util.ArrayList;

public class ModItems {

    public static final Item FLY_AGARIC_SPORE_PRINT = registerItem("fly_agaric_spore_print", new Item.Settings(), FlyAgaricSporePrint.class);
    public static final Item FLY_AGARIC = registerItem("fly_agaric", new Item.Settings(), FlyAgaricItem.class);
    public static final Item FLY_AGARIC_CAP = registerItem("fly_agaric_cap", new Item.Settings().food(ModFoodComponents.FLY_AGARIC_CAP, ModFoodComponents.FLY_AGARIC_CAP_EFFECT), Item.class);
    public static final Item DEHYDRATED_FLY_AGARIC_CAP = registerItem("dehydrated_fly_agaric_cap", new Item.Settings().food(ModFoodComponents.DEHYDRATED_FLY_AGARIC_CAP, ModFoodComponents.DEHYDRATED_FLY_AGARIC_CAP_EFFECT), DehydratedFlyAgaricItem.class);
    public static final Item CROWN_OF_THE_MUSHROOM_FOREST = registerItem("crown_of_the_mushroom_forest", new Item.Settings(), CrownOfTheMushroomForest.class);

    public static final Item LIONS_MANE_SPORE_PRINT = registerItem("lions_mane_spore_print", new Item.Settings(), LionsManeSporePrint.class);
    public static final Item LIONS_MANE = registerItem("lions_mane", new Item.Settings().food(ModFoodComponents.LIONS_MANE, ModFoodComponents.LIONS_MANE_EFFECT), LionsManeItem.class);
    public static final Item COOKED_LIONS_MANE = registerItem("cooked_lions_mane", new Item.Settings().food(ModFoodComponents.COOKED_LIONS_MANE, ModFoodComponents.COOKED_LIONS_MANE_EFFECT), CookedLionsManeItem.class);

    public static final Item OYSTER_MUSHROOM_SPORE_PRINT = registerItem("oyster_mushroom_spore_print", new Item.Settings(), OysterMushroomSporePrint.class);
    public static final Item OYSTER_MUSHROOM = registerItem("oyster_mushroom", new Item.Settings().food(ModFoodComponents.OYSTER_MUSHROOM), OysterMushroomItem.class);
    public static final Item COOKED_OYSTER_MUSHROOM = registerItem("cooked_oyster_mushroom", new Item.Settings().food(ModFoodComponents.COOKED_OYSTER_MUSHROOM), CookedOysterMushroomItem.class);
    public static final Item CREAM_OF_OYSTER_MUSHROOM_SOUP = registerItem("cream_of_oyster_mushroom_soup", new Item.Settings().food(ModFoodComponents.CREAM_OF_OYSTER_MUSHROOM_SOUP), CreamofOysterMushroomSoupItem.class);

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
        ArrayList<Item> allItems = getItems();
        Minecology.log(String.format("Registering %d mod items", allItems.size()));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            for (Item item : allItems) {
                entries.add(item);
            }
        });
    }

    /** Get all items in this mod **/
    public static ArrayList<Item> getItems() {
        ArrayList<Item> allItems = new ArrayList<>();
        allItems.add(FLY_AGARIC_SPORE_PRINT);
        allItems.add(FLY_AGARIC);
        allItems.add(FLY_AGARIC_CAP);
        allItems.add(DEHYDRATED_FLY_AGARIC_CAP);
        allItems.add(CROWN_OF_THE_MUSHROOM_FOREST);

        allItems.add(LIONS_MANE_SPORE_PRINT);
        allItems.add(LIONS_MANE);
        allItems.add(COOKED_LIONS_MANE);

        allItems.add(OYSTER_MUSHROOM_SPORE_PRINT);
        allItems.add(OYSTER_MUSHROOM);
        allItems.add(COOKED_OYSTER_MUSHROOM);
        allItems.add(CREAM_OF_OYSTER_MUSHROOM_SOUP);

        return allItems;
    }
}
