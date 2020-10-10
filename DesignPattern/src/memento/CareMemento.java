package memento;

import java.util.ArrayList;

/**
 * @Description 管理备忘录对象
 * @ClassName CareMemento
 * @Author zzq
 * @Date 2020/10/8 19:29
 */
public class CareMemento {
    private final ArrayList<Memento> mementos;

    public CareMemento() {
        this.mementos = new ArrayList<>();
    }

    public void add(Memento memento) {
        this.mementos.add(memento);
    }

    public Memento get(int index) {
        return mementos.get(index);
    }
}
