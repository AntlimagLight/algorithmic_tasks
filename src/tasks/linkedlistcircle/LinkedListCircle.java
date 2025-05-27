package tasks.linkedlistcircle;

/*Given Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.*/

public class LinkedListCircle {

    public static boolean linkedListCircle(Node head) {
        var slow = head;
        var fast = head;

        while (true) {
            if (slow == null) return false;
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
            if (fast == null) return false;
            if (slow == fast) return true;
        }
    }

    public static void testsLinkedListCircle() {
        var list1 = new CustomLinkedList();
        list1.add(2);
        list1.add(3);
        list1.add(0);
        list1.addAndCircle(-4, 1);

        var list2 = new CustomLinkedList();
        list2.add(1);
        list2.addAndCircle(2, 0);

        var list3 = new CustomLinkedList();
        list3.add(1);

        System.out.println("true -> " + linkedListCircle(list1.head));
        System.out.println("true -> " + linkedListCircle(list2.head));
        System.out.println("false -> " + linkedListCircle(list3.head));
    }


}
