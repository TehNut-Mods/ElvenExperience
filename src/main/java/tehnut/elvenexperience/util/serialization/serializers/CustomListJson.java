package tehnut.elvenexperience.util.serialization.serializers;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import vazkii.botania.client.challenge.Challenge;
import vazkii.botania.client.challenge.ModChallenges;

import java.lang.reflect.Type;
import java.util.List;

public class CustomListJson implements JsonDeserializer<List<Challenge>> {

    @Override
    public List<Challenge> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        List<Challenge> list = context.deserialize(json.getAsJsonObject().get("challenges"), new TypeToken<List<Challenge>>() {
        }.getType());

        for (Challenge challenge : list)
            ModChallenges.addChallenge(challenge.level, challenge.unlocalizedName, challenge.icon);

        return list;
    }
}
