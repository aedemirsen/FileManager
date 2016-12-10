/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanager;

/**
 *
 * @author aedemirsen
 */
public class Key {
    
    private final long size;
    private final int keyValue;
    
    public Key(long size, int keyValue){
        this.keyValue = keyValue;
        this.size = size;
    }
    
    public int getKeyValue(){
        return this.keyValue;
    }
    
    public long getSize(){
        return this.size;
    }
    
    
}
