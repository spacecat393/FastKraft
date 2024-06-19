package com.nali.fastkraft.mixin.render;

import net.minecraft.client.renderer.RenderGlobal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RenderGlobal.class)
public abstract class MixinRenderGlobal
{
//    @Inject(method = "renderBlockLayer(Lnet/minecraft/util/BlockRenderLayer;DILnet/minecraft/entity/Entity;)I", at = @At(value = "HEAD"), cancellable = true)
//    private void nali_fastkraft_renderBlockLayer(BlockRenderLayer blockLayerIn, double partialTicks, int pass, Entity entityIn, CallbackInfoReturnable<Integer> callbackinforeturnable)
//    {
//        //RenderGlobal
//        //ViewFrustum
//        //RenderChunk ChunkCache Chunk
//        callbackinforeturnable.setReturnValue(-1);
//    }

//    @Redirect(method = "setupTerrain", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;setRenderDistanceWeight(D)V"))
//    private void nali_fastkraft_setupTerrain(double renderDistWeight)
//    {
//        Entity.setRenderDistanceWeight(MathHelper.clamp(64 / 8.0D, 1.0D, 2.5D));
//    }

    @Shadow private int renderDistanceChunks;

    @Redirect(method = "loadRenderers", at = @At(value = "FIELD", target = "Lnet/minecraft/client/renderer/RenderGlobal;renderDistanceChunks:I"))
    private void nali_fastkraft_loadRenderers(RenderGlobal instance, int value)
    {
        this.renderDistanceChunks = 64;
    }

    @Redirect(method = "setupTerrain", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/RenderGlobal;loadRenderers()V"))
    private void nali_fastkraft_setupTerrain(RenderGlobal instance)
    {
    }

    @ModifyVariable(method = "renderWorldBorder", at = @At(value = "STORE", ordinal = 3))
    private double nali_fastkraft_renderWorldBorder(CallbackInfo ci)
    {
        return 64 * 16;
    }
}
