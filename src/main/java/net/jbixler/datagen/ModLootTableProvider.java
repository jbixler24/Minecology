package net.jbixler.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.jbixler.block.FlyAgaricBlock;
import net.jbixler.block.ModBlocks;
import net.jbixler.item.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    // TODO: add block drops once blocks are added
    @Override
    public void generate() {
        addDrop(ModBlocks.DEHYDRATOR_BLOCK);
    }
}
