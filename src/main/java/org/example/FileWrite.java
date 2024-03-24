package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class FileWrite {

    // Méthode pour écrire une matrice de nombres aléatoires dans des fichiers CSV
    // Chaque fichier est nommé en fonction de la taille des données, de la moyenne et de la variance
    public static void writeMatrixToCSV(LinkedList<Double>[][][][] randomNumbersMatrices, int[] dataSizes, double[] means, double[] variances) {
        // Création du dossier pour stocker les fichiers s'il n'existe pas
        File directory = new File("DadaAverageCaseFiles");
        if (!directory.exists()) {
            directory.mkdirs(); // Crée le répertoire et ses parents s'ils n'existent pas
        }

        for (int i = 0; i < dataSizes.length; i++) {
            for (int j = 0; j < means.length; j++) {
                for (int k = 0; k < variances.length; k++) {
                    String fileName = "results_datasize_" + dataSizes[i] + "_mean_" + means[j] + "_variance_" + variances[k] + ".csv";
                    File file = new File(directory, fileName);
                    try {
                        // Création d'un FileWriter et d'un PrintWriter pour écrire dans le fichier CSV
                        FileWriter fileWriter = new FileWriter(file);
                        PrintWriter printWriter = new PrintWriter(fileWriter);

                        // Récupération de la liste de nombres aléatoires à partir de la matrice
                        LinkedList<Double> randomNumbersList = randomNumbersMatrices[i][j][k][0];

                        // Écriture de chaque nombre aléatoire dans le fichier
                        for (Double randomNumber : randomNumbersList) {
                            printWriter.println(randomNumber);
                        }

                        // Fermeture du PrintWriter après l'écriture dans le fichier
                        printWriter.close();
                        System.out.println("File '" + file.getAbsolutePath() + "' created successfully.");
                    } catch (IOException e) {
                        // En cas d'erreur lors de l'écriture dans le fichier, une exception est levée
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

/*
    //tous les donne dans la meme fichier
    public static void writeMatrixToCSVEnd(LinkedList<Double>[][][][] randomNumbersMatrices, int[] dataSizes, double[] means, double[] variances) {
        // Création du dossier pour stocker les fichiers s'il n'existe pas
        File directory = new File("GenerateDataFileEnd");
        if (!directory.exists()) {
            directory.mkdirs(); // Crée le répertoire et ses parents s'ils n'existent pas
        }

        String fileEnd = "resultsEnd.csv";
        File file = new File(directory, fileEnd);

        LinkedList<Double> randomNumbersList = new LinkedList<>();

        // Parcours des différentes dimensions des matrices
        for (int i = 0; i < dataSizes.length; i++) {
            for (int j = 0; j < means.length; j++) {
                for (int k = 0; k < variances.length; k++) {
                    // Récupération de la liste de nombres aléatoires à partir de la matrice
                    LinkedList<Double> currentList = randomNumbersMatrices[i][j][k][0];
                    // Ajout des éléments de cette liste à la liste globale
                    randomNumbersList.addAll(currentList);
                }
            }
        }

        try {
            // Création d'un FileWriter et d'un PrintWriter pour écrire dans le fichier CSV
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // Écriture de chaque nombre aléatoire dans le fichier
            for (Double randomNumber : randomNumbersList) {
                printWriter.println(randomNumber);
            }

            // Fermeture du PrintWriter après l'écriture dans le fichier
            printWriter.close();
            System.out.println("File '" + file.getAbsolutePath() + "' created successfully.");
        } catch (IOException e) {
            // En cas d'erreur lors de l'écriture dans le fichier, une exception est levée
            throw new RuntimeException(e);
        }
    }

 */
}
