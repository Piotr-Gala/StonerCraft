package com.stonercraft.stonercraft.items;

import com.stonercraft.stonercraft.util.StrainType;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class BudItem extends Item {
    private final StrainType strain;

    public BudItem(StrainType strain, Properties properties) {
        super(properties);
        this.strain = strain;
    }

    public StrainType getStrainType() {
        return strain;
    }

    @Override
    public String getDescriptionId(ItemStack stack) {
        return "item.stonercraft." + strain.getId() + "_bud";
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.literal("Strain: " + strain.getId()));
        tooltip.add(Component.literal("Type: " + strain.getPlantGen().name()));
    }
}
