package com.Liulishuo;

import java.util.*;

public class minLengthCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(createHuffman(s));

    }
    public static int createHuffman(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0;i<chars.length;i++){
            if(map.containsKey(chars[i])){
                map.put(chars[i], map.get(chars[i]) + 1);
            }
            else{
                map.put(chars[i], 1);
            }
        }
        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>(map.size(), new Comparator<HuffmanNode>() {
            @Override
            public int compare(HuffmanNode o1, HuffmanNode o2) {
                return o1.weight - o2.weight;
            }
        });
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            queue.offer(new HuffmanNode(entry.getValue(), entry.getKey()));
        }
        while(queue.size() > 1){
            HuffmanNode leftNode = queue.poll();
            HuffmanNode rightNode = queue.poll();
            HuffmanNode fatherNode = new HuffmanNode(leftNode.weight + rightNode.weight);
            fatherNode.left = leftNode;
            fatherNode.right = rightNode;
            queue.offer(fatherNode);
        }
        HuffmanNode root = queue.poll();
        return getLength(root, 0);

    }
    public static int getLength(HuffmanNode node, int depth) {
        if(node == null){
            return 0;
        }
        return (node.ch == null ? 0:node.weight)*depth + getLength(node.left, depth+1) + getLength(node.right,
                depth+1);
    }
}
class HuffmanNode{
    int weight;
    HuffmanNode left;
    HuffmanNode right;
    Character ch;
    public HuffmanNode(int weight) {
        super();
        this.weight = weight;
    }
    public HuffmanNode(int weight, char ch) {
        super();
        this.weight = weight;
        this.ch = ch;
    }
}
