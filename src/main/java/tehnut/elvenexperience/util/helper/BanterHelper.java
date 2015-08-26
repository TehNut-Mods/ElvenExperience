package tehnut.elvenexperience.util.helper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import tehnut.elvenexperience.ConfigHandler;

import java.util.List;
import java.util.Random;

public class BanterHelper {

    public static void doWittyMessage(List<EntityPlayer> players) {
        Random random = new Random();

        ChatComponentText whisper = new ChatComponentText(StatCollector.translateToLocal("chat.ElvenExperience.banter.whisper").replace("&", "\u00a7"));
        ChatComponentText wittyMessage = new ChatComponentText(ConfigHandler.banterLines[random.nextInt(ConfigHandler.banterLines.length)].replace("&", "\u00a7"));

        for (EntityPlayer player : players) {
            player.addChatComponentMessage(whisper);
            player.addChatComponentMessage(wittyMessage);
        }
    }
}
