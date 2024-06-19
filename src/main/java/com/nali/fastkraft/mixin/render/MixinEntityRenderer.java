package com.nali.fastkraft.mixin.render;

import net.minecraft.client.renderer.EntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EntityRenderer.class)
public abstract class MixinEntityRenderer
{
    @Shadow private float farPlaneDistance;

    @Overwrite
    private void setupFog(int startCoords, float partialTicks)
    {

    }

    @Redirect(method = "setupCameraTransform", at = @At(value = "FIELD", target = "Lnet/minecraft/client/renderer/EntityRenderer;farPlaneDistance:F", ordinal = 0))
    private void setupCameraTransform(EntityRenderer instance, float value)
    {
        this.farPlaneDistance = 64 * 16;
    }
}
