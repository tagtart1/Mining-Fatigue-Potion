package net.tagtart.miningfatiguepotion.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.vanilla.IJeiBrewingRecipe.
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraftforge.common.brewing.BrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.brewing.VanillaBrewingRecipe;
import net.tagtart.miningfatiguepotion.MiningFatiguePotion;
import net.tagtart.miningfatiguepotion.potion.ModPotions;
import net.tagtart.miningfatiguepotion.util.BetterBrewingRecipe;

import java.util.List;

@JeiPlugin
public class JEIMiningFatiguePotionPlugin implements IModPlugin {



    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(MiningFatiguePotion.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

    }
}