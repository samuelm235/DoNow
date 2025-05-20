import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        Inventory doing = new Inventory();
        doing.addTask("pet cats");
        doing.addTask("clean room");
        doing.addTask(0, "war crimes");
        System.out.println(doing);
    }
}