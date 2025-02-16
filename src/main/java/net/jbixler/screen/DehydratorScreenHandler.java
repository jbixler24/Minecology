//package net.jbixler.screen;
//
//import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
//import net.jbixler.block.entity.DehydratorBlockEntity;
//import net.minecraft.block.entity.BlockEntity;
//import net.minecraft.client.gui.screen.Screen;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.entity.player.PlayerInventory;
//import net.minecraft.inventory.Inventory;
//import net.minecraft.item.ItemStack;
//import net.minecraft.network.PacketByteBuf;
//import net.minecraft.network.RegistryByteBuf;
//import net.minecraft.network.codec.PacketCodec;
//import net.minecraft.screen.ArrayPropertyDelegate;
//import net.minecraft.screen.FurnaceScreenHandler;
//import net.minecraft.screen.PropertyDelegate;
//import net.minecraft.screen.ScreenHandler;
//import net.minecraft.screen.slot.Slot;
//
//public class DehydratorScreenHandler extends ScreenHandler {
////    public DehydratorScreenHandler(int syncId, PlayerInventory playerInventory) {
////        super(syncId, playerInventory);
////    }
//
//    protected Inventory inventory;
//    private PropertyDelegate propertyDelegate;
//    private DehydratorBlockEntity blockEntity;
//
//    public DehydratorScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf) {
//        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(buf.readBlockPos()), new ArrayPropertyDelegate(3));
//    }
//
//    public DehydratorScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity, ArrayPropertyDelegate arrayPropertyDelegate) {
//        super(ModScreenHandlers.DEHYDRATOR_SCREEN_HANDLER, syncId);
//        checkSize((Inventory) blockEntity, 2);
//        this.inventory = (Inventory) blockEntity;
//        this.inventory.onOpen(playerInventory.player);
//        this.propertyDelegate = arrayPropertyDelegate;
//        this.blockEntity = (DehydratorBlockEntity) blockEntity;
//
//        this.addSlot(new Slot(inventory, 0, 80, 11));
//        this.addSlot(new Slot(inventory, 0, 80, 59));
//        this.addSlot(new Slot(inventory, 0, 80, 70));
//
//        addPlayerInventory(playerInventory);
//        addPlayerHotbar(playerInventory);
//
//        addProperties(propertyDelegate);
//    }
//
//    public boolean isCrafting() {
//        return propertyDelegate.get(0) > 0;
//    }
//
//    // TODO: implement
////    public int getScaledProgress() {
////        int progress = this.propertyDelegate.get(0);
////        int maxProgress = this.propertyDelegate.get(1);
////    }
//
//    @Override
//    public ItemStack quickMove(PlayerEntity player, int invSlot) {
//        ItemStack newStack = ItemStack.EMPTY;
//        Slot slot = this.slots.get(invSlot);
//        if (slot != null && slot.hasStack()) {
//            ItemStack originalStack = slot.getStack();
//            newStack = originalStack.copy();
//            if (invSlot < this.inventory.size()) {
//                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
//                    return ItemStack.EMPTY;
//                }
//            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
//                return ItemStack.EMPTY;
//            }
//
//            if (originalStack.isEmpty()) {
//                slot.setStack(ItemStack.EMPTY);
//            } else {
//                slot.markDirty();
//            }
//        }
//
//        return newStack;
//    }
//
//    @Override
//    public boolean canUse(PlayerEntity player) {
//        return this.inventory.canPlayerUse(player);
//    }
//
//    private void addPlayerInventory(PlayerInventory playerInventory) {
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 9; j++) {
//                this.addSlot(new Slot(playerInventory, i + j*9 + 9, 8 + j * 16, 84 + i * 18));
//            }
//        }
//    }
//
//    private void addPlayerHotbar(PlayerInventory playerInventory) {
//        for (int i = 0; i < 9; i++) {
//            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
//        }
//    }
//}
