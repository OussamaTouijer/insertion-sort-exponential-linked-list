package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class Main {

    public static void appendToCSV(String fileName, long timeOfSort) {
        String txt = " Time taken to sort " + fileName + ": " + timeOfSort + " milliseconds";
        String csvFileName = "resultaTimeOfsort/sort_times.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFileName, true))) {
            writer.write(txt);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        // Définir les moyennes, les variances et les tailles de données
        double[] means = {1.0, 2.0, 3.0};
        double[] variances = {0.25, 0.5, 0.75};
        int[] dataSizes = {100, 200, 500};

        LinkedList<Double>[][][][] result = MatrixApproach.matrixApproach(dataSizes, means, variances);

        // Affichage des résultats pour vérification
        for (int i = 0; i < dataSizes.length; i++) {
            for (int j = 0; j < means.length; j++) {
                for (int k = 0; k < variances.length; k++) {
                    System.out.println("Data size: " + dataSizes[i] + ", Mean: " + means[j] + ", Variance: " + variances[k]);
                    System.out.println("Generated numbers: " + result[i][j][k][0]);
                }
            }
        }

        // Appel de la méthode pour écrire la matrice dans des fichiers CSV
        FileWrite.writeMatrixToCSV(result, dataSizes, means, variances);

        // Écriture des données générées dans des fichiers CSV individuels et mesure du temps de tri
        for (int i = 0; i < dataSizes.length; i++) {
            for (int j = 0; j < means.length; j++) {
                for (int k = 0; k < variances.length; k++) {
                    String directoryGenerate = "D:/alg/ProjectReda/GenerateDadaFiles/";
                    String directoryBestCase = "D:/alg/ProjectReda/BestCaseFiles/"; // Remplacez ce chemin par le répertoire où vous souhaitez stocker les fichiers triés en meilleur cas
                    String fileName = "results_datasize_" + dataSizes[i] + "_mean_" + means[j] + "_variance_" + variances[k] + ".csv";
                    String fileNameBest = "SortBestresults_datasize_" + dataSizes[i] + "_mean_" + means[j] + "_variance_" + variances[k] + ".csv";
                    FilesSort.convertingDataToBestCase(directoryGenerate+fileName, directoryBestCase,fileNameBest);
                    long timeOfSort = FilesSort.calculeTimeOfSort(directoryGenerate+fileName);


                    // Créer le répertoire s'il n'existe pas
                    File directory = new File("resultaTimeOfsort");
                    if (!directory.exists()) {
                        directory.mkdirs();
                    }
                    appendToCSV(fileName, timeOfSort);

                }
            }
        }
    }
    }
