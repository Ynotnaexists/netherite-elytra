package ynotnaexists.netheriteelytra.mixin.client;


import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ynotnaexists.netheriteelytra.NetheriteElytraFeatureRenderer;

@Mixin(PlayerEntityRenderer.class)
public class PlayerEntityRendererMixin {
	@Inject(method = "<init>", at = @At("TAIL"))
	private void injectCustomElytraFeature(EntityRendererFactory.Context ctx, boolean slim, CallbackInfo ci) {
		((LivingEntityRendererInvoker) this).invokeAddFeature(
				new NetheriteElytraFeatureRenderer((PlayerEntityRenderer) (Object) this, ctx.getModelLoader())
		);
//		this.invokeAddFeature(new NetheriteElytraFeatureRenderer((PlayerEntityRenderer) (Object) this, ctx.getModelLoader()));
	}
}