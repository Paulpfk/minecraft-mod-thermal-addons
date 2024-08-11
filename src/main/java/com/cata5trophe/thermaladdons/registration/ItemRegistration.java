package com.cata5trophe.thermaladdons.registration;

import com.cata5trophe.thermaladdons.ThermalAddonsMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistration {
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ThermalAddonsMod.MOD_ID);
}
