package tree;

public class Node extends ListItem{
    public Node(Object value) {
        super(value);
    }

    @Override
    ListItem next() {
        return rightLink;
    }

    @Override
    ListItem setNext(ListItem i) {
        rightLink = i;
        return rightLink;
    }

    @Override
    ListItem previous() {
        return leftLink;
    }

    @Override
    ListItem setPrevious(ListItem i) {
        leftLink = i;
        return leftLink;
    }

    @Override
    int compareTo(ListItem i) {
        Comparable myValue = (Comparable) this.value;
        return myValue.compareTo(i.getValue());
    }
}
