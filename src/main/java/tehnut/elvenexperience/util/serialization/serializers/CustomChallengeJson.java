package tehnut.elvenexperience.util.serialization.serializers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import net.minecraft.item.ItemStack;
import tehnut.elvenexperience.util.Utils;
import tehnut.elvenexperience.util.helper.JsonHelper;
import vazkii.botania.client.challenge.Challenge;
import vazkii.botania.client.challenge.EnumChallengeLevel;

import java.lang.reflect.Type;
import java.util.Locale;

public class CustomChallengeJson implements JsonDeserializer<Challenge> {

    @Override
    public Challenge deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonHelper helper = new JsonHelper(json);

        String name = helper.getString("name");
        EnumChallengeLevel level = EnumChallengeLevel.valueOf(helper.getString("level").toUpperCase(Locale.ENGLISH));
        ItemStack icon = Utils.parseItemStack(helper.getString("stack"));

        return new Challenge(name, icon, level);
    }
}
