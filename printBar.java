import java.io.*;

public class printBar {
    public static void main(String[] args){
        int maxCol = 0;
        try{
            Process processCols = Runtime.getRuntime().exec("tput cols");
            BufferedReader readCols = new BufferedReader(new InputStreamReader(processCols.getInputStream()));
            String sCols = readCols.readLine();
            maxCol = Integer.parseInt(sCols);
        } catch (IOException e){
            System.out.println("Error");
        }
        System.out.println("Max cols: " + maxCol);
    }
}
