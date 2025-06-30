class MyLinkedList {
    static class Node {
        int val;
        Node next;

        Node(int x){
            this.val = x;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;
    int length = 0;
    public MyLinkedList() {
    }
    
    public int get(int index) {
        if(index < 0 || index >= length){
            return -1;
        }

        int cnt = 0;
        Node temp = head;
        while(temp != null && cnt != index){
            temp = temp.next;
            cnt++;
        }
        return temp.val;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
            tail = newNode;
        }

        newNode.next = head;
        head = newNode;
        length++;
    }
    
    public void addAtTail(int val) {
        if(length == 0){
            addAtHead(val);
            return;
        }

        // Node newNode = new Node(val);
        // Node temp = head;
        // while(temp.next != null){
        //     temp = temp.next;
        // }
        // temp.next = newNode;
        // newNode.next = null;
        tail.next = new Node(val);
        tail = tail.next;
        length++;
    }
    
    public void addAtIndex(int index, int val) {
        Node newNode = new Node(val);
        Node temp = head;
        int cnt = 0;

        if(index > length){
            return;
        }

        if(index == 0){
            addAtHead(val);
            return;
        }

        if(index == length){
            addAtTail(val);
            return;
        }

        while(cnt != index - 1){
            temp = temp.next;
            cnt++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
    }
    
    public void deleteAtIndex(int index) {
        if(index <0 || index >= length){
            return;
        }

        if(index == 0){
            head = head.next;
            if (head == null) tail = null;
            length--;
            return;
        }
        Node curr = head;
        Node prev = null;
        int cnt = 0;
        while(cnt != index){
            prev = curr;
            curr = curr.next;
            cnt++;
        }
        prev.next = curr.next;
        if (curr == tail) tail = prev;
        length--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */