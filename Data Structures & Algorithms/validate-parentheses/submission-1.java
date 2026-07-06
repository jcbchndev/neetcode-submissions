class Solution {
    public boolean isValid(String s) {
        Deque<Character> openStack = new ArrayDeque<>();
        Map<Character, Character> brackets = new HashMap<>(
            Map.of(
                ')', '(',
                ']', '[',
                '}', '{'
            )
        );

        for (char c : s.toCharArray()){
            if (c == '(' || c == '{' || c == '['){
                openStack.push(c);
                continue;
            }

            if (!openStack.isEmpty() && openStack.peek() == brackets.get(c)){
                openStack.pop();
            } else {
                return false;
            }
        }

        return openStack.isEmpty();
    }
}
