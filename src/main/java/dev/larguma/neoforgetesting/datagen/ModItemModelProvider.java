package dev.larguma.neoforgetesting.datagen;

import dev.larguma.neoforgetesting.neoforgetesting;
import dev.larguma.neoforgetesting.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

  public ModItemModelProvider(PackOutput output, ExistingFileHelper exFileHelper) {
    super(output, neoforgetesting.MODID, exFileHelper);
  }

  @Override
  protected void registerModels() {
    basicItem(ModItems.CHISEL.get());
    basicItem(ModItems.EXAMPLE_ITEM.get());
    basicItem(ModItems.EXAMPLE_ITEM_2.get());
    basicItem(ModItems.EXAMPLE_ITEM_ASEPRITE.get());
  }

}
