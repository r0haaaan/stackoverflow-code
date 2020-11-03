package in.rohaan;

import java.util.Stack;

/*
 * StackOverflow Post: https://stackoverflow.com/questions/64668672
 */
public class MyCustomStack<E> extends Stack<E> {
    @Override
    public synchronized E peek() {
        if (isEmpty()) {
            return null;
        }
        return super.peek();
    }
}
