package com.stonercraft.stonercraft;

import com.stonercraft.stonercraft.blocks.GrowPotBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, StonerCraft.MODID);

    public static final RegistryObject<Block> GROW_POT = BLOCKS.register("grow_pot", GrowPotBlock::new);

    public static final RegistryObject<Item> GROW_POT_ITEM = ModItems.ITEMS.register("grow_pot",
            () -> new BlockItem(GROW_POT.get(), new Item.Properties()));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
