package net.misery.mixin;

import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import net.misery.confighandler.configsList;


// Minecrafts own Math class
@Mixin(MathHelper.class)
public abstract class WackyMath {

    // Affects math for most things
    // These values cant be changed in config
    private static final float[] SINE_TABLE = Util.make(new float[65536], sineTable -> {
        for (int i = 0; i < sineTable.length; ++i) {
            sineTable[i] = (float)Math.sin((double)i * Math.PI * 2.0 / 65536.0);
        }
    });

    // Changes sin to cos
    // Default value: cir.setReturnValue(SINE_TABLE[(int)(value * 10430.378f + 16384.0f) & 0xFFFF]);
    @Inject(at = @At("RETURN"), method = "sin", cancellable = true)
    private static void sin(float value, CallbackInfoReturnable<Float> cir){
        if(configsList.DISABLE_MOD == false){
        cir.setReturnValue(SINE_TABLE[(int)(value * configsList.SIN_VALUE + configsList.COS_VALUE) & 0xFFFF]);
    }else{
        cir.setReturnValue(SINE_TABLE[(int)(value * 10430.378f) & 0xFFFF]);}
    }

    // Changes cos to sin
    // Default value: cir.setReturnValue(SINE_TABLE[(int)(value * 10430.378f) & 0xFFFF]);
    @Inject(at = @At("RETURN"), method = "cos", cancellable = true)
    private static void cos(float value, CallbackInfoReturnable<Float> cir){
        if(configsList.DISABLE_MOD == false){
        cir.setReturnValue(SINE_TABLE[(int)(value * configsList.SIN_VALUE) & 0xFFFF]);
    }else{
        cir.setReturnValue(SINE_TABLE[(int)(value * 10430.378f + 16384.0f) & 0xFFFF]);}
    }

    // Mob head spin go brr
    // Default: end - start
    @Inject(at = @At("RETURN"), method = "subtractAngles", cancellable = true)
    private static void subtractAngles(float start, float end, CallbackInfoReturnable<Float> cir){
        if(configsList.DISABLE_MOD == false){
        cir.setReturnValue(MathHelper.wrapDegrees(start + end));
    }else{
        cir.setReturnValue(MathHelper.wrapDegrees(end - start));}
    }
}
