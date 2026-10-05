public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
    for(ListNode node:lists){
        if(node!=null){
            pq.add(node);
        }
    }
    ListNode dummy=new ListNode(-1);
    ListNode curr=dummy;
    while(pq.size()!=0){
        ListNode s=pq.remove();
        curr.next=s;
        curr=curr.next;
        if(s.next!=null){
            pq.add(s.next);
        }
    }
    return dummy.next;

}