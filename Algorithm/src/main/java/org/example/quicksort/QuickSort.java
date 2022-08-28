package org.example.quicksort;

/**
 * shuffle the array before sort
 * pick pivot randomly
 *
 * ==> quick select, in place
 */
public class QuickSort {

  public int[] quickSort(int[] array) {
    quickSort(array, 0, array.length-1);
    return array;
  }

  public void quickSort(int[] array, int left, int right) {
    if(left >= right) return;
    int pivot = partition(array, left, right);
    quickSort(array, left, pivot - 1);
    quickSort(array, pivot + 1, right);
  }

  public int partition(int[] array, int left, int right) {
    int pivot = array[right], wall = left;

    for(int i=left; i<right; i++) {
      if(array[i] < pivot) {
        swap(array, i, wall);
        wall++;
      }
    }
    swap(array, wall, right);
    return wall;
  }

  public void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

}
