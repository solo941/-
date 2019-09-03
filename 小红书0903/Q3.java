package com.smallredbook;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Q3 {
    public static List<Point> a = new ArrayList<>();
    public static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int [][] boxes = new int[n][n];
        int startX = 0,startY = 0;
        for (int i = 0; i < n; i++){
            String s = sc.nextLine();
            for (int j = 0; j < n; j++){
                if ((s.charAt(j)=='.'))
                    boxes[i][j] = 1;
                if ((s.charAt(j)=='#'))
                    boxes[i][j] = 2;
                if ((s.charAt(j)=='S')){
                    boxes[i][j] = 0;
                    startX = i;
                    startY = j;
                }
                if ((s.charAt(j)=='E')){
                    boxes[i][j] = -1;
                }
            }
        }
        a.add(new Point(-1,0));
        a.add(new Point(1,0));
        a.add(new Point(0,1));
        a.add(new Point(0,-1));
        dp = new int[n][n];
        searchMinLength(boxes,startX,startY,new LinkedList<Point>());
    }

    private static void searchMinLength(int[][] boxes, int startX, int startY, LinkedList<Point> q) {
        int count = 0;
        q.add(new Point(startX,startY));
        int n = boxes.length;
        boolean isFinished = false;
        boxes[startX][startY] = 2;
        while (!q.isEmpty()){
            Point startPoint = q.poll();
            for (int i = 0; i< a.size(); i++){
                Point p = a.get(i);
                if (boxes[(startPoint.x + p.x + n) % n][(startPoint.y + p.y + n) % n] == -1){
                    System.out.println(dp[startPoint.x][startPoint.y] + 1);
                    isFinished = true;
                    break;
                }
                if (boxes[(startPoint.x + p.x + n) % n][(startPoint.y + p.y + n) % n] != 2){
                    q.add(new Point((startPoint.x + p.x + n) % n,(startPoint.y + p.y + n) % n ));
                    boxes[(startPoint.x + p.x + n) % n][(startPoint.y + p.y + n) % n] = 2;
                    dp[(startPoint.x + p.x + n) % n][(startPoint.y + p.y + n) % n] = dp[startPoint.x][startPoint.y] + 1;
                }
            }
            if (isFinished) break;
        }
        if (!isFinished)
            System.out.println(-1);
    }
}
