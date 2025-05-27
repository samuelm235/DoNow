import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose Your Adventure: " + "\n" + "1: Print Inventory" + "\n" + "2: Add Items" + "\n" + "3: Remove Items" + "\n");1
        int decision = input.nextInt();
        input.close();
        String scale1 = "Very Good"; String scale2 = "Good"; String scale3 = "Fair"; String scale4 = "Poor"; String scale5 = "DEMOLISHED";
        Appliance a = new Appliance("Couch", 1, scale5, 50, "Two legs fallen off, stiches ripped");
        Appliance b = new Appliance("3D Printer", 5, scale3, 200, "soooo hard to fix these thingys");
        ArrayList<Appliance> items = new ArrayList<Appliance>();
        items.add(a); items.add(b);
        Inventory doing = new Inventory(items, 20);
        if(decision == 1) System.out.println(doing);

    }
}