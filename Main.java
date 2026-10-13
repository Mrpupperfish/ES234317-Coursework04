
/**
 * ES234317 - Algorithms and Data Structures
 * Gasal | 2026-2027
 * Coursework   : 04
 * Student ID   : 5026251164
 * Full Name    : Desanda Verdely Yulisar
 * Class        : C
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {
        /*
         * System.out.println("Hello World!"); Queue<Integer> q = new
         * LinkedList<Integer>(); q.addAll(Arrays.asList(67, 29, 115, 84, 33, 71, 90));
         * collectionMystery9(q, 50);
         */

        /*
         * Stack<Integer> s = new Stack<Integer>(); s.push(1); s.push(2); s.push(3);
         * System.out.println(s); s.pop(); System.out.println(s); s.push(4);
         * System.out.println(s);
         */
        /*
         * Queue<Integer> q = new LinkedList<Integer>(); q.add(1); q.add(2); q.add(3);
         * System.out.println(q); q.remove(); System.out.println(q); q.add(4);
         * System.out.println(q);
         */

        /*
         * ArrayList<Integer> l = new ArrayList<Integer>(); Integer [] a = {0, 16, 9, 1,
         * 64, 25, 25, 14, 0};
         * 
         * l.addAll(Arrays.asList(a)); System.out.println(l); collectionMystery4(l);
         */

        System.out.println("Problem Test Case 1:");
        Integer[] a = { 1, 3, 1, 4, 3, 7, -2, 0, 7, -2, -2, 1 };
        ArrayList<Integer> v = new ArrayList<Integer>(Arrays.asList(a));
        System.out.println(twice(v));

        System.out.println("Problem Test Case 2:");
        String[] fNames = { "Marty", "Stuart", "Jessica", "Amanda", "Meghan", "Hal" };
        String[] lNames = { "Stepp", "Reges", "Miller", "Camp", "Miller", "Perkins" };
        String[] lNamesX = { "Stepp", "Reges", "Muller", "Camp", "Miller", "Perkins" };

        TreeMap<String, String> m1 = new TreeMap<String, String>();
        for (int i = 0; i < fNames.length; i++) {
            m1.put(fNames[i], lNames[i]);
        }

        TreeMap<String, String> m2 = new TreeMap<String, String>();
        for (int i = 0; i < fNames.length; i++) {
            m2.put(fNames[i], lNamesX[i]);
        }

        System.out.println(hasDuplicateValue(m1));
        System.out.println(hasDuplicateValue(m2));

        System.out.println("Problem Test Case 3:");
        Integer d1[] = { 3, 8, 17, 9, 17, 8, 3 };
        Integer d2[] = { 3, 8, 17, 9, 4, 17, 8, 3 };

        Queue<Integer> q1 = new LinkedList<Integer>(Arrays.asList(d1));
        Queue<Integer> q2 = new LinkedList<Integer>(Arrays.asList(d2));

        System.out.println(isPalindrome(q1));
        System.out.println(isPalindrome(q2));

    }

    public static Set<Integer> twice(List<Integer> l) {
        Set<Integer> satu = new LinkedHashSet<>();
        Set<Integer> dua = new LinkedHashSet<>();
        Set<Integer> lebih_dari_dua = new LinkedHashSet<>();

        for (int i : l) {
            if (lebih_dari_dua.contains(i)) {
                continue;
            }
            if (dua.contains(i)) {
                dua.remove(i);
                lebih_dari_dua.add(i);
            }
            else if (satu.contains(i)) {
                dua.add(i);
            }
            else {
                satu.add(i);
            }
        }
        return dua;
    }

    public static boolean hasDuplicateValue(Map<String, String> m) {
        boolean s = false;
        // complete your code here
        Set<String> values = new HashSet<String>();
        values.addAll(m.values());
        if (values.size() < m.size()) {
            s = true;
        }

        return s;
    }

    public static boolean isPalindrome(Queue<Integer> q) {
        // complete your code here
        Stack<Integer> ss = new Stack<>();
        int size = q.size();

        for (int i = 0; i < size; i++) {
            int num = q.remove();
            ss.push(num);
            q.add(num);
        }

        boolean cek = true;

        for (int i = 0; i < size; i++) {
            int nq = q.remove();
            int ns = ss.pop();

            if (cek && nq != ns) {
                cek = false;
            }
            q.add(nq);
        }
        return cek;
    }

    public static void collectionMystery4(ArrayList<Integer> v) {
        for (int i = 1; i < v.size(); i += 2) {
            if (v.get(i - 1) >= v.get(i)) {
                v.remove(i);
                v.add(0, 0);
            }
        }
        System.out.println(v);
    }

    public static void collectionMystery9(Queue<Integer> queue, int p) {
        Stack<Integer> stack = new Stack<Integer>();
        int count = 0;
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int element = queue.remove();
            if (element < p) {
                queue.add(element);
            }
            else {
                count++;
                stack.push(count);
                stack.push(element);
            }
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        System.out.println(queue);
    }
}
