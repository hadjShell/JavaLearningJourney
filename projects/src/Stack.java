public class Stack {
    private static final int SIZE = 5;
    private int top;
    private final int[] arr;

    public Stack() {
        top = -1;
        arr = new int[SIZE];
    }
    
    public void push(int element) {
        try {
            top++;
            checkCondition();

            arr[top] = element;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            top--;
        }
    }
    
    public int pop() {
        try {
            checkCondition();

            int rtn = arr[top];
            arr[top--] = 0;
            return rtn;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public void checkCondition() throws Exception {
        if (top == -1)            throw new StackUnderflowException();
        else if (top == SIZE)   throw new StackOverflowException();
    }

    static class StackOverflowException extends Exception {
        public String getMessage() {
            return "Stack overflow!";
        }
    }

    static class StackUnderflowException extends Exception {
        public String getMessage() {
            return "Stack underflow!";
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        System.out.println(s.pop());
        System.out.println("---");
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println("---");
        s.push(6);
        System.out.println("---");
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println("---");
        System.out.println(s.pop());
    }
}


