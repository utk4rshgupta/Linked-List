package com.utkarsh;

public class DLL {

    private class Node{
        int val;
        int next;
        int prev;
        public Node(int val){
            this.val=val;
        }
        public Node(int val,int next,int prev){
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
        Node head;
    }
}
