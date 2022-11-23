package com.waste.hacks.client;

import com.waste.hacks.FlyHack;
import com.waste.hacks.Hacks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class HacksClient implements ClientModInitializer {
    public static MinecraftClient client = MinecraftClient.getInstance();
    private static KeyBinding flightKeyBinding;
    private static KeyBinding fullbrightKeyBinding;
    private static KeyBinding xrayKeyBinding;
    @Override
    public void onInitializeClient() {
        flightKeyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.hacks.fly",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_GRAVE_ACCENT,
                "category.hacks.fly"
        ));
        fullbrightKeyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.hacks.fullbright",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_B,
                "category.hacks.fullbright"
        ));
        xrayKeyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.hacks.xray",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_X,
                "category.hacks.xray"
        ));
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(flightKeyBinding.wasPressed()){
                FlyHack.flying = !FlyHack.flying;
            }
            if(fullbrightKeyBinding.wasPressed()){
                Hacks.FullBrightEnabled = !Hacks.FullBrightEnabled;
                if(Hacks.FullBrightEnabled){
                    Hacks.Gamma = 10.0;
                } else {
                    Hacks.Gamma = 1.0;
                }
            }
            if(xrayKeyBinding.wasPressed()){
                Hacks.XRAYEnabled = !Hacks.XRAYEnabled;
                if(Hacks.XRAYEnabled) Hacks.Gamma = 10.0;
                MinecraftClient MC = MinecraftClient.getInstance();
                MC.worldRenderer.reload();
            }
        });
    }
}
