package dev.larguma.neoforgetesting.datagen;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import dev.larguma.neoforgetesting.neoforgetesting;
import dev.larguma.neoforgetesting.block.ModBlocks;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockTagProvider extends BlockTagsProvider {

  public ModBlockTagProvider(PackOutput output, CompletableFuture<Provider> lookupProvider,
      @Nullable ExistingFileHelper existingFileHelper) {
    super(output, lookupProvider, neoforgetesting.MODID, existingFileHelper);
  }

  @Override
  protected void addTags(Provider provider) {
    tag(BlockTags.MINEABLE_WITH_PICKAXE)
        .add(ModBlocks.EXAMPLE_BLOCK.get())
        .add(ModBlocks.EXAMPLE_BLOCK_ORE.get())
        .add(ModBlocks.EXAMPLE_BLOCK_BLOCKBENCH.get());

    tag(BlockTags.NEEDS_STONE_TOOL)
        .add(ModBlocks.EXAMPLE_BLOCK.get())
        .add(ModBlocks.EXAMPLE_BLOCK_ORE.get())
        .add(ModBlocks.EXAMPLE_BLOCK_BLOCKBENCH.get());
  }

}
