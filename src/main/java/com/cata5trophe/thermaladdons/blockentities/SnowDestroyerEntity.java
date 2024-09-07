package com.cata5trophe.thermaladdons.blockentities;

import com.cata5trophe.thermaladdons.registration.BlockEntityRegistration;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import static com.cata5trophe.thermaladdons.blocks.SnowDestroyer.ENABLED;

public class SnowDestroyerEntity extends BlockEntity {

    public static final String NAME = "snow_destroyer_entity";

    public SnowDestroyerEntity(BlockPos blockPos, BlockState blockState) {
        super(BlockEntityRegistration.SNOW_DESTROYER_ENTITY.get(), blockPos, blockState);
    }

    public static void tick(Level level, BlockPos blockPos, BlockState blockState, SnowDestroyerEntity snowDestroyerEntity) {

        if (blockState.getValue(ENABLED) && !level.isClientSide()) {
            int radius = 20;

            BlockPos positiveRadiusPosition = blockPos.offset(radius, radius, radius);
            BlockPos negativeRadiusPosition = blockPos.offset(-1 * radius, -1 * radius, -1 * radius);

            Iterable<BlockPos> cubeResult = BlockPos.betweenClosed(positiveRadiusPosition, negativeRadiusPosition);
            Block snowLayer = Blocks.SNOW;
            Block snowBlock = Blocks.SNOW_BLOCK;
            Block powderSnow = Blocks.POWDER_SNOW;

            for (BlockPos pos : cubeResult) {
                Block blockForCheckName = level.getBlockState(pos).getBlock();
                if (blockForCheckName.equals(snowLayer) || blockForCheckName.equals(snowBlock) || blockForCheckName.equals(powderSnow)) {
                    level.destroyBlock(pos, false);
                }
            }
        }
    }
}
