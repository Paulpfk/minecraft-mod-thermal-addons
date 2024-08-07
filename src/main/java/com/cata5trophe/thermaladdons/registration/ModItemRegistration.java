package com.cata5trophe.thermaladdons.registration;

import com.cata5trophe.thermaladdons.ThermalAddonsMod;
import com.cata5trophe.thermaladdons.tab.ModCreativeModeTab;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemRegistration {
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ThermalAddonsMod.MOD_ID);


    public static RegistryObject<Item> registerItem(String name, Item.Properties properties, CreativeModeTab tab) {
        return ModItemRegistration.ITEMS.register(name, () -> new Item(properties.tab(tab)));
    }


    public static String name = "world_heater";
    public static CreativeModeTab tab = ModCreativeModeTab.THERMAL_ADDONS_TAB;
    public static Item.Properties properties = new Item.Properties()
            .fireResistant()
            .stacksTo(16);

    public static final RegistryObject<Item> WORLD_HEATER = registerItem(name, properties, tab);

}