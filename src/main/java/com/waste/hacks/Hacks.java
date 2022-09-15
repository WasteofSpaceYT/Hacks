package com.waste.hacks;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Hacks implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("modid");
    public static boolean fishCaught;
    public static boolean AutoFishEnabled = true;
    public static boolean FlyHackEnabled = true;
    public static boolean FullBrightEnabled = true;
    public static double defGamma = 1.0;
    public static double FBGamma = 10000000.0;
    public static MinecraftClient client = MinecraftClient.getInstance();
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        LOGGER.info("Hello Fabric world!");
    }
}
