package com.cata5trophe.thermaladdons.tab;

import com.cata5trophe.thermaladdons.registration.ModItemRegistration;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ModCreativeModeTab {
    public static final CreativeModeTab THERMAL_ADDONS_TAB = new CreativeModeTab("thermaladdonstab") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(ModItemRegistration.WORLD_HEATER.get());
        }
    };
}
