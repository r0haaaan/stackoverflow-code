package in.rohaan;

/**
 * Code for https://stackoverflow.com/questions/67199737
 */
public class BackSlashToDoubleSlash {
    public static void main(String[] args) {
        String str = "C:\\Program Files\\Text.txt";

        str = str.replace("\\", "\\\\");

        System.out.println(str);
    }
}
