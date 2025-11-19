package dev.larguma.neoforgetesting.datagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import dev.larguma.neoforgetesting.block.ModBlocks;
import dev.larguma.neoforgetesting.item.ModItems;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

public class ModRecipeProvider extends RecipeProvider {

  public ModRecipeProvider(PackOutput output, CompletableFuture<Provider> registries) {
    super(output, registries);
  }

  @Override
  protected void buildRecipes(RecipeOutput recipeOutput) {
    List<ItemLike> EXAMPLE_BLOCK_SMELTABLES = List.of(
        ModBlocks.EXAMPLE_BLOCK.get(),
        ModBlocks.EXAMPLE_BLOCK_ORE.get());

    ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CHISEL.get())
        .define('#', Items.COPPER_INGOT)
        .define('S', Items.STICK)
        .pattern(" # ")
        .pattern(" S ")
        .pattern(" S ")
        .unlockedBy("has_copper_ingot", has(Items.COPPER_INGOT))
        .save(recipeOutput);

    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.EXAMPLE_ITEM_2.get(), 2)
        .requires(ModItems.EXAMPLE_ITEM.get())
        .requires(Items.RED_DYE)
        .unlockedBy("has_example_item", has(ModItems.EXAMPLE_ITEM.get()))
        .save(recipeOutput, "neoforgetesting:example_item_from_dye");

    oreSmelting(recipeOutput, EXAMPLE_BLOCK_SMELTABLES, RecipeCategory.MISC, ModItems.CHISEL.get(), 0.5f, 100,
        "chisel");
    oreBlasting(recipeOutput, EXAMPLE_BLOCK_SMELTABLES, RecipeCategory.MISC, ModItems.CHISEL.get(), 0.5f, 50,
        "chisel");
  }

}
