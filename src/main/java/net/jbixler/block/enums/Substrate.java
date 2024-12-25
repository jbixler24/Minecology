package net.jbixler.block.enums;

import net.jbixler.item.SporePrintItem;
import net.minecraft.util.StringIdentifiable;

import java.util.List;

public enum Substrate implements StringIdentifiable {
    NONE("none", List.of()),
    COCOA_GROUNDS("cocoa_grounds", List.of()),
    SAWDUST("sawdust", List.of()),
    STRAW("straw", List.of()),
    WOOD_CHIPS("wood_chips", List.of());

    private final String name;
    private final List<SporePrintItem> validSporePrints;

    Substrate(String name, List<SporePrintItem> validSporePrints) {
        this.name = name;
        this.validSporePrints = validSporePrints;
    }

    /** True iff the spore print can grow on this substrate **/
    public boolean isValidSporePrint(SporePrintItem sporePrint) {
        return this.validSporePrints.contains(sporePrint);
    }

    /** Returns the name of this substrate **/
    public String getName() {
        return this.name;
    }

    /** Returns a list of the valid spore prints for this substrate **/
    public List<SporePrintItem> getValidSporePrints() {
        return this.validSporePrints;
    }

    /** Returns the String translation of this substrate **/
    @Override
    public String asString() {
        return getName();
    }
}
