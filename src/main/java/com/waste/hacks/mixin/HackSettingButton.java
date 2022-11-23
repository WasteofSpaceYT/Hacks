package com.waste.hacks.mixin;
import com.waste.hacks.HackScreen;

import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameMenuScreen.class)
public class HackSettingButton extends Screen {

    protected HackSettingButton(Text title) {
        super(title);
    }

    @Inject(at = @At("HEAD"), method = "initWidgets()V")
    private void initWidgets(CallbackInfo ci) {
        this.addDrawableChild(new ButtonWidget(10, 10, 90, 20, Text.literal("Waste Hacks"), (button) -> {
            this.client.setScreen(new HackScreen(this));
        }));
    }
}
