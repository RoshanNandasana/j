import java.util.ArrayList;  

class GenericStack<T> {   
    private ArrayList<T> stack;   

    public GenericStack() {  
        stack = new ArrayList<>();  
    }  

    public void push(T item) {  
        stack.add(item);  
    }  

    public T pop() {  
        if (isEmpty()) {  
            throw new RuntimeException("Stack is empty!");  
        }  
        return stack.remove(stack.size() - 1);  
    }  

    public T peek() {  
        if (isEmpty()) {  
            throw new RuntimeException("Stack is empty!");  
        }  
        return stack.get(stack.size() - 1);  
    }  

    public boolean isEmpty() {   
        return stack.isEmpty();  
    }  
}  

public class Stack {  
    public static void main(String[] args) {  
        GenericStack<Integer> intStack = new GenericStack<>();   
        intStack.push(2);  
        intStack.push(4);   
        intStack.push(8);  

        System.out.println("Top Element: " + intStack.peek());   
        System.out.println("Popped Element: " + intStack.pop());   
        System.out.println("Is Stack Empty? " + intStack.isEmpty());  
    }  
}