import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class EchoClient {

    public static void main(String[] args) {
        // args[0] fara que agafem el primer parametre que li pasem despres d'executar
        // el programa
        // host //port
        MySocket sc = new MySocket(args[0], Integer.parseInt(args[1]));
        // Input threat (keyboard)
        new Thread() {
            public void run() {
                BufferedReader kbd = new BufferedReader(new InputStreamReader(System.in));
                String line;
                try {
                    while ((line = kbd.readLine()) != null) {
                        sc.println(line);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }.start();

        // Output threat (console)
        new Thread() {
            public void run() {
                String line;
                while ((line = sc.readLine()) != null) {
                        System.out.println(line);
                    }
            }
        }.start();

        //Segona manera
        // Output threat (console)
        new Thread(() -> {
            String line;
            while ((line = sc.readLine()) != null) {    
                System.out.println(line);
                }
        }).start();
    }
}
