package me.wurgo.antiresourcereload.mixin;

import net.minecraft.resource.LifecycledResourceManager;
import net.minecraft.server.SaveLoader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SaveLoader.class)
public class SaveLoaderMixin {

    @Redirect(method = "close", at = @At(value = "INVOKE", target = "Lnet/minecraft/resource/LifecycledResourceManager;close()V"))
    private void antiresourcereload_keepOpened(LifecycledResourceManager instance) {}

}
