package com.waste.hacks;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.math.Vec3d;

public class FlyHack {
    public static float speed = 1.0f;
    public static float acceleration = 0.1f;
    public static float FallSpeed = 0.04f;
    public static int toggle = 30;
    public static boolean flying = false;

    public static void tick(MinecraftClient client) {
        if (client.player != null && Hacks.FlyHackEnabled && flying) {
            boolean forward = client.options.forwardKey.isPressed();
            boolean back = client.options.backKey.isPressed();
            boolean left = client.options.leftKey.isPressed();
            boolean right = client.options.rightKey.isPressed();
            boolean up = client.options.jumpKey.isPressed();
            boolean down = client.options.sneakKey.isPressed();
            Vec3d newVelocity;
            Vec3d velocity = client.player.getVelocity();
            if(toggle == 0) {
                newVelocity = new Vec3d(velocity.x, -0.4, velocity.z);
            } else {
                newVelocity = new Vec3d(velocity.x, 0, velocity.z);
            }
            if (up) {
                newVelocity = newVelocity.add(0, speed, 0);
            }
            if(down){
                newVelocity = newVelocity.add(0, -speed/2, 0);
            } if(forward) {
                newVelocity = client.player.getRotationVector().multiply(1.5);
                if(!up && !down) {
                    newVelocity = new Vec3d(newVelocity.x, 0, newVelocity.z);
                } else if(up){
                    newVelocity = new Vec3d(newVelocity.x, speed, newVelocity.z);
                } else if(down){
                    newVelocity = new Vec3d(newVelocity.x, -speed/2, newVelocity.z);
                }
            } else if(back){
                newVelocity = client.player.getRotationVector().multiply(-1.5);
                if(!up && !down) {
                    newVelocity = new Vec3d(newVelocity.x, 0, newVelocity.z);
                } else if(up){
                    newVelocity = new Vec3d(newVelocity.x, speed, newVelocity.z);
                } else if(down){
                    newVelocity = new Vec3d(newVelocity.x, -speed/2, newVelocity.z);
                }
            }
            if(left){
                newVelocity = client.player.getRotationVector().multiply(1.5);
                if(!forward && !back){
                    newVelocity = newVelocity.rotateY((float) Math.toRadians(90));
                } else if(forward){
                    newVelocity = newVelocity.rotateY((float) Math.toRadians(90)).crossProduct(newVelocity).multiply(-1);
                } else if(back) {
                    newVelocity = newVelocity.rotateY((float) Math.toRadians(-90)).crossProduct(newVelocity).multiply(-1);
                }
                if(!up && !down) {
                    newVelocity = new Vec3d(newVelocity.x, 0, newVelocity.z);
                } else if(up){
                    newVelocity = new Vec3d(newVelocity.x, speed, newVelocity.z);
                } else if(down){
                    newVelocity = new Vec3d(newVelocity.x, -speed/2, newVelocity.z);
                }
            } else if(right){
                newVelocity = client.player.getRotationVector().multiply(1.5);
                if(!forward && !back){
                    newVelocity = newVelocity.rotateY((float) Math.toRadians(-90));
                } else if(forward){
                    newVelocity = newVelocity.rotateY((float) Math.toRadians(-90)).crossProduct(newVelocity);

                } else if(back) {
                    newVelocity = newVelocity.rotateY((float) Math.toRadians(90)).crossProduct(newVelocity);
                }
                if(!up && !down) {
                    newVelocity = new Vec3d(newVelocity.x, 0, newVelocity.z);
                } else if(up){
                    newVelocity = new Vec3d(newVelocity.x, speed, newVelocity.z);
                } else if(down){
                    newVelocity = new Vec3d(newVelocity.x, -speed/2, newVelocity.z);
                }
            }

            client.player.getDamageTracker().onDamage(DamageSource.FALL, client.player.defaultMaxHealth, 0);
            client.player.handleFallDamage(0, 0, DamageSource.FALL);
            System.out.println("FallDistance = " + client.player.fallDistance);
            client.player.setOnGround(true);
            if(toggle == 0){
                client.player.setVelocity(newVelocity.x, -0.4, newVelocity.z);
                toggle = 30;
            } else if(toggle == 30){
                client.player.setVelocity(newVelocity.x, 0.4, newVelocity.z);
                toggle--;
            }else {
                client.player.setVelocity(newVelocity);
                toggle--;
            }
        }
    }
}