package linkedlist;

/**
 * @author zzq
 * @creat 2020-06-09 15:05
 */
public class Joseph {
    public static void main(String[] args) {
        CircleSingleLinkedList csll = new CircleSingleLinkedList();
        csll.addBoy(25);
        csll.showBoy();
        System.out.println("*********************顺序为*************************");
        csll.orderBoy(3,5,25);
    }
}

class CircleSingleLinkedList {   //环形链表

    private static Boy first = null;   //第一个节点

    /**
     * @Description 添加节点构成环形链表
     * @Param [num]
     * @Return void
     * @Author zzq
     * @Date 2020/7/28 14:04
     */
    public void addBoy(int num) {
        if (num < 1) {
            System.out.println("num错误");
            return;
        }
        Boy temp = null;    //帮助构筑环形链表
        for (int i = 1; i <= num; i++) {
            Boy newBoy = new Boy(i);
            if (i == 1) {
                first = newBoy;
                first.next = first;   //first节点指向自己
                temp = first;   //让辅助节点指向first节点
            } else {
                temp.next = newBoy;   //先指向新节点
                newBoy.next = first;  //新节点指向first节点
                temp = newBoy;  //移动辅助节点
            }
        }
    }

    /**
     * @Description 显示整个链表
     * @Param null
     * @Return void
     * @Author zzq
     * @Date 2020/7/28 14:04
     */
    public void showBoy() {
        if (first == null) {
            System.out.println("环形链表为空");
            return;
        }
        Boy temp = first;
        do {
            System.out.println(temp.toString());
            temp = temp.next;
        } while (temp != first);
    }

    /**
     * @Description 根据开始位置，间隔，总个数。计算出顺序
     * @Param [startId, countNum, numBoy]
     * @Return void
     * @Author zzq
     * @Date 2020/7/28 14:38
     */
    public void orderBoy(int startId, int countNum, int numBoy) {
        if (first == null || startId < 1 || startId > numBoy) {
            System.out.println("参数有误，请重新输入");
            return;
        }
        Boy temp = first;   //定义辅助节点
        while (temp.next != first) {    //移动辅助节点temp，使temp.next=first
            temp = temp.next;
        }
        for (int i = 0; i < startId - 1; i++) { //移动first和temp到指定的startId位置
            first = first.next;
            temp = temp.next;
        }
        while (first != temp) {
            for (int i = 0; i < countNum - 1; i++) {    //将first移动countNum-1次
                first = first.next;
                temp = temp.next;
            }
            System.out.println("编号：" + first.id);
            first = first.next; //移动first节点
            temp.next = first;  //使temp.next始终指向first
        }
        System.out.println("编号：" + first.id);   //打印最后剩下的1个节点
    }
}


class Boy {     //Boy节点

    public int id;
    public Boy next;

    public Boy(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "id=" + id +
                '}';
    }
}
