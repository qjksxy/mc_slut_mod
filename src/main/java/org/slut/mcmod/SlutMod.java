package org.slut.mcmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slut.mcmod.items.ExampleItem;
import org.slut.mcmod.items.JiangeItem;
import org.slut.mcmod.items.KaoJiangeItem;
import org.slut.mcmod.items.MusicDisc;
import org.slut.mcmod.items.tools.HumoZhiZhangToolMaterial;
import org.slut.mcmod.items.weapon.HumoZhiZhang;

public class SlutMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.


	public static final String MOD_ID = "slut";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	// 添加一个名为 slut:example 的物品
	public static final ExampleItem EXAMPLE_ITEM =
			Registry.register(Registries.ITEM, new Identifier(MOD_ID, "example"),
					new ExampleItem(new FabricItemSettings()));

	public static final Item QINGJIN_SUIMO_ITEM =
			Registry.register(Registries.ITEM, new Identifier(MOD_ID, "qingjinsuimo"),
					new Item(new FabricItemSettings()));

	public static final JiangeItem JIANGE_ITEM = new JiangeItem(new Item.Settings()
			.food((new FoodComponent.Builder())
					.hunger(6)
					.saturationModifier(0.8F)
					.build())
			.maxCount(64));
	public static final KaoJiangeItem KAO_JIANGE_ITEM = new KaoJiangeItem(new Item.Settings()
			.food((new FoodComponent.Builder())
					.hunger(8)
					.saturationModifier(1F)
					.build())
			.maxCount(64));

	public static final HumoZhiZhang HUMO_ZHI_ZHANG = new HumoZhiZhang(
			new HumoZhiZhangToolMaterial(), 8, -2F, new Item.Settings());

	// 初始化物品组 图片暂用humo
	public static final ItemGroup SLUT_ITEM_GROUP = FabricItemGroup.builder(new Identifier(MOD_ID, "maingroup"))
			.icon(() -> new ItemStack(HUMO_ZHI_ZHANG))
			.build();

	// 音乐
	// 秒数？
	public static final MusicDisc MUSIC_ORMOS = new MusicDisc(2, Sound.SOUND_ORMOS, new Item.Settings().rarity(Rarity.RARE), 100);

	@Override
	public void onInitialize() {
		Sound.sound();
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "jiange"), JIANGE_ITEM);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "kaojiange"), KAO_JIANGE_ITEM);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "humozhizhang"), HUMO_ZHI_ZHANG);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "music_ormos"), MUSIC_ORMOS);

		CompostingChanceRegistry.INSTANCE.add(JIANGE_ITEM, 0.6F);
		CompostingChanceRegistry.INSTANCE.add(KAO_JIANGE_ITEM, 1F);

		// 将物品加入到物品组中
		// TODO: 此处可以进行简化写法，比如利用反射等
		ItemGroupEvents.modifyEntriesEvent(SLUT_ITEM_GROUP).register(content -> {
			content.add(QINGJIN_SUIMO_ITEM);
			content.add(JIANGE_ITEM);
			content.add(KAO_JIANGE_ITEM);
			content.add(HUMO_ZHI_ZHANG);
			content.add(MUSIC_ORMOS);
		});

		LOGGER.info("Hello Fabric world!");
	}
}
