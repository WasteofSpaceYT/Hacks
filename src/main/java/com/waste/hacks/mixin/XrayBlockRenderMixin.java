package com.waste.hacks.mixin;

import com.waste.hacks.Hacks;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockRenderView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockRenderManager.class)
public class XrayBlockRenderMixin {

    @Inject(method = "renderBlock", at = @At("HEAD"), cancellable = true)
    public void noRender(BlockState state, BlockPos pos, BlockRenderView world, MatrixStack matrices, VertexConsumer vertexConsumer, boolean cull, Random random, CallbackInfo ci) {
        System.out.println(("beep"));
        if(Hacks.XRAYEnabled && !state.getBlock().getName().getString().contains("ore")){
            ci.cancel();
        }
    }

}
