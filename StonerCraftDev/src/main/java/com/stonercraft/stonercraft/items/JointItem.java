package com.stonercraft.stonercraft.items;

import com.stonercraft.stonercraft.util.StrainType;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class JointItem extends Item {

    private final StrainType strain;

    public JointItem(StrainType strain, Properties properties) {
        super(properties);
        this.strain = strain;

    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack joint = player.getItemInHand(hand);

        if (!joint.hasTag()) joint.getOrCreateTag();

        boolean lit = joint.getTag().getBoolean("lit");

        if (!lit) {
            // odpalanie jointa zapalniczką
            ItemStack off = player.getOffhandItem();
            if (off.getItem() == Items.FLINT_AND_STEEL) {
                joint.getTag().putBoolean("lit", true);
                joint.getTag().putInt("burnTime", 1200);
                joint.getTag().putInt("puffsUsed", 0);

                off.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(InteractionHand.OFF_HAND));
                player.level.playSound(null, player.blockPosition(), SoundEvents.FLINTANDSTEEL_USE,
                        player.getSoundSource(), 1.0F, 1.0F);

                return InteractionResultHolder.success(joint);
            }
            return InteractionResultHolder.fail(joint);
        } else {
            player.startUsingItem(hand); // naciąganie jak łuk
            return InteractionResultHolder.consume(joint);
        }
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (!(entity instanceof Player player)) return stack;
        if (!stack.hasTag()) return stack;

        int burnTime = stack.getTag().getInt("burnTime");
        int puffsUsed = stack.getTag().getInt("puffsUsed");

        if (burnTime >= 150 && puffsUsed < 8) {
            stack.getTag().putInt("burnTime", burnTime - 150);
            stack.getTag().putInt("puffsUsed", puffsUsed + 1);

            switch (strain.getPlantGen()) {
                case INDICA -> player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200));
                case SATIVA -> player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1));
                case HYBRID -> player.addEffect(new MobEffectInstance(MobEffects.JUMP, 200, 1));
                case RARE -> player.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 100));
            }

            if (puffsUsed + 1 >= 8) stack.shrink(1);
        }

        return stack;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean selected) {
        if (!level.isClientSide && stack.hasTag() && stack.getTag().getBoolean("lit")) {
            int burnTime = stack.getTag().getInt("burnTime");

            // zmniejszamy tylko raz na 10 ticków
            if (level.getGameTime() % 50 == 0) {
                int newBurnTime = burnTime - 50;
                if (newBurnTime <= 0) {
                    stack.shrink(1); // joint skończony
                } else {
                    stack.getTag().putInt("burnTime", newBurnTime);
                }
            }
        }
    }



    @Override
    public boolean isBarVisible(ItemStack stack) {
        return stack.hasTag() && stack.getTag().getBoolean("lit");
    }

    @Override
    public int getBarWidth(ItemStack stack) {
        if (!stack.hasTag()) return 0;
        return Math.round(13.0f * stack.getTag().getInt("burnTime") / 1200.0f);
    }

    @Override
    public int getBarColor(ItemStack stack) {
        return 0x00ff00;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW; // naciąganie jak łuk
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 20; // ok. 1 sekundy naciągania
    }

    @Override
    public Component getName(ItemStack stack) {
        return new TextComponent(strain.getId().replace("_", " ") + " Joint");
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(new TextComponent("Strain: " + strain.getId()));
        tooltip.add(new TextComponent("Type: " + strain.getPlantGen().name()));
    }

    public StrainType getStrainType() {
        return strain;
    }
}
