package com.stonercraft.stonercraft.items;

import com.stonercraft.stonercraft.util.StrainType;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
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
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(new TextComponent("Strain: " + strain.getId()));
        tooltip.add(new TextComponent("Type: " + strain.getPlantGen().name()));
    }
}
