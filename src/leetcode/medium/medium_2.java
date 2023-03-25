package leetcode.medium;

public class medium_2 {
    public static void main(String[] args) {
        //ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        //ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        //ListNode l1 = new ListNode(0);
        //ListNode l2 = new ListNode(0);
        //ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        //ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))));

        addTwoNumbers(l1, l2);
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder l1Builder = new StringBuilder();
        StringBuilder l2Builder = new StringBuilder();
        nodeNext(l1, l1Builder);
        nodeNext(l2, l2Builder);

        String l1String = l1Builder.toString();
        String l2String = l2Builder.toString();

        String[] l1Arr = l1String.split("");
        String[] l2Arr = l2String.split("");

        int max = Math.max(l1String.length(), l2String.length());
        int[] NodeInt = new int[max];
        for(int i = 0; i < max; i++) {
            int l1Int = 0;
            int l2Int = 0;

            if (l1Arr.length > i) {
                l1Int = Integer.parseInt(l1Arr[i]);
            }
            if (l2Arr.length > i) {
                l2Int = Integer.parseInt(l2Arr[i]);
            }
            NodeInt[i] = l1Int + l2Int;
        }

        return createNode(NodeInt, NodeInt.length-1);
    }
    private static ListNode createNode(int[] nodeInt, int count) {
        int value = nodeInt[count];
        if (count == 0) {
            return new ListNode(value);
        }
        count--;
        return new ListNode(value, createNode(nodeInt, count));
    }
    private static void nodeNext(ListNode node, StringBuilder result) {
        if (node.next != null) {
            nodeNext(node.next, result);
        }
        result.append(node.val);
    }
    //정답 ....
    /*
    ListNode dummyHead = new ListNode(0);
    ListNode currentNode = dummyHead;
    int carry = 0;

    while (l1 != null || l2 != null || carry != 0) {
        int l1Val = (l1 != null) ? l1.val : 0;
        int l2Val = (l2 != null) ? l2.val : 0;
        int sum = l1Val + l2Val + carry;
        carry = sum / 10;
        int digit = sum % 10;

        currentNode.next = new ListNode(digit);
        currentNode = currentNode.next;

        if (l1 != null) l1 = l1.next;
        if (l2 != null) l2 = l2.next;
    }

    return dummyHead.next;
     */
/*
    private static String ListNodeToString(ListNode node) {
        StringBuilder result = new StringBuilder();
        result.append(node.val);
        do {
            node = node.next;
            result.append(node.val);
        } while (node.next != null);
        return result.toString();
    }*/

    static class ListNode {
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
    }
}
