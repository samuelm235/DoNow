import java.util.ArrayList;
public class ToDoList
{
    ArrayList<String> list = new ArrayList<String>();
    public ToDoList(ArrayList<String> preList)
    {
        list = preList;
    }

    public ToDoList()
    {

    }

    public void addTask(String task)
    {
        list.add(task);
    }

    public void addTask(int index, String task)
    {
        list.add(index, task);
    }

    public void removeTask(int index)
    {
        list.remove(index);
    }


    public toString()
    {
        int item_num = 1;
        for(String s : list)
        {   
            System.out.print(item_num + ": ");
            System.out.println(s);
            item_num++;
        }
    }

} 
