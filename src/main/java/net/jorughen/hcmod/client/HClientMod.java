package net.jorughen.hcmod.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.jorughen.hcmod.HCmod;
import net.jorughen.hcmod.client.render.entity.HClientModEntityRenderer;
import net.jorughen.hcmod.client.render.entity.model.HCModConequeEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.item.Item;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.jorughen.hcmod.item.ModItems;
import net.jorughen.hcmod.item.custom.coneque_staff;

public class HClientMod implements ClientModInitializer{

    public static final EntityModelLayer Coneque_Staff = new EntityModelLayer(new Identifier(HCmod.MOD_ID, "coneque_staff"), "main");


    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(Coneque_Staff, HCModConequeEntityModel::getConequeTexturedModelData);


        coneque_staff item = (coneque_staff) ModItems.Coneque_Staff;
        Identifier coneque_staffId = Registry.ITEM.getId(item);
        Identifier texture = new Identifier(coneque_staffId.getNamespace(), "textures/entity/" + coneque_staffId.getPath() + ".png");

        EntityModelLayer modelLayer =Coneque_Staff;
        HClientModItemRenderer Coneque_staffItemRenderer = new HClientModItemRenderer(coneque_staffId, texture, modelLayer);
        ResourceManagerHelper.get(ResourceType.CLIENT_RESOURCES).registerReloadListener(Coneque_staffItemRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register(item, Coneque_staffItemRenderer);
        ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) -> out.accept(new ModelIdentifier(coneque_staffId + "_in_inventory", "inventory")));





    }
}
