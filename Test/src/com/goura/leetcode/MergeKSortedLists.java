package com.goura.leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeKSortedLists {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		
	}

    public static ListNode mergeKLists(ListNode[] lists) {
    	if (0 == lists.length) {
    		return null;
    	} else if (1 == lists.length) {
    		return lists[0];
    	} else if (2 == lists.length) {
    		ListNode start = null, current = null, future = null;

    		if (null == lists[0]) {
    			return lists[1];
    		} else if (null == lists[1]) {
    			return lists[0];
    		} else if (lists[0].val < lists[1].val) {
				start = current = lists[0];
				future = lists[1];
			} else {
				start = current = lists[1];
				future = lists[0];
			}

    		while (true) {
    			if (null == current.next) {
    				current.next = future;
    				break;
    			}
    			if (current.next.val <= future.val) {
    				current = current.next;
    			} else {
    				ListNode temp = current.next;
    				current.next = future;
    				future = temp;
    			}
			}
    		return start;
    	} else {
    		ListNode[] temp = new ListNode[lists.length - 1];
    		System.arraycopy(lists, 1, temp, 0, temp.length);
    		ListNode result = mergeKLists(temp);
    		return mergeKLists(new ListNode[] {lists[0], result});
    	}
    }
}


