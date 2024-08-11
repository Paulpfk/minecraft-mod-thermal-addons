package com.cata5trophe.thermaladdons.registration;

import com.cata5trophe.thermaladdons.ThermalAddonsMod;
import com.cata5trophe.thermaladdons.items.WorldHeaterItem;
import com.cata5trophe.thermaladdons.tab.ThermalAddonsCreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistration {
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ThermalAddonsMod.MOD_ID);

    public static final RegistryObject<Item> WORLD_HEATER = ITEMS.register(WorldHeaterItem.NAME, () -> new WorldHeaterItem(ThermalAddonsCreativeModeTab.THERMAL_ADDONS_TAB));
}
