package pinduoduo;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] firstLine = line.split(" ");
        int taskNum = Integer.parseInt(firstLine[0]), dependencyNum = Integer.parseInt(firstLine[1]);
        String[] secondLine = sc.nextLine().split(" ");
        int[] timeArray = new int[secondLine.length];
        int startIndex = 0;
        for (String s : secondLine)
            timeArray[startIndex++] = Integer.parseInt(s);
        while(sc.hasNextLine()){
            String dependencyLine = sc.nextLine();
            String[] dependencies = dependencyLine.split(" ");

        }

    }

}
