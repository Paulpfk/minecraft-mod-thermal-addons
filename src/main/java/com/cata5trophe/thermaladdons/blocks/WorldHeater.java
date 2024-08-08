package com.cata5trophe.thermaladdons.blocks;


import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class WorldHeater extends Block {
    public WorldHeater() {

        super(
                BlockBehaviour.Properties.of(Material.HEAVY_METAL)
                        .strength(10f)
                        .lightLevel((p_60954_) -> 15)
                        .sound(SoundType.METAL)
                        .requiresCorrectToolForDrops()
        );
    }
}
