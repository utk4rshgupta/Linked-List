package com.utkarsh;

public class DLL {
    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;   // point new node to current head
        node.prev = null;   // first node has no previous

        if (head != null) {
            head.prev = node; // update previous of old head
        }

        head = node; // move head to new node
    }
    public void display(){
        Node node = head ;
        while(node!=null){
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println("END");
    }
    private class Node{
        int val;
        Node next;
        Node prev;
        public Node(int val){
            this.val=val;
        }
        public Node(int val,Node next,Node prev){
            this.val = val;
            this.prev = prev;
            this.next = next;
        }

    }
    private Node head;


}
