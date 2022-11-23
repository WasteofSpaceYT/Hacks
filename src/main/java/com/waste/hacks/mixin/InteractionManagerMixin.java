package com.waste.hacks.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientPlayerInteractionManager.class)
public class InteractionManagerMixin {
    @Shadow @Final private MinecraftClient client;

    //@Inject(at = @At("RETURN"), method = "getReachDistance", cancellable = true)
    private void getReachDistance(CallbackInfoReturnable<Float> cir) {
        cir.setReturnValue(100.0F);
    }
}
