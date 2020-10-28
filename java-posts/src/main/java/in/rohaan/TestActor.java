package in.rohaan;

public class TestActor {
    private String name;
    private String address;
    private int age;

    public TestActor() {  }

    public TestActor(String s, String g, int p) {
        this.name = s;
        this.address = g;
        this.age = p;
    }

    public void setName(String s) {
        name = s;
    }

    public void setAddress(String g) {
        address = g;
    }

    public void printAct() {
        System.out.println("The actor's name is " + name + " and age is " + age + ". They live in " + address);
    }

    public void setAge(int p) {
        age = p;
    }

    public String toString() {
        return "The actor's name is " + name + " and age is " + age + ". They live in " + address;
    }

}