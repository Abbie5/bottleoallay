package cc.abbie.bottleoallay;

import eu.pb4.polymer.api.item.PolymerSpawnEggItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class BottleOAllay implements ModInitializer {
    public static final Item BOTTLE_O_ALLAY = new BottleOAllayItem();

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new ResourceLocation("bottleoallay", "bottleoallay"), BOTTLE_O_ALLAY);
    }
}
