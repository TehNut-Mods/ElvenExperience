package tehnut.elvenexperience.registry;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.lexicon.LexiconEntry;
import vazkii.botania.api.recipe.RecipeManaInfusion;
import vazkii.botania.common.lexicon.page.PageManaInfusionRecipe;
import vazkii.botania.common.lexicon.page.PageText;

public class LexiconRegistry {
    
    public static void registerLexiconEntries() {
        initBanterToken();
    }
    
    private static void initBanterToken() {
        RecipeManaInfusion recipeManaInfusion = new RecipeManaInfusion(new ItemStack(ItemRegistry.token), new ItemStack(Items.book), 100);
        LexiconEntry entry = new LexiconEntry("lexicon.ElvenExperience.entry.token.name", BotaniaAPI.categoryAlfhomancy);
        entry.setKnowledgeType(BotaniaAPI.elvenKnowledge);
        entry.setIcon(new ItemStack(ItemRegistry.token));
        entry.addPage(new PageText("lexicon.ElvenExperience.entry.token.page.0"));
        entry.addPage(new PageManaInfusionRecipe("lexicon.ElvenExperience.entry.token.page.1", new RecipeManaInfusion(recipeManaInfusion.getOutput(), recipeManaInfusion.getInput(), recipeManaInfusion.getManaToConsume())));

        BotaniaAPI.addEntry(entry, BotaniaAPI.categoryAlfhomancy);
    }
}
