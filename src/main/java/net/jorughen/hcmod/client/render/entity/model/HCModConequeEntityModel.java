package net.jorughen.hcmod.client.render.entity.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import java.util.function.Function;

@Environment(EnvType.CLIENT)
public class HCModConequeEntityModel extends Model {

    private final ModelPart root;

    public HCModConequeEntityModel(ModelPart root) {
        super(RenderLayer::getEntitySolid);
        this.root = root;
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData modelPartData2 = modelPartData.addChild("pole", ModelPartBuilder.create().uv(7, 5).cuboid(-9.0F, -24.5F, 7.0F, 2.0F, 2.0F, 2.0F), ModelTransform.NONE);
        modelPartData2.addChild("base", ModelPartBuilder.create().uv(0, 10).cuboid(-8.5F, -27.0F, 6.5F, 1.0F, 1.0F, 1.0F), ModelTransform.NONE);
        modelPartData2.addChild("left_spike", ModelPartBuilder.create().uv(11, 11).cuboid(-8.5F, -24.0F, 10.5F, 1.0F, 1.0F, 1.0F), ModelTransform.NONE);
        modelPartData2.addChild("middle_spike", ModelPartBuilder.create().uv(9, 0).cuboid(-8.5F, -25.0F, 9.5F, 1.0F, 3.0F, 1.0F), ModelTransform.NONE);
        modelPartData2.addChild("right_spike", ModelPartBuilder.create().uv(3, 4).mirrored().cuboid(-8.5F, -26.0F, 5.5F, 1.0F, 4.0F, 1.0F), ModelTransform.NONE);
        modelPartData2.addChild("right_spike2", ModelPartBuilder.create().uv(0, 8).mirrored().cuboid(-8.5F, -22.0F, 6.5F, 1.0F, 1.0F, 3.0F), ModelTransform.NONE);
        return TexturedModelData.of(modelData, 32, 32);
    }

    public static TexturedModelData getAtlanTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData modelPartData2 = modelPartData.addChild("pole", ModelPartBuilder.create().uv(7, 5).cuboid(-1.0F, -16.5F, 1.0F, 2.0F, 2.0F, 2.0F), ModelTransform.NONE);
        modelPartData2.addChild("base", ModelPartBuilder.create().uv(0, 10).cuboid(-0.5F, -19.0F, 0.5F, 1.0F, 1.0F, 1.0F), ModelTransform.NONE);
        modelPartData2.addChild("left_spike", ModelPartBuilder.create().uv(11, 11).cuboid(-0.5F, -16.0F, 4.5F, 1.0F, 1.0F, 1.0F), ModelTransform.NONE);
        modelPartData2.addChild("middle_spike", ModelPartBuilder.create().uv(9, 0).cuboid(-0.5F, -17.0F, 3.5F, 1.0F, 3.0F, 1.0F), ModelTransform.NONE);
        modelPartData2.addChild("right_spike", ModelPartBuilder.create().uv(3, 4).mirrored().cuboid(-0.5F, -18.0F, -1.5F, 1.0F, 4.0F, 1.0F), ModelTransform.NONE);
        modelPartData2.addChild("right_spike2", ModelPartBuilder.create().uv(0, 8).mirrored().cuboid(-0.5F, -14.0F, 0.5F, 1.0F, 1.0F, 3.0F), ModelTransform.NONE);

        modelPartData2.addChild("lower", ModelPartBuilder.create().uv(4, 10).mirrored().cuboid(-0.5F, -13.0F, -0.5F, 1.0F, 4.0F, 2.0F), ModelTransform.NONE);
        modelPartData2.addChild("lower2", ModelPartBuilder.create().uv(0, 5).mirrored().cuboid(-0.5F, -9.0F, 0.5F, 1.0F, 5.0F, 1.0F), ModelTransform.NONE);
        modelPartData2.addChild("lower3", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-0.5F, -4.0F, -0.5F, 1.0F, 17.0F, 1.0F), ModelTransform.NONE);
        return TexturedModelData.of(modelData, 32, 32);
    }

    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        this.root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}
