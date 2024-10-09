package ynotnaexists.netheriteelytra.mixin.client;

import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(LivingEntityRenderer.class)
public interface LivingEntityRendererInvoker <T extends LivingEntity, M extends EntityModel<T>> {
    @Invoker("addFeature")
    public boolean invokeAddFeature(FeatureRenderer<T, M> feature);
}
