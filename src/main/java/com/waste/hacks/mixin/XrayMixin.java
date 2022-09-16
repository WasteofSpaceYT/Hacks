package com.waste.hacks.mixin;

/*@Mixin(TitleScreen.class)
    @Inject(at = @At("HEAD"), method = "init()V")
    private void init(CallbackInfo info) {
        ExampleMod.LOGGER.info("This line is printed by an example mod mixin!");
    }
}*/

import com.waste.hacks.Hacks;
import com.waste.hacks.client.HacksClient;
import net.fabricmc.fabric.impl.blockrenderlayer.BlockRenderLayerMapImpl;
import net.fabricmc.fabric.impl.client.indigo.renderer.render.BlockRenderInfo;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import com.waste.hacks.client.HacksClient;

public abstract class XrayMixin {

    private static void shouldDrawFace(Direction face, CallbackInfoReturnable<Boolean> cir) {
        if(Hacks.XRAYEnabled){
            BlockRenderLayerMapImpl.INSTANCE.putBlock(block, RenderLayer.getTranslucent());
        }
    }
}
