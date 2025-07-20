package tasks.addtwonums;

/*You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.*/

import java.util.Arrays;

import static tasks.addtwonums.ListNode.createListByArray;
import static tasks.addtwonums.ListNode.printListByHeadNode;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode nums1, ListNode nums2) {
        var length = getMaxLength(nums1, nums2);
        var arr1 = createArrayByListNode(nums1, length);
        var arr2 = createArrayByListNode(nums2, length);
        var resultArray = new int[length + 1];
        boolean digitUpFlag = false;
        for (int i = length - 1; i >= 0; i--) {
            var mainOperation = arr1[i] + arr2[i] + (digitUpFlag ? 1 : 0);
            if (mainOperation >= 10) {
                resultArray[length - i - 1] = mainOperation - 10;
                digitUpFlag = true;
            } else {
                resultArray[length - i - 1] = mainOperation;
                digitUpFlag = false;
            }
        }
        if (digitUpFlag) {
            resultArray[length] = 1;
        } else {
            if (resultArray.length > 1) {
                resultArray = Arrays.copyOfRange(resultArray, 0, length);
            }
        }
        return createListByArray(resultArray);
    }

    public static int getMaxLength(ListNode nums1, ListNode nums2) {
        int length1 = 0;
        ListNode current1 = nums1;
        while (current1 != null) {
            length1++;
            current1 = current1.next;
        }

        int length2 = 0;
        ListNode current2 = nums2;
        while (current2 != null) {
            length2++;
            current2 = current2.next;
        }

        return Math.max(length1, length2);
    }


    public static int[] createArrayByListNode(ListNode listNode, int length) {
        var node = listNode;
        if (node != null) {
            int[] array = new int[length];
            int i = 1;
            while (node != null) {
                array[length - i] = node.val;
                node = node.next;
                i++;
            }

            return array;
        }
        throw new RuntimeException("Передан null вместо головного узла");
    }

    public static void testsAddTwoNumbers() {
        int[] test1_1 = {2, 7, 1, 5};
        int[] test1_2 = {3, 2, 4};
        int[] test2_1 = {2, 4, 3};
        int[] test2_2 = {5, 6, 4};
        int[] test3_1 = {9, 9, 9, 9, 9, 9, 9};
        int[] test3_2 = {9, 9, 9, 9};
        int[] test4_1 = {0};
        int[] test4_2 = {0};

        printListByHeadNode(addTwoNumbers(createListByArray(test1_1), createListByArray(test1_2)));
        System.out.println(" ->>> " + "5955");
        printListByHeadNode(addTwoNumbers(createListByArray(test2_1), createListByArray(test2_2)));
        ;
        System.out.println(" ->>> " + "708");
        printListByHeadNode(addTwoNumbers(createListByArray(test3_1), createListByArray(test3_2)));
        System.out.println(" ->>> " + "89990001");
        printListByHeadNode(addTwoNumbers(createListByArray(test4_1), createListByArray(test4_2)));
        System.out.println(" ->>> " + "0");

    }


}
