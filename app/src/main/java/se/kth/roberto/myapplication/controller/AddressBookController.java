package se.kth.roberto.myapplication.controller;

import java.util.List;
import java.util.Vector;

/**
 * Created by guancio on 03/11/2017.
 */

public class AddressBookController {
    private List<String> names;

    public AddressBookController() {
        names = new Vector<String>();
    }
    public void addName(String name) {
        this.names.add(name);
    }
    public void removeName(String name) {
        int idx = this.names.indexOf(name);
        this.names.remove(idx);
    }
    public List<String> getAllNames() {
        return this.names;
    }
}
