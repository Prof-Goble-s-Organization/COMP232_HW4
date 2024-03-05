package hw04;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class No3Test {
    @Test
    public void testFindMin() {
        String[] keys = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
        "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
        "W", "X", "Y", "Z" };
        ArrayList<Integer> values = new ArrayList<Integer>();
        for (int i = 0; i < keys.length; i++) {
            values.add(i);
        }

        for(int trial = 0; trial < 100; trial++) {
            Collections.shuffle(values);
            COMP232LinkedBinaryTree<String, Integer> tree = new COMP232LinkedBinaryTree<String, Integer>(keys, values.toArray(new Integer[] {}));

            MinKeyFinder mkf = new MinKeyFinder();
            tree.visitPreOrder(mkf);

            int min_index = getMinIndex(values);
            String minKey = keys[min_index];

            assertEquals("Incorrect minimum key.", minKey, mkf.getMinKey());
        }
    }

    private static int getMinIndex(ArrayList<Integer> vals) {
        int min_index = 0;
        int min = vals.get(0);
        for(int i = 1; i < vals.size(); i++){
            if(vals.get(i) < min) {
                min = vals.get(i);
                min_index = i;
            }
        }

        return min_index;
    }
}
