package org.slut.mcmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slut.mcmod.items.ExampleItem;

public class SlutMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	public static final String MOD_ID = "slut";
	// 添加一个名为 slut:example 的物品
	public static final ExampleItem EXAMPLE_ITEM =
			Registry.register(Registries.ITEM, new Identifier(MOD_ID, "example"),
					new ExampleItem(new FabricItemSettings()));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		CompostingChanceRegistry.INSTANCE.add(EXAMPLE_ITEM, 0.8F);

		LOGGER.info("Hello Fabric world!");
	}
}
