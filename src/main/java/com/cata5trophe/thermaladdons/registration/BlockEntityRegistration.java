package com.cata5trophe.thermaladdons.registration;

import com.cata5trophe.thermaladdons.ThermalAddonsMod;
import com.cata5trophe.thermaladdons.blockentities.SnowDestroyerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityRegistration {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ThermalAddonsMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<SnowDestroyerBlockEntity>> SNOW_DESTROYER_BLOCK_ENTITY = BLOCK_ENTITIES.register(SnowDestroyerBlockEntity.NAME, () -> BlockEntityType.Builder.of(SnowDestroyerBlockEntity::new, BlockRegistration.SNOW_DESTROYER_BLOCK.get()).build(null));
}
