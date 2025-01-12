package net.tagtart.miningfatiguepotion;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.tagtart.miningfatiguepotion.potion.ModPotions;
import net.tagtart.miningfatiguepotion.util.BetterBrewingRecipe;
import org.slf4j.Logger;


@Mod(MiningFatiguePotion.MOD_ID)
public class MiningFatiguePotion
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "mining_fatigue_potion";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace


    public MiningFatiguePotion()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);


        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
        ModPotions.register(modEventBus);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            BrewingRecipe miningFatigueRecipe = new BrewingRecipe(
                    Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD)),
                    Ingredient.of(Items.CLOCK),
                    PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.MINING_FATIGUE_POTION.get()));

            BrewingRecipe longerMiningFatigueRecipe = new BrewingRecipe(
                    Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.MINING_FATIGUE_POTION.get())),
                    Ingredient.of(Items.REDSTONE),
                    PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.LONGER_MINING_FATIGUE_POTION.get())
            );

            BrewingRecipe strongerMiningFatigueRecipe = new BrewingRecipe(
                    Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.MINING_FATIGUE_POTION.get())),
                    Ingredient.of(Items.GLOWSTONE_DUST),
                    PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.STRONGER_MINING_FATIGUE_POTION.get())
            );

            BrewingRecipeRegistry.addRecipe(miningFatigueRecipe);
            BrewingRecipeRegistry.addRecipe(longerMiningFatigueRecipe);
            BrewingRecipeRegistry.addRecipe(strongerMiningFatigueRecipe);
        }
    }
}
