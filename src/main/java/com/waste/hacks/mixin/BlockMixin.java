package com.waste.hacks.mixin;

import com.waste.hacks.Hacks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public abstract class BlockMixin implements ItemConvertible
{

    @Inject(at = @At("HEAD"), method = "shouldDrawSide", cancellable = true)
    private static void shouldDrawSide(BlockState state, BlockView world, BlockPos pos, Direction side, BlockPos otherPos, CallbackInfoReturnable<Boolean> cir)
    {
        if (Hacks.XRAYEnabled)
        {
            Identifier identifier = Registry.BLOCK.getId(state.getBlock());
            cir.setReturnValue((identifier.toString().contains("ore") || identifier.toString().contains("debris")) && world.getBlockState(pos.add(side.getVector())) != state);
        }
    }
}