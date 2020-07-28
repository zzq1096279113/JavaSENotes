package linkedlist;

/**
 * @author zzq
 * @creat 2020-06-08 14:00
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList dll = new DoubleLinkedList();
        HeroNode1 hero1 = new HeroNode1(1, "宋江", "及时雨");
        HeroNode1 hero2 = new HeroNode1(2, "卢俊义", "玉麒麟");
        HeroNode1 hero3 = new HeroNode1(4, "吴用", "智多星");
        HeroNode1 hero4 = new HeroNode1(3, "林冲", "豹子头");
        HeroNode1 hero5 = new HeroNode1(3, "公孙胜", "入云龙");

        //添加
        System.out.println("*********************添加后*************************");
        dll.add2(hero1);
        dll.add2(hero2);
        dll.add2(hero3);
        dll.add2(hero4);
        dll.show();

        // 修改
        System.out.println("*********************修改后*************************");
        dll.update(hero5);
        dll.show();
        System.out.println();

        // 删除
        System.out.println("*********************删除后*************************");
        dll.delete(4);
        dll.show();
    }
}

class DoubleLinkedList {

    private static final HeroNode1 head = new HeroNode1(0, "", "");

    /**
     * @Description 显示整个链表
     * @Param null
     * @Return void
     * @Author zzq
     * @Date 2020/7/28 10:19
     */
    public void show() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode1 temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /**
     * @Description 直接添加节点在链表末尾
     * @Param [heroNode1]
     * @Return void
     * @Author zzq
     * @Date 2020/7/28 10:21
     */
    public void add1(HeroNode1 heroNode1) {
        HeroNode1 temp = head;
        while (temp.next != null) { //遍历链表找到最后
            temp = temp.next;   //改变指针
        }
        temp.next = heroNode1;
        heroNode1.pre = temp;
    }

    /**
     * @Description 考虑id顺序，从小到大，重复报错
     * @Param [heroNode1]
     * @Return void
     * @Author zzq
     * @Date 2020/7/28 10:38
     */
    public void add2(HeroNode1 heroNode1) {
        HeroNode1 temp = head.next;
        while (true) {
            if (temp == null) {
                add1(heroNode1);
                break;
            }
            if (temp.id > heroNode1.id) {
                temp.pre.next = heroNode1;
                heroNode1.pre = temp.pre;
                heroNode1.next = temp;
                temp.pre = heroNode1;
                break;
            } else if (temp.id == heroNode1.id) {
                System.out.println("英雄已存在");
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * @Description 修改已经存在的节点
     * @Param [heroNode1]
     * @Return void
     * @Author zzq
     * @Date 2020/7/28 10:24
     */
    public void update(HeroNode1 heroNode1) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode1 temp = head.next;
        while (true) {
            if (temp == null) {
                System.out.println("没有找到节点或节点不存在");
                break;
            }
            if (temp.id == heroNode1.id) {  //判断id是否相等
                temp.name = heroNode1.name;
                temp.nickName = heroNode1.nickName;
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
     * @Date 2020/7/28 10:26
     */
    public void delete(int id) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode1 temp = head.next;
        while (true) {
            if (temp == null) {
                System.out.println("没有找到节点或节点不存在");
                break;
            }
            if (temp.id == id) {    //判断id是否相等
                temp.pre.next = temp.next;
                if (temp.next != null) {
                    temp.next.pre = temp.pre;
                }
                break;
            }
            temp = temp.next;
        }
    }
}

class HeroNode1 {

    public int id;
    public String name;
    public String nickName;
    public HeroNode1 next;//指向下一个节点
    public HeroNode1 pre;//指向上一个节点

    public HeroNode1(int id, String name, String nickName) {
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
