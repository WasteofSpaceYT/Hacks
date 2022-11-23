package com.waste.hacks.mixin;

import com.waste.hacks.FlyHack;
import com.waste.hacks.Hacks;
import com.waste.hacks.ReachHack;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin {
    @Shadow protected abstract void doItemUse();
    @Shadow
    public static MinecraftClient instance;

    @Inject(at = @At("TAIL"), method = "tick()V")
    private void tick(CallbackInfo ci){
        FlyHack.tick(this.instance);
        if(Hacks.fishCaught && Hacks.AutoFishEnabled){
            doItemUse();
        }
    }
}
