package src.edu.hogwarts;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
        app.initApp();
    }
    public void initApp(){
        HogwartsStudent harry = new HogwartsStudent();
        HogwartsStudent ron = new HogwartsStudent();
        HogwartsStudent hermione = new HogwartsStudent();
        HogwartsStudent neville = new HogwartsStudent();

        System.out.println(harry + "" + ron + hermione + neville);

    }
}
