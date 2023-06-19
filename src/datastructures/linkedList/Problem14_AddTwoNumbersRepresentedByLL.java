package com.learning.dsa._3.linked_list;

public class Problem14_AddTwoNumbersRepresentedByLL {

    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(0);
        ListNode curr = res;
        int carry = 0;
        while (list1 != null || list2 != null) {
            int num1 = list1 != null ? list1.data : 0;
            int num2 = list2 != null ? list2.data : 0;

            int sum = carry + num1 + num2;
            carry = sum / 10;
            sum = sum % 10;

            curr.next = new ListNode(sum);
            curr = curr.next;

            if (list1 != null) {
                list1 = list1.next;
            }

            if (list2 != null) {
                list2 = list2.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return res.next;
    }
}
