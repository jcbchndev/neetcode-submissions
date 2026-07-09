class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Set<String> ops = new HashSet<>(Set.of("*", "+", "-", "/"));

        for (String c : tokens) {
            if (!ops.contains(c)) {
                stack.push(Integer.parseInt(c));
            } else {
                int y = stack.pop();
                int x = stack.pop();
                int res = 0;
                if (c.equals("+")) {
                    res = x + y;
                }
                if (c.equals("-")) {
                    res = x - y;
                }
                if (c.equals("/")) {
                    res = x / y;
                }
                if (c.equals("*")) {
                    res = x * y;
                }
                stack.push(res);
            }
        }
        return stack.pop();
    }
}