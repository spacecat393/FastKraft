//package com.nali.fastkraft.mixin.render;
//
//import com.nali.Nali;
//import net.minecraft.client.renderer.culling.ICamera;
//import net.minecraft.client.renderer.entity.Render;
//import net.minecraft.client.renderer.entity.RenderManager;
//import net.minecraft.entity.Entity;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Overwrite;
//import org.spongepowered.asm.mixin.Shadow;
//
//import javax.annotation.Nullable;
//
//@Mixin(RenderManager.class)
//public abstract class MixinRenderManager
//{
//    @Shadow @Nullable public abstract <T extends Entity> Render<T> getEntityRenderObject(Entity entityIn);
//
//    @Overwrite
//    public boolean shouldRender(Entity entityIn, ICamera camera, double camX, double camY, double camZ)
//    {
//        Render<Entity> render = this.getEntityRenderObject(entityIn);
//        boolean should_render = render != null && render.shouldRender(entityIn, camera, camX, camY, camZ);
//        Nali.I.logger.info("entityIn " + entityIn);
//        Nali.I.logger.info("should_render " + should_render);
//        return should_render;
//    }
//}
