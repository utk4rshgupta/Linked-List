package com.utkarsh;

public class main{
    public static void main(String[] args) {
//        DLL list = new DLL();
//        list.insertFirst(10);
//        list.insertFirst(10);
//        list.insertFirst(13);
//        list.insertFirst(24);
//        list.insertFirst(16);
//        list.insertFirst(6);
//        list.insertFirst(45);
//        list.insertFirst(98);
//        list.insert(10,99);
          LL list = new LL();
          list.insertFirst(98);
          list.insertFirst(2);
          list.insertFirst(12);
          list.insertFirst(23);
          list.display();
          list.insertRec(99,1);
          list.display();

    }
}
