package com.stonercraft.stonercraft;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, StonerCraft.MODID);

    public static final RegistryObject<CreativeModeTab> STONERCRAFT_TAB = CREATIVE_TABS.register("stonercraft_tab",
            () -> CreativeModeTab.builder()
                    .withTabsBefore(CreativeModeTabs.FOOD_AND_DRINKS)
                    .title(Component.translatable("itemGroup.stonercraft_tab"))
                    .icon(() -> ModItems.JOINT_LEMON_HAZE.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.GROW_POT_ITEM.get());
                        output.accept(ModItems.LEMON_HAZE_SEED.get());
                        output.accept(ModItems.AFGHAN_KUSH_SEED.get());
                        output.accept(ModItems.PURPLE_HAZE_SEED.get());
                        output.accept(ModItems.WHITE_WIDOW_SEED.get());
                        output.accept(ModItems.LEMON_HAZE_BUD.get());
                        output.accept(ModItems.AFGHAN_KUSH_BUD.get());
                        output.accept(ModItems.PURPLE_HAZE_BUD.get());
                        output.accept(ModItems.WHITE_WIDOW_BUD.get());
                        output.accept(ModItems.JOINT_LEMON_HAZE.get());
                        output.accept(ModItems.JOINT_AFGHAN_KUSH.get());
                        output.accept(ModItems.JOINT_PURPLE_HAZE.get());
                        output.accept(ModItems.JOINT_WHITE_WIDOW.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_TABS.register(eventBus);
    }
}
