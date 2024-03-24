package org.example;

import java.io.*;
import java.util.LinkedList;

public class FilesSort {

    // Méthode pour lire les données à partir d'un fichier CSV et les stocker dans une LinkedList
    public static LinkedList<Double> readCSV(String directory, String filename) throws IOException {
        LinkedList<Double> data = new LinkedList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(directory+filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                double value = Double.parseDouble(line.trim());
                data.add(value);
            }
        }

        return data;
    }

    // Méthode pour écrire les données d'une LinkedList dans un fichier CSV dans un répertoire spécifique
    public static void writeCSV(LinkedList<Double> data, String directory, String filename) throws IOException {
        // Vérifie si le répertoire existe, s'il n'existe pas, le crée
        File dir = new File(directory);
        if (!dir.exists()) {
            if (!dir.mkdirs()) {
                throw new IOException("Could not create directory: " + directory);
            }
        }

        // Écriture des données dans le fichier CSV
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(directory + "/" + filename))) {
            for (Double value : data) {
                writer.write(value.toString());
                writer.newLine();
            }
        }
    }

    // Méthode pour convertir les données en meilleur cas en utilisant l'algorithme d'insertion
    public static void convertingDataToBestCase(String directoryGenerate, String directoryBestCase, String name_File_of_data_average_case, String name_File_of_data_best_case) throws IOException {
        LinkedList<Double> linkedList = readCSV(directoryGenerate, name_File_of_data_average_case);
        LinkedlistInsertionSort.insertionSort(linkedList);
        writeCSV(linkedList, directoryBestCase, name_File_of_data_best_case);
    }

    // Méthode pour convertir les données en pert cas en utilisant l'algorithme d'insertion
    public static void convertingDataToWorstCase(String directoryGenerate, String directoryBestCase, String name_File_of_data_average_case, String name_File_of_data_best_case) throws IOException {
        LinkedList<Double> linkedList = readCSV(directoryGenerate, name_File_of_data_average_case);
        LinkedlistInsertionSort.insertionSortDescending(linkedList);
        writeCSV(linkedList, directoryBestCase, name_File_of_data_best_case);
    }


    /*
    public static void convertingDataToBestCaseEnd(String directoryGenerate, String directoryBestCase, String name_File_of_data_average_case, String name_File_of_data_best_case) throws IOException {
        LinkedList<Double> linkedList = readCSV(directoryGenerate, name_File_of_data_average_case);
        LinkedlistInsertionSort.insertionSort(linkedList);
        writeCSV(linkedList, directoryBestCase, name_File_of_data_best_case);
    }
*/


    // Méthode pour calculer le temps d'exécution de l'algorithme de tri pour une liste donnée
    public static long calculeTimeOfSort(String name_of_csv, String directoryGenerate) {
        long time = -1;
        try {
            LinkedList<Double> dataList = readCSV(directoryGenerate, name_of_csv);
            long t0 = System.nanoTime();
            LinkedlistInsertionSort.insertionSort(dataList);
            long t1 = System.nanoTime();
            time = (t1 - t0) / 1000000;

        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier CSV : " + e.getMessage());
        }
        return time;
    }


}
