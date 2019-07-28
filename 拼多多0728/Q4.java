package pinduoduo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer num = sc.nextInt();
        ArrayList<String[]> list = new ArrayList<>();
        int[] wi = new int[num];
        sc.nextLine();
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            String[] stringArray = line.split(" ");
            list.add(stringArray);
        }
        String[] length = list.get(0);
        String[] width = list.get(1);
        for (int i = 0; i < num; i++){
            wi[i] = Integer.parseInt(length[i]) * Integer.parseInt(width[i]);
        }
        System.out.println(calHeight(wi));

    }
    public static int calHeight(int[] wi){
        Arrays.sort(wi);
        int[] dp = new int[wi.length];
        dp[0] = 1;
        for(int i = 1; i < dp.length; i++){
            int sum = 0;
            boolean bool = true;
            for (int j = 0; j < i; j++){
                sum += wi[j];
               if(wi[i]* 7 < sum){
                   dp[i] = Math.max(dp[i - 1] , dp[j] + 1);
                   bool = false;
               }
            }
            if (bool == true) dp[i] = dp[i-1] + 1;
        }
        return dp[wi.length - 1];


    }
}
