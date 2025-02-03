package part6;

import java.io.*;
import java.util.*;

public class TreeHL {
    static class Node {
        int num;
        int parent;
        int left;
        int right;

        public Node(int num, int left, int right) {
            this.num = num;
            this.left = left;
            this.right = right;
            this.parent = -1;
        }
    }

    static Node[] tree;
    static int[] max, min;
    static int idx, maxLevel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        tree = new Node[N + 1];
        max = new int[N + 1];
        min = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            tree[i] = new Node(i, -1, -1);
            max[i] = 0;
            min[i] = N + 1;
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            tree[num].left = left;
            tree[num].right = right;

            if (left > 0) {
                tree[left].parent = num;
            }
            if (right > 0) {
                tree[right].parent = num;
            }
        }

        int root = 0;
        for (int i = 1; i < N + 1; i++) {
            if (tree[i].parent == -1) {
                root = i;
            }
        }

        idx = 1;
        maxLevel = 0;
        inOrder(root, 1);

        int ansLevel = 0;
        int ansWidth = 0;
        for (int i = 1; i <= maxLevel; i++) {
            int width = max[i] - min[i] + 1;
            if (ansWidth < width) {
                ansLevel = i;
                ansWidth = width;
            }
        }

        System.out.println(ansLevel + " " + ansWidth);
    }

    private static void inOrder(int num, int level) {
        Node node = tree[num];

        if (node.left > 0) {
            inOrder(node.left, level + 1);
        }

        maxLevel = Math.max(maxLevel, level);
        max[level] = Math.max(max[level], idx);
        min[level] = Math.min(min[level], idx);
        idx++;

        if (node.right > 0) {
            inOrder(node.right, level + 1);
        }
    }

}





