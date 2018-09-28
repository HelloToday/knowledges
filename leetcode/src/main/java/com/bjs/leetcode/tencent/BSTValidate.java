package com.bjs.leetcode.tencent;

import java.util.ArrayList;
import java.util.List;

public class BSTValidate {
    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        if (root==null) return true;


        List<Integer> vals = new ArrayList<Integer>();
        inorder(root, vals);
        for (int i = 0; i < vals.size() - 1; ++i) {
            if (vals.get(i) >= vals.get(i+1)) return false;
        }
        return true;
    }

    void inorder(TreeNode root, List<Integer> vals) {
        if (root==null) return;
        inorder(root.left, vals);
        vals.add(root.val);
        inorder(root.right, vals);
    }
}
