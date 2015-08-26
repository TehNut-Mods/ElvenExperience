package tehnut.elvenexperience;

import com.google.gson.GsonBuilder;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import tehnut.elvenexperience.proxy.CommonProxy;
import tehnut.elvenexperience.registry.ItemRegistry;
import tehnut.elvenexperience.registry.LexiconRegistry;
import tehnut.elvenexperience.util.handler.EventHandler;
import tehnut.elvenexperience.util.serialization.ChallengeCreator;

import java.io.File;

@Mod(modid = ModInformation.ID, name = ModInformation.NAME, version = ModInformation.VERSION, dependencies = ModInformation.REQUIRED)
public class ElvenExperience {

    @Mod.Instance
    public static ElvenExperience instance;

    @SidedProxy(clientSide = ModInformation.CLIENTPROXY, serverSide = ModInformation.COMMONPROXY)
    public static CommonProxy proxy;

    private static File configDir;
    private static GsonBuilder gsonBuilder;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        configDir = new File(event.getModConfigurationDirectory() + "/" + ModInformation.ID);
        configDir.mkdirs();
        ConfigHandler.init(new File(configDir.getPath(), ModInformation.ID + ".cfg"));

        proxy.load();

        ItemRegistry.registerItems();
        LexiconRegistry.registerLexiconEntries();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        EventHandler eventHandler = new EventHandler();
        FMLCommonHandler.instance().bus().register(eventHandler);
        MinecraftForge.EVENT_BUS.register(eventHandler);

        gsonBuilder = new GsonBuilder();
        File challengeFile = new File(configDir, "CustomChallenges.json");
        if (!challengeFile.exists())
            ChallengeCreator.writeDefaultFile(challengeFile);
        ChallengeCreator.registerCustomSerializers(gsonBuilder);
        ChallengeCreator.createChallengesFromJson(gsonBuilder, new File(configDir, challengeFile.getName()));
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}