package com.cata5trophe.thermaladdons.registration;

import com.cata5trophe.thermaladdons.ThermalAddonsMod;
import com.cata5trophe.thermaladdons.blocks.WorldHeaterBlock;
import com.cata5trophe.thermaladdons.tab.ModCreativeModeTab;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


public class ModBlockRegistration {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ThermalAddonsMod.MOD_ID);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> registryObject = BLOCKS.register(name, block);
        registerBlockItem(name, registryObject, tab);

        return registryObject;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, Supplier<T> block, CreativeModeTab tab) {

        return ModItemRegistration.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static final RegistryObject<Block> WORLD_HEATER_BLOCK = ModBlockRegistration.registerBlock(WorldHeaterBlock.NAME,
            WorldHeaterBlock::new,
            ModCreativeModeTab.THERMAL_ADDONS_TAB);
}
