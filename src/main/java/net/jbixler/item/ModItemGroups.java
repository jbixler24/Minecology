package net.jbixler.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.jbixler.Minecology;
import net.jbixler.potion.ModPotions;
import net.jbixler.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class ModItemGroups {

    public static final ItemGroup MINECOLOGY_ITEMS_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(Minecology.MOD_ID, "minecology_items"),
            FabricItemGroup
                    .builder()
                    .icon(() -> new ItemStack(ModItems.FLY_AGARIC))
                    .displayName(Text.translatable("itemgroup.minecology.minecology_items"))
                    .entries(((displayContext, entries) -> {
                        for (Item item : ModItems.getItems()) {
                            entries.add(item);
                        }
                        for (Block block : ModBlocks.getBlocks()) {
                            entries.add(block);
                        }
                        entries.add(PotionContentsComponent.createStack(Items.POTION, ModPotions.AMANITA_EXTRACT));
                        entries.add(PotionContentsComponent.createStack(Items.LINGERING_POTION, ModPotions.AMANITA_EXTRACT));
                        entries.add(PotionContentsComponent.createStack(Items.SPLASH_POTION, ModPotions.AMANITA_EXTRACT));
                    }))
                    .build()
    );
    public static void registerItemGroups() {
        List<ItemGroup> allItemGroups = getItemGroups();
        Minecology.log(String.format("Registering %d item groups", allItemGroups.size()));
    }

    public static List getItemGroups() {
        List<ItemGroup> allItemGroups = new ArrayList<>();
        allItemGroups.add(MINECOLOGY_ITEMS_GROUP);
        return allItemGroups;
    }
}
