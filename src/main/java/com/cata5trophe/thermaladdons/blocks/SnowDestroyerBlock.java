package com.cata5trophe.thermaladdons.blocks;


import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;

public class SnowDestroyerBlock extends Block {

    public static final String NAME = "snow_destroyer_block";

    public static final BooleanProperty ENABLED = BooleanProperty.create("enabled");

    public SnowDestroyerBlock() {
        super(BlockBehaviour.Properties.of(Material.HEAVY_METAL)
                .strength(6f)
                .lightLevel(state -> state.getValue(SnowDestroyerBlock.ENABLED) ? 15 : 0)
                .sound(SoundType.METAL)
                .requiresCorrectToolForDrops()
        );
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {

        if (interactionHand == InteractionHand.MAIN_HAND && !level.isClientSide()) {

            if (!blockState.getValue(ENABLED)) {
                level.setBlock(blockPos, blockState.setValue(ENABLED, true), 3);
                player.sendSystemMessage(Component.literal("Snow Destroyer turned on."));

                int radius = 20;

                BlockPos positiveRadiusPosition = blockPos.offset(radius, radius, radius);
                BlockPos negativeRadiusPosition = blockPos.offset(-1 * radius, -1 * radius, -1 * radius);

                Iterable<BlockPos> cubeResult = BlockPos.betweenClosed(positiveRadiusPosition, negativeRadiusPosition);

                for (BlockPos pos : cubeResult) {
                    MutableComponent blockForCheckName = level.getBlockState(pos).getBlock().getName();
                    if (blockForCheckName.equals(Blocks.SNOW.getName()) || blockForCheckName.equals(Blocks.SNOW_BLOCK.getName()) || blockForCheckName.equals(Blocks.POWDER_SNOW.getName())) {
                        level.destroyBlock(pos, false);
                    }
                }

            } else {
                level.setBlock(blockPos, blockState.setValue(ENABLED, false), 3);
                player.sendSystemMessage(Component.literal("Snow Destroyer turned off."));
            }
        }

        return super.

                use(blockState, level, blockPos, player, interactionHand, blockHitResult);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(ENABLED);
    }
}
