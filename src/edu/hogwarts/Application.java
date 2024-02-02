package src.edu.hogwarts;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
        app.initApp();
    }
    public void initApp(){
        HogwartsStudent harry = new HogwartsStudent("Harry Potter");
        HogwartsStudent ron = new HogwartsStudent("Ron Weasley");
        HogwartsStudent hermione = new HogwartsStudent("Hermione Granger");
        HogwartsStudent neville = new HogwartsStudent("Neville Longbottom");

        System.out.println(harry + "" + ron + hermione + neville);

    }
}
