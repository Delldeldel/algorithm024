package Week3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LowestCommonAncestor {
    //方法一 根节点递归测试
    private TreeNode acestorNode = null;


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.acestorNode;

    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        // recursion terminator
        if (root == null) return false;
        // process current problem
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        // merge
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            acestorNode = root;

        }
        return lson || rson || (root.val == p.val || root.val == q.val);
        // revert the current level status
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    //方法二：存储父节点
    private Map<Integer, TreeNode> parentMap = new HashMap<>();
    private Set<TreeNode> visited = new HashSet<>();

    public TreeNode lowestCommonAncestorWithHash(TreeNode root, TreeNode p, TreeNode q) {
        this.dfsHash(root);
        while (p != null) {
            visited.add(p);
            p = parentMap.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q)) {
                return q;
            }
            q = parentMap.get(q.val);
        }

        return null;

    }

    private void dfsHash(TreeNode root) {
        if (root.left != null) {
            parentMap.put(root.left.val, root);
            dfsHash(root.left);
        }
        if (root.right != null) {
            parentMap.put(root.right.val, root);
            dfsHash(root.right);
        }
    }

    //方法三 向下递归 返回公共节点
    public TreeNode lowestCommonAncestorGlobal(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestorGlobal(root.left, p, q);
        TreeNode right = lowestCommonAncestorGlobal(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }


}

