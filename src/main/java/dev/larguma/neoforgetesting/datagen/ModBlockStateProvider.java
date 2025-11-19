package dev.larguma.neoforgetesting.datagen;

import dev.larguma.neoforgetesting.neoforgetesting;
import dev.larguma.neoforgetesting.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {

  public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
    super(output, neoforgetesting.MODID, exFileHelper);
  }

  @Override
  protected void registerStatesAndModels() {
    blockWithItem(ModBlocks.EXAMPLE_BLOCK);
    blockWithItem(ModBlocks.EXAMPLE_BLOCK_ORE);
    blockWithItem(ModBlocks.MAGIC_BLOCK);
  }

  private void blockWithItem(DeferredBlock<?> block) {
    simpleBlockWithItem(block.get(), cubeAll(block.get()));
  }

}
