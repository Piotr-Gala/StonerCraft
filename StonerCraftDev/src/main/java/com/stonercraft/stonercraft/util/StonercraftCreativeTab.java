package com.stonercraft.stonercraft.util;

import com.stonercraft.stonercraft.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class StonercraftCreativeTab {
    public static final CreativeModeTab STONERCRAFT_TAB = new CreativeModeTab("stonercraft_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.JOINT_LEMON_HAZE.get()); // możesz zmienić na co chcesz
        }
    };
}
