package com.bjs.leetcode.tencent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreeLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
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
    void inorder(TreeNode root, List<List<Integer>> vals) {
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
}
