package com.waste.hacks.mixin;

import com.waste.hacks.Hacks;
import net.minecraft.block.AbstractBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractBlock.class)
public class AbstractBlockMixin {
    @Inject(at = @At("RETURN"), method = "getAmbientOcclusionLightLevel", cancellable = true)
    private void getAmbientOcclusionLightLevel(CallbackInfoReturnable<Float> cir) {
        if(Hacks.XRAYEnabled) cir.setReturnValue(1.0F);
    }
}
