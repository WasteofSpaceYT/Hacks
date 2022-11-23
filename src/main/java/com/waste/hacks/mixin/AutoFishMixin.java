package com.waste.hacks.mixin;

/*@Mixin(TitleScreen.class)
    @Inject(at = @At("HEAD"), method = "init()V")
    private void init(CallbackInfo info) {
        ExampleMod.LOGGER.info("This line is printed by an example mod mixin!");
    }
}*/

import com.waste.hacks.Hacks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FishingBobberEntity.class)
public abstract class AutoFishMixin {

    @Shadow private boolean caughtFish;

    @Inject(at = @At("TAIL"), method="tick()V")
    private void tick(CallbackInfo info) {
        Hacks.fishCaught = caughtFish;
    }
}
