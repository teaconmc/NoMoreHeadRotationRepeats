package org.teacon.nmhrr.mixin;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    private @Shadow float yBodyRot;
    private @Shadow float yBodyRotO;

    private @Shadow float yHeadRot;
    private @Shadow float yHeadRotO;

    public LivingEntityMixin(EntityType<?> type, Level level) {
        super(type, level);
    }

    @Inject(method = "tick()V", at = @At(value = "INVOKE_ASSIGN", target = "tickHeadTurn(FF)F"))
    public void onTickHeadTurnAssign(CallbackInfo ignored) {
        var yRot = this.getYRot();
        this.yRotO = yRot - Mth.wrapDegrees(yRot - this.yRotO);
        this.yBodyRotO = this.yBodyRot - Mth.wrapDegrees(this.yBodyRot - this.yBodyRotO);
        var xRot = this.getXRot();
        this.xRotO = xRot - Mth.wrapDegrees(xRot - this.xRotO);
        this.yHeadRotO = this.yHeadRot - Mth.wrapDegrees(this.yHeadRot - this.yHeadRotO);
    }
}
