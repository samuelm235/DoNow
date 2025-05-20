public class Item
{
    private String name;
    private String condition;
    private String notes;
    private int quantity;
    private int replace_cost;

    public Item(String n, int q, String c, int rc, String note)
    {
        name = n;
        notes = note;
        condition = c;
        quantity = q;
        replace_cost = rc;

    }

    public String toString()
    {
        String s = name + " / " + quantity + " / " + condition + " / " + replace_cost + " / " + notes;
        return s;

    }
}
