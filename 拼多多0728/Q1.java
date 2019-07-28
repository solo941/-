package pinduoduo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<int[]> list = new ArrayList<>();
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String[] lineStringArray = line.split(",");
            int[] intArray = Arrays.stream(lineStringArray).mapToInt(Integer::parseInt).toArray();
            for (String s : lineStringArray)
                Integer.parseInt(s);
            list.add(intArray);
        }
        String result = strictSort(list.get(0),list.get(1));
        System.out.println(result);

    }
    private static String strictSort(int[] A, int [] B){
        if(A == null || B == null ||A.length < 2 || B.length == 0) return "No";
        int lengthA = A.length;
        int lengthB = B.length;
        int replace = B[0];
        int pre = 0, cur = 1;
        while(A[cur] > A[pre] && cur < lengthA){
            pre++;
            cur++;
        }
        if(cur == lengthA - 1){
            for (int i = 0; i < lengthB; i++)
                replace = B[i] > replace ? B[i] : replace;
            if (replace > A[pre]) A[cur] = replace;
            else return "No";
        }
        else{
            for (int i = 0; i < lengthB; i++)
                if(B[i] <= A[pre] || B[i] >= A[cur + 1]) continue;
                else replace = B[i] > replace ? B[i] : replace;
            if (replace > A[pre] && replace < A[cur + 1]) A[cur] = replace;
            else return "No";
        }
        return Arrays.toString(A);
    }
}
