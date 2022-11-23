package com.waste.hacks;

import net.minecraft.client.MinecraftClient;

import java.lang.reflect.Array;
import java.util.List;

public class Xray {
    public static void tick(MinecraftClient client){
        if(Hacks.XRAYEnabled){
            client.chunkCullingEnabled = false;
            client.worldRenderer.reload();
        }

    }
}
