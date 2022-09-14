package com.waste.hacks;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.Vec3d;

public class FlyHack {
    public static float speed = 3;
    public static float acceleration = 0.1f;
    public static float FallSpeed = 0.04f;
    public static int toggle = 40;
    public static void tick(MinecraftClient client){
        if(client.player != null && Hacks.FlyHackEnabled){
            boolean forward = client.options.forwardKey.isPressed();
            boolean back = client.options.backKey.isPressed();
            boolean left = client.options.leftKey.isPressed();
            boolean right = client.options.rightKey.isPressed();
            boolean up = client.options.jumpKey.isPressed();
            Vec3d velocity = client.player.getVelocity();
            Vec3d newVelocity = new Vec3d(velocity.x, -FallSpeed, velocity.z);
            if(up){
                if(forward){
                    newVelocity = client.player.getRotationVector().multiply(acceleration);
                }
                if(back){
                    newVelocity = client.player.getRotationVector().negate().multiply(acceleration);
                }
                newVelocity = new Vec3d(newVelocity.x, (toggle == 0 && newVelocity.y >FallSpeed) ? FallSpeed : speed , newVelocity.z);
                if(forward || left || right || back){
                    if(acceleration<speed){
                        acceleration += 0.1f;
                    } else if (acceleration > 0.2){
                        acceleration -= 0.2f;
                    }
                }
                if(toggle == 0 || newVelocity.y <= -0.04){
                    toggle = 40;
                }
                toggle--;
                client.player.setVelocity(newVelocity);
            }
        }
    }
}