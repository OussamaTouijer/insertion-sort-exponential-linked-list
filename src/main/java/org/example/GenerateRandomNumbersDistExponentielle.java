package org.example;
import org.apache.commons.math3.distribution.ExponentialDistribution;

import java.util.LinkedList;

public class GenerateRandomNumbersDistExponentielle {

    // Méthode pour générer une LinkedList de nombres aléatoires selon une distribution exponentielle avec une moyenne et une variance spécifiées
    public static LinkedList<Double> generateRandomNumbers(int dataSize, double mean, double variance) {
        LinkedList<Double> randomNumbersList = new LinkedList<>();
        ExponentialDistribution exponentialDistribution = new ExponentialDistribution(mean);
        for (int i = 0; i < dataSize; i++) {
            randomNumbersList.add(exponentialDistribution.sample());
        }
        return randomNumbersList;
    }
}
