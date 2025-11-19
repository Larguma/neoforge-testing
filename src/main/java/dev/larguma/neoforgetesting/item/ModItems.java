package dev.larguma.neoforgetesting.item;

import java.util.List;

import dev.larguma.neoforgetesting.neoforgetesting;
import dev.larguma.neoforgetesting.item.custom.ChiselItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
  public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(neoforgetesting.MODID);

  public static final DeferredItem<Item> EXAMPLE_ITEM = ITEMS.register("example_item",
      () -> new Item(new Item.Properties()));
  public static final DeferredItem<Item> EXAMPLE_ITEM_2 = ITEMS.register("example_item_2",
      () -> new Item(new Item.Properties()));
  public static final DeferredItem<Item> EXAMPLE_ITEM_ASEPRITE = ITEMS.register("example_item_aseprite",
      () -> new Item(new Item.Properties()));

  public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel",
      () -> new ChiselItem(new Item.Properties().durability(64)) {
        public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents,
            TooltipFlag tooltipFlag) {
          tooltipComponents.add(Component.translatable("tooltip.neoforgetesting.chisel.tooltip"));
          super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        };
      });

  public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
  }

}
