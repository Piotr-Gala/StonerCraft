package com.stonercraft.stonercraft;

import com.stonercraft.stonercraft.items.BudItem;
import com.stonercraft.stonercraft.items.JointItem;
import com.stonercraft.stonercraft.items.PreloadedJointItem;
import com.stonercraft.stonercraft.util.StonercraftCreativeTab;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.stonercraft.stonercraft.items.SeedItem;
import com.stonercraft.stonercraft.util.StrainType;


@Mod.EventBusSubscriber(modid = StonerCraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, StonerCraft.MODID);

//JOINTS

    public static final RegistryObject<Item> JOINT_LEMON_HAZE = ITEMS.register("joint_lemon_haze",
            () -> new JointItem(StrainType.LEMON_HAZE, new Item.Properties().stacksTo(1).tab(StonercraftCreativeTab.STONERCRAFT_TAB)));

    public static final RegistryObject<Item> JOINT_AFGHAN_KUSH = ITEMS.register("joint_afghan_kush",
            () -> new JointItem(StrainType.AFGHAN_KUSH, new Item.Properties().stacksTo(1).tab(StonercraftCreativeTab.STONERCRAFT_TAB)));

    public static final RegistryObject<Item> JOINT_PURPLE_HAZE = ITEMS.register("joint_purple_haze",
            () -> new JointItem(StrainType.PURPLE_HAZE, new Item.Properties().stacksTo(1).tab(StonercraftCreativeTab.STONERCRAFT_TAB)));

    public static final RegistryObject<Item> JOINT_WHITE_WIDOW = ITEMS.register("joint_white_widow",
            () -> new JointItem(StrainType.WHITE_WIDOW, new Item.Properties().stacksTo(1).tab(StonercraftCreativeTab.STONERCRAFT_TAB)));

//SEEDS

    public static final RegistryObject<Item> LEMON_HAZE_SEED = ITEMS.register("lemon_haze_seed",
            () -> new SeedItem(StrainType.LEMON_HAZE, new Item.Properties().tab(StonercraftCreativeTab.STONERCRAFT_TAB)));

    public static final RegistryObject<Item> AFGHAN_KUSH_SEED = ITEMS.register("afghan_kush_seed",
            () -> new SeedItem(StrainType.AFGHAN_KUSH, new Item.Properties().tab(StonercraftCreativeTab.STONERCRAFT_TAB)));

    public static final RegistryObject<Item> PURPLE_HAZE_SEED = ITEMS.register("purple_haze_seed",
            () -> new SeedItem(StrainType.PURPLE_HAZE, new Item.Properties().tab(StonercraftCreativeTab.STONERCRAFT_TAB)));

    public static final RegistryObject<Item> WHITE_WIDOW_SEED = ITEMS.register("white_widow_seed",
            () -> new SeedItem(StrainType.WHITE_WIDOW, new Item.Properties().tab(StonercraftCreativeTab.STONERCRAFT_TAB)));

//BUDS

    public static final RegistryObject<Item> LEMON_HAZE_BUD = ITEMS.register("lemon_haze_bud",
            () -> new BudItem(StrainType.LEMON_HAZE, new Item.Properties().tab(StonercraftCreativeTab.STONERCRAFT_TAB)));

    public static final RegistryObject<Item> AFGHAN_KUSH_BUD = ITEMS.register("afghan_kush_bud",
            () -> new BudItem(StrainType.AFGHAN_KUSH, new Item.Properties().tab(StonercraftCreativeTab.STONERCRAFT_TAB)));

    public static final RegistryObject<Item> PURPLE_HAZE_BUD = ITEMS.register("purple_haze_bud",
            () -> new BudItem(StrainType.PURPLE_HAZE, new Item.Properties().tab(StonercraftCreativeTab.STONERCRAFT_TAB)));

    public static final RegistryObject<Item> WHITE_WIDOW_BUD = ITEMS.register("white_widow_bud",
            () -> new BudItem(StrainType.WHITE_WIDOW, new Item.Properties().tab(StonercraftCreativeTab.STONERCRAFT_TAB)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
