package pinduoduo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] lineStringArray = sc.nextLine().split(" ");
        System.out.println(IsCircle(lineStringArray));
    }
    private static boolean IsCircle(String[] stringArray){
        for (int i =0; i < stringArray.length; i++){
            ArrayList<String> list = new ArrayList<>();
            for (String s : stringArray) list.add(s);
            list.remove(i);
            if(IsCircleAsFirst(stringArray[i],list)) return true;
        }
        return false;
    }
    private static boolean IsCircleAsFirst(String s, List<String> stringList){
        if(stringList.size() == 0) return true;
        char C = s.charAt(s.length() - 1);
        for (int i = 0; i < stringList.size(); i++){
            if (C == stringList.get(i).charAt(0)){
                ArrayList<String> newList = new ArrayList(stringList);
                newList.remove(i);
                if (IsCircleAsFirst(stringList.get(i), newList)) return true;
            }
        }
        return false;
    }
}
