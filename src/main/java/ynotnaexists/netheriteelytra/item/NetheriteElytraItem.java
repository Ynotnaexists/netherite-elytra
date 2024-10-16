package ynotnaexists.netheriteelytra.item;

import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.Equipment;
import net.minecraft.util.Identifier;

public class NetheriteElytraItem extends ElytraItem implements Equipment {
    public NetheriteElytraItem(Settings settings) {
        super(settings);
    }
    @Override
    public EquipmentSlot getSlotType() {
        return EquipmentSlot.CHEST;
    }

    public static AttributeModifiersComponent createKnockbackModifier(float knockback, String path) {
        return AttributeModifiersComponent.builder()
            .add(
                    EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE,
                    new EntityAttributeModifier(Identifier.of("netheriteelytra", path), knockback, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.CHEST
            )
            .build();

    }
}