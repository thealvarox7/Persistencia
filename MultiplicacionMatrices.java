package org.example;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MultiplicacionMatrices {
    public static void main(String[] args) {
        String matriz1File = "matriz1.txt";
        String matriz2File = "matriz2.txt";
        String resultadoFile = "resultado.txt";

        try {
            int[][] matriz1 = leerMatriz(matriz1File);
            int[][] matriz2 = leerMatriz(matriz2File);
            int[][] resultado = multiplicarMatrices(matriz1, matriz2);
            escribirMatriz(resultado, resultadoFile);
            System.out.println("La multiplicación de matrices se ha completado. El resultado se ha guardado en el archivo '" + resultadoFile + "'.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer o escribir archivos.");
            e.printStackTrace();
        }
    }

    public static int[][] leerMatriz(String archivo) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(archivo));
        String linea;
        int filas = 0;
        int columnas = 0;

        // Contar el número de filas y columnas en el archivo
        while ((linea = reader.readLine()) != null) {
            filas++;
            String[] elementos = linea.trim().split("\\s+");
            columnas = elementos.length;
        }

        reader.close();

        int[][] matriz = new int[filas][columnas];

        // Leer los elementos del archivo y guardarlos en la matriz
        reader = new BufferedReader(new FileReader(archivo));
        int fila = 0;

        while ((linea = reader.readLine()) != null) {
            String[] elementos = linea.trim().split("\\s+");
            for (int columna = 0; columna < elementos.length; columna++) {
                matriz[fila][columna] = Integer.parseInt(elementos[columna]);
            }
            fila++;
        }

        reader.close();

        return matriz;
    }

    public static void escribirMatriz(int[][] matriz, String archivo) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                writer.write(matriz[i][j] + " ");
            }
            writer.newLine();
        }

        writer.close();
    }

    public static int[][] multiplicarMatrices(int[][] matriz1, int[][] matriz2) {
        int filasMatriz1 = matriz1.length;
        int columnasMatriz1 = matriz1[0].length;
        int filasMatriz2 = matriz2.length;
        int columnasMatriz2 = matriz2[0].length;

        int[][] resultado = new int[filasMatriz1][columnasMatriz2];

        for (int i = 0; i < filasMatriz1; i++) {
            for (int j = 0; j < columnasMatriz2; j++) {
                for (int k = 0; k < columnasMatriz1; k++) {
                    resultado[i][j] += matriz1[i][k] * matriz2[k][j];
                }
            }
        }

        return resultado;
    }
}
