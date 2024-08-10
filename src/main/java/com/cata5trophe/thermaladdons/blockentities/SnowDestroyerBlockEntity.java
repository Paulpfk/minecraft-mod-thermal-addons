package com.cata5trophe.thermaladdons.blockentities;

import com.cata5trophe.thermaladdons.registration.BlockEntityRegistration;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import static com.cata5trophe.thermaladdons.blocks.SnowDestroyerBlock.ENABLED;

public class SnowDestroyerBlockEntity extends BlockEntity {

    public static final String NAME = "snow_destroyer_block_entity";

    public SnowDestroyerBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(BlockEntityRegistration.SNOW_DESTROYER_BLOCK_ENTITY.get(), blockPos, blockState);
    }

    public static void tick(Level level, BlockPos blockPos, BlockState blockState, SnowDestroyerBlockEntity snowDestroyerBlockEntity) {

        if (blockState.getValue(ENABLED) && !level.isClientSide()) {
            int radius = 20;

            BlockPos positiveRadiusPosition = blockPos.offset(radius, radius, radius);
            BlockPos negativeRadiusPosition = blockPos.offset(-1 * radius, -1 * radius, -1 * radius);

            Iterable<BlockPos> cubeResult = BlockPos.betweenClosed(positiveRadiusPosition, negativeRadiusPosition);
            MutableComponent snowName = Blocks.SNOW.getName();
            MutableComponent snowBlockName = Blocks.SNOW_BLOCK.getName();
            MutableComponent powderSnowName = Blocks.POWDER_SNOW.getName();

            for (BlockPos pos : cubeResult) {
                MutableComponent blockForCheckName = level.getBlockState(pos).getBlock().getName();
                if (blockForCheckName.equals(snowName) || blockForCheckName.equals(snowBlockName) || blockForCheckName.equals(powderSnowName)) {
                    level.destroyBlock(pos, false);
                }
            }
        }
    }
}
