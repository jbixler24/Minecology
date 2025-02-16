package net.jbixler.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class DehydratorBlock extends Block {

//    public static final BooleanProperty ON = BooleanProperty.;

    public DehydratorBlock(Settings settings) {
        super(settings);
//        this.setDefaultState(this.stateManager.getDefaultState().with(, Direction.NORTH).with(ON, false));
}

//    @Override
//    protected MapCodec<? extends BlockWithEntity> getCodec() {
//        return createCodec(DehydratorBlock::new);
//    }

//    @Override
//    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
//        return new DehydratorBlockEntity(pos, state);
//    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
//            if (blockEntity instanceof DehydratorBlockEntity) {
//                ItemScatterer.spawn(world, pos, (DehydratorBlockEntity) blockEntity);
//                world.updateComparators(pos, this);
//            }
        }
        super.onStateReplaced(state, world, pos, newState, moved);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient()) {
//            NamedScreenHandlerFactory screenHandlerFactory = ((DehydratorBlockEntity) world.getBlockEntity(pos));
//            if (screenHandlerFactory != null) {
//                player.openHandledScreen(screenHandlerFactory);
//            }
        }
        return ActionResult.SUCCESS;
    }

//    @Override
//    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
//        return validateTicker(type, ModBlockEntities.DEHYDRATOR_BLOCK_ENTITY, (world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1));
//    }
}
