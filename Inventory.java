import java.util.ArrayList;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.*;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;

public class Inventory
{
    private ArrayList<Tool> itemCollection;
    private static int storageSpace;
    private int usedStorage  = 0;
    public Inventory(ArrayList<Tool> preList, int size)
    {
        itemCollection = preList;
        storageSpace = size;
        for(Tool t : preList)
        {
            usedStorage += t.getQuant();
        }
    }

    public Inventory(int size)
    {
        storageSpace = size;
    }

    public void addItem(Tool newEquipment)
    {
        if(usedStorage < storageSpace)
        {
            itemCollection.add(newEquipment);
            usedStorage += newEquipment.getQuant();
        }
        System.out.println("STORAGE FULL");
    }

    public void addItem(Tool newEquipment, int index)
    {
        if(usedStorage < storageSpace)
        {
            itemCollection.get(index);
            usedStorage += newEquipment.getQuant();
        }
        System.out.println("STORAGE FULL");
    }


    public void removeItem(int index, int amount)
    {
        itemCollection.get(index).changeStock(-amount);
    }

    public String toString()
    {
        String s = "";
        for(Tool t : itemCollection)
        {
            s += t.toString() + "\n";
        }
        return s;
    }

} 
