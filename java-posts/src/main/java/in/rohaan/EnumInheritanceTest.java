package in.rohaan;

public class EnumInheritanceTest {
    public static void main(String[] args) {
        System.out.println("Moon's surface gravity: " + Satellites.MOON.surfaceGravity());
        System.out.println("Mars's surface gravity: " + Planet.MARS.surfaceGravity());
        System.out.println("Jupiter's surface gravity: " + Planet.JUPITER.surfaceGravity());
    }
}
