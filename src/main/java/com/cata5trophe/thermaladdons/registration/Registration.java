package com.cata5trophe.thermaladdons.registration;

import net.minecraftforge.eventbus.api.IEventBus;

import static com.cata5trophe.thermaladdons.registration.ModBlockRegistration.BLOCKS;
import static com.cata5trophe.thermaladdons.registration.ModItemRegistration.ITEMS;

public class Registration {

    public static void registerAll(IEventBus modEventbus) {
        registerItems(modEventbus);
        registerBlocks(modEventbus);
    }

    private static void registerItems(IEventBus modEventbus) {
        ITEMS.register(modEventbus);
    }

    private static void registerBlocks(IEventBus modEventbus) {
        BLOCKS.register(modEventbus);
    }
}
