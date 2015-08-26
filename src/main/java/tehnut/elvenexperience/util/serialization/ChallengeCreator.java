package tehnut.elvenexperience.util.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import tehnut.elvenexperience.util.serialization.serializers.CustomChallengeJson;
import tehnut.elvenexperience.util.serialization.serializers.CustomListJson;
import vazkii.botania.client.challenge.Challenge;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ChallengeCreator {

    public static void registerJsonChallenges(GsonBuilder gsonBuilder, File challengeFile) {
        createChallengesFromJson(gsonBuilder, challengeFile);
    }

    @SuppressWarnings("unchecked")
    public static List<Challenge> createChallengesFromJson(GsonBuilder gsonBuilder, File file) {
        try {
            Gson gson = gsonBuilder.setPrettyPrinting().disableHtmlEscaping().serializeNulls().create();
            return gson.fromJson(new FileReader(file), ArrayList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Stupid shit go!
    public static void writeDefaultFile(File file) {
        try {
            FileWriter writer = new FileWriter(file);
            writer.write("{\n    \"challenges\": [\n\n    ]\n}");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void registerCustomSerializers(GsonBuilder gsonBuilder) {
        gsonBuilder.registerTypeAdapter(ArrayList.class, new CustomListJson());
        gsonBuilder.registerTypeAdapter(Challenge.class, new CustomChallengeJson());
    }

}
