package net.jbixler.util;

import net.jbixler.Minecology;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {

    public static class ModBlockTags {
        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Minecology.MOD_ID, name));
        }
    }

    public static class ModItemTags {
        public static final TagKey<Item> MUSHROOM_ITEMS = createTag("mushroom_items");
        public static final TagKey<Item> MUSHROOM_CROWN_REPAIR = createTag("mushroom_crown_repair");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Minecology.MOD_ID, name));
        }
    }
}
