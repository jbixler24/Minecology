//package net.jbixler.block.entity;
//
//import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
//import net.jbixler.item.ModItems;
//import net.jbixler.screen.DehydratorScreenHandler;
//import net.jbixler.screen.ModScreenHandlers;
//import net.minecraft.block.BlockState;
//import net.minecraft.block.entity.BlockEntity;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.entity.player.PlayerInventory;
//import net.minecraft.inventory.Inventories;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemStack;
//import net.minecraft.nbt.NbtCompound;
//import net.minecraft.registry.RegistryWrapper;
//import net.minecraft.screen.PropertyDelegate;
//import net.minecraft.screen.ScreenHandler;
//import net.minecraft.server.network.ServerPlayerEntity;
//import net.minecraft.text.Text;
//import net.minecraft.util.collection.DefaultedList;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.world.World;
//import org.jetbrains.annotations.Nullable;
//
//public class DehydratorBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
//    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);
//
//    private static final int INPUT_SLOT_INDEX = 0;
//    private static final int FUEL_SLOT_INDEX = 1;
//    private static final int OUTPUT_SLOT_INDEX = 2;
//    private static final int MAX_PROGRESS_TIME = 200;
//
//    protected final PropertyDelegate propertyDelegate;
//
//    private int progress = 0;
//    private int maxProgress = 72;
//
//    public DehydratorBlockEntity(BlockPos pos, BlockState state) {
//        super(ModBlockEntities.DEHYDRATOR_BLOCK_ENTITY, pos, state);
//        this.propertyDelegate = new PropertyDelegate() {
//            @Override
//            public int get(int index) {
//                return switch (index) {
//                    case 0 -> DehydratorBlockEntity.this.progress;
//                    case 1 -> DehydratorBlockEntity.this.maxProgress;
//                    default -> 0;
//                };
//            }
//
//            @Override
//            public void set(int index, int value) {
//                switch (index) {
//                    case 0: DehydratorBlockEntity.this.progress = value;
//                    case 1: DehydratorBlockEntity.this.maxProgress = value;
//                }
//            }
//
//            @Override
//            public int size() {
//                return 2;
//            }
//        };
//    }
//
//    @Override
//    public DefaultedList<ItemStack> getItems() {
//        return this.inventory;
//    }
//
//    @Override
//    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
//        super.writeNbt(nbt, registries);
//        Inventories.writeNbt(nbt, this.inventory, registries);
//        nbt.putInt("dehydrator.progress", this.progress);
//    }
//
//    @Override
//    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
//        super.readNbt(nbt, registries);
//        Inventories.readNbt(nbt, this.inventory, registries);
//        this.progress = nbt.getInt("dehydrator.progress");
//    }
//
//    @Override
//    public Text getDisplayName() {
//        return Text.translatable("dehydrator_block_entity");
//    }
//
//    public void tick(World world, BlockPos pos, BlockState state) {
//        if (world.isClient) {
//            return;
//        }
//
//        if (isOutputSlotEmptyOrRecievable()) {
//            if (this.hasRecipe()) {
//                this.increaseCraftProgress();
//                markDirty(world, pos, state);
//                if (hasCraftingFinished()) {
//                    this.craftItem();
//                    this.resetProgress();
//                }
//            } else {
//                this.resetProgress();
//            }
//        } else {
//            this.resetProgress();
//            markDirty(world, pos, state);
//        }
//    }
//
//    private void resetProgress() {
//        this.progress = 0;
//    }
//
//    private void craftItem() {
//        this.removeStack(INPUT_SLOT_INDEX, 1);
//        ItemStack result = new ItemStack(ModItems.DEHYDRATED_FLY_AGARIC_CAP);
//        this.setStack(OUTPUT_SLOT_INDEX, new ItemStack(result.getItem(), getStack(OUTPUT_SLOT_INDEX).getCount() + result.getCount()));
//    }
//
//    private boolean hasCraftingFinished() {
//        return this.progress >= MAX_PROGRESS_TIME;
//    }
//
//    private void increaseCraftProgress() {
//        this.progress++;
//    }
//
//    private boolean hasRecipe() {
//        ItemStack result = new ItemStack(ModItems.DEHYDRATED_FLY_AGARIC_CAP);
//        boolean hasInput = getStack(INPUT_SLOT_INDEX).getItem() == ModItems.FLY_AGARIC;
//
//        return hasInput && canInsertAmountIntoOutputSlot(result) && canInsertItemIntoOutputSlot(result.getItem());
//    }
//
//    private boolean canInsertItemIntoOutputSlot(Item item) {
//        return this.getStack(OUTPUT_SLOT_INDEX).getItem() == item || this.getStack(OUTPUT_SLOT_INDEX).isEmpty();
//    }
//
//    private boolean canInsertAmountIntoOutputSlot(ItemStack result) {
//        return this.getStack(OUTPUT_SLOT_INDEX).getCount() + result.getCount() <= getStack(OUTPUT_SLOT_INDEX).getMaxCount();
//    }
//
//    private boolean isOutputSlotEmptyOrRecievable() {
//        return this.getStack(OUTPUT_SLOT_INDEX).isEmpty() || this.getStack(OUTPUT_SLOT_INDEX).getCount() < this.getStack(OUTPUT_SLOT_INDEX).getMaxCount();
//    }
//
//    @Override
//    public Object getScreenOpeningData(ServerPlayerEntity serverPlayerEntity) {
//        return null;
//    }
//
//    @Override
//    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
//        return null;
//    }
//}
