package linkedlist;

import java.util.Stack;

/**
 * @author zzq
 * @creat 2020-06-04 15:50
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode hero5 = new HeroNode(5, "戴宗", "神行太保");
        HeroNode hero6 = new HeroNode(6, "张顺", "浪里白条");
        HeroNode hero7 = new HeroNode(2, "卢本伟", "五五开");

        //添加测试
        System.out.println("*********************添加后*************************");
        sll.add2(hero4);
        sll.add2(hero1);
        sll.add2(hero3);
        sll.add2(hero2);
        sll.add2(hero6);
        sll.add2(hero5);
        sll.show();

//        //修改测试
//        System.out.println("*********************修改后*************************");
//        sll.update(hero7);
//        sll.show();
//        //删除测试
//        System.out.println("*********************删除后*************************");
//        sll.delete(1);
//        sll.delete(6);
//        sll.show();
//        //获取长度
//        System.out.println("**********************************************");
//        int length = sll.getLength();
//        System.out.println("链表长度为：" + length);
        //查找倒数第index节点
        System.out.println("*********************查找到*************************");
        HeroNode lastNode = sll.findLastNode(2);
        System.out.println(lastNode);
//        //反转链表
//        System.out.println("*********************反转后*************************");
//        sll.reverseList();
//        sll.show();
//        //逆序打印
//        System.out.println("*********************逆序后*************************");
//        sll.reversePrint();
    }

    public HeroNode mergeTwoLists(HeroNode h1, HeroNode h2) {
        HeroNode heroNode = new HeroNode(0, "", "");
        HeroNode current = heroNode;
        while (h1 != null && h2 != null) {
            if (h1.id < h2.id) {
                current.next = h1;
                h1 = h1.next;
                current = current.next;
            } else {
                current.next = h2;
                h2 = h2.next;
                current = current.next;
            }
            if (h1 == null) {
                current.next = h2;
            } else {
                current.next = h1;
            }
        }
        return heroNode.next;
    }
}

class SingleLinkedList {

    private static final HeroNode head = new HeroNode(0, "", "");  //先初始化一个头节点

    /**
     * @Description 不考虑id顺序，直接在链表尾部插入数据
     * @Param [heroNode]
     * @Return void
     * @Author zzq
     * @Date 2020/7/27 16:41
     */
    public void add1(HeroNode heroNode) {
        HeroNode temp = head;   //因为头节点不能动，因此我们需要一个辅助节点
        while (temp.next != null) { //结束循环时temp == null
            temp = temp.next;   //改变指针
        }
        temp.next = heroNode;
    }

    /**
     * @Description 考虑id顺序，从小到大，重复报错
     * @Param [heroNode]
     * @Return void
     * @Author zzq
     * @Date 2020/7/27 16:49
     */
    public void add2(HeroNode heroNode) {
        HeroNode temp = head;   //temp需要是添加位置的前一个节点
        boolean isExist = false;    //编号是否存在，默认不存在
        while (true) {
            if (temp.next == null)
                break;
            if (temp.next.id > heroNode.id)
                break;
            else if (temp.next.id == heroNode.id) {
                isExist = true;
                break;
            }
            temp = temp.next;//后移
        }
        if (isExist) {
            System.out.println("英雄已存在");
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    /**
     * @Description 修改已经存在的节点
     * @Param [heroNode]
     * @Return void
     * @Author zzq
     * @Date 2020/7/27 17:23
     */
    public void update(HeroNode heroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) { //先判断节点是否为空
                System.out.println("没有找到节点或节点不存在");
                break;
            }
            if (temp.id == heroNode.id) {   //再判断id是否相等
                temp.name = heroNode.name;
                temp.nickName = heroNode.nickName;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * @Description 删除已经存在的节点
     * @Param [id]
     * @Return void
     * @Author zzq
     * @Date 2020/7/27 17:43
     */
    public void delete(int id) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {    //先判断节点是否为空
                System.out.println("没有找到节点或节点不存在");
                break;
            }
            if (temp.next.id == id) {   //再判断id是否相等
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * @Description 显示整个链表
     * @Param null
     * @Return void
     * @Author zzq
     * @Date 2020/7/27 16:53
     */
    public void show() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (temp != null) {
            System.out.println(temp);   //输出节点信息
            temp = temp.next;
        }
    }

    /**
     * @Description 获得链表的有效长度
     * @Param null
     * @Return int
     * @Author zzq
     * @Date 2020/7/27 17:59
     */
    public int getLength() {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode temp = head.next;  //定义辅助变量的位置在第一个节点（没有统计头节点）
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * @Description 查找链表中倒数第k个节点
     * @Param [index]
     * @Return linkedList.HeroNode
     * @Author zzq
     * @Date 2020/7/27 18:06
     */
    public HeroNode findLastNode(int index) {
        if (head.next == null)
            return null;
        int size = getLength();
        if (index <= 0 || index > size)
            return null;
        HeroNode temp = head.next;
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 反转链表
     *
     * @return
     */
    public void reverseList() {
        if (head.next == null || head.next.next == null)//链表节点为空或是只有一个节点直接返回原来的链表
            return;
        HeroNode temp = head.next;
        HeroNode next = null;
        HeroNode newHead = new HeroNode(0, "", "");//创建一个新的链表
        while (temp != null) {
            next = temp.next;
            temp.next = newHead.next;
            newHead.next = temp;
            temp = next;
        }
        head.next = newHead.next;
    }

    public void reversePrint() {
        if (head.next == null) {
            return;
        }
        HeroNode temp = head.next;
        Stack<HeroNode> heroNodes = new Stack<>();
        while (temp != null) {
            heroNodes.push(temp);
            temp = temp.next;
        }
        while (heroNodes.size() > 0) {
            System.out.println(heroNodes.pop());
        }
    }
}

class HeroNode {

    public int id;  //英雄编号
    public String name; //英雄姓名
    public String nickName; //英雄别名
    public HeroNode next;//指向下一个节点

    public HeroNode(int id, String name, String nickName) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName +
                '}';
    }
}
