package com.stonercraft.stonercraft.items;

import com.stonercraft.stonercraft.ModItems;
import com.stonercraft.stonercraft.util.StrainType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class PreloadedJointItem extends Item {

    private final StrainType strain;

    public PreloadedJointItem(StrainType strain, Properties properties) {
        super(properties);
        this.strain = strain;
    }

    @Override
    public ItemStack getDefaultInstance() {
        ItemStack stack = new ItemStack(ModItems.JOINT_LEMON_HAZE.get());
        stack.getOrCreateTag().putString("strain", strain.getId());
        return stack;
    }
}
