package com.stonercraft.stonercraft.items;

import com.stonercraft.stonercraft.util.StrainType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;

import java.util.List;

public class JointItem extends Item {
    private static final int MAX_BURN_TIME = 1200;
    private static final int PUFF_BURN_COST = 150;
    private static final int MAX_PUFFS = 8;

    private final StrainType strain;

    public JointItem(StrainType strain, Properties properties) {
        super(properties);
        this.strain = strain;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack joint = player.getItemInHand(hand);
        CompoundTag data = getOrCreateData(joint);

        if (!data.getBoolean("lit")) {
            InteractionHand lighterHand = getOtherHand(hand);
            ItemStack lighter = player.getItemInHand(lighterHand);
            if (lighter.is(Items.FLINT_AND_STEEL)) {
                data.putBoolean("lit", true);
                data.putInt("burnTime", MAX_BURN_TIME);
                data.putInt("puffsUsed", 0);
                setData(joint, data);

                lighter.hurtAndBreak(1, player, LivingEntity.getSlotForHand(lighterHand));
                level.playSound(null, player.blockPosition(), SoundEvents.FLINTANDSTEEL_USE,
                        player.getSoundSource(), 1.0F, 1.0F);

                return InteractionResultHolder.success(joint);
            }

            return InteractionResultHolder.fail(joint);
        }

        player.startUsingItem(hand);
        return InteractionResultHolder.consume(joint);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (!(entity instanceof Player player)) {
            return stack;
        }

        CompoundTag data = getOrCreateData(stack);
        int burnTime = data.getInt("burnTime");
        int puffsUsed = data.getInt("puffsUsed");

        if (burnTime >= PUFF_BURN_COST && puffsUsed < MAX_PUFFS) {
            data.putInt("burnTime", burnTime - PUFF_BURN_COST);
            data.putInt("puffsUsed", puffsUsed + 1);
            setData(stack, data);

            switch (strain.getPlantGen()) {
                case INDICA -> player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200));
                case SATIVA -> player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1));
                case HYBRID -> player.addEffect(new MobEffectInstance(MobEffects.JUMP, 200, 1));
                case RARE -> player.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 100));
            }

            if (puffsUsed + 1 >= MAX_PUFFS) {
                stack.shrink(1);
            }
        }

        return stack;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean selected) {
        CompoundTag data = getData(stack);
        if (!level.isClientSide && data.getBoolean("lit") && level.getGameTime() % 50 == 0) {
            int burnTime = data.getInt("burnTime");
            int newBurnTime = burnTime - 50;

            if (newBurnTime <= 0) {
                stack.shrink(1);
            } else {
                data.putInt("burnTime", newBurnTime);
                setData(stack, data);
            }
        }
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        return getData(stack).getBoolean("lit");
    }

    @Override
    public int getBarWidth(ItemStack stack) {
        return Math.round(13.0F * getData(stack).getInt("burnTime") / MAX_BURN_TIME);
    }

    @Override
    public int getBarColor(ItemStack stack) {
        return 0x00ff00;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 20;
    }

    @Override
    public Component getName(ItemStack stack) {
        return Component.literal(strain.getId().replace("_", " ") + " Joint");
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.literal("Strain: " + strain.getId()));
        tooltip.add(Component.literal("Type: " + strain.getPlantGen().name()));
    }

    public StrainType getStrainType() {
        return strain;
    }

    private static CompoundTag getData(ItemStack stack) {
        CustomData customData = stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        return customData.copyTag();
    }

    private static CompoundTag getOrCreateData(ItemStack stack) {
        return getData(stack);
    }

    private static void setData(ItemStack stack, CompoundTag data) {
        stack.set(DataComponents.CUSTOM_DATA, CustomData.of(data));
    }

    private static InteractionHand getOtherHand(InteractionHand hand) {
        return hand == InteractionHand.MAIN_HAND ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND;
    }
}
