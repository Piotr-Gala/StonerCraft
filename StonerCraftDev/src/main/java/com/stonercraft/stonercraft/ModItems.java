package com.stonercraft.stonercraft;

import com.stonercraft.stonercraft.items.BudItem;
import com.stonercraft.stonercraft.items.JointItem;
import com.stonercraft.stonercraft.items.SeedItem;
import com.stonercraft.stonercraft.util.StrainType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.EnumMap;
import java.util.Map;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, StonerCraft.MODID);

    private static final Map<StrainType, RegistryObject<Item>> SEEDS = new EnumMap<>(StrainType.class);
    private static final Map<StrainType, RegistryObject<Item>> BUDS = new EnumMap<>(StrainType.class);
    private static final Map<StrainType, RegistryObject<Item>> JOINTS = new EnumMap<>(StrainType.class);

    public static final RegistryObject<Item> JOINT_LEMON_HAZE = registerJoint(StrainType.LEMON_HAZE);
    public static final RegistryObject<Item> JOINT_AFGHAN_KUSH = registerJoint(StrainType.AFGHAN_KUSH);
    public static final RegistryObject<Item> JOINT_PURPLE_HAZE = registerJoint(StrainType.PURPLE_HAZE);
    public static final RegistryObject<Item> JOINT_WHITE_WIDOW = registerJoint(StrainType.WHITE_WIDOW);

    public static final RegistryObject<Item> LEMON_HAZE_SEED = registerSeed(StrainType.LEMON_HAZE);
    public static final RegistryObject<Item> AFGHAN_KUSH_SEED = registerSeed(StrainType.AFGHAN_KUSH);
    public static final RegistryObject<Item> PURPLE_HAZE_SEED = registerSeed(StrainType.PURPLE_HAZE);
    public static final RegistryObject<Item> WHITE_WIDOW_SEED = registerSeed(StrainType.WHITE_WIDOW);

    public static final RegistryObject<Item> LEMON_HAZE_BUD = registerBud(StrainType.LEMON_HAZE);
    public static final RegistryObject<Item> AFGHAN_KUSH_BUD = registerBud(StrainType.AFGHAN_KUSH);
    public static final RegistryObject<Item> PURPLE_HAZE_BUD = registerBud(StrainType.PURPLE_HAZE);
    public static final RegistryObject<Item> WHITE_WIDOW_BUD = registerBud(StrainType.WHITE_WIDOW);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static Item getSeedForStrain(StrainType strainType) {
        return getItemForStrain(SEEDS, strainType);
    }

    public static Item getBudForStrain(StrainType strainType) {
        return getItemForStrain(BUDS, strainType);
    }

    public static Item getJointForStrain(StrainType strainType) {
        return getItemForStrain(JOINTS, strainType);
    }

    private static RegistryObject<Item> registerSeed(StrainType strainType) {
        RegistryObject<Item> item = ITEMS.register(strainType.getSeedItemId(),
                () -> new SeedItem(strainType, new Item.Properties()));
        SEEDS.put(strainType, item);
        return item;
    }

    private static RegistryObject<Item> registerBud(StrainType strainType) {
        RegistryObject<Item> item = ITEMS.register(strainType.getBudItemId(),
                () -> new BudItem(strainType, new Item.Properties()));
        BUDS.put(strainType, item);
        return item;
    }

    private static RegistryObject<Item> registerJoint(StrainType strainType) {
        RegistryObject<Item> item = ITEMS.register(strainType.getJointItemId(),
                () -> new JointItem(strainType, new Item.Properties().stacksTo(1)));
        JOINTS.put(strainType, item);
        return item;
    }

    private static Item getItemForStrain(Map<StrainType, RegistryObject<Item>> items, StrainType strainType) {
        RegistryObject<Item> item = items.get(strainType);
        return item != null ? item.get() : Items.AIR;
    }
}
