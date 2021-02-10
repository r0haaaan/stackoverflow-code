package in.rohaan;

/*
 * Code for https://stackoverflow.com/questions/66105548/
 */
public interface CelestialBody {
    double G = 6.67300E-11;

    default double surfaceGravity(double mass, double radius) {
        return G * mass / (radius * radius);
    }

    default double surfaceWeight(double otherMass, double mass, double radius) {
        return otherMass * surfaceGravity(mass, radius);
    }
}
