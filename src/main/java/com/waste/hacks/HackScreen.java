package com.waste.hacks;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

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
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 102, this.height / 4 + 24 + -16, 204, 20, Text.translatable("AutoFish: " + (Hacks.AutoFishEnabled ? "On" : "Off")), (button) -> {
            Hacks.AutoFishEnabled = !Hacks.AutoFishEnabled;
            button.setMessage(Text.literal("AutoFish: " + (Hacks.AutoFishEnabled ? "On" : "Off")));
        }));
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 102, this.height / 4 + 24, 204, 20, Text.translatable("FlyHack: " + (Hacks.FlyHackEnabled ? "On" : "Off")), (button) -> {
            Hacks.FlyHackEnabled = !Hacks.FlyHackEnabled;
            button.setMessage(Text.literal("FlyHack: " + (Hacks.FlyHackEnabled ? "On" : "Off")));
        }));
    }
}
