package com.santosh.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/** This will even handle string like (Abc{xyz[lmn]}) */
public final class BalancedParantheses {

    private static final Map<Character, Character> closeBrackets = new HashMap<Character, Character>();
    private static final Set<Character> openBrackets = new HashSet<Character>();
    
    static {
    	openBrackets.add('[');
    	openBrackets.add('{');
    	openBrackets.add('(');
    }
    
    static {
    	closeBrackets.put(']', '[');
    	closeBrackets.put('}', '{');
    	closeBrackets.put(')', '(');
    }  

    private BalancedParantheses() {};


    public static boolean isBalanced(String str) {
        if (str.length() == 0) {
            throw new IllegalArgumentException("String length should be greater than 0");
        }

        final Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            if (openBrackets.contains(str.charAt(i))) {
                stack.push(str.charAt(i));
            } else if (closeBrackets.containsKey(str.charAt(i))) {
                if (stack.peek() == closeBrackets.get(str.charAt(i))) 
                	stack.pop();
                else
                	return false;
            } 
        }
        
        if (stack.isEmpty())
        	return true;
        else 
        	return false;
    } 

    public static void main(String[] args) {
        System.out.println(isBalanced("{}([])"));
        System.out.println(isBalanced("([}])"));
        System.out.println(isBalanced("([s])"));
        System.out.println(isBalanced("()[]{}[][]"));
        System.out.println(isBalanced("(Abc{xyz[lmn]})"));
    }
}
