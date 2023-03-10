package com.wandonium.h2demo;

import java.util.Stack;

public class TowerOfHanoi {

    static Stack<Integer> stack1 = new Stack();
    static Stack<Integer> stack2 = new Stack();
    static Stack<Integer> stack3 = new Stack();

    public static void main(String[] args) {
        for(int i = 4; i > 0; i--) {
            stack1.push(i);
        }
        System.out.println("stack1: " + stack1);
        if(move(stack1, stack2)) {
            stack2.push(stack1.pop());
        } else if(move(stack1, stack3)) {
            stack3.push(stack1.pop());
        } else if(move(stack2, stack3)) {
            stack3.push(stack2.pop());
        }
    }

    public static boolean move(Stack<Integer> s1, Stack<Integer> s2) {
        if(s2.isEmpty()) {
            return true;
        } else {
            if(s1.peek() < s2.peek()) {
                return true;
            } else {
                return false;
            }
        }
    }
}
