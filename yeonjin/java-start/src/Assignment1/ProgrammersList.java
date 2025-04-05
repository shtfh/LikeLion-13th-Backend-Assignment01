package Assignment1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ProgrammersList {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];

        return switch (n) {
            case 1 -> Arrays.copyOfRange(num_list, 0, b + 1);
            case 2 -> Arrays.copyOfRange(num_list, a, num_list.length);
            case 3 -> Arrays.copyOfRange(num_list, a, b + 1);
            case 4 -> sliceWithStep(num_list, a, b, c);
            default -> new int[0]; // 예외 처리용
        };
    }


    private int[] sliceWithStep(int[] arr, int start, int end, int step) {
        List<Integer> result = new ArrayList<>();
        for (int i = start; i <= end; i += step) {
            result.add(arr[i]);
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
