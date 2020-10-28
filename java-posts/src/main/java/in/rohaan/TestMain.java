package in.rohaan;

public class TestMain {
    public static void main(String[] args) {
        TestActor[] actor = new TestActor[2];
        //Actor act1 = new Actor(" ", " ", 0);
actor[0] = new TestActor("Jack Nicholson", "Miami.", 74);
actor[0].printAct();
actor[0] = new TestActor();
actor[0].setName("Jack Nicholson");
actor[0].setAddress("Miami.");
actor[0].setAge(74);
actor[0].printAct();

    }
}
