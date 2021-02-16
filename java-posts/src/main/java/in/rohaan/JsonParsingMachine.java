package in.rohaan;

import java.io.File;
import java.nio.file.Files;

import org.json.*;

/*
 * Code for https://stackoverflow.com/questions/66203728
 */
public class JsonParsingMachine {

    public static void main(String[] args) {
        File inputFile = new File(JsonParsingMachine.class.getResource("/input-json.json").getFile());

        try {
            String contents = new String((Files.readAllBytes(inputFile.toPath())));
            JSONObject o = new JSONObject(contents);
            JSONObject quoteResponse = o.getJSONObject("quoteResponse");
            JSONArray res = quoteResponse.getJSONArray("result");

            for (int i = 0; i < res.length(); i++) {
                System.out.println(res.get(i));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}