package com.waste.hacks;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Hacks implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("WasteHacks");
    public static boolean fishCaught;
    public static boolean AutoFishEnabled = true;
    public static boolean FlyHackEnabled = true;
    public static boolean FullBrightEnabled = true;
    public static boolean XRAYEnabled = false;
    public static Double Gamma = 1.0;
    @Override
    public void onInitialize() {
        LOGGER.info("WasteHacks initialized");
    }
}
