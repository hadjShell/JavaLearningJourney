package tree;

public class MyLinkedList implements NodeList{
    private ListItem root;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return root;
    }

    @Override
    public boolean addItem(ListItem addedItem) {
        // no nodes
        if(root == null) {
            root = addedItem;
            return true;
        }

        // Insert as root
        if(root.compareTo(addedItem) > 0) {
            addedItem.setNext(root);
            root.setPrevious(addedItem);
            root = addedItem;
            return true;
        }

        // Same as root
        if(root.compareTo(addedItem) == 0)
            return false;


        ListItem currentItem = root.next();
        ListItem tail = root;
        while (currentItem != null) {
            tail = currentItem;

            int compare = addedItem.compareTo(currentItem);
            // insert between nodes
            if (compare < 0) {
                currentItem.previous().setNext(addedItem);
                addedItem.setPrevious(currentItem.previous());
                addedItem.setNext(currentItem);
                currentItem.setPrevious(addedItem);
                return true;
            }
            else if (compare > 0) {
                currentItem = currentItem.next();
            }
            else
                return false;
        }

        // insert to tail
        tail.setNext(addedItem);
        addedItem.setPrevious(tail);
        return true;

    }

    @Override
    public boolean removeItem(ListItem removedItem) {
        if(removedItem == null)
            return false;

        ListItem currentItem = root;
        while(currentItem != null) {
            if(currentItem.compareTo(removedItem) == 0) {
                // only one node
                if(currentItem == root && currentItem.next() == null) {
                    root = null;
                }
                // remove root
                else if(currentItem == root) {
                    currentItem.next().setPrevious(null);
                    root = currentItem.next();
                }
                //remove tail
                else if(currentItem.next() == null) {
                    currentItem.previous().setNext(null);
                }
                // remove middle node
                else {
                    currentItem.previous().setNext(currentItem.next());
                    currentItem.next().setPrevious(currentItem.previous());
                }
                return true;
            }
            currentItem = currentItem.next();
        }
        // no node
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if(root == null) {
            System.out.println("This list is empty");
            return;
        }

        ListItem currentItem = root;
        while(currentItem != null) {
            System.out.println(currentItem.getValue());
            currentItem = currentItem.next();
        }
    }
}
