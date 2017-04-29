package com.example.pc.swimapp3.utils;

import android.content.Context;

import com.example.pc.swimapp3.beans.ListItem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.LinkedList;


public class FileManager {
   private final static String FILE_NAME = "items.srl";
    private Context context;
    private LinkedList<ListItem> itemsList = new LinkedList<>();

    public FileManager(Context context){

        this.context = context.getApplicationContext();

    }

    public boolean write(ListItem item){
        read();
        ObjectOutput out;
        itemsList.add(item);
        try {
            out = new ObjectOutputStream(new FileOutputStream(new File(context.getFilesDir(),"")+File.separator+FILE_NAME));
            out.writeObject(itemsList);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public LinkedList<ListItem> read() {
        ObjectInputStream input;

        try {
            input = new ObjectInputStream(new FileInputStream(new File(new File(context.getFilesDir(), "") + File.separator + FILE_NAME)));
            itemsList = (LinkedList<ListItem>) input.readObject();
            input.close();

        } catch (StreamCorruptedException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return itemsList;

    }

}
