/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanager;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aedemirsen
 */
public class Value {

    private final File file;
    private int quantity;
    private final long sizeInBytes;
    private final String fileName;

    public Value(File f, Long sizeInBytes) {
        this.file = f;
        this.sizeInBytes = sizeInBytes;
        this.quantity = 1;
        fileName = f.getName();
    }

    public void increaseQuantity() {
        quantity++;
    }

    public long getSizeInBytes() {
        return this.sizeInBytes;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public File getFile() {
        return this.file;
    }
    
    public String getFileName() {
        return this.fileName;
    }

    public boolean isSameValue(Value v) {
        boolean b = true;
        if (this.getSizeInBytes() == v.getSizeInBytes()) {
            try {
                InputStream is1 = this.file.toURI().toURL().openStream();
                byte[] b1 = new byte[is1.available()];
                is1.read(b1);
                InputStream is2 = v.getFile().toURI().toURL().openStream();
                byte[] b2 = new byte[is2.available()];
                is2.read(b2);
                for (int i = 0; i < b1.length; i++) {
                    if (b1[i] != b2[i]) {
                        b = false;
                        break;
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(Value.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else b = false;
        return b;
    }
   

}
