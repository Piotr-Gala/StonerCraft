package com.stonercraft.stonercraft.client;

import com.stonercraft.stonercraft.ModItems;
import com.stonercraft.stonercraft.StonerCraft;
import com.stonercraft.stonercraft.items.JointItem;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = StonerCraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {
    private static final ResourceLocation LIT_PROPERTY = ResourceLocation.fromNamespaceAndPath(StonerCraft.MODID, "lit");

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            registerLitProperty(ModItems.JOINT_LEMON_HAZE);
            registerLitProperty(ModItems.JOINT_AFGHAN_KUSH);
            registerLitProperty(ModItems.JOINT_PURPLE_HAZE);
            registerLitProperty(ModItems.JOINT_WHITE_WIDOW);
        });
    }

    private static void registerLitProperty(RegistryObject<Item> item) {
        ItemProperties.register(item.get(), LIT_PROPERTY,
                (stack, level, entity, seed) -> JointItem.isLit(stack) ? 1.0F : 0.0F);
    }
}
