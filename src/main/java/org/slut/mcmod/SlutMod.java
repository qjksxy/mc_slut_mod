package org.slut.mcmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slut.mcmod.items.ExampleItem;
import org.slut.mcmod.items.JiangeItem;
import org.slut.mcmod.items.KaoJiangeItem;

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

	public static final Item QINGJIN_SUIMO_ITEM =
			Registry.register(Registries.ITEM, new Identifier(MOD_ID, "qingjinsuimo"),
					new Item(new FabricItemSettings()));

	public static final JiangeItem JIANGE_ITEM = new JiangeItem(new Item.Settings()
			.food((new FoodComponent.Builder())
					.hunger(4)
					.saturationModifier(0.8F)
					.build())
			.maxCount(64));
	public static final KaoJiangeItem KAO_JIANGE_ITEM = new KaoJiangeItem(new Item.Settings()
			.food((new FoodComponent.Builder())
					.hunger(6)
					.saturationModifier(1F)
					.build())
			.maxCount(64));


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "jiange"), JIANGE_ITEM);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "kaojiange"), KAO_JIANGE_ITEM);

		CompostingChanceRegistry.INSTANCE.add(JIANGE_ITEM, 0.6F);
		CompostingChanceRegistry.INSTANCE.add(KAO_JIANGE_ITEM, 1F);

		LOGGER.info("Hello Fabric world!");
	}
}
