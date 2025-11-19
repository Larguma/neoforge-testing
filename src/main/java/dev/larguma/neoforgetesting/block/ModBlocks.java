package dev.larguma.neoforgetesting.block;

import java.util.function.Supplier;

import dev.larguma.neoforgetesting.neoforgetesting;
import dev.larguma.neoforgetesting.block.custom.*;
import dev.larguma.neoforgetesting.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
  public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(neoforgetesting.MODID);

  public static final DeferredBlock<Block> EXAMPLE_BLOCK = registerBlock("example_block",
      () -> new Block(BlockBehaviour.Properties.of()
          .strength(1f)
          .requiresCorrectToolForDrops()
          .sound(SoundType.SWEET_BERRY_BUSH)));

  public static final DeferredBlock<Block> EXAMPLE_BLOCK_ORE = registerBlock("example_block_ore",
      () -> new DropExperienceBlock(UniformInt.of(2, 4),
          BlockBehaviour.Properties.of()
              .strength(1f)
              .requiresCorrectToolForDrops()
              .sound(SoundType.STONE)));

  public static final DeferredBlock<Block> MAGIC_BLOCK = registerBlock("magic_block",
      () -> new MagicBlock(BlockBehaviour.Properties.of()
          .strength(1f)
          .sound(SoundType.AMETHYST)
          .noLootTable()));
          
  public static final DeferredBlock<Block> EXAMPLE_BLOCK_BLOCKBENCH = registerBlock("example_block_blockbench",
      () -> new ExampleBlockBlockbenchBlock(BlockBehaviour.Properties.of().noOcclusion()));

  private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
    DeferredBlock<T> toReturn = BLOCKS.register(name, block);
    registerBlockItem(name, toReturn);
    return toReturn;
  }

  private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
    ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
  }

  public static void register(IEventBus eventBus) {
    BLOCKS.register(eventBus);
  }
}
