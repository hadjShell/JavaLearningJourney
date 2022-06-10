package tree;

public interface NodeList {
    ListItem getRoot();
    boolean addItem(ListItem i);
    boolean removeItem(ListItem i);
    void traverse(ListItem root);
}
