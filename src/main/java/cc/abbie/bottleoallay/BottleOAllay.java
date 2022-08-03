package cc.abbie.bottleoallay;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class BottleOAllay implements ModInitializer {
    public static final Item BOTTLE_O_ALLAY = new BottleOAllayItem();

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new ResourceLocation("bottleoallay", "bottleoallay"), BOTTLE_O_ALLAY);
    }
}
