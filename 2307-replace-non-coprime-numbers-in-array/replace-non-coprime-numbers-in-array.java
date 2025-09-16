import java.util.*;

class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> st = new Stack<>();
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            st.push(num);

            while (st.size() > 1) {
                int a = st.pop();
                int b = st.pop();

                int g = gcd(a, b);
                if (g > 1) {
                    long lcm = (long) a * b / g;
                    st.push((int) lcm);
                } else {
                    st.push(b);
                    st.push(a);
                    break;
                }
            }
        }

        while (!st.isEmpty()) {
            result.add(0, st.pop());
        }

        return result;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    
    }
}
