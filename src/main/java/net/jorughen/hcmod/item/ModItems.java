package net.jorughen.hcmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.jorughen.hcmod.HCmod;
import net.jorughen.hcmod.item.custom.coneque_staff;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item Coneque_Staff = regsiterItem("coneque_staff",
            new coneque_staff(new FabricItemSettings().group(ItemGroup.MISC).maxCount(1)));


    private static Item regsiterItem(String name, Item item ){
        return Registry.register(Registry.ITEM, new Identifier(HCmod.MOD_ID, name), item);
    }



    public static void registerModItems(){

        HCmod.LOGGER.debug("Registering Mod Items for " + HCmod.MOD_ID);

    }
}
