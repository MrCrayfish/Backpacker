package com.mrcrayfish.backpacker.init;

import com.mrcrayfish.backpacker.Backpacker;
import com.mrcrayfish.backpacker.Reference;
import com.mrcrayfish.backpacker.item.UpgradedBackpackItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Author: MrCrayfish
 */
public class ModItems
{
    public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MOD_ID);

    public static final RegistryObject<Item> IRON_BACKPACK = REGISTER.register("iron_backpack", () -> new UpgradedBackpackItem(2, Backpacker.IRON_BACKPACK_TEXTURE, new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)));

}
