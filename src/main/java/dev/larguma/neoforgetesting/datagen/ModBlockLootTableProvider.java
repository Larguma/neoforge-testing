package dev.larguma.neoforgetesting.datagen;

import java.util.Set;

import dev.larguma.neoforgetesting.block.ModBlocks;
import dev.larguma.neoforgetesting.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class ModBlockLootTableProvider extends BlockLootSubProvider {

  protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
    super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
  }

  @Override
  protected void generate() {
    dropSelf(ModBlocks.EXAMPLE_BLOCK.get());

    add(ModBlocks.EXAMPLE_BLOCK_ORE.get(), block -> createOreDrop(block, ModItems.EXAMPLE_ITEM.get()));
    add(ModBlocks.EXAMPLE_BLOCK_BLOCKBENCH.get(), block -> createMultipleOreDrops(block, ModItems.CHISEL.get(), 2, 5));
  }

  // Nearly the same as "createCopperOreDrops" in BlockLootSubProvider, but with
  // configurable min/max drop count
  protected LootTable.Builder createMultipleOreDrops(Block block, Item item, int min, int max) {
    HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
    return this.createSilkTouchDispatchTable(block,
        this.applyExplosionDecay(block, LootItem.lootTableItem(item)
            .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max))))
            .apply(ApplyBonusCount.addOreBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE))));
  }

  @Override
  protected Iterable<Block> getKnownBlocks() {
    return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
  }

}
