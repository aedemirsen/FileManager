/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanager;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aedemirsen
 */
public class FileOperation {

    public static void write(byte[] b, String path) {
        try (FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(b);
            fos.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileOperation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileOperation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static String getFileExtension(String file) {
        String extension = "", reversed
                = StringOperation.reverse(file);
        for (int i = 0; i < reversed.length(); i++) {
            if (reversed.charAt(i) == '.') {
                break;
            }
            extension = extension.concat(reversed.charAt(i) + "");
        }
        return StringOperation.reverse(extension);
    }

}

class StringOperation {

    public static String reverse(String string) {
        String reversed = "";
        for (int i = string.length() - 1; i >= 0; i--) {
            reversed = reversed.concat(string.charAt(i) + "");
        }
        return reversed;
    }

}
