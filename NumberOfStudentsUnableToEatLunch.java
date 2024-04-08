class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        int n = students.length;
        for (int i = n - 1; i >= 0; i--) {
            stack.push(sandwiches[i]);
        } 

        for (int i = 0; i < n; i++) {
            queue.add(students[i]);
        }

        int cnt = 0;
        while (cnt != queue.size()) {
            cnt++;
            int student = queue.remove();
            if (stack.peek() == student) {
                stack.pop();
                cnt = 0;
            } else {
                queue.add(student);
            }
        }

        return cnt;
    }
}
