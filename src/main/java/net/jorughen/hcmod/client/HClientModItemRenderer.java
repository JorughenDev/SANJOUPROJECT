package net.jorughen.hcmod.client;

import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.resource.ResourceReloadListenerKeys;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.jorughen.hcmod.client.render.entity.model.HCModConequeEntityModel;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;

import java.util.Collection;
import java.util.Collections;


public class HClientModItemRenderer implements BuiltinItemRendererRegistry.DynamicItemRenderer, SimpleSynchronousResourceReloadListener {

    private final Identifier id;
    private final Identifier coneque_staffId;
    private final Identifier texture;
    private final EntityModelLayer modelLayer;
    private ItemRenderer itemRenderer;
    private HCModConequeEntityModel coneque_staffEntityModel;
    private BakedModel inventoryConeque_staffModel;

    public HClientModItemRenderer(Identifier tridentId, Identifier texture, EntityModelLayer modelLayer) {
        this.id = new Identifier(tridentId.getNamespace(), tridentId.getPath() + "_renderer");
        this.coneque_staffId = tridentId;
        this.texture = texture;
        this.modelLayer = modelLayer;
    }

    @Override
    public Identifier getFabricId() {
        return this.id;
    }

    @Override
    public Collection<Identifier> getFabricDependencies() {
        return Collections.singletonList(ResourceReloadListenerKeys.MODELS);
    }

    @Override
    public void reload(ResourceManager manager) {
        MinecraftClient mc = MinecraftClient.getInstance();
        this.itemRenderer = mc.getItemRenderer();
        this.coneque_staffEntityModel = new HCModConequeEntityModel(mc.getEntityModelLoader().getModelPart(this.modelLayer));
        this.inventoryConeque_staffModel = mc.getBakedModelManager().getModel(new ModelIdentifier(this.coneque_staffId + "_in_inventory", "inventory"));
    }

    @Override
    public void render(ItemStack stack, ModelTransformation.Mode renderMode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        assert this.coneque_staffEntityModel != null;
        if (renderMode == ModelTransformation.Mode.GUI || renderMode == ModelTransformation.Mode.GROUND || renderMode == ModelTransformation.Mode.FIXED) {
            matrices.pop(); // cancel the previous transformation and pray that we are not breaking the state
            matrices.push();
            itemRenderer.renderItem(stack, renderMode, false, matrices, vertexConsumers, light, overlay, this.inventoryConeque_staffModel);
        } else {
            matrices.push();
            matrices.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumers, this.coneque_staffEntityModel.getLayer(this.texture), false, stack.hasGlint());
            this.coneque_staffEntityModel.render(matrices, vertexConsumer, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
            matrices.pop();
        }
    }

}
