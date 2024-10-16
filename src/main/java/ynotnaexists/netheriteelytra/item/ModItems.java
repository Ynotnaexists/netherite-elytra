package ynotnaexists.netheriteelytra.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import ynotnaexists.netheriteelytra.NetheriteElytra;

public class ModItems {


    public static final Item NETHERITE_ELYTRA = registerItem("netherite_elytra", new NetheriteElytraItem(
            new Item.Settings().maxDamage(472).rarity(Rarity.EPIC).fireproof().attributeModifiers(NetheriteElytraItem.createKnockbackModifier(0.1f, "amor.elytra"))));

    private static Item registerItem(String name, Item item) {
        registerModItems();
        return Registry.register(Registries.ITEM, Identifier.of(NetheriteElytra.MOD_ID, name), item);
    }
    public static void registerModItems() {
        NetheriteElytra.LOGGER.info("Registering Mod Items for " + NetheriteElytra.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addToFoodAndDrinkTab);
    }
    public static void addToFoodAndDrinkTab(FabricItemGroupEntries entries) {
        entries.add(ModItems.NETHERITE_ELYTRA.asItem());
    }

}
