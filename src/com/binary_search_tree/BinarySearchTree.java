package com.binary_search_tree;

/*
@GS Create a binary search tree.
Implement a function to 1) insert a new node 2) search for a given node. 3) calculate height of a binary tree 4) check if a tree is height balanced.
 */
public class BinarySearchTree {

    public static void main(String[] args) {
        Node root = new Node(35);
        Node right = new Node(45);
        Node left = new Node(25);
        root.right = right;
        root.left = left;
        root.left.left = new Node(22);
        root.left.left.left = new Node(18);

        int data = 55;
        System.out.println(Node.insert(root, data).data);
        System.out.println(Node.search(root, 55).data);
        System.out.println(Node.getHeight(root));
        System.out.println(Node.isBalanced(root));
    }

    private static class Node {
        int data;
        Node right;
        Node left;

        Node(int d) {
            data = d;
        }

        public static boolean isBalanced(Node root) {
            if (root == null) {
                return true;
            }
            int right = getHeight(root.right);
            int left = getHeight(root.left);
            if (Math.abs(right - left) <= 1 && isBalanced(root.right) && isBalanced(root.left)) {
                return true;
            }
            return false;
        }

        static int getHeight(Node root) {
            if (root == null) {
                return -1;
            }
            int right_height, left_height;
            right_height = getHeight(root.right);
            left_height = getHeight(root.left);
            return Integer.max(right_height, left_height) + 1;
        }

        static Node insert(Node root, int d) {
            // identify a leaf node.
            if (root == null) {
                root = new Node(d);
                return root;
            }
            // keep root node unchanged.
            if (d < root.data) {
                root.left = insert(root.left, d);
            } else {
                root.right = insert(root.right, d);
            }
            return root;
        }

        static Node search(Node node, int d) {
            if (node == null || node.data == d) {
                return node;
            }
            Node n;
            if (d > node.data) {
                n = search(node.right, d);
            } else {
                n = search(node.left, d);
            }
            return n;
        }


    }
}
