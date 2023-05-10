package activities;

import java.util.Arrays;

public class Activity4 {

        static void ascendingSort(int array[]) {
            int size = array.length, i;

            for (i = 1; i < size; i++) {
                int key = array[i];
                int j = i - 1;

                while (j >= 0 && key < array[j]) {
                    array[j + 1] = array[j];
                    --j;
                }
                array[j + 1] = key;
            }
        }

        public static void main(String args[]) {
            int[] input = { 8, 2, 0, 6, 15, 10, 9, 11 };
            System.out.println("Input array: "+  Arrays.toString(input));
            ascendingSort(input);
            System.out.println("Sorted Array in Ascending Order: ");
            System.out.println(Arrays.toString(input));
        }
    }

