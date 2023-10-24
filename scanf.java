import java.util.Scanner;
import java.util.ArrayList;

class scanf {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<>();

        System.out.print("Pon numeros hasta el '0' ");

        int numero;
        do{
            System.out.print("Introduce numeros ya: ");
            numero = scanner.nextInt();

            if(numero != 0){
                numeros.add(numero);
            }
        } while(numero != 0);
            
        System.out.println("Numeros ingresados: ");

        for(int num : numeros) {
            System.out.println(num);
        }
        
        scanner.close();
    }
}