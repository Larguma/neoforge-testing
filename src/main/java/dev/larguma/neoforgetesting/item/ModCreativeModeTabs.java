package dev.larguma.neoforgetesting.item;

import java.util.function.Supplier;

import dev.larguma.neoforgetesting.neoforgetesting;
import dev.larguma.neoforgetesting.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeModeTabs {
  public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister
      .create(Registries.CREATIVE_MODE_TAB, neoforgetesting.MODID);

  public static final Supplier<CreativeModeTab> EXAMPLE_TAB_ITEMS = CREATIVE_MODE_TABS.register("example_tab_items",
      () -> CreativeModeTab.builder()
          .icon(() -> ModItems.EXAMPLE_ITEM.get().getDefaultInstance())
          .title(Component.translatable("creative_mode_tab.neoforgetesting.example_tab_items"))
          .displayItems((itemDisplayParameters, output) -> {
            output.accept(ModItems.EXAMPLE_ITEM.get());
            output.accept(ModItems.EXAMPLE_ITEM_2.get());
            output.accept(ModItems.EXAMPLE_ITEM_ASEPRITE.get());
            output.accept(ModItems.CHISEL.get());
          })
          .build());

  public static final Supplier<CreativeModeTab> EXAMPLE_TAB_BLOCKS = CREATIVE_MODE_TABS.register("example_tab_blocks",
      () -> CreativeModeTab.builder()
          // Place this tab before the custom items tab
          .withTabsBefore(ResourceLocation.fromNamespaceAndPath(neoforgetesting.MODID, "example_tab_items"))
          .icon(() -> ModBlocks.EXAMPLE_BLOCK.get().asItem().getDefaultInstance())
          .title(Component.translatable("creative_mode_tab.neoforgetesting.example_tab_blocks"))
          .displayItems((itemDisplayParameters, output) -> {
            output.accept(ModBlocks.EXAMPLE_BLOCK.get());
            output.accept(ModBlocks.EXAMPLE_BLOCK_BLOCKBENCH.get());
            output.accept(ModBlocks.EXAMPLE_BLOCK_ORE.get());
            output.accept(ModBlocks.MAGIC_BLOCK.get());
          })
          .build());

  public static void register(IEventBus eventBus) {
    CREATIVE_MODE_TABS.register(eventBus);
  }
}
