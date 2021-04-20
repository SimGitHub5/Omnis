package com.sammy.omnis.common.items.gear;

import com.sammy.omnis.common.items.IComboItem;
import com.sammy.omnis.common.items.ModPickaxeItem;
import com.sammy.omnis.core.init.effects.OmnisEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;

public class ModHammerItem extends ModPickaxeItem implements IComboItem
{
    public final int staggeredAmplifier;
    public ModHammerItem(IItemTier material, int damage, float speed, int staggeredAmplifier, Properties properties)
    {
        super(material, damage, speed, properties);
        this.staggeredAmplifier = staggeredAmplifier;
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        increaseCombo(attacker, target);
        return super.hitEntity(stack, target, attacker);
    }

    @Override
    public int maxCombo(LivingEntity attacker, LivingEntity target)
    {
        return 3;
    }

    @Override
    public void triggerCombo(LivingEntity attacker, LivingEntity target)
    {
        target.addPotionEffect(new EffectInstance(OmnisEffects.STAGGERED.get(), 100, staggeredAmplifier));
    }
}
