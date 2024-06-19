//package com.nali.fastkraft.mixin.render;
//
//import net.minecraft.entity.Entity;
//import net.minecraftforge.fml.relauncher.Side;
//import net.minecraftforge.fml.relauncher.SideOnly;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Redirect;
//
//@Mixin(Entity.class)
//public abstract class MixinEntity
//{
//    @Redirect(method = "isInRangeToRender3d", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;isInRangeToRenderDist(D)Z"))
//    @SideOnly(Side.CLIENT)
//    public boolean isInRangeToRender3d(Entity instance, double distance)
//    {
//        double d0 = this.posX - x;
//        double d1 = this.posY - y;
//        double d2 = this.posZ - z;
//        double d3 = d0 * d0 + d1 * d1 + d2 * d2;
//        return this.isInRangeToRenderDist(d3);
//    }
//}
