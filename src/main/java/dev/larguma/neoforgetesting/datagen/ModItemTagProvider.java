package dev.larguma.neoforgetesting.datagen;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import dev.larguma.neoforgetesting.neoforgetesting;
import dev.larguma.neoforgetesting.item.ModItems;
import dev.larguma.neoforgetesting.util.ModTags;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemTagProvider extends ItemTagsProvider {

  public ModItemTagProvider(PackOutput output, CompletableFuture<Provider> lookupProvider,
      CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
    super(output, lookupProvider, blockTags, neoforgetesting.MODID, existingFileHelper);
  }

  @Override
  protected void addTags(Provider provider) {
    tag(ModTags.Items.TRANSFORMABLE)
    .add(ModItems.CHISEL.get())
    .add(ModItems.EXAMPLE_ITEM_ASEPRITE.get());
  }

}
