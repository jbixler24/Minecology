package net.jbixler.block;

import net.jbixler.Minecology;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {

    /* Mushroom blocks */
    public static final Block CHANTERELLE_BLOCK = registerBlock("chanterelle_block", AbstractBlock.Settings.create(), ChanterelleBlock.class, new Item.Settings());
    public static final Block CHICKEN_OF_THE_WOODS_BLOCK = registerBlock("chicken_of_the_woods_block", AbstractBlock.Settings.create(), ChickenOfTheWoodsBlock.class, new Item.Settings());
    public static final Block DESTROYING_ANGEL_BLOCK = registerBlock("destroying_angel_block", AbstractBlock.Settings.create(), DestroyingAngelBlock.class, new Item.Settings());
    public static final Block FLY_AGARIC_BLOCK = registerBlock("fly_agaric_block", AbstractBlock.Settings.create(), FlyAgaricBlock.class, new Item.Settings());
    public static final Block HONEY_MUSHROOM_BLOCK = registerBlock("honey_mushroom_block", AbstractBlock.Settings.create(), HoneyMushroomBlock.class, new Item.Settings());
    public static final Block LIONS_MANE_BLOCK = registerBlock("lions_mane_block", AbstractBlock.Settings.create(), LionsManeBlock.class, new Item.Settings());
    public static final Block MOREL_BLOCK = registerBlock("morel_block", AbstractBlock.Settings.create(), MorelBlock.class, new Item.Settings());
    public static final Block OYSTER_MUSHROOM_BLOCK = registerBlock("oyster_mushroom_block", AbstractBlock.Settings.create(), OysterMushroomBlock.class, new Item.Settings());
    public static final Block PORCINI_BLOCK = registerBlock("porcini_block", AbstractBlock.Settings.create(), PorciniBlock.class, new Item.Settings());
    public static final Block REISHI_BLOCK = registerBlock("reishi_block", AbstractBlock.Settings.create(), ReishiBlock.class, new Item.Settings());

    /* Other blocks */
    public static final Block DEHYDRATOR_BLOCK = registerBlock("dehydrator", AbstractBlock.Settings.create().requiresTool().strength(3.5F), DehydratorBlock.class, new Item.Settings());
    public static final Block GRAIN_GROW_BAG_BLOCK = registerBlock("grain_grow_bag", AbstractBlock.Settings.create().strength(0.8F), GrainGrowBagBlock.class, new Item.Settings());
    public static final Block WOOD_CHIPS_GROW_BAG_BLOCK = registerBlock("wood_chips_grow_bag", AbstractBlock.Settings.create().strength(0.8F), WoodChipsGrowBagBlock.class, new Item.Settings());
    public static final Block PRESSURE_COOKER_BLOCK = registerBlock("pressure_cooker", AbstractBlock.Settings.create().requiresTool().strength(3.5F), PressureCookerBlock.class, new Item.Settings());

    public static Block registerBlock(String name, AbstractBlock.Settings blockSettings, Class<? extends Block> blockClass, Item.Settings itemSettings) {
        Identifier id = Identifier.of(Minecology.MOD_ID, name);
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, id);
        Block block;
        try {
            block = blockClass.getDeclaredConstructor(AbstractBlock.Settings.class).newInstance(blockSettings.registryKey(key));
            registerBlockItem(name, block, itemSettings);
        } catch (Exception e) {
            Minecology.debug(String.format("Error in registering block %s", name));
            e.printStackTrace();
            block = new Block(blockSettings.registryKey(key));
            registerBlockItem(name, block, itemSettings);
        }
        return Registry.register(Registries.BLOCK, key, block);
    }

     static void registerBlockItem(String name, Block block, Item.Settings settings) {
        Identifier id = Identifier.of(Minecology.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);

        Item item = new BlockItem(block, settings.registryKey(key));
        Registry.register(Registries.ITEM, key, item);
    }

    public static void registerBlocks() {
        List<Block> allBlocks = getBlocks();
        Minecology.log(String.format("Registering %d blocks", allBlocks.size()));
    }

    public static List<Block> getBlocks() {
        List<Block> allBlocks = new ArrayList<>(getMushroomBlocks());
        allBlocks.add(DEHYDRATOR_BLOCK);
        allBlocks.add(GRAIN_GROW_BAG_BLOCK);
        allBlocks.add(WOOD_CHIPS_GROW_BAG_BLOCK);
        allBlocks.add(PRESSURE_COOKER_BLOCK);
        return allBlocks;
    }

    public static List<Block> getMushroomBlocks() {
        List<Block> mushroomBlocks = new ArrayList<>();
        mushroomBlocks.add(CHANTERELLE_BLOCK);
        mushroomBlocks.add(CHICKEN_OF_THE_WOODS_BLOCK);
        mushroomBlocks.add(DESTROYING_ANGEL_BLOCK);
        mushroomBlocks.add(FLY_AGARIC_BLOCK);
        mushroomBlocks.add(HONEY_MUSHROOM_BLOCK);
        mushroomBlocks.add(LIONS_MANE_BLOCK);
        mushroomBlocks.add(MOREL_BLOCK);
        mushroomBlocks.add(OYSTER_MUSHROOM_BLOCK);
        mushroomBlocks.add(PORCINI_BLOCK);
        mushroomBlocks.add(REISHI_BLOCK);
        return mushroomBlocks;
    }
}
