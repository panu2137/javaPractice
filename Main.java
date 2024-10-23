import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {
    public static int[] liczZnakiSlowa(String nazwaPliku) {
        int liczbaZnakow = 0;
        int liczbaBialych = 0;
        int liczbaSlow = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(nazwaPliku))) {
            String linia;

            while ((linia = br.readLine()) != null) {
                liczbaZnakow += linia.length();

                for (char znak : linia.toCharArray()) {
                    if (Character.isWhitespace(znak)) {
                        liczbaBialych++;
                    }
                }
                String[] slowa = linia.trim().split("\\s+");
                if (slowa.length > 0 && !slowa[0].isEmpty()) {
                    liczbaSlow += slowa.length;
                }
            }
        } catch (IOException e) {
            System.err.println("Wystąpił błąd podczas odczytu pliku: " + e.getMessage());
            return null;
        }

        return new int[]{liczbaZnakow, liczbaBialych, liczbaSlow};
    }
    public static void zad1(String plik){
        String nazwaPliku = plik;
        int[] wyniki = liczZnakiSlowa(nazwaPliku);

        if (wyniki != null) {
            System.out.println("Liczba znaków: " + wyniki[0]);
            System.out.println("Liczba białych znaków: " + wyniki[1]);
            System.out.println("Liczba słów: " + wyniki[2]);
        }
    }
    public static void main(String[] args) {
        zad1("C:\\Users\\PE\\IdeaProjects\\untitled3\\src\\plik.txt");
    }
}