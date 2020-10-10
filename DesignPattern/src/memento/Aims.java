package memento;

/**
 * @Description 目标对象
 * @ClassName Aims
 * @Author zzq
 * @Date 2020/10/8 19:17
 */
public class Aims {
    private String attack;  //攻击力属性
    private String defense; //防御力属性

    public Aims(String attack, String defense) {
        this.attack = attack;
        this.defense = defense;
    }

    public String getAttack() {
        return attack;
    }

    public void setAttack(String attack) {
        this.attack = attack;
    }

    public String getDefense() {
        return defense;
    }

    public void setDefense(String defense) {
        this.defense = defense;
    }

    /**
     * @Description 将攻击力与防御力属性保存在备忘录对象中
     * @Param []
     * @Return memento.Memento
     * @Author zzq
     * @Date 2020/10/8 19:26
     */
    public Memento save() {
        return new Memento(this.attack, this.defense);
    }

    /**
     * @Description 从备忘录对象中读取保存的信息
     * @Param [memento]
     * @Return void
     * @Author zzq
     * @Date 2020/10/8 19:26
     */
    public void read(Memento memento) {
        this.attack = memento.getAttack();
        this.defense = memento.getDefense();
    }

    public void show(){
        System.out.println("角色攻击力为：" + this.attack);
        System.out.println("角色防御力为：" + this.defense);
    }
}
