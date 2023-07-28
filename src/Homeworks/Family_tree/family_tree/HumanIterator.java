package Homeworks.family_tree.family_tree;

import java.util.Iterator;
import java.util.List;

// import Homeworks.family_tree.person.Human;

public class HumanIterator<T> implements Iterator<T> {
    private int index;
    private List<T> humanList;

    public HumanIterator(List<T> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return humanList.size() > index;
    }

    @Override
    public T next() {
        return humanList.get(index++);
    }
}
