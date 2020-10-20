package com.mrcrayfish.backpacker.item;

import com.mrcrayfish.backpacked.item.BackpackItem;
import com.mrcrayfish.backpacker.Backpacker;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

/**
 * Author: MrCrayfish
 */
public class EnderBackpackItem extends BackpackItem
{
    private static final ITextComponent BACKPACK_TRANSLATION = new TranslationTextComponent("container.enderchest");

    public EnderBackpackItem(Properties properties)
    {
        super(properties);
    }

    @Override
    public void showInventory(ServerPlayerEntity player)
    {
        player.openContainer(new SimpleNamedContainerProvider((windowId, playerInventory, playerEntity) -> {
            return ChestContainer.createGeneric9X3(windowId, playerInventory, playerEntity.getInventoryEnderChest());
        }, BACKPACK_TRANSLATION));
    }

    @Override
    public ResourceLocation getModelTexture()
    {
        return Backpacker.ENDERSACK_TEXTURE;
    }
}
