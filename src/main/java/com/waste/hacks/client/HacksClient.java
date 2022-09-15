package com.waste.hacks.client;

import com.waste.hacks.FlyHack;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class HacksClient implements ClientModInitializer {
    private static KeyBinding keyBinding;
    @Override
    public void onInitializeClient() {
        keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.hacks.fly",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_GRAVE_ACCENT,
                "category.hacks.fly"
        ));
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(keyBinding.wasPressed()){
                FlyHack.flying = !FlyHack.flying;
                System.out.println("Toggled FlyHack");
            }
        });
    }
}
