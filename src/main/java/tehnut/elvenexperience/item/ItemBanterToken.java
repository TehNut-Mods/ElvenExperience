package tehnut.elvenexperience.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import tehnut.elvenexperience.ModInformation;
import tehnut.elvenexperience.registry.ItemRegistry;
import vazkii.botania.api.BotaniaAPI;

public class ItemBanterToken extends Item {

    public ItemBanterToken() {
        super();

        setUnlocalizedName(ModInformation.ID + ".token");
        setTextureName("Botania:rune0");
        setMaxStackSize(16);
        setCreativeTab(CreativeTabs.tabMisc);
        BotaniaAPI.registerManaInfusionRecipe(new ItemStack(ItemRegistry.token), new ItemStack(Items.book), 100);
    }
}
