package org.Basic;

public class OneDimensionalArray {
    static int[] dummyArray = {9, 1, 8, 2, 7, 3, 6, 4, 5};
    static int[] SortedDummyArray = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};

    public static void main(String[] args) {
        int index = interpolationSearch(SortedDummyArray, 16);
        System.out.println(index);
    }

    public static int linearSearch(int[] array, int value){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value)
                return i;
        }
        return -1;
    }

    public static int binarySearch(int[] array, int target){
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int value = array[middle];

            System.out.println("middle value: " + value);

            if(value < target) left = middle + 1;
            else if(value > target) right = middle - 1;
            else return middle;
        }
        return -1;
    }


    //tham khảo tại https://freetuts.net/tim-kiem-noi-suy-interpolation-search-2922.html
//    Chúng ta sẽ sử dụng công thức tìm phần tử chính giữa của tập theo cách tìm kiếm Binary Search:
//      Search = left + (right - left) * 1/2
//    Trong công thức trên chúng ta sẽ thay giá trị 1/2 bằng biểu thức sau:
//      (X - T[left]) / (T[right] - T[left])
//    Sau khi thay biểu thức vào công thức sẽ được công thức mới như sau:
//      Search = left + (X- T[left]) * (right – left) / (T[right] – T[left])
    public static int interpolationSearch(int[] array, int value){
        int left = 0;
        int right = array.length - 1;

        while (value >= array[left] && value <= array[right] && left <= right) {
            int probe = left + (right - left) * (value - array[left]) / (array[right] - array[left]);
            System.out.println("probe: " + probe);
            if(array[probe] == value) {
                return probe;
            }
            else if(array[probe] < value) {
                left = probe + 1;
            }
            else {
                right = probe - 1;
            }
        }
        return -1;
    }

    public static void bubbleSort(int[] array){
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j <array.length - i - 1; j++){
                if (array[j] > array[j+1]) {
                    int temp = array [j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
    }

    public static void selectionSort(int[] array){
        for (int i = 0; i < array.length - 1; i++){
            int min = i;
            for (int j = i + 1; j < array.length; j++){
                if(array[min] < array[j]){
                    min = j;
                }
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }

    public static void insertionSort(int[] array) {
        for(int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }

    //Recursion: đệ quy

    //**************** mergeSort ****************
    public static void mergeSort(int[] array){
        int length = array.length;
        if (length <= 1) return;

        int middle = length/2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];

        int i = 0;//left array
        int j = 0;//right array

        for(; i < length; i++){
            if(i < middle) {
                leftArray[i] = array[i];
            }
            else{
                rightArray[j] = array[i];
                j++;
            }
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, array);
    }

    public static void merge(int[] leftArray, int[] rightArray, int[] array){

        int leftSize = array.length/2;
        int rightSize = array.length/2;
        int i = 0, l = 0, r = 0; //indices

        //check the conditions for merging
        while (l < leftSize && r < rightSize) {
            if(leftArray[l] < rightArray[r]) {
                array[i] = leftArray[l];
                i++;
                l++;
            }
            else {
                array[i] = rightArray[r];
                i++;
            }
        }

        while(l < leftSize) {
            array[i] = leftArray[l];
            i++;
            l++;
        }

        while(r < rightSize) {
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }

    //**************** QuickSort ****************
    public static void quickSort(int[] array, int start, int end) {
        if(end <= start) return; //base case
        int pivot = partition(array, start, end);
        quickSort(array, start, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    public static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start - 1;

        for (int j = start; j <= end - 1; j++){
            if (array[i] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        i++;
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;
        return i;
    }
}