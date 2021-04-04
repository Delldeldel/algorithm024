package week9;

public class SortUtils {
    public static void BubbleSort(int[] arrayay) {
        int len = arrayay.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (arrayay[j] > arrayay[j+1]) {        // 相邻元素两两对比
                    int temp = arrayay[j+1];        // 元素交换
                    arrayay[j+1] = arrayay[j];
                    arrayay[j] = temp;
                }
            }
        }
    }
    public static void SelectionSort(int[] array) {
        int len = array.length;
        int minIndex, temp;
        for (int i = 0; i < len - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (array[j] < array[minIndex]) {     // 寻找最小的数
                    minIndex = j;                 // 将最小数的索引保存
                }
            }
            temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    public static void InsertionSort(int[] array) {
        int len = array.length;
        int preIndex, current;
        for (int i = 1; i < len; i++) {
            preIndex = i - 1;
            current = array[i];
            while (preIndex >= 0 && array[preIndex] > current) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
    }
}
