package org.example;

import java.util.LinkedList;

import static org.example.GenerateRandomNumbersDistExponentielle.generateRandomNumbers;

public class MatrixApproach {

    public static LinkedList<Double>[][][][] matrixApproach(int[] dataSizes, double[] means, double[] variances) {
        // Initialiser les matrices pour stocker les LinkedList de nombres aléatoires générés
        LinkedList<Double>[][][][] randomNumbersMatrices = new LinkedList[dataSizes.length][means.length][variances.length][];

        // Générer des nombres aléatoires pour chaque combinaison de moyenne, variance et taille de données
        for (int i = 0; i < dataSizes.length; i++) {
            for (int j = 0; j < means.length; j++) {
                for (int k = 0; k < variances.length; k++) {
                    randomNumbersMatrices[i][j][k] = new LinkedList[]{generateRandomNumbers(dataSizes[i], means[j], variances[k])};
                }
            }
        }
        return randomNumbersMatrices;
    }

}
