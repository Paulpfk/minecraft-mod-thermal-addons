package com.cata5trophe.thermaladdons.blocks;

import com.cata5trophe.thermaladdons.blockentities.SnowDestroyerBlockEntity;
import com.cata5trophe.thermaladdons.registration.BlockEntityRegistration;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class SnowDestroyerBlock extends BaseEntityBlock implements EntityBlock {

    public static final String NAME = "snow_destroyer_block";

    public static final BooleanProperty ENABLED = BooleanProperty.create("enabled");

    public SnowDestroyerBlock() {
        super(BlockBehaviour.Properties
                .of(Material.HEAVY_METAL)
                .strength(6f)
                .lightLevel(state -> state.getValue(SnowDestroyerBlock.ENABLED) ? 15 : 0)
                .sound(SoundType.METAL)
                .requiresCorrectToolForDrops());
        this.registerDefaultState(this.stateDefinition.any().setValue(ENABLED, false));
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {

        if (interactionHand == InteractionHand.MAIN_HAND && !level.isClientSide()) {

            if (!blockState.getValue(ENABLED)) {
                level.setBlock(blockPos, blockState.setValue(ENABLED, true), 3);
                player.sendSystemMessage(Component.literal("Snow Destroyer turned on."));


            } else {
                level.setBlock(blockPos, blockState.setValue(ENABLED, false), 3);
                player.sendSystemMessage(Component.literal("Snow Destroyer turned off."));
            }
        }

        return super.use(blockState, level, blockPos, player, interactionHand, blockHitResult);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(ENABLED);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return BlockEntityRegistration.SNOW_DESTROYER_BLOCK_ENTITY.get().create(blockPos, blockState);
    }

    @Override
    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.MODEL;
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> type) {
        return createTickerHelper(type, BlockEntityRegistration.SNOW_DESTROYER_BLOCK_ENTITY.get(), SnowDestroyerBlockEntity::tick);
    }
}
