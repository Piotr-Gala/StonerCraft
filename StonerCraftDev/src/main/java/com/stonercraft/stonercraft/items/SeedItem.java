package com.stonercraft.stonercraft.items;

import com.stonercraft.stonercraft.util.StrainType;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
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
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        ChatFormatting color;
        switch (strainType.getPlantGen()) {
            case INDICA -> color = ChatFormatting.DARK_PURPLE;
            case SATIVA -> color = ChatFormatting.GREEN;
            case HYBRID -> color = ChatFormatting.AQUA;
            case RARE -> color = ChatFormatting.LIGHT_PURPLE;
            default -> color = ChatFormatting.GRAY;
        }

        tooltip.add(new TextComponent("Type: " + strainType.getPlantGen().name()).withStyle(color));
        tooltip.add(new TextComponent("Preferred biome: " + strainType.getPreferredBiome()).withStyle(ChatFormatting.GRAY));
    }
}
