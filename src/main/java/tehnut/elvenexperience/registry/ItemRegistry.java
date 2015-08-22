package tehnut.elvenexperience.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import tehnut.elvenexperience.item.ItemBanterToken;

public class ItemRegistry {

    public static Item token;

    public static void registerItems() {
        token = new ItemBanterToken();
        GameRegistry.registerItem(token, token.getClass().getSimpleName());
    }
}
