package in.rohaan;

/*
 * Code for https://stackoverflow.com/questions/66986563
 */
public class ReplaceSpecialChar {
    public static void main(String[] args) {
        String input = "bOcfAzr@}Cl~Aa@pO}p@zIgW|TkJjSoW|Ysk@nD}o@zQeRdN_@jAyYvs@{zA~mCce@~x@{\\\\t]gi@jUce@fBmm@gO\\\\";
        System.out.println("input: " + input);
        String replaced = input.replace("\\\\", "\\");
        System.out.println(replaced);
    }
}
