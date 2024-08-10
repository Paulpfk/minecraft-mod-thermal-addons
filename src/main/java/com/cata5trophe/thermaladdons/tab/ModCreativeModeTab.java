package com.cata5trophe.thermaladdons.tab;

import com.cata5trophe.thermaladdons.registration.ItemRegistration;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ModCreativeModeTab {
    public static final CreativeModeTab THERMAL_ADDONS_TAB = new CreativeModeTab("thermaladdonstab") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(ItemRegistration.WORLD_HEATER.get());
        }
    };
}
