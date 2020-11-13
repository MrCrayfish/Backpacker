package com.mrcrayfish.backpacker.common;

import com.mrcrayfish.backpacked.Backpacked;
import com.mrcrayfish.backpacker.Reference;
import com.mrcrayfish.backpacker.init.ModItems;
import net.minecraft.entity.monster.ShulkerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Author: MrCrayfish
 */
@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class CommonEvents
{
    @SubscribeEvent
    public static void onEntityAttack(LivingDamageEvent event)
    {
        if(event.getSource().getTrueSource() instanceof ShulkerEntity && event.getEntity() instanceof PlayerEntity)
        {
            PlayerEntity player = (PlayerEntity) event.getEntity();
            if(Backpacked.getBackpackStack(player).getItem() == ModItems.SHULKERPACK.get())
            {
                if(player.world.rand.nextInt(2) == 0)
                {
                    event.setCanceled(true);
                }
            }
        }
    }
}
