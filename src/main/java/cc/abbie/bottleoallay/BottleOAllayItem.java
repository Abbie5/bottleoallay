package cc.abbie.bottleoallay;

import eu.pb4.polymer.api.item.PolymerSpawnEggItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class BottleOAllayItem extends PolymerSpawnEggItem {
    public BottleOAllayItem() {
        super(
                EntityType.ALLAY,
                Items.EXPERIENCE_BOTTLE,
                new FabricItemSettings().group(CreativeModeTab.TAB_MISC).stacksTo(1)
        );
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        InteractionResult result = super.useOn(useOnContext);
        if (result == InteractionResult.CONSUME) {
            useOnContext.getPlayer().getInventory().placeItemBackInInventory(new ItemStack(Items.GLASS_BOTTLE));
        }
        return result;
    }
}
