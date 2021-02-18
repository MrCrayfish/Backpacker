package com.mrcrayfish.backpacker.mixin.client;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mrcrayfish.backpacked.Backpacked;
import com.mrcrayfish.backpacked.client.model.ModelBackpack;
import com.mrcrayfish.backpacked.client.renderer.entity.layers.BackpackLayer;
import com.mrcrayfish.backpacked.integration.Curios;
import com.mrcrayfish.backpacked.item.BackpackItem;
import com.mrcrayfish.backpacker.crafting.IColored;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

/**
 * Author: MrCrayfish
 */
@Mixin(BackpackLayer.class)
public abstract class BackpackLayerMixin
{
    @Shadow(remap = false)
    private ModelBackpack model;

    /**
     * Overrides the rendering to allowing colouring of the backpack model
     *
     * @author MrCrayfish
     */
    @Overwrite(remap = false)
    public void render(MatrixStack stack, IRenderTypeBuffer renderTypeBuffer, int packedLightIn, PlayerEntity player, float p_225628_5_, float p_225628_6_, float red, float green, float blue, float alpha)
    {
        ItemStack backpack = Backpacked.getBackpackStack(player);
        if(backpack.getItem() instanceof BackpackItem)
        {
            ItemStack chestStack = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
            if(chestStack.getItem() == Items.ELYTRA) return;

            if(Backpacked.isCuriosLoaded() && !Curios.isBackpackVisible(player)) return;

            stack.push();

            BackpackLayer layer = (BackpackLayer) (Object) this;
            ((BipedModel) layer.getEntityModel()).setModelAttributes(this.model);
            this.model.setupAngles((BipedModel) layer.getEntityModel());

            BackpackItem item = (BackpackItem) backpack.getItem();
            if(item instanceof IColored)
            {
                IColored colored = (IColored) item;
                int color = colored.hasColor(backpack) ? colored.getColor(backpack) : colored.baseColor();
                red = (float) (color >> 16 & 255) / 255.0F;
                green = (float) (color >> 8 & 255) / 255.0F;
                blue = (float) (color & 255) / 255.0F;
                String textureLocation = item.getModelTexture().toString();
                ResourceLocation texture = new ResourceLocation(textureLocation.substring(0, textureLocation.length() - 4) + "_overlay.png");
                IVertexBuilder overlayBuilder = ItemRenderer.func_239391_c_(renderTypeBuffer, this.model.getRenderType(texture), false, backpack.hasEffect());
                this.model.render(stack, overlayBuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
            }

            IVertexBuilder builder = ItemRenderer.func_239391_c_(renderTypeBuffer, this.model.getRenderType(item.getModelTexture()), false, backpack.hasEffect());
            this.model.render(stack, builder, packedLightIn, OverlayTexture.NO_OVERLAY, red, green, blue, 1.0F);

            stack.pop();
        }
    }
}
