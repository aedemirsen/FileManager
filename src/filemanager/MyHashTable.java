/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanager;

import java.io.File;

/**
 *
 * @author aedemirsen
 */
public class MyHashTable {

    private final Value[] values;
    private int size;
    private final int TABLE_LENGTH;
    private long sourceSize;
    private long destSize;

    public MyHashTable(int length) {
        size = 0;
        sourceSize = 0;
        destSize = 0;
        values = new Value[length];
        this.TABLE_LENGTH = length;
    }

    public int getSize() {
        return this.size;
    }

    public void put(Value value) {
        if (size == TABLE_LENGTH) {
            throw new MyHashTableException("Table is full!");
        }
        int hash = (int) value.getSizeInBytes() % TABLE_LENGTH;
        if (values[hash] == null) {
            values[hash] = value;
            destSize += value.getSizeInBytes();
            size++;
        } else if (values[hash].isSameValue(value)) {
            values[hash].increaseQuantity();
        } else {
            while (values[hash] != null) {
                hash++;
                if (hash == TABLE_LENGTH) {
                    hash = 0;
                }
                if (values[hash] != null && values[hash].isSameValue(value)) {
                    values[hash].increaseQuantity();
                    return;
                }
            }
            values[hash] = value;
            size++;
            destSize += value.getSizeInBytes();
        }
        sourceSize += value.getSizeInBytes();
    }

    public Value[] getValues() {
        Value[] v = new Value[size];
        int j = 0;
        for (int i = 0; i < TABLE_LENGTH; i++) {
            if (values[i] != null) {
                v[j] = values[i];
                j++;
            }
        }
        return v;
    }

    public long getSourceSize() {
        return this.sourceSize;
    }

    public long getDestSize() {
        return this.destSize;
    }

    public File[] getValueFile() {
        File[] file = new File[size];
        int j = 0;
        for (int i = 0; i < TABLE_LENGTH; i++) {
            if (values[i] != null) {
                file[j] = values[i].getFile();
                j++;
            }
        }
        return file;
    }

    void print() {
        for (Value value : values) {
            try {
                System.out.print(value.getSizeInBytes() + "--");
            } catch (Exception e) {
                System.out.print("NULL--");
            }
        }
    }

}

class MyHashTableException extends RuntimeException {

    public MyHashTableException(String msg) {
        super(msg);
    }

}
