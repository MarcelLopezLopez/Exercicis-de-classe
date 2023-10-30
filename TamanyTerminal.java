import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TamanyTerminal {
    public static void main(String[] args) throws InterruptedException {
        int columns;
        try {

            EditableBufferedReader.setRaw();

            System.out.print("\033[18t");

            Scanner sc = new Scanner(System.in);

        } finally {

        }
        
        try {
            // Ejecutar el comando "tput cols" para obtener el número de columnas del terminal
            Process process = Runtime.getRuntime().exec(new String[] { "bash", "-c", "tput cols 2>/dev/tty" });

            // Leer la salida del comando
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            if ((line = reader.readLine()) != null) {
                columns = Integer.parseInt(line);
                System.out.println("Número de columnas del terminal: " + columns);
            }

            // Esperar a que el proceso termine
            process.waitFor();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}