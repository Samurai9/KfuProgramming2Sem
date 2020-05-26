package Task21.LinkedList;

import java.util.Objects;

public class MyLinkedList <T>{
    private Node head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }



    public void add(T element) {
        if (head == null) {
            Node head = new Node(element);
            this.head = head;
        } else {
            Node lastNode = getLast();
            Node tempNode = new Node(element);
            lastNode.next = tempNode;
        }
        size++;
    }

    public void addAfter(int index, T element){
        if(index > size || index < 0){
            return;
        }
        Node tempNode = head;
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.next;
        }
        if(tempNode.next != null){
            Node newInsertNode = new Node(element);
            newInsertNode.next = tempNode.next;
            tempNode.next = newInsertNode;
        }
        size++;
    }

    public void addFirst(T element){
        Node head = new Node(element);
        if (head == null) {
            this.head = head;
        }
        else{
            head.next = this.head;
            this.head = head;
        }
        size++;
    }

    public boolean equals(MyLinkedList mll){
        if (size != mll.size){
            return false;
        }
        else{
            Node tempNode = head;
            Node tempNode2 = mll.head;
            for (int i = 0; i < size; i++) {
                if (!tempNode.data.equals(tempNode2.data)){
                    return false;
                }else{
                    tempNode = tempNode.next;
                    tempNode2 = tempNode2.next;
                }
            }
        }
        return true;
    }
    
    public int indexOf(T element){
        int index = -1;
        boolean stopFlag = false;
        Node tempNode = head;
        for (int i = 0; i < size && !stopFlag; i++) {
            if (tempNode.data == element){
                index = i;
                stopFlag = true;
            }
            else {
                tempNode = tempNode.next;
            }
        }
        return index;
    }
    
    public T get(int index){
        if (index > size){
            return null;
        }
        else{
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                if(index == i){
                    return tempNode.data;
                }
                if (tempNode.next != null){
                    tempNode = tempNode.next;
                }
            }
        }
        return null;
    }

    private Node getLast(){
        Node tempNode = head;
        for (int i = 0; i < size; i++) {
            if (tempNode.next != null){
                tempNode = tempNode.next;
            }
        }
        return tempNode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, size);
    }

    public void merge(MyLinkedList mll){
        Node tempNode = getLast();
        tempNode.next = mll.head;
        size += mll.size;
    }

    public void remove(T element){
        if(head.data == element){
            head = head.next;
            size--;
        }
        else {
            Node tempNode = head;
            boolean stopFlag = false;
            for (int i = 0; i < size && !stopFlag; i++) {
                Node tempNode2 = tempNode.next;
                if (tempNode2.data == element) {
                    if (tempNode.next != null) {
                        tempNode.next = tempNode2.next;
                    } else {
                        tempNode.next = null;
                    }
                    stopFlag = true;
                    size--;
                } else if (tempNode2.next != null) {
                    tempNode = tempNode2;
                }
            }
        }
    }

    public void remove(int index){
        if (index > size){
            return;
        }
        if (index == 0){
            head = head.next;
        }
        else {
            Node tempNode = head;
            for (int i = 0; i < index-1; i++) {
                tempNode = tempNode.next;
            }
            Node tempNode2 = tempNode.next;
            if(tempNode2.next != null){
                tempNode = tempNode2.next;
            }
            else {
                tempNode.next = null;
            }
        }
        size--;
    }

    public int size(){
        return size;
    }

    private void showList(){
        Node tempNode = head;
        for (int i = 0; i < size; i++) {
            System.out.println(tempNode.getData());
            tempNode = tempNode.next;
        }
    }

    private class Node {
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
            next = null;
        }
        public T getData(){
            return data;
        }
    }


    public static void main(String[] args) {
        MyLinkedList mll = new MyLinkedList();
        MyLinkedList mll2 = new MyLinkedList();
        mll.add(1);
        mll.add(2);
        mll.add(3);
        mll.add(4);
        mll.addFirst(0);

        mll2.add(0);
        mll2.add(1);
        mll2.add(2);
        mll2.add(3);
        mll2.add(4);

        mll.addAfter(2, 8);

        //mll.merge(mll2);

        System.out.println("Index of - " + mll.indexOf(3));
        //mll.remove(2);
        mll.showList();
    }
}

