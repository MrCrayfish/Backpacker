package com.mrcrayfish.backpacker.init;

import com.mrcrayfish.backpacker.Backpacker;
import com.mrcrayfish.backpacker.Reference;
import com.mrcrayfish.backpacker.item.EnderBackpackItem;
import com.mrcrayfish.backpacker.item.NetherBackpackItem;
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

    public static final RegistryObject<Item> RUCKSACK = REGISTER.register("rucksack", () -> new UpgradedBackpackItem(2, Backpacker.RUCKSACK_TEXTURE, new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)));
    public static final RegistryObject<Item> SHULKERPACK = REGISTER.register("shulkerpack", () -> new UpgradedBackpackItem(3, Backpacker.SHULKERPACK_TEXTURE, new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)));
    public static final RegistryObject<Item> NETHERPACK = REGISTER.register("netherpack", () -> new NetherBackpackItem(5, Backpacker.NETHERPACK_TEXTURE, new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)));
    public static final RegistryObject<Item> ENDERSACK = REGISTER.register("endersack", () -> new EnderBackpackItem(new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)));

}
