package tehnut.elvenexperience.util.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tehnut.elvenexperience.registry.ItemRegistry;
import tehnut.elvenexperience.util.helper.BanterHelper;
import vazkii.botania.api.recipe.ElvenPortalUpdateEvent;

import java.util.List;

public class EventHandler {

    @SubscribeEvent
    @SuppressWarnings("unchecked")
    public void elvenUpdate(ElvenPortalUpdateEvent event) {
        List<ItemStack> inventory = event.stacksInside;
        World world = event.portalTile.getWorldObj();
        List<EntityPlayer> players = world.getEntitiesWithinAABB(EntityPlayer.class, event.aabb.expand(15, 5, 15));

        if (inventory.isEmpty())
            return;

        for (ItemStack stack : inventory) {
            if (stack.getItem() == ItemRegistry.token) {
                inventory.remove(stack);
                BanterHelper.doWittyMessage(players);
                break;
            }
        }
    }
}
