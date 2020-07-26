package com.chuck.algorithmproject.algorithm;

public class LastIndexKValue {
    public class ListNode{
        int value;
        ListNode next;
    }

    public ListNode rootNode = new ListNode();
    public void buildListNode(int value){
        ListNode tempNode = rootNode;
        while(tempNode != null){
            if(tempNode.next == null){
                ListNode curNode = new ListNode();
                curNode.value = value;
                tempNode.next = curNode;
                break;
            }
            tempNode = tempNode.next;
        }
    }

    public int findLastKIndexValue(int k){
        if(rootNode.next == null){
            return -1;
        }
        if(k <= 1){
            return rootNode.next.value;
        }
        ListNode p = rootNode.next;
        while(k > 1){
            p = p.next;//定位到从前往后的第k个位置
            --k;
        }
        ListNode q = rootNode.next;//节点在初始位置
        while(p.next != null){//p遍历完成，在最后一个节点，对应的q在倒数第k个节点
            p = p.next;
            q = q.next;
        }
        return q.value;
    }

    public void main() {
        int[] array = {1,2,3,4,5,6,7};
        for(int value:array){
            buildListNode(value);
        }
        int indexKValue = findLastKIndexValue(2);
        System.out.println("k value is:" + indexKValue);
    }
}
