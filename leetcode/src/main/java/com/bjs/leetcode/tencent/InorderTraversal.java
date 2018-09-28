package com.bjs.leetcode.tencent;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> vals = new ArrayList<Integer>();
        inorder(root, vals);
        return  vals;
    }
    void inorder(TreeNode root, List<Integer> vals) {
        if (root==null) return;
        inorder(root.left, vals);
        vals.add(root.val);
        inorder(root.right, vals);
    }
}
