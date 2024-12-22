package net.jbixler.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.jbixler.Minecology;
import net.jbixler.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;
import java.util.List;

public class ModBlockEntityTypes {

    public static final BlockEntityType<DehydratorBlockEntity> DEHYDRATOR_BLOCK_ENTITY_TYPE =
            registerBlockEntityType("dehydrator_block_entity_type", FabricBlockEntityTypeBuilder.create(
                    new FabricBlockEntityTypeBuilder.Factory<DehydratorBlockEntity>(){
        @Override
        public DehydratorBlockEntity create(BlockPos blockPos, BlockState blockState) {
            return new DehydratorBlockEntity(blockPos, blockState);
        }
    }, ModBlocks.DEHYDRATOR_BLOCK).build());


    public static <T extends BlockEntityType<?>> T registerBlockEntityType(String name, T blockEntityType) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Minecology.MOD_ID, name), blockEntityType);
    }

    public static void registerBlockEntityTypes() {
        Minecology.log(String.format("Registering %d block entity types", getEntityBlockTypes().size()));
    }

    public static List<BlockEntityType<?>> getEntityBlockTypes() {
        List<BlockEntityType<?>> allBlockEntityTypes = new ArrayList<>();
        allBlockEntityTypes.add(DEHYDRATOR_BLOCK_ENTITY_TYPE);
        return allBlockEntityTypes;
    }
}
