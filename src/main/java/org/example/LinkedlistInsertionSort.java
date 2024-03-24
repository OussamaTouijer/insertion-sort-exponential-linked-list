package org.example;

import java.util.LinkedList;

public class LinkedlistInsertionSort {
    public static LinkedList<Double> insertionSort(LinkedList<Double> list) {
        int n = list.size();
        for (int i = 1; i < n; ++i) {
            Double key = list.get(i);
            int j = i - 1;

            // Déplacer les éléments de la liste[0..i-1], qui sont plus grands que la clé,
            // vers une position avant leur position actuelle
            while (j >= 0 && list.get(j) > key) {
                list.set(j + 1, list.get(j));
                j = j - 1;
            }
            list.set(j + 1, key);
        }
        return list;
    }

    public static LinkedList<Double> insertionSortDescending(LinkedList<Double> list) {
        int n = list.size();
        for (int i = 1; i < n; ++i) {
            Double key = list.get(i);
            int j = i - 1;

            // Déplacer les éléments de la liste[0..i-1], qui sont plus petits que la clé,
            // vers une position après leur position actuelle
            while (j >= 0 && list.get(j) < key) {
                list.set(j + 1, list.get(j));
                j = j - 1;
            }
            list.set(j + 1, key);
        }
        return list;
    }

    public static void main(String[] args) {
        // Créer une liste non triée
        LinkedList<Double> list = new LinkedList<>();
        list.add(12.);
        list.add(11.);
        list.add(13.);
        list.add(5.);
        list.add(6.);

        System.out.println("LinkedList non triée : " + list);

        // Trier la liste avec le tri par insertion
        LinkedList<Double> sortedList = insertionSort(list);

        System.out.println("LinkedList triée : " + sortedList);

        LinkedList<Double> sortedList1 = insertionSortDescending(list);

        System.out.println("LinkedList triée : " + sortedList1);
    }
}

