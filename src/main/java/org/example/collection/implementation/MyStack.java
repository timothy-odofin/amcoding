package org.example.collection.implementation;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 225 Implement Stack using Queues – Easy
 * Problem:
 *
 * Implement the following operations of a stack using queues.
 *
 * push(x) — Push element x onto stack. pop() — Removes the element on top of the stack.
 * * top() — Get the top element. empty() — Return whether the stack is empty. Notes:
 * * You must use only standard operations of a queue — which means only push to back,
 * * peek/pop from front, size, and is empty operations are valid.
 * * Depending on your language, queue may not be supported natively.
 * * You may simulate a queue by using a list or deque (double-ended queue),
 * * as long as you use only standard operations of a queue. You may assume that all operations are
 * * valid (for example, no pop or top operations will be called on an empty stack).
 * * * */
class MyStack {
    Queue<Integer> q = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        Queue<Integer> newq = new LinkedList<Integer>();
        newq.add(x);
        while (q.size() > 0) {
            newq.add(q.poll());
        }
        q = newq;
    }

    // Removes the element on top of the stack.
    public void pop() {
        q.poll();
    }

    // Get the top element.
    public int top() {
        return q.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.size() == 0;
    }
}
