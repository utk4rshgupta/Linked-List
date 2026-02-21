package com.utkarsh;

public class main{
    public static void main(String[] args) {
        DLL list = new DLL();
        list.insertFirst(10);
        list.insertFirst(10);
        list.insertFirst(13);
        list.insertFirst(24);
        list.insertFirst(16);
        list.insertFirst(6);
        list.insertFirst(45);
        list.insertFirst(98);
        list.insert(10,99);
        list.display();
    }
}
