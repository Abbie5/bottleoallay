package cc.abbie.bottleoallay;

import eu.pb4.polymer.api.item.PolymerItemUtils;
import eu.pb4.polymer.api.item.PolymerSpawnEggItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantments;

public class BottleOAllayItem extends PolymerSpawnEggItem {
    public BottleOAllayItem() {
        super(
                EntityType.ALLAY,
                Items.GLASS_BOTTLE,
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

    @Override
    public ItemStack getPolymerItemStack(ItemStack itemStack, ServerPlayer player) {
        ItemStack out = PolymerItemUtils.createItemStack(itemStack, player);
        out.enchant(Enchantments.FISHING_SPEED, 0);
        return out;
    }

}
