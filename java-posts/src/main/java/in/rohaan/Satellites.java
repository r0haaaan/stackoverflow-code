package in.rohaan;

/*
 * Code for https://stackoverflow.com/questions/66105548/
 */
public enum Satellites implements CelestialBody {
    CALLISTO(1.07593e+23, 2.410e+3),
    MOON(7.34767309e+22, 1.7371e+3),
    EUROPA(4.79984e+22, 1.5608e+3),
    DIONE(1.095552e+21,5.614e+2);

    private final double mass;
    private final double radius;

    Satellites(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }

    /**
     * Wrapper around CelestialBody.surfaceGravity() delegates Surface gravity
     * related calculation to implementation in parent interface
     *
     * @return double value for Surface Gravity
     */
    public double surfaceGravity() {
        return surfaceGravity(mass, radius);
    }
}
