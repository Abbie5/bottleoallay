package cc.abbie.bottleoallay.mixin;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.allay.Allay;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static cc.abbie.bottleoallay.BottleOAllay.BOTTLE_O_ALLAY;

@Mixin(Allay.class)
public class AllayMixin {
    @Inject(method = "mobInteract", at = @At("HEAD"), cancellable = true)
    private void captureAllay(Player player, InteractionHand interactionHand, CallbackInfoReturnable<InteractionResult> cir) {
        ItemStack playerItemStack = player.getItemInHand(interactionHand);
        if (playerItemStack.is(Items.GLASS_BOTTLE)) {
            Allay allay = ((Allay) (Object) this);

            if (allay.isLeashed()) allay.dropLeash(true, true);
            allay.fallDistance = 0;
            CompoundTag tag = new CompoundTag();
            allay.saveAsPassenger(tag);
            tag.remove("Pos");

            playerItemStack.shrink(1);
            ItemStack bottle = new ItemStack(BOTTLE_O_ALLAY);
            CompoundTag bottleTag = new CompoundTag();
            bottleTag.put("EntityTag", tag);
            bottle.setTag(bottleTag);

            player.getInventory().placeItemBackInInventory(bottle);

            allay.remove(Entity.RemovalReason.DISCARDED);
            cir.setReturnValue(InteractionResult.SUCCESS);
        }
    }
}
