package net.jorughen.hcmod.client.render.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jorughen.hcmod.client.render.entity.model.HCModConequeEntityModel;
import net.jorughen.hcmod.entity.HcConequeEntity;
import net.jorughen.hcmod.item.custom.coneque_staff;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3f;

@Environment(EnvType.CLIENT)
public class HClientModEntityRenderer extends EntityRenderer <HcConequeEntity> {


    private final HCModConequeEntityModel model;
    private final Identifier texture;

    public HClientModEntityRenderer(EntityRendererFactory.Context context, Identifier texture, EntityModelLayer modelLayer) {
        super(context);
        this.model = new HCModConequeEntityModel(context.getPart(modelLayer));
        this.texture = texture;
    }

    public void render(HcConequeEntity hcConequeEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(MathHelper.lerp(g, hcConequeEntity.prevYaw, hcConequeEntity.getYaw()) - 90.0F));
        matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(MathHelper.lerp(g, hcConequeEntity.prevPitch, hcConequeEntity.getPitch()) + 90.0F));
        VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.model.getLayer(this.getTexture(hcConequeEntity)), false, false);
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.pop();
        super.render(hcConequeEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    public Identifier getTexture(HcConequeEntity hcConequeEntity) {
        return this.texture;
    }

}
