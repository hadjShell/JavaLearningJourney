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
}

class StackOverflowException extends Exception {
    public String getMessage() {
        return "Stack overflow!";
    }
}

class StackUnderflowException extends Exception {
    public String getMessage() {
        return "Stack underflow!";
    }
}
