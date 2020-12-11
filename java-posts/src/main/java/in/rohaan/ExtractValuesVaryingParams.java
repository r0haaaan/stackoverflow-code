package in.rohaan;

/*
 * Code for https://stackoverflow.com/questions/65247010 
 */ 
public class ExtractValuesVaryingParams {
    public static class DecryptedKey {
        private String hardwareKey;
        private String[] values;
        private String product;

        public DecryptedKey(String hardwareKey, String[] values, String product) {
            this.hardwareKey = hardwareKey;
            this.values = values;
            this.product = product;
        }

        public static DecryptedKey fromString(String key) {
            String[] parts = key.split(",");
            String[] values = new String[10];

            String hardwareKey = getValueFromEntry(parts[0]);
            String product = getValueFromEntry(parts[parts.length - 1]);
            for (int i = 1; i < parts.length - 1; i++) {
                if (parts[i].startsWith("value")) {
                    int index = parts[i].charAt(5) -'0';
                    values[index] = getValueFromEntry(parts[i]);
                }
            }

            return new DecryptedKey(hardwareKey, values, product);
        }

        private static String getValueFromEntry(String keyAndEntryColonSeparated) {
            String[] parts = keyAndEntryColonSeparated.split(":");
            if (parts.length == 2) {
                return parts[1];
            }
            return null;
        }

        public void print() {
            System.out.println("Hardware Key: " + this.hardwareKey);
            for (int i = 0; i < values.length; i++) {
                System.out.println("Value " + i + " : "+ values[i]);
            }
            System.out.println("Product: " + this.product);
        }
    }

    public static void main(String[] args) {
        String input1 = "hardwareKey:12345,value1:1.1.1.1,value2:false,value3:410000,product:ABC";
        String input2 = "hardwareKey:12345,value4:abcd-123,value5:100,value6:10000,value7:500,product:DEF";

        DecryptedKey d1 = DecryptedKey.fromString(input1);
        DecryptedKey d2 = DecryptedKey.fromString(input2);

        d1.print();
        d2.print();
    }
}
