package com.marnex.armorfix.mixins;

import net.minecraft.client.entity.AbstractClientPlayer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import JinRyuu.JBRA.RenderPlayerJBRA;

@Mixin(value = RenderPlayerJBRA.class, remap = false)
public class JBRAdisableInvisCheck {

    @Redirect(
        method = "preRenderCallback(Lnet/minecraft/client/entity/AbstractClientPlayer;F)V",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/client/entity/AbstractClientPlayer;isInvisible()Z"))
    private boolean alwaysVisible(AbstractClientPlayer player) {
        return false;
    }
}
