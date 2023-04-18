package com.bing.mini.beans.factory.config;


import java.util.ArrayList;
import java.util.List;

public class ConstructorArgumentValues {

    private final List<ConstructorArgumentValue> ConstructorArgumentValueList = new ArrayList<ConstructorArgumentValue>();

    public ConstructorArgumentValues() {
    }

    public void addConstructorArgumentValue(ConstructorArgumentValue ConstructorArgumentValue) {
        this.ConstructorArgumentValueList.add(ConstructorArgumentValue);
    }

    public ConstructorArgumentValue getIndexedConstructorArgumentValue(int index) {
        ConstructorArgumentValue ConstructorArgumentValue = this.ConstructorArgumentValueList.get(index);
        return ConstructorArgumentValue;
    }

    public int getArgumentCount() {
        return (this.ConstructorArgumentValueList.size());
    }

    public boolean isEmpty() {
        return (this.ConstructorArgumentValueList.isEmpty());
    }
}
