package src.edu.hogwarts.application;

public class Application {

    public static void main(String[] args) {
        var app = new Application();
        app.start();
    }

    public void start() {
        var InitApp = new InitApp();
        InitApp.initApp();
    }
}
