class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] output = new int[temperatures.length];     
        Deque<List<Integer>> stack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++){
            while (!stack.isEmpty() && temperatures[i] > stack.peek().get(0)){
                List<Integer> top = stack.pop();
                int idx = top.get(1);
                output[idx] = i - idx;
            }
            stack.push(Arrays.asList(temperatures[i], i));
        }
        return output;
    }
}
