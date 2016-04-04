package LinkedList;


import java.io.PrintWriter;

public class TestList {
    public static void main (String[] args) {
        PrintWriter pw = new PrintWriter(System.out);
        LinkedList<Integer> ll = new LinkedList(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);
        ll.add(7);
        ll.add(8);
        ll.add(9);
        ll.add(10);
        ll.add(11);
        ll.add(12);
        ll.add(13);
        ll.add(14);
        ll.add(15);
        pw.println("elements in list = " + ll);
        pw.println("size of list = " + ll.size());
        pw.println("get 3 element from list = " + ll.get(3));
        pw.println("get 8 element from list = " + ll.get(8));
        pw.println("delete 2 element from list = " + ll.remove(2));
        pw.println("elements in list = " + ll);
        pw.println("get 3 element from list = " + ll.get(3));
        pw.println("get 8 element from list = " + ll.get(8));
        pw.println("size of list = " + ll.size());
        pw.println("elements in list = " + ll);
        for (int i = 0; i < ll.size(); i++) {
            pw.print(ll.get(i) + " ");
        }
        pw.println();
        pw.close();
    }
}

class LinkedList <T> {
    
    private int size = 0;
    private Node head = null;
    private Node last = null;
    
    private class Node {
        Node next;
        T data;

        public Node (T data) {
            next = null;
            this.data = data;
        }

        public T getData () {
            return data;
        }

        public void setData (T data) {
            this.data = data;
        }

        public Node getNext () {
            return next;
        }

        public void setNext (Node next) {
            this.next = next;
        }
    }
    
    public LinkedList () {}
    
    public LinkedList (T data) {
        add(data);
    }
    
    public void add(T data) {
        if (head == null) {
            head = new Node(data);
            last = head;
        }
        else {
            last.setNext(new Node (data));
            last = last.getNext();
        }
        size++;
    }
    
    public int size () {
        return size;
    }
    
    public void add (T data, int index) {
        Node temp = new Node(data);
        Node current = head;
        if (current != null) {
            for (int i = 1; i < index && current.getNext() != null; i++) {
                current = current.getNext();
            }
        }
        temp.setNext(current.getNext());
        current.setNext(temp);
        size++;
    }
    
    public T get (int index) {
        if (index < 0 || size <= index)
            return null;
        Node current = null;
        if (head != null) {
            current = head;
            for (int i = 0; i < index; i++) {
                if (current.getNext() == null) {
                    return null;
                }
                current = current.getNext();
            }
            return current.getData();
        }
        return null;
    }
    
    public boolean remove (int index) {
        if (index < 0 || size <= index)
            return false;
        Node current = head;
        if (current != null) {
            for (int i = 0; i < index; i++) {
                if (current.getNext() == null) {
                        return false;
                }
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
            size--;
            return true;
        }
        return false;
    }
    
    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder();
        if (head != null) {
            Node current = head;
            while (current != null) {
                sb.append("[").append(current.getData().toString()).append("]");
                current = current.getNext();
            }
        }
        return new String(sb);
    }
    
    public boolean isEmpty () {
        return head == null;
    }
}