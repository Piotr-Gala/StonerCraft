package com.stonercraft.stonercraft.client;

import com.stonercraft.stonercraft.ModBlocks;
import com.stonercraft.stonercraft.ModItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod.EventBusSubscriber(modid = "stonercraft", bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvent {
    public static void onClientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.GROW_POT.get(), RenderType.cutout());
        });
    }
    @SubscribeEvent
    public static void registerItemProperties(FMLClientSetupEvent event) {
        ItemProperties.register(ModItems.JOINT_LEMON_HAZE.get(), new ResourceLocation("stonercraft", "lit"), (stack, level, entity, seed) -> {
                    return (stack.hasTag() && stack.getTag().getBoolean("lit")) ? 1.0F : 0.0F;
        });

        ItemProperties.register(ModItems.JOINT_PURPLE_HAZE.get(), new ResourceLocation("stonercraft", "lit"), (s, l, e, seed) -> {
            return (s.hasTag() && s.getTag().getBoolean("lit")) ? 1.0F : 0.0F;
        });

        ItemProperties.register(ModItems.JOINT_AFGHAN_KUSH.get(), new ResourceLocation("stonercraft", "lit"), (s, l, e, seed) -> {
            return (s.hasTag() && s.getTag().getBoolean("lit")) ? 1.0F : 0.0F;
        });

        ItemProperties.register(ModItems.JOINT_WHITE_WIDOW.get(), new ResourceLocation("stonercraft", "lit"), (s, l, e, seed) -> {
            return (s.hasTag() && s.getTag().getBoolean("lit")) ? 1.0F : 0.0F;
        });
    }

}
