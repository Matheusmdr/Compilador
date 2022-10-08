/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Matheus
 */
public class FileFilterTXT extends FileFilter {

    @Override
    public boolean accept(File f) {
        return f.isDirectory() || f.getName().endsWith(".txt");
    }

    @Override
    public String getDescription() {
        return ".txt";
    }
}
