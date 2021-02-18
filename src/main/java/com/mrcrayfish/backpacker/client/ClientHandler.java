package com.mrcrayfish.backpacker.client;

import com.mrcrayfish.backpacker.crafting.IColored;
import com.mrcrayfish.backpacker.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraftforge.common.util.Constants;

/**
 * Author: MrCrayfish
 */
public class ClientHandler
{
    public static void setup()
    {
        IItemColor color = (stack, index) ->
        {
            if(index != 0) return -1;
            int tint = ((IColored) stack.getItem()).baseColor();
            if(stack.hasTag() && stack.getTag().contains("Color", Constants.NBT.TAG_INT))
            {
                tint = stack.getTag().getInt("Color");
            }
            return tint;
        };
        Minecraft.getInstance().getItemColors().register(color, ModItems.RUCKSACK.get());
    }
}
