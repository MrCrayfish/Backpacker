package com.mrcrayfish.backpacker.item;

import com.mrcrayfish.backpacked.item.BackpackItem;
import net.minecraft.util.ResourceLocation;

/**
 * Author: MrCrayfish
 */
public class UpgradedBackpackItem extends BackpackItem
{
    private final int rows;
    private final ResourceLocation texture;

    public UpgradedBackpackItem(int rows, ResourceLocation texture, Properties properties)
    {
        super(properties);
        this.rows = rows;
        this.texture = texture;
    }

    @Override
    public int getRowCount()
    {
        return this.rows;
    }

    @Override
    public ResourceLocation getModelTexture()
    {
        return this.texture;
    }
}
