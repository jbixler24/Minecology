package net.jbixler.block.enums;

import net.jbixler.block.ModBlocks;
import net.jbixler.block.MushroomBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.StringIdentifiable;

import java.util.List;

public enum MushroomType implements StringIdentifiable {

    NONE("none", ModBlocks.HONEY_MUSHROOM_BLOCK, List.of()),
    CHANTERELLE("chanterelle", ModBlocks.CHANTERELLE_BLOCK, List.of()),
    CHICKEN_OF_THE_WOODS("chicken_of_the_woods", ModBlocks.CHICKEN_OF_THE_WOODS_BLOCK, List.of()),
    DESTROYING_ANGEL("destroying_angel", ModBlocks.DESTROYING_ANGEL_BLOCK, List.of()),
    FLY_AGARIC("fly_agaric", ModBlocks.FLY_AGARIC_BLOCK, List.of()),
    HONEY_MUSHROOM("honey_mushroom", ModBlocks.HONEY_MUSHROOM_BLOCK, List.of()),
    LIONS_MANE("lions_mane", ModBlocks.LIONS_MANE_BLOCK, List.of()),
    MOREL("morel", ModBlocks.MOREL_BLOCK, List.of()),
    OYSTER_MUSHROOM("oyster_mushroom", ModBlocks.OYSTER_MUSHROOM_BLOCK, List.of()),
    PORCINI("porcini", ModBlocks.PORCINI_BLOCK, List.of()),
    REISHI("reishi", ModBlocks.REISHI_BLOCK, List.of());

    private final String name;
    private final MushroomBlock mushroomBlock;

    MushroomType(String name, Block mushroomBlock, List<Substrate> validSubstrates) {
        this.name = name;
        this.mushroomBlock = (MushroomBlock) mushroomBlock;
    }

    public String getName() {
        return this.name;
    }

    public MushroomBlock getMushroomBlock() {
        return this.mushroomBlock;
    }

    @Override
    public String asString() {
        return getName();
    }
}
