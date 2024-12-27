//package net.jbixler.screen;
//
//import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
//import net.jbixler.Minecology;
//import net.jbixler.block.DehydratorBlock;
//import net.minecraft.network.codec.PacketCodecs;
//import net.minecraft.registry.Registries;
//import net.minecraft.registry.Registry;
//import net.minecraft.screen.ScreenHandlerType;
//import net.minecraft.util.Identifier;
//
//public class ModScreenHandlers {
//    public static final ScreenHandlerType<DehydratorScreenHandler> DEHYDRATOR_SCREEN_HANDLER =
//            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(Minecology.MOD_ID, "dehydrator"),
//                    new ExtendedScreenHandlerType<>(DehydratorScreenHandler::new, DehydratorBlock.CODEC));
//
//    public static void registerScreenHandlers() {
//        Minecology.log("Registering screen handlers");
//    }
//}
