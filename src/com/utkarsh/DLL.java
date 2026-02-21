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
    public void displayRev(){
        Node node = head;
        Node last = null;
        while(node!=null){
            last = node;
            node = node.next;
        }
        while(last!=null){
            System.out.print(last.val + "->");
            last=last.prev;
        }
        System.out.println("END");
    }
    // add a node to the last
    public void insertLast(int val){
        Node node = new Node(val);
        Node last = head;
        node.next=null;
        if(head==null){
            node.prev=null;
            head=node;
            return;
        }
        while(last.next!=null){
            last = last.next;
        }
        last.next=node;
        node.prev=last;
    }

    public Node find(int value){
        Node node = head;
        while(node!=null) {
            if(node.val==value) {
            return node;
            }
            node = node.next;
        }
        return null;
    }


    //insert a node after a given node
    public void insert(int after,int val){
        Node p = find(after);
        if(p==null){
            System.out.println("doesn't exixt");
        }
        Node node = new Node(val);
        node.next=p.next;
        p.next=node;
        node.prev=p;
        if(node.next!=null){
            node.next.prev = node;
        }
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
