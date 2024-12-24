package net.jbixler.world.gen.treedecorator;

import com.mojang.serialization.MapCodec;
import net.jbixler.Minecology;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

public class ModTreeDecoratorTypes {
    public static TreeDecoratorType<OysterMushroomTreeDecorator> OYSTER_MUSHROOM_TREE_DECORATOR_TYPE = register("oyster_mushroom_tree_decorator_type", OysterMushroomTreeDecorator.CODEC);
    public static TreeDecoratorType<LionsManeTreeDecorator> LIONS_MANE_TREE_DECORATOR_TYPE = register("lions_mane_tree_decorator_type", LionsManeTreeDecorator.CODEC);

    public static <T extends TreeDecorator> TreeDecoratorType<T> register(String name, MapCodec<T> codec) {
        return Registry.register(Registries.TREE_DECORATOR_TYPE, Identifier.of(Minecology.MOD_ID, name), new TreeDecoratorType<>(codec));
    }

    public static void registerTreeDecoratorTypes() {
        Minecology.log("Registering tree decorator types");
    }
}
