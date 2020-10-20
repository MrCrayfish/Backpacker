package com.mrcrayfish.backpacker.client;

import com.mrcrayfish.backpacked.Backpacked;
import com.mrcrayfish.backpacker.Reference;
import com.mrcrayfish.backpacker.item.EnderBackpackItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

/**
 * Author: MrCrayfish
 */
@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Dist.CLIENT)
public class ClientEvents
{
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event)
    {
        if(event.phase == TickEvent.Phase.START) return;

        PlayerEntity player = event.player;
        ItemStack backpack = Backpacked.getBackpackStack(event.player);
        if(backpack.getItem() instanceof EnderBackpackItem)
        {
            Random rand = player.world.rand;
            Vector3d vec = Vector3d.fromPitchYaw(0F, player.renderYawOffset).scale(-1.0).scale(0.25).add(0, 0.8375 + 0.5 * rand.nextDouble(), 0).add(player.getPositionVec());
            double posX = vec.getX();
            double posY = vec.getY();
            double posZ = vec.getZ();
            int j = rand.nextInt(2) * 2 - 1;
            int k = rand.nextInt(2) * 2 - 1;
            double xSpeed = rand.nextFloat() * (float) j;
            double ySpeed = (rand.nextFloat() - 0.5D) * 0.125D;
            double zSpeed = rand.nextFloat() * (float) k;
            player.world.addParticle(ParticleTypes.PORTAL, posX, posY, posZ, xSpeed, ySpeed, zSpeed);
        }
    }
}
