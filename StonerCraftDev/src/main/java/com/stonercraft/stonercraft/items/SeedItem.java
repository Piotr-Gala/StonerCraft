package com.stonercraft.stonercraft.items;

import com.stonercraft.stonercraft.util.StrainType;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class SeedItem extends Item {
    private final StrainType strainType;

    public SeedItem(StrainType strainType, Properties properties) {
        super(properties);
        this.strainType = strainType;
    }

    public StrainType getStrainType() {
        return strainType;
    }

    @Override
    public String getDescriptionId(ItemStack stack) {
        return "item.stonercraft." + strainType.getId() + "_seed";
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        ChatFormatting color = switch (strainType.getPlantGen()) {
            case INDICA -> ChatFormatting.DARK_PURPLE;
            case SATIVA -> ChatFormatting.GREEN;
            case HYBRID -> ChatFormatting.AQUA;
            case RARE -> ChatFormatting.LIGHT_PURPLE;
        };

        tooltip.add(Component.literal("Type: " + strainType.getPlantGen().name()).withStyle(color));
        tooltip.add(Component.literal("Preferred biome: " + strainType.getPreferredBiome()).withStyle(ChatFormatting.GRAY));
    }
}
