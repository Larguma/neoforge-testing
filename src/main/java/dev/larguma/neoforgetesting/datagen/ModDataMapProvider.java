package dev.larguma.neoforgetesting.datagen;

import java.util.concurrent.CompletableFuture;

import dev.larguma.neoforgetesting.item.ModItems;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

public class ModDataMapProvider extends DataMapProvider {

  protected ModDataMapProvider(PackOutput packOutput, CompletableFuture<Provider> lookupProvider) {
    super(packOutput, lookupProvider);
  }

  @Override
  protected void gather(Provider provider) {
    this.builder(NeoForgeDataMaps.FURNACE_FUELS)
        .add(ModItems.CHISEL.getId(), new FurnaceFuel(200), false);
  }

}
