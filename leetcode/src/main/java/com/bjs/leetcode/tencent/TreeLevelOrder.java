package com.bjs.leetcode.tencent;

import java.util.*;

public class TreeLevelOrder {
    public static void main(String[] args) {
        TreeNode v0 = new TreeNode(0);
        TreeNode v1 = new TreeNode(1);
        TreeNode v2 = new TreeNode(2);
        TreeNode v3 = new TreeNode(3);
        TreeNode v4 = new TreeNode(4);
        TreeNode v5 = new TreeNode(5);

        v0.left =v1;
        v0.right = v2;

        v1.left = v3;
        v1.right = v4;
        v2.left = v5;

        printTree(v0);
    }
    public  static  List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        inorder(root,result);
        if (root!=null){
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            result.add(list);
        }
        Collections.reverse(result);
        return result;
    }
    private static void inorder(TreeNode root, List<List<Integer>> vals) {
        boolean flag = false;
        List<Integer> list = new ArrayList<>();
        if (root==null) return;
        if (root.left != null) {
            flag = true;
            list.add(root.left.val);
            inorder(root.left,vals);
        }
        if (root.right != null) {
            flag = true;
            list.add(root.right.val);
            inorder(root.right,vals);
        }
        if (flag){
            vals.add(list);
        }
    }

    public static void printTree(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode last = root;
        TreeNode nlast = root;
        while (!queue.isEmpty()){
            TreeNode t = queue.peek();
            System.out.print(queue.poll().val);
            if(t.left!=null){
                queue.add(t.left);
                nlast = t.left;
            }
            if(t.right!=null){
                queue.add(t.right);
                nlast = t.right;
            }
            if(last!=null&&t!=null &&last.val == t.val){
                System.out.println("ss");
                last = nlast;
            }
        }
    }
}
