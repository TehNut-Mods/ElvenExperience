package tehnut.elvenexperience;

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
import tehnut.elvenexperience.util.EventHandler;

import java.io.File;

@Mod(modid = ModInformation.ID, name = ModInformation.NAME, version = ModInformation.VERSION, dependencies = ModInformation.REQUIRED)
public class BanterTokens {

    @Mod.Instance
    public static BanterTokens instance;

    @SidedProxy(clientSide = ModInformation.CLIENTPROXY, serverSide = ModInformation.COMMONPROXY)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        ConfigHandler.init(new File(event.getModConfigurationDirectory(), ModInformation.NAME + ".cfg"));

        ItemRegistry.registerItems();
        LexiconRegistry.registerLexiconEntries();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        EventHandler eventHandler = new EventHandler();
        FMLCommonHandler.instance().bus().register(eventHandler);
        MinecraftForge.EVENT_BUS.register(eventHandler);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}