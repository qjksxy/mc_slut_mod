package org.slut.mcmod;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;


public class Sound {
    // TODO 无法播放声音
    public static final SoundEvent SOUND_ORMOS = Sound.register("music_ormos");
    // 调用此方法以加载此类
    public static void sound(){
    }

    public static SoundEvent register(String name) {
        Identifier id = new Identifier(SlutMod.MOD_ID + ":" + name);
        return (SoundEvent) Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));

    }
}
