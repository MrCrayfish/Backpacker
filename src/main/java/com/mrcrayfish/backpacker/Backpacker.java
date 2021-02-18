package com.mrcrayfish.backpacker;

import com.mrcrayfish.backpacker.client.ClientHandler;
import com.mrcrayfish.backpacker.init.ModItems;
import com.mrcrayfish.backpacker.init.ModRecipeSerializers;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * Author: MrCrayfish
 */
@Mod(Reference.MOD_ID)
public class Backpacker
{
    public static final ResourceLocation RUCKSACK_TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/rucksack.png");
    public static final ResourceLocation SHULKERPACK_TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/shulkerpack.png");
    public static final ResourceLocation NETHERPACK_TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/netherpack.png");
    public static final ResourceLocation ENDERSACK_TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/endersack.png");

    public Backpacker()
    {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.commonSpec);
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.REGISTER.register(bus);
        ModRecipeSerializers.REGISTER.register(bus);
        bus.addListener(this::onClientSetup);
    }

    private void onClientSetup(FMLClientSetupEvent event)
    {
        ClientHandler.setup();
    }
}
