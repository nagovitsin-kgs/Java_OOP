package Homeworks.family_tree.model.family_tree;

import java.util.Iterator;
import java.util.List;

// import Homeworks.family_tree.person.Human;

public class HumanIterator<E extends FamilyTreeItemInter<E>> implements Iterator<E> {
    private int index;
    private List<E> humanList;

    public HumanIterator(List<E> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return humanList.size() > index;
    }

    @Override
    public E next() {
        return humanList.get(index++);
    }

}
