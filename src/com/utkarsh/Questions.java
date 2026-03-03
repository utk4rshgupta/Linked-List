package com.utkarsh;

public class Questions {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // https://leetcode.com/problems/linked-list-cycle
    // Amazon and Microsoft
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    // find length of the cycle
    public int lengthCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // calculate the length
                ListNode temp = slow;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                } while (temp != slow);
                return length;
            }
        }
        return 0;
    }

    // https://leetcode.com/problems/linked-list-cycle-ii/
    public ListNode detectCycle(ListNode head) {
        LL ListNode = new LL();
        int length = 0;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                length = lengthCycle(slow);
                break;
            }
        }

        if (length == 0) {
            return null;
        }

        // find the start node
        ListNode f = head;
        ListNode s = head;

        while (length > 0) {
            s = s.next;
            length--;
        }

        // keep moving both forward and they will meet at cycle start
        while (f != s) {
            f = f.next;
            s = s.next;
        }
        return s;
    }

    // Google: https://leetcode.com/problems/happy-number/
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while (slow != fast);

        if (slow == 1) {
            return true;
        }
        return false;
    }
    private int findSquare(int number) {


        int ans = 0;
        while (number > 0) {
            int rem = number % 10 ;
            ans += rem * rem;
            number /= 10;
        }
        return ans;
    }
    // https://leetcode.com/problems/middle-of-the-linked-list/submissions/
    public ListNode middleNode(ListNode head) {
        ListNode s = head;
        ListNode f = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }


    // Reversing a Linked List
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode prev = null;
        ListNode pres = head;
        ListNode next = pres.next;
        while(pres!=null){
            pres.next= prev;
            prev = pres;
            pres=next;
            if(next!=null){
                next=next.next;
            }
        }
        return prev;
    }

    // find reverse in an interval
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right){
            return head;
        }
        // skip the fiorst left-1 nodes
        ListNode curr = head;
        ListNode prev = null;

        for(int i =0;curr!=null && i<left-1;i++){
            prev = curr;
            curr = curr.next;
        }

        ListNode last= prev;
        ListNode newEnd = curr;

        //reverse betn left and right nodes

        ListNode next = curr.next;
        for(int i =0;curr != null && i<right-left+1;i++){
            curr.next=prev;
            prev  = curr;
            curr = next;
            if(next!=null){
                next = next.next;
            }
        }
        if(last!=null){
            last.next= prev;
        }else{
            head = prev;
        }
        newEnd.next=curr;
        return head;
    }
    // reorder list
    public void reorderList(ListNode head) {
        if(head == null || head.next==null){
            return;
        }
        ListNode mid = middleNode(head);
        ListNode hs = reverseList(mid);
        ListNode hf = head;

        while(hf!=null && hs!=null){
            ListNode temp = hf.next;
            hf.next=hs;
            hf=temp;

            temp = hs.next;
            hs.next=hf;
            hs= temp;

        }
        if(hf!=null){
            hf.next = null;
        }
    }



    // reverse nodes in k group
    public ListNode reverseKGroup(ListNode head,int k){
        if(k<=1 || head == null){
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;

        int length = getLength(head);
        int count = length/k;
        while(count>0){
          ListNode last = prev;
          ListNode newEnd = curr;

          ListNode next = curr.next;
            for (int i = 0; curr != null && i < k; i++) {
                curr.next = prev;
                prev = curr;
                curr=next;
                if(next!=null){
                    next=next.next;
                }
            }
            if(last!=null){
                last.next = prev;
            }else{
                head = prev;
            }
            newEnd.next = curr;

            prev = newEnd;
            count--;
        }
        return head;
    }

    private int getLength(ListNode head) {
        ListNode node = head;
        int length = 0;
        while(node!=null){
            length++;
            node = node.next;
        }
        return length;
    }

}
