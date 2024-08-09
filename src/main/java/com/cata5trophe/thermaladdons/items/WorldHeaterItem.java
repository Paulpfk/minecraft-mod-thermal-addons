package com.cata5trophe.thermaladdons.items;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public class WorldHeaterItem extends Item {

    public static final String NAME = "world_heater";

    public WorldHeaterItem(CreativeModeTab tab) {
        super(new Properties()
                .tab(tab)
                .fireResistant()
                .stacksTo(16));
    }
}