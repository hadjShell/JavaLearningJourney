package phone;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        myContacts = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact c) {
        boolean flag = false;
        int pos = findContact(c);
        if(pos < 0) {
            myContacts.add(c);
            flag = true;
        }
        return flag;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        boolean flag = false;
        int pos = findContact(oldContact);
        if(pos >= 0) {
            myContacts.set(pos, newContact);
            flag = true;
        }
        return flag;
    }

    public boolean removeContact(Contact c) {
        boolean flag = false;
        int pos = findContact(c);
        if(pos >= 0) {
            myContacts.remove(pos);
            flag = true;
        }
        return flag;
    }

    public Contact queryContact(String name) {
        int pos = findContact(name);
        return pos == -1 ? null : myContacts.get(pos);
    }

    public void printContacts() {
        System.out.println("phone.Contact List: ");
        int num = 1;
        for (Contact c : myContacts) {
            System.out.printf("%d. %s -> %s\n", num++, c.getName(), c.getPhoneNumber());
        }
    }

    private int findContact(Contact contact) {
        return findContact(contact.getName());
    }

    private int findContact(String name) {
        int pos = -1;

        for (Contact c : myContacts) {
            if(c.getName().equals(name)) {
                pos = myContacts.indexOf(c);
                break;
            }
        }

        return pos;
    }
}
