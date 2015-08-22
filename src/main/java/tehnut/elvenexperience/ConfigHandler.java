package tehnut.elvenexperience;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler {

    public static Configuration config;

    public static String[] banterLines;
    public static String[] banterLinesDefault = {
            "What do you call an Orc with two brain cells? &oPregnant.&r",
            "How rich is a goblin? &oAs rich as the last to cross his path.&r",
            "Why did the halfling cross the road? &oTo steal the chicken.&r",
            "A half-elf and a cart of fertilizer fell off in the side of the road. &oWe salvaged the fertilizer.&r",
            "How many dwarves does it take to change a light bulb? &oTwo, one to hold the light bulb in place and the other to drink till the room starts to spin.&r",
            "Why did the orc cross the road? &oNo seriously, he forgot.&r",
            "May the Dragon of Life only burn your hotdog and never your buns.",
            "What's the difference between a rock and a gnome? &oWe're still trying to find out.&r",
            "Ogres aren't even worth insulting, I mean, just look at them... It's sad really.",
            "That's the last time we invite dwarves for dinner... Trees are collapsing under their confounded caves, and we can't find our mead.",
            "I heard you saw a kobold recently. &oWe send our consolations.&r",
            "Go ahead. Throw another. It's funny watching you.",
            "I saw a Satyr fall once. Just picture it.",
            "Are you not tired of doing this yet?",
            "You're telling me you went underground? Humans...",
            "I still haven't restrung my bow.",
            "What, were you expecting something witty?"
    };

    public static void init(File file) {
        config = new Configuration(file);
        syncConfig();
    }

    public static void syncConfig() {
        String category;

        category = "Banter";
        config.addCustomCategoryComment(category, "All settings related to having witty banter with the Elves");
        banterLines = config.getStringList("banterLines", category, banterLinesDefault, "As much wit as you can stand.\nThis should match the server's config to work correctly. Changing values on just the client can/will break things. Possibly even crash.\n");

        config.save();
    }
}
