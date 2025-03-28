package ed.lab;

import java.util.ArrayList;

public class E01FlattenBT {
    private void preOrder(TreeNode<Integer> root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.value);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    private void buildFlatTree(TreeNode<Integer> root, ArrayList<Integer> inorder) {
        TreeNode<Integer> node = root;
        for (int i = 1; i < inorder.size(); i++) {
            node.left = null;
            node.right = new TreeNode<>(inorder.get(i));
            node = node.right;
        }
    }

    public void flatten(TreeNode<Integer> root) {

        ArrayList<Integer> inorder = new ArrayList<>();
        preOrder(root, inorder);

        buildFlatTree(root, inorder);
    }

}
