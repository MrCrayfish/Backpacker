package com.mrcrayfish.backpacker;

import com.mrcrayfish.backpacker.init.ModItems;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * Author: MrCrayfish
 */
@Mod(Reference.MOD_ID)
public class Backpacker
{
    public static final ResourceLocation IRON_BACKPACK_TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/iron_backpack.png");

    public Backpacker()
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.REGISTER.register(bus);
    }
}
