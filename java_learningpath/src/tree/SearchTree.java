package tree;

public class SearchTree implements NodeList{
    private ListItem root;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return root;
    }

    @Override
    public boolean addItem(ListItem addedItem) {
        if(root == null) {
            root = addedItem;
            return true;
        }

        ListItem currentItem = root;
        ListItem tail = root;
        boolean goLeft = true;
        while(currentItem != null) {
            tail = currentItem;
            int compare = addedItem.compareTo(currentItem);
            if(compare < 0) {
                currentItem = currentItem.previous();
                goLeft = true;
            }
            else if(compare > 0) {
                currentItem = currentItem.next();
                goLeft = false;
            }
            else
                return false;
        }

        if(goLeft) {
            tail.setPrevious(addedItem);
        }
        else {
            tail.setNext(addedItem);
        }
        return true;
    }

    @Override
    public boolean removeItem(ListItem removedItem) {
        if(removedItem == null)
            return false;

        ListItem currentItem = root;
        // fake a parent for root
        ListItem parent = new Node(null);
        parent.setPrevious(root);


        while(currentItem != null) {
            int compare = removedItem.compareTo(currentItem);
            // Found
            if(compare == 0) {
                // only one node
                if(currentItem == root && currentItem.previous() == null && currentItem.next() == null)
                    root = null;
                else {
                    performRemoval(currentItem, parent);
                    // remove root node
                    if (currentItem == root)
                        root = parent.previous();
                }
                return true;
            }
            else {
                parent = currentItem;
                if (compare < 0) {
                    currentItem = currentItem.previous();
                }
                else if (compare > 0) {
                    currentItem = currentItem.next();
                }
            }
        }
        // no node
        return false;
    }

    private void performRemoval(ListItem removedItem, ListItem parent) {
        // leaf node
        if(removedItem.previous() == null && removedItem.next() == null) {
            if(parent.previous() == removedItem)
                parent.setPrevious(null);
            else
                parent.setNext(null);
            return;
        }

        // Removed node only has right branch
        else if(removedItem.previous() == null) {
            if(parent.previous() == removedItem) {
                parent.setPrevious(removedItem.next());
            }
            else {
                parent.setNext(removedItem.next());
            }
            return;
        }
        // Removed node only has left branch
        else if(removedItem.next() == null) {
            if(parent.previous() == removedItem) {
                parent.setPrevious(removedItem.previous());
            }
            else {
                parent.setNext(removedItem.previous());
            }
            return;
        }

        // Removed node has two branches
        else {
            // Search biggest node in removed node left branch
            ListItem biggestInLeft = removedItem.previous();
            ListItem biggestParent = removedItem;
            while(biggestInLeft.next() != null) {
                biggestParent = biggestInLeft;
                biggestInLeft = biggestInLeft.next();
            }


            // Remove node and put the biggest found node in the position
            biggestParent.setNext(biggestInLeft.previous());
            biggestInLeft.setPrevious(removedItem.previous());
            biggestInLeft.setNext(removedItem.next());
            if(parent.previous() == removedItem) {
                parent.setPrevious(biggestInLeft);
            }
            else {
                parent.setNext(biggestInLeft);
            }
            return;
        }
    }

    @Override
    public void traverse(ListItem root) {
        if(root == null) {
            return;
        }

        traverse(root.previous());
        System.out.println(root.getValue());
        traverse(root.next());
    }
}
