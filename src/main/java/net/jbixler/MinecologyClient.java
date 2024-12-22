package net.jbixler;


import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.jbixler.block.ModBlocks;
import net.minecraft.client.render.RenderLayer;

public class MinecologyClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.OYSTER_MUSHROOM_BLOCK, RenderLayer.getCutout());
    }
}