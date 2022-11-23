package com.waste.hacks.mixin;

import com.waste.hacks.Hacks;
import net.fabricmc.fabric.impl.client.indigo.renderer.render.TerrainRenderContext;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TerrainRenderContext.class)
public class TerrainGenerationMixin {
    @Inject(at = @At("HEAD"), method = "tessellateBlock", cancellable = true)
    private void tessellateBlock(BlockState blockState, BlockPos blockPos, BakedModel model, MatrixStack matrixStack, CallbackInfoReturnable<Boolean> cir) {
        if (Hacks.XRAYEnabled)
        {
            Identifier identifier = Registry.BLOCK.getId(blockState.getBlock());
            System.out.println(identifier);
            //if (!XrayClient.BLOCKS.contains(identifier)) cir.cancel();
        }
    }
}
