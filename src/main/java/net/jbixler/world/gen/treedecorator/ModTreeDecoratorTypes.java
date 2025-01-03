package net.jbixler.world.gen.treedecorator;

import com.mojang.serialization.MapCodec;
import net.jbixler.Minecology;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

public class ModTreeDecoratorTypes {

    public static TreeDecoratorType<ChickenOfTheWoodsTreeDecorator> CHICKEN_OF_THE_WOODS_TREE_DECORATOR_TYPE = register("chicken_of_the_woods_tree_decorator_type", ChickenOfTheWoodsTreeDecorator.CODEC);
    public static TreeDecoratorType<HoneyMushroomTreeDecorator> HONEY_MUSHROOM_TREE_DECORATOR_TYPE = register("honey_mushroom_tree_decorator_type", HoneyMushroomTreeDecorator.CODEC);
    public static TreeDecoratorType<LionsManeTreeDecorator> LIONS_MANE_TREE_DECORATOR_TYPE = register("lions_mane_tree_decorator_type", LionsManeTreeDecorator.CODEC);
    public static TreeDecoratorType<OysterMushroomTreeDecorator> OYSTER_MUSHROOM_TREE_DECORATOR_TYPE = register("oyster_mushroom_tree_decorator_type", OysterMushroomTreeDecorator.CODEC);
    public static TreeDecoratorType<ReishiTreeDecorator> REISHI_TREE_DECORATOR_TYPE = register("reishi_tree_decorator_type", ReishiTreeDecorator.CODEC);

    public static <T extends TreeDecorator> TreeDecoratorType<T> register(String name, MapCodec<T> codec) {
        return Registry.register(Registries.TREE_DECORATOR_TYPE, Identifier.of(Minecology.MOD_ID, name), new TreeDecoratorType<>(codec));
    }

    public static void registerTreeDecoratorTypes() {
        Minecology.log("Registering tree decorator types");
    }
}
