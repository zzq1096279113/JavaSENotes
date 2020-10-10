package memento;

/**
 * @Description 备忘录对象
 * @ClassName Memento
 * @Author zzq
 * @Date 2020/10/8 19:22
 */
public class Memento {
    private final String attack;
    private final String defense;

    public Memento(String attack, String defense) {
        this.attack = attack;
        this.defense = defense;
    }

    public String getAttack() {
        return attack;
    }

    public String getDefense() {
        return defense;
    }
}
