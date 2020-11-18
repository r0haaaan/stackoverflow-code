package in.rohaan;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * Code for https://stackoverflow.com/questions/64870391
 */
public class WritingJsonToFile {
    private static class Record {
        private String purpose, id, updateTime, checkIn;

        public Record(String purpose, String id, String updateTime, String checkIn) {
            this.purpose = purpose;
            this.id = id;
            this.updateTime = updateTime;
            this.checkIn = checkIn;
        }

        public JSONObject toJSON() {
            JSONObject jo = new JSONObject();
            jo.put("purpose", this.purpose);
            jo.put("id", this.id);
            jo.put("updateTime", this.id);
            jo.put("checkIn", this.id);

            return jo;
        }
    }

    public static void main(String[] args) throws IOException {
        Record[] myRecords = {
                new Record("Medical", "1", "2020-10-14", "2020-10-14"),
                new Record("Pharma", "2", "2020-10-14", "2020-10-14"),
                new Record("Security", "3", "2020-10-14", "2020-10-14"),
        };

        JSONArray jsonArr = new JSONArray();
        Arrays.stream(myRecords).forEach(r -> jsonArr.put(r.toJSON()));
        for (int i = 0; i < jsonArr.length(); i++) {
            JSONObject jsonObj = jsonArr.getJSONObject(i);
            try (FileWriter file = new FileWriter("NewFile.json", true)) {
                file.write(jsonObj.toString());
            }
        }

        try (FileWriter file2 = new FileWriter("NewFileCompleteArr.json", true)) {
            file2.write(jsonArr.toString());
        }
    }
}
