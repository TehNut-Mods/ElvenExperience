package tehnut.elvenexperience.util;

import com.google.common.base.Strings;
import cpw.mods.fml.common.registry.GameData;
import net.minecraft.item.ItemStack;

public class Utils {

    /**
     * Takes a string input with a specific formatting and
     * parses it as an ItemStack.
     *
     * Syntax: domain:regname:meta#amount
     * IE: minecraft:stone:0#8
     *
     * @param stackString - Formatted string
     * @return            - An ItemStack built from the string
     */
    public static ItemStack parseItemStack(String stackString) {
        if (Strings.isNullOrEmpty(stackString))
            return null;

        String[] nameInfo = stackString.split(":");
        String name = nameInfo[0] + ":" + nameInfo[1];
        int meta = nameInfo.length >= 3 ? Integer.parseInt(nameInfo[2]) : 0;

        return new ItemStack(GameData.getItemRegistry().getObject(name), 1, meta);
    }
}
