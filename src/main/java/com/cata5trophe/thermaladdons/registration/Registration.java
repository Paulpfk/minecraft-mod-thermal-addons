package com.cata5trophe.thermaladdons.registration;

import net.minecraftforge.eventbus.api.IEventBus;

import static com.cata5trophe.thermaladdons.registration.BlockEntityRegistration.BLOCK_ENTITIES;
import static com.cata5trophe.thermaladdons.registration.BlockRegistration.BLOCKS;
import static com.cata5trophe.thermaladdons.registration.ItemRegistration.ITEMS;

public class Registration {

    public static void registerAll(IEventBus modEventbus) {
        registerItems(modEventbus);
        registerBlocks(modEventbus);
        registerBlockEntities(modEventbus);
    }

    private static void registerItems(IEventBus modEventbus) {
        ITEMS.register(modEventbus);
    }

    private static void registerBlocks(IEventBus modEventbus) {
        BLOCKS.register(modEventbus);
    }

    private static void registerBlockEntities(IEventBus modEventbus) {
        BLOCK_ENTITIES.register(modEventbus);
    }
}

