package com.mrcrayfish.backpacker.item;

import com.mrcrayfish.backpacked.item.BackpackItem;
import net.minecraft.util.ResourceLocation;

import java.util.function.Supplier;

/**
 * Author: MrCrayfish
 */
public class UpgradedBackpackItem extends BackpackItem
{
    private final Supplier<Integer> rows;
    private final ResourceLocation texture;

    public UpgradedBackpackItem(Supplier<Integer> rows, ResourceLocation texture, Properties properties)
    {
        super(properties);
        this.rows = rows;
        this.texture = texture;
    }

    @Override
    public int getRowCount()
    {
        return this.rows.get();
    }

    @Override
    public ResourceLocation getModelTexture()
    {
        return this.texture;
    }
}
