package com.mrcrayfish.backpacker.item;

import com.mrcrayfish.backpacker.crafting.IColored;
import net.minecraft.util.ResourceLocation;

import java.util.function.Supplier;

/**
 * Author: MrCrayfish
 */
public class ColoredBackpackItem extends UpgradedBackpackItem implements IColored
{
    public ColoredBackpackItem(Supplier<Integer> rows, ResourceLocation texture, Properties properties)
    {
        super(rows, texture, properties);
    }

    @Override
    public int baseColor()
    {
        return 0xFFCA84;
    }
}
