package com.mrcrayfish.backpacker.item;

import net.minecraft.util.ResourceLocation;

/**
 * Author: MrCrayfish
 */
public class NetherBackpackItem extends UpgradedBackpackItem
{
    public NetherBackpackItem(int rows, ResourceLocation texture, Properties properties)
    {
        super(rows, texture, properties);
    }

    @Override
    public boolean func_234687_u_()
    {
        return true;
    }
}
