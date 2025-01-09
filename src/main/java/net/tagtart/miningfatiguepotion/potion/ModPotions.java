package net.tagtart.miningfatiguepotion.potion;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tagtart.miningfatiguepotion.MiningFatiguePotion;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(ForgeRegistries.POTIONS, MiningFatiguePotion.MOD_ID);

    public static final RegistryObject<Potion> MINING_FATIGUE_POTION = POTIONS.register("mining_fatigue_potion",
            () -> new Potion(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 3600, 0)));
    public static final RegistryObject<Potion> LONGER_MINING_FATIGUE_POTION = POTIONS.register("longer_mining_fatigue_potion",
            () -> new Potion(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 7200, 0)));
    public static final RegistryObject<Potion> STRONGER_MINING_FATIGUE_POTION = POTIONS.register("stronger_mining_fatigue_potion",
            () -> new Potion(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 2400, 0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
