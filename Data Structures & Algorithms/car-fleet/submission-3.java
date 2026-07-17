class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] car = new int[position.length][2];
        for (int i = 0; i < position.length; i++){
            car[i][0] = position[i];
            car[i][1] = speed[i];
        }
        // sort based on position from destination
        Arrays.sort(car, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();

        for (int[] pair : car){
            double ttd = (double) (target - pair[0]) / pair[1];
            stack.push(ttd);
            if (stack.size() >= 2){
                if (stack.peek() <= stack.get(stack.size() - 2)){
                    stack.pop();
                }
            }
        }
        return stack.size();
    }
}
