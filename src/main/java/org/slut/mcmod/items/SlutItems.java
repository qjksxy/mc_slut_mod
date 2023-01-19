package org.slut.mcmod.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import org.slut.mcmod.SlutMod;
import org.slut.mcmod.Sound;
import org.slut.mcmod.items.tools.HumoZhiZhangToolMaterial;
import org.slut.mcmod.items.weapon.HumoZhiZhang;

public class SlutItems {
    public static final String MOD_ID = SlutMod.MOD_ID;
    // 物品组 图片暂用humo
    public static final ItemGroup SLUT_ITEM_GROUP = FabricItemGroup.builder(new Identifier(MOD_ID, "maingroup")).icon(() -> new ItemStack(SlutItems.HUMO_ZHI_ZHANG)).build();

    public static final ExampleItem EXAMPLE_ITEM = register("example_item", new ExampleItem(new FabricItemSettings()));
    public static final Item QINGJIN_SUIMO_ITEM = register("qingjinsuimo_item", new Item(new FabricItemSettings()));
    public static final JiangeItem JIANGE_ITEM = register("jiange_item", new JiangeItem(new Item.Settings().food((new FoodComponent.Builder()).hunger(6).saturationModifier(0.8F).build()).maxCount(64)));
    public static final KaoJiangeItem KAO_JIANGE_ITEM = register("kaojiange_item", new KaoJiangeItem(new Item.Settings().food((new FoodComponent.Builder()).hunger(8).saturationModifier(1F).build()).maxCount(64)));
    public static final HumoZhiZhang HUMO_ZHI_ZHANG = register("humozhizhang_item", new HumoZhiZhang(new HumoZhiZhangToolMaterial(), 8, -2F, new Item.Settings()));
    public static final MusicDiscItem MUSIC_ORMOS = register("dis_ormos_item", new MusicDiscItem(2, Sound.SOUND_ORMOS, new Item.Settings().rarity(Rarity.RARE), 100));

    private static <V extends Item> V register(String id, V item) {
        return Registry.register(Registries.ITEM, new Identifier(MOD_ID, id), item);
    }

    /**
     * 将物品加入到物品组中
     */
    public static void addItemToGroup() {
        // TODO: 此处可以进行简化写法，比如利用反射等
        ItemGroupEvents.modifyEntriesEvent(SLUT_ITEM_GROUP).register(content -> {
            content.add(QINGJIN_SUIMO_ITEM);
            content.add(JIANGE_ITEM);
            content.add(KAO_JIANGE_ITEM);
            content.add(HUMO_ZHI_ZHANG);
            content.add(MUSIC_ORMOS);
        });
    }

    /**
     * 堆肥
     */
    public static void compostingChanceRegistry() {
        CompostingChanceRegistry.INSTANCE.add(SlutItems.JIANGE_ITEM, 0.8F);
        CompostingChanceRegistry.INSTANCE.add(SlutItems.KAO_JIANGE_ITEM, 1F);
    }
}
