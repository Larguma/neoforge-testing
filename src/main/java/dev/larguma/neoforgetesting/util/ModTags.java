package dev.larguma.neoforgetesting.util;

import dev.larguma.neoforgetesting.neoforgetesting;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
  public static class Blocks {
    public static final TagKey<Block> RANDOM_TAG = createTagKey("magic_blocks");

    private static TagKey<Block> createTagKey(String name) {
      return BlockTags.create(ResourceLocation.fromNamespaceAndPath(neoforgetesting.MODID, name));
    }
  }

  public static class Items {
    public static final TagKey<Item> TRANSFORMABLE = createTagKey("transformable");

    private static TagKey<Item> createTagKey(String name) {
      return ItemTags.create(ResourceLocation.fromNamespaceAndPath(neoforgetesting.MODID, name));
    }
  }
}
