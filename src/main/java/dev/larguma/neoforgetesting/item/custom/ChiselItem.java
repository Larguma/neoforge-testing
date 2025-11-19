package dev.larguma.neoforgetesting.item.custom;

import java.util.List;
import java.util.Map;

import dev.larguma.neoforgetesting.block.ModBlocks;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class ChiselItem extends Item {
  private static final Map<Block, Block> CHISELABLES = Map.of(
      Blocks.STONE, Blocks.POLISHED_BLACKSTONE,
      Blocks.DEEPSLATE, Blocks.POLISHED_DEEPSLATE,
      Blocks.COBBLESTONE, Blocks.STONE,
      Blocks.OAK_PLANKS, Blocks.STRIPPED_OAK_LOG,
      Blocks.BIRCH_PLANKS, Blocks.STRIPPED_BIRCH_LOG,
      // .get() because deferred
      Blocks.SPRUCE_PLANKS, ModBlocks.EXAMPLE_BLOCK_BLOCKBENCH.get());

  public ChiselItem(Properties properties) {
    super(properties);
  }

  @Override
  public InteractionResult useOn(UseOnContext context) {
    Level level = context.getLevel();
    Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

    if (CHISELABLES.containsKey(clickedBlock)) {
      if (!level.isClientSide()) {
        level.setBlockAndUpdate(context.getClickedPos(), CHISELABLES.get(clickedBlock).defaultBlockState());

        context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
            item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

        level.playSound(null, context.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);
      }
    }

    return InteractionResult.sidedSuccess(level.isClientSide());
  }

  @Override
  public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents,
      TooltipFlag tooltipFlag) {
    if (Screen.hasShiftDown()) {
      tooltipComponents.add(Component.translatable("tooltip.neoforgetesting.chisel.tooltip.shift"));
    } else {
      tooltipComponents.add(Component.translatable("tooltip.neoforgetesting.chisel.tooltip.noshift"));
    }
    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
  }
}
