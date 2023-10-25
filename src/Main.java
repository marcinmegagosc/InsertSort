import static java.lang.Double.parseDouble;
import static java.lang.Math.random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Sortowanie przez wybór");
        System.out.println("Wybierz: 1. Losowanie Tablicy, 2. Wlasnoręczne dane");
        Scanner scanner = new Scanner(System.in);
        String wybor = scanner.nextLine();
        System.out.println("Wpisz rozmiar tablicy");
        int sizeOfArray = scanner.nextInt();
        double[] doubleArray = new double[sizeOfArray];
        if(wybor.equals("1")) {
            System.out.println("Wybrałeś losowanie tablicy");
            for (int i = 0; i < sizeOfArray; i++) {
                doubleArray[i] = (double) (int) (random() * 10000) / 100;
            }
            insertionSort(doubleArray);
            printArray(doubleArray);
        }

        if(wybor.equals("2")){
            for(int i = 0; i < doubleArray.length;i++){
                System.out.println("Wpisz dane do tablicy: ");
                doubleArray[i] = loadNumber();
            }
            insertionSort(doubleArray);
            printArray(doubleArray);
        }

    }

    public static void printArray(double[] arr) {
        System.out.println("Tablica po sortowaniu:");
        for (double element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }


    public static void insertionSort(double []doubleArray){
        double temp;
        int arrSize = doubleArray.length;
        for(int i=1; i < arrSize; i++){
            temp = doubleArray[i];
            for(int j = i-1; j >= 0; j--){
                if(doubleArray[j] > temp){
                    doubleArray[j+1] = doubleArray[j];
                    doubleArray[j] = temp;
                }
            }
        }

    }


//    public static double loadNumber(Scanner scanner){
//        if(scanner.hasNextDouble()){
//          return scanner.nextDouble();
//        }
//        else System.out.println("To nie jest liczba");
//        return 0;
//    }

    public static double loadNumber(){
        Scanner scanner = new Scanner(System.in);
        String strNumber = scanner.nextLine();
        boolean isNumber = true;
        for(int i = 0; i < strNumber.length(); i++){
            if(strNumber.charAt(i) < 48 || strNumber.charAt(i) > 57){
                System.out.println("To nie jest liczba");
                isNumber = false;
                break;
            }
        }
        if(isNumber){
            return parseDouble(strNumber);
        }else{
            System.out.println("podaj liczbe");
            return loadNumber();
        }
    }

}