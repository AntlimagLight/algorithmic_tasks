package tasks.addtwonums;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createListByArray(int[] arr) {
        if (arr.length == 0) {
            throw new RuntimeException("Невозможно создать связный список, переданный массив пустой");
        }
        ListNode node = null;
        ListNode prevNode = null;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (node != null) {
                prevNode = node;
                node = new ListNode(arr[i], prevNode);
            } else {
                node = new ListNode(arr[i]);
            }
        }
        return node;
    }

    public static void printListByHeadNode(ListNode head) {
        if (head == null) {
            throw new RuntimeException("Передан null вместо головного узла");
        }
        StringBuilder result = new StringBuilder();
        result.append("list: ").append(head.val);
        ListNode next = head.next;
        while (next != null) {
            result.append(", ").append(next.val);
            next = next.next;
        }
        System.out.println(result);

    }
}