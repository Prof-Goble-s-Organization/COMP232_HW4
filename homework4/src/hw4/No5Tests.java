package hw4;

import static org.junit.Assert.*;
import hw4.COMP232LinkedBinaryTree.BTNode;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

public class No5Tests {
    private static Random rnd = new Random();

    @Test
    public void testInOrderTraversal() {
        for (int trial = 0; trial < 100; trial++) {
            String[] keys = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                            "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
                            "W", "X", "Y", "Z" };
            ArrayList<Integer> values = new ArrayList<Integer>();
            for(int i = 0; i < keys.length; i++) {
                values.add(i);
            }

            COMP232LinkedBinaryTree<String, Integer> tree = new COMP232LinkedBinaryTree<>(keys, values.toArray(new Integer[] {}));

            int rems = rnd.nextInt(5);
            for(int i = 0; i < rems; i++) {
                int rind = rnd.nextInt(keys.length);
                String rkey = keys[rind];
                tree.remove(rkey);
            }

            // System.out.println(tree.size());

            KeyStringVisitor<String, Integer> v = new KeyStringVisitor<String, Integer>();
            tree.visitInOrder(v);
            String hwSolnInOrder = v.getKeys();
            String corredInOrder = getKeysInOrder(tree.root);

            assertEquals("Incorrect inorder traversal", hwSolnInOrder, corredInOrder);
        }
    }

    private String getKeysInOrder(BTNode<String, Integer> root) {
        if (root != null) {
            String keys = getKeysInOrder(root.left);
            keys = keys + root.key;
            keys = keys + getKeysInOrder(root.right);
            return keys;
        } else {
            return "";
        }
    }

    private static class KeyStringVisitor<K, V> implements COMP232Visitor<K, V> {
        private String list;

        public KeyStringVisitor() {
            list = "";
        }

        public void visit(K key, V value) {
            list = list + key;
        }

        public String getKeys() {
            return list;
        }
    }
}
