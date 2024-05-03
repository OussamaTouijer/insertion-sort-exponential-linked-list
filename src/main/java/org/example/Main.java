package org.example;

import org.example.FilesSort;
import org.example.MatrixApproach;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.nio.file.Files; // Import pour Files

public class Main {


    public static void appendToCSV(String fileName, String fileNameBest, String fileNameWorst, double timeOfSortAverage, double timeOfSortBest, double timeOfSortWorst) {
        String csvFileName = "resultaTimeOfsort/sort_times.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFileName, true))) {
            // Écriture des temps de tri dans le fichier CSV
            writer.write("Average Time taken to sort " + fileName + ": " + timeOfSortAverage + " milliseconds");
            writer.newLine();
            writer.write("Best Time taken to sort " + fileNameBest + ": " + timeOfSortBest + " milliseconds");
            writer.newLine();
            writer.write("Worst Time taken to sort " + fileNameWorst + ": " + timeOfSortWorst + " milliseconds");
            writer.newLine();
            writer.write("********************************************************************************\n");
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void visualise(String fileName, double timeOfSortAverage, double timeOfSortBest, double timeOfSortWorst) {
        String csvFileName = "resultaTimeOfsort/chart.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFileName, true))) {
            // Écriture des temps de tri dans le fichier CSV
            writer.write(  fileName + " : " +"averageCase : "+ timeOfSortAverage + " ms " +"bestCase : "+ timeOfSortBest + " ms " + "worstCase : "+timeOfSortWorst + " ms ");
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

        // Appel de la méthode pour écrire la matrice dans des fichiers CSV
         FileWrite.writeMatrixToCSV(result, dataSizes, means, variances); // Assurez-vous d'implémenter ou d'importer cette méthode correctement

        // Écriture des données générées dans des fichiers CSV individuels et mesure du temps de tri
        for (int i = 0; i < dataSizes.length; i++) {
            for (int j = 0; j < means.length; j++) {
                for (int k = 0; k < variances.length; k++) {
                    String directoryGenerate = "D:/alg/insertion-sort-exponential-linked-list/DadaAverageCaseFiles/";
                    String directoryBestCase = "D:/alg/insertion-sort-exponential-linked-list/DadaBestCaseFiles/";
                    String directoryWorstCase = "D:/alg/insertion-sort-exponential-linked-list/DadaWorstCaseFiles/";

                    String fileName = "results_datasize_" + dataSizes[i] + "_mean_" + means[j] + "_variance_" + variances[k] + ".csv";
                    String fileNameBest = "Bestresults_datasize_" + dataSizes[i] + "_mean_" + means[j] + "_variance_" + variances[k] + ".csv";
                    String fileNameWorst = "Worstresults_datasize_" + dataSizes[i] + "_mean_" + means[j] + "_variance_" + variances[k] + ".csv";
                     FilesSort.convertingDataToBestCase(directoryGenerate, directoryBestCase, fileName, fileNameBest); // Assurez-vous d'implémenter ou d'importer cette méthode correctement
                     FilesSort.convertingDataToWorstCase(directoryGenerate, directoryWorstCase, fileName, fileNameWorst); // Assurez-vous d'implémenter ou d'importer cette méthode correctement
                     double timeOfSortAverage = FilesSort.calculeTimeOfSort(fileName, directoryGenerate); // Assurez-vous d'implémenter ou d'importer cette méthode correctement
                     double timeOfSortBest = FilesSort.calculeTimeOfSort(fileNameBest, directoryBestCase); // Assurez-vous d'implémenter ou d'importer cette méthode correctement
                     double timeOfSortWorst = FilesSort.calculeTimeOfSort(fileNameWorst, directoryWorstCase); // Assurez-vous d'implémenter ou d'importer cette méthode correctement

                    // Créer le répertoire s'il n'existe pas
                    File directory = new File("resultaTimeOfsort");
                    if (!directory.exists()) {
                        directory.mkdirs();
                    }
                     appendToCSV(fileName,fileNameBest,fileNameWorst,timeOfSortAverage,timeOfSortBest,timeOfSortWorst);
                    String fileName1 = " datasize : " + dataSizes[i] + " mean : " + means[j] + " variance : " + variances[k];

                    visualise(fileName1,timeOfSortAverage,timeOfSortBest,timeOfSortWorst);

                }
            }
        }
    }
}
