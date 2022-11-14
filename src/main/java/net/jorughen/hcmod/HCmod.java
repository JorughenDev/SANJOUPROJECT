package net.jorughen.hcmod;

import net.fabricmc.api.ModInitializer;
import net.jorughen.hcmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HCmod implements ModInitializer {
	public static final String MOD_ID = "hcmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();

	}
}
