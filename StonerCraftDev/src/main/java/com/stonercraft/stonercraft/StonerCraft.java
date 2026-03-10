package com.stonercraft.stonercraft;

import com.stonercraft.stonercraft.client.ClientModEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;




@Mod(StonerCraft.MODID)
public class StonerCraft {
    public static final String MODID = "stonercraft";

    public StonerCraft() {
        ModItems.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModBlocks.register(FMLJavaModLoadingContext.get().getModEventBus());
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientModEvent::onClientSetup);
    }


}
