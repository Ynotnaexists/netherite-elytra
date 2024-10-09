package ynotnaexists.netheriteelytra.item;

import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.Equipment;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class NetheriteElytraItem extends ElytraItem implements Equipment {
    public NetheriteElytraItem(Settings settings) {
        super(settings);
    }
    @Override
    public EquipmentSlot getSlotType() {
        return EquipmentSlot.CHEST;
    }
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        ItemStack chestItem = ((LivingEntity) entity).getEquippedStack(EquipmentSlot.CHEST);
        if (chestItem.isOf(ModItems.NETHERITE_ELYTRA)) {
            modifyKnockback((LivingEntity) entity, 0.5F, "amor.elytra");
        }
    }

    public void modifyKnockback (LivingEntity entity, float knockback, String path) {
        EntityAttributeInstance attributeInstance = entity.getAttributeInstance(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE);
        if (attributeInstance != null) {
            // Remove any existing modifier with the same UUID to avoid stacking
//            attributeInstance.removeModifier(EntityAttributeModifier.);
            // Add the new modifier
            attributeInstance.addTemporaryModifier(
                new EntityAttributeModifier(Identifier.of("netheriteelytra", path), knockback, EntityAttributeModifier.Operation.ADD_VALUE)
            );
        }
//
//
//        AttributeModifierSlot attributeModifierSlot = AttributeModifierSlot.forEquipmentSlot(EquipmentSlot.CHEST);
//        AttributeModifiersComponent.Builder builder = AttributeModifiersComponent.builder();
//        builder.add(
//                EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE,
//                new EntityAttributeModifier(Identifier.of("netheriteelytra", path), (double) knockback, EntityAttributeModifier.Operation.ADD_VALUE),
//                attributeModifierSlot
//        );
    }
}