package in.rohaan;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/*
 * Code for https://stackoverflow.com/questions/66118829/json-object-array-to-pojo
 */
public class JsonObjectArrayToPojo {
    public static class Market{
        public int id;
        public int type;
        public MarketData data;
    }
    public static class MarketData {
        public String name;
    }

    public static void main(String[] args) throws IOException {
        File responseFile = new File(JsonObjectArrayToPojo.class.getResource("/response.json").getFile());
        String response = new String(Files.readAllBytes(responseFile.toPath()));
        ObjectMapper objectMapper = new ObjectMapper();
        Market[] markets = objectMapper.readValue(response, Market[].class);

        System.out.println("marketData length " + markets.length);
        for (Market m :  markets) {
            System.out.printf("\tid: %s", m.id);
            System.out.printf("\ttype: %s", m.type);
            System.out.printf("\tdata name: %s", m.data.name);

            System.out.println();
        }
    }
}
