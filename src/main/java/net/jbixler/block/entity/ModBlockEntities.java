//package net.jbixler.block.entity;
//
//import net.fabricmc.fabric.api.block.v1.FabricBlock;
//import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
//import net.jbixler.Minecology;
//import net.jbixler.block.ModBlocks;
//import net.minecraft.block.Block;
//import net.minecraft.block.BlockWithEntity;
//import net.minecraft.block.entity.BlockEntity;
//import net.minecraft.block.entity.BlockEntityType;
//import net.minecraft.registry.Registries;
//import net.minecraft.registry.Registry;
//import net.minecraft.util.Identifier;
//
//public class ModBlockEntities {
//    public static final BlockEntityType<DehydratorBlockEntity> DEHYDRATOR_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Minecology.MOD_ID, "dehydrator_block_entity"), FabricBlockEntityTypeBuilder.create(DehydratorBlockEntity::new, ModBlocks.DEHYDRATOR_BLOCK).build());
//
//    public static void registerBlockEntities() {
//        Minecology.log("Registering block entities");
//    }
//}
