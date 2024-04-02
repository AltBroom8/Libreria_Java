package View;

import Controller.DBManager;

public class Main {
    static Login login;
    static Programa program;
    public static void main(String[] args) {
        System.out.println("Hello world!");
        mostrarLogin();
    }

    public static void mostrarLogin() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DBManager manager = new DBManager();
                login = new Login();
                login.setVisible(true);
            }
        });
    }
    public static void cambioInterfaz(){

        login.setVisible(false);
        program = new Programa();
        program.setVisible(true);
    }
    public static void cambioInterfaz2(){
        program.setVisible(false);
        login = new Login();
        login.setVisible(true);


    }
}