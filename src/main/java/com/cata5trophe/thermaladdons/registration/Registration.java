package com.cata5trophe.thermaladdons.registration;

import net.minecraftforge.eventbus.api.IEventBus;

import static com.cata5trophe.thermaladdons.registration.BlockEntityRegistration.BLOCK_ENTITIES;
import static com.cata5trophe.thermaladdons.registration.BlockRegistration.BLOCKS;
import static com.cata5trophe.thermaladdons.registration.ItemRegistration.ITEMS;

public class Registration {

    public static void registerAll(IEventBus modEventbus) {
        ITEMS.register(modEventbus);
        BLOCKS.register(modEventbus);
        BLOCK_ENTITIES.register(modEventbus);
    }
}

