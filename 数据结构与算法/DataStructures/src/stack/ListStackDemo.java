package stack;


/**
 * @Description 使用链表模拟栈
 * @ClassName ListStack
 * @Author zzq
 * @Date 2020/7/28 17:09
 */
public class ListStackDemo {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(6);
        ListNode l4 = new ListNode(7);
        ListStack listStack = new ListStack(4);
        System.out.println("*********************入栈后************************");
        listStack.push(l1);
        listStack.push(l2);
        listStack.push(l3);
        listStack.push(l4);
        listStack.show();
        System.out.println("*********************出栈后************************");
        System.out.println(listStack.pop());
        System.out.println(listStack.pop());
    }
}

class ListStack {

    private static final ListNode head = new ListNode(0);   //设置头节点
    private int top = 0;    //用于计算栈中节点的个数
    private int maxSize;

    public ListStack(int maxSize) {
        this.maxSize = maxSize;
    }

    public void push(ListNode l) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;  //个数增加
        l.next = head.next; //将节点添加在head后
        head.next = l;  //使原来的head.next连接上
    }

    public ListNode pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        top--;
        ListNode l = head.next; //将第一个节点的内容保存
        head.next = head.next.next;     //“head的下一个节点”变为“第一个节点的下一个节点”
        return l;   //返回保存的节点
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        ListNode cur = head.next;   //从第一个节点开始
        while (cur != null) {
            System.out.println(cur);
            cur = cur.next;
        }
    }

    public boolean isFull() {
        return top == maxSize;
    }

    public boolean isEmpty() {
        return top == 0;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
