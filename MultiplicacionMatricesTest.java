package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class MultiplicacionMatricesTest {

    @Test
    public void testMultiplicacionMatrices() throws IOException {
        int[][] matriz1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] matriz2 = {{7, 8}, {9, 10}, {11, 12}};
        int[][] expected = {{58, 64}, {139, 154}};

        int[][] resultado = MultiplicacionMatrices.multiplicarMatrices(matriz1, matriz2);

        Assertions.assertArrayEquals(expected, resultado);
    }
}
