import java.util.ArrayList;


public class Inventory
{
    private ArrayList<Appliance> itemCollection;
    private static int storageSpace;
    private int usedStorage  = 0;

public List<List<Object>> toSheetData() {
    List<List<Object>> data = new ArrayList<>();
    data.add(Arrays.asList("Name", "Quantity", "Condition", "Cost", "Notes")); // header
    for (Appliance a : itemCollection) {
        data.add(Arrays.asList(
            a.getName(),
            a.getQuant(),
            a.getCondition(),
            a.getReplaceCost(),
            a.getNotes()
        ));
    }
    return data;
}


    public Inventory(ArrayList<Appliance> preList, int size)
    {
        itemCollection = preList;
        storageSpace = size;
        for(Appliance t : preList)
        {
            usedStorage += t.getQuant();
        }
    }

    public Inventory(int size)
    {
        storageSpace = size;
    }
    public ArrayList<Appliance> getRawList()
    {
        return itemCollection;
    }

    public void addItem(Appliance newEquipment)
    {
        int amnt = newEquipment.getQuant();
        for(Appliance t : itemCollection)
        {
            if(t.getName().equals(newEquipment.getName()))
            {
                if(usedStorage + amnt < storageSpace)
                {
                    t.changeStock(amnt);
                    usedStorage += amnt;
                    break;
                }
            }
        }
        if(usedStorage + amnt < storageSpace)
        {
            itemCollection.add(newEquipment);
            usedStorage += amnt;
        }
        else{System.out.println("STORAGE TOO FULL");}
    }

    public void addItem(Appliance newEquipment, int index)
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
    
    public void checkCollection()
    {
        for(int i = 0; i < itemCollection.size(); i++)
        {
            if(itemCollection.get(i).getQuant() <= 0)
            {
                itemCollection.remove(i);
            }
        }
    }

    public String toString()
    {
        String s = "";
        for(Appliance t : itemCollection)
        {
            s += t.toString() + "\n";
        }
        return s;
    }

} 
