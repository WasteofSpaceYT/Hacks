package com.waste.hacks;

import com.waste.hacks.mixin.MinecraftClientMixin;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.SliderWidget;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.text.Text;

import com.waste.hacks.client.HacksClient;

public class HackScreen extends Screen {
    protected HackScreen(Text title) {
        super(title);
    }
    private Screen parent;
    public HackScreen(Screen parent) {
        super(Text.literal("Waste Hacks"));
        this.parent = parent;
    }
    public void init() {
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 204, this.height / 4 + 24 + -50, 102, 20, Text.translatable("AutoFish: " + (Hacks.AutoFishEnabled ? "On" : "Off")), (button) -> {
            Hacks.AutoFishEnabled = !Hacks.AutoFishEnabled;
            button.setMessage(Text.literal("AutoFish: " + (Hacks.AutoFishEnabled ? "On" : "Off")));
        }));
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 204, this.height / 4 + 24 + -25, 102, 20, Text.translatable("FlyHack: " + (Hacks.FlyHackEnabled ? "On" : "Off")), (button) -> {
            Hacks.FlyHackEnabled = !Hacks.FlyHackEnabled;
            button.setMessage(Text.literal("FlyHack: " + (Hacks.FlyHackEnabled ? "On" : "Off")));
        }));
        this.addDrawableChild(new SliderWidget(this.width / 2 - 204, this.height / 4 + 24, 102, 20, Text.translatable("Gamma: " + Hacks.Gamma), Hacks.Gamma/10) {
            @Override
            protected void updateMessage() {
                this.setMessage(Text.translatable("Gamma: " + Math.round(value * 10)));
            }

            @Override
            protected void applyValue() {
                Hacks.Gamma = Double.valueOf(Math.round(value*10));
            }
        });
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 204, this.height / 4 + 24 + 25, 102, 20, Text.translatable("X-Ray: " + (Hacks.XRAYEnabled ? "On" : "Off")), (button) -> {
            Hacks.XRAYEnabled = !Hacks.XRAYEnabled;
            if(Hacks.XRAYEnabled) Hacks.Gamma = 10.0;
            button.setMessage(Text.literal("X-Ray: " + (Hacks.XRAYEnabled ? "On" : "Off")));
            MinecraftClient client = MinecraftClient.getInstance();
            client.worldRenderer.reload();
        }));
    }
}
