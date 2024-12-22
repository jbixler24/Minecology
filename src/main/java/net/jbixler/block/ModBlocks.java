package net.jbixler.block;

import net.jbixler.Minecology;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SaplingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final Block FLY_AGARIC_BLOCK = registerBlock("fly_agaric_block", AbstractBlock.Settings.create().breakInstantly().sounds(BlockSoundGroup.NETHER_WART), FlyAgaricBlock.class, new Item.Settings());
    public static final Block LIONS_MANE_BLOCK = registerBlock("lions_mane_block", AbstractBlock.Settings.create().breakInstantly().sounds(BlockSoundGroup.NETHER_WART), LionsManeBlock.class, new Item.Settings());
    public static final Block OYSTER_MUSHROOM_BLOCK = registerBlock("oyster_mushroom_block", AbstractBlock.Settings.create().breakInstantly().sounds(BlockSoundGroup.NETHER_WART), OysterMushroomBlock.class, new Item.Settings());

    public static final Block DEHYDRATOR_BLOCK = registerBlock("dehydrator", AbstractBlock.Settings.create().requiresTool().strength(3.5F), DehydratorBlock.class, new Item.Settings());

    public static Block registerBlock(String name, AbstractBlock.Settings blockSettings, Class<? extends Block> blockClass, Item.Settings itemSettings) {
        Identifier id = Identifier.of(Minecology.MOD_ID, name);
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, id);

        try {
            Block block = blockClass.getDeclaredConstructor(Block.Settings.class).newInstance(blockSettings.registryKey(key));
            registerBlockItem(name, block, itemSettings);
            return Registry.register(Registries.BLOCK, key, block);
        } catch (Exception e) {
            Minecology.log(String.format("Error in registering block %s", name));
            e.printStackTrace();
            Block block = new Block(blockSettings.registryKey(key));
            registerBlockItem(name, block, itemSettings);
            return Registry.register(Registries.BLOCK, key, block);
        }
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
        List<Block> allBlocks = new ArrayList<>();
        allBlocks.add(FLY_AGARIC_BLOCK);
        allBlocks.add(LIONS_MANE_BLOCK);
        allBlocks.add(OYSTER_MUSHROOM_BLOCK);
        allBlocks.add(DEHYDRATOR_BLOCK);
        return allBlocks;
    }

    public static List<Block> getMushroomBlocks() {
        List<Block> allBlocks = new ArrayList<>();
        allBlocks.add(FLY_AGARIC_BLOCK);
        allBlocks.add(OYSTER_MUSHROOM_BLOCK);
        return allBlocks;
    }
}
