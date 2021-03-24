package implementation;

import java.sql.SQLOutput;

public class Node {
    int coff;
    int pow;
    Node next;
    Node(int coff,int pow){
        this.coff=coff;
        this.pow =pow;

    }

}
class LinkedList{
    Node head = null;
    Node tail = null;
    Node addLast(int c, int p){
        Node n = new Node(c,p);

        if (head==null){
            head = n;
            tail =n;
            return head;
        }
        tail.next=n;
        tail=n;

        return head;
    }
    void print(){
        Node temp = head;
        while(temp!=null){
        System.out.println("coff--"+temp.coff+" "+"pow--"+temp.pow);
        temp =temp.next;
        }
    }
    void add(Node head1,Node head2){
        Node temp1 =head1;
        Node temp2 =head2;
        while (temp1 != null ||temp2!=null){
            if (temp1.pow==temp2.pow){
                addLast(temp1.coff+temp2.coff,temp1.pow);
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            else
                if (temp1.pow> temp2.pow){
                    addLast(temp1.coff,temp1.pow);
                    temp1=temp1.next;
                }
                else {
                    addLast(temp2.coff, temp2.pow);
                    temp2 = temp2.next;
                }
        }
    }
    void multiply(Node head1,Node head2){
        Node temp1=head1;

        while (temp1!=null){
            Node temp2=head2;
            while (temp2!=null){
              addLast(temp1.coff* temp2.coff,temp1.pow+ temp2.pow);
              temp2= temp2.next;
            }
            temp1=temp1.next;
        }
    }

    public static void main(String[] args) {
        LinkedList l1=new LinkedList();
        l1.addLast(5,2);
        l1.addLast(3,1);
        l1.addLast(4,0);
        System.out.println("first equation-->");
        l1.print();
        LinkedList l2= new LinkedList();
        l2.addLast(7,3);
        l2.addLast(5,2);
        l2.addLast(3,0);
        System.out.println("second equation -->");
        l2.print();
        LinkedList l3 =new LinkedList();
        l3.add(l1.head,l2.head);
        System.out.println("addition resultant equation --->");
        l3.print();
        LinkedList l4 =new LinkedList();
        l4.multiply(l1.head, l2.head);
        System.out.println("Multiply resultant equation -->");
        l4.print();
    }

}

