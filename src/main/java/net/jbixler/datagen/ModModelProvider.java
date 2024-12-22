package net.jbixler.datagen;


import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.jbixler.block.*;
import net.jbixler.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.client.data.*;
import net.minecraft.item.Item;
import net.minecraft.state.property.Property;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEHYDRATOR_BLOCK);
        blockStateModelGenerator.registerCrop(
                ModBlocks.FLY_AGARIC_BLOCK,
                FlyAgaricBlock.AGE,
                new int[]{0, 1, 2});
        blockStateModelGenerator.registerCrop(
                ModBlocks.OYSTER_MUSHROOM_BLOCK,
                OysterMushroomBlock.AGE,
                new int[]{0, 1, 2});
        blockStateModelGenerator.registerCrop(
                ModBlocks.LIONS_MANE_BLOCK,
                LionsManeBlock.AGE,
                new int[]{0, 1, 2});
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        for (Item item : ModItems.getItems()) {
            itemModelGenerator.register(item, Models.GENERATED);
        }
    }
}
