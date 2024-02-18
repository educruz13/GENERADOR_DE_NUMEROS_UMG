import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GeneradorDeNumeros {
    public static void main(String[] args) {
        generarYGuardarNumeros();
        ordenarYGuardarNumeros("numeros.txt", "numeros_ordenados.txt");
        System.out.println("Se han generado, ordenado y guardado los números.");
    }

    private static void generarYGuardarNumeros() {
        Random random = new Random();
        int min = -10000000;
        int max = 10000000;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("numeros.txt"))) {
            for (int i = 0; i < 20000000; i++) {
                int num = random.nextInt(max - min + 1) + min;
                writer.write(String.valueOf(num));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void ordenarYGuardarNumeros(String archivoEntrada, String archivoSalida) {
        List<Integer> numeros = leerNumeros(archivoEntrada);
        Collections.sort(numeros);
        guardarNumeros(numeros, archivoSalida);
    }

    private static List<Integer> leerNumeros(String archivo) {
        List<Integer> numeros = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                numeros.add(Integer.parseInt(linea));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numeros;
    }

    private static void guardarNumeros(List<Integer> numeros, String archivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(archivo))) {
            for (int num : numeros) {
                writer.println(num);
            }
        } catch (IOException e) {
            e.printStackTrace();
}
        }
    }
