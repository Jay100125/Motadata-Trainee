package practical;

import java.util.ArrayList;
import java.util.List;

abstract class Item{
    protected String ItemName;
    protected long ItemId;
    protected boolean isBorrowed;

    public Item(String ItemName, long ItemId)
    {
        this.ItemName = ItemName;
        this.ItemId = ItemId;
        this.isBorrowed = false;
    }

    public boolean isAvailable()
    {
        return !isBorrowed;
    }

    public void borrowItem()
    {
        if(!isBorrowed)
        {
            isBorrowed = true;
            System.out.println(ItemName + " borrowed.");
        }
        else
        {
            System.out.println(ItemName + " is already borrowed.");
        }
    }

    public void returnItem(){
        if(isBorrowed)
        {
            isBorrowed = false;
            System.out.println(ItemName + " returned.");
        }
        else
        {
            System.out.println(ItemName + " is not borrowed.");
        }
    }

    public String getTitle()
    {
        return ItemName;
    }

}

class Book extends Item{
    Book(String ItemName, long ItemId)
    {
        super(ItemName, ItemId);
    }
}

class Magazine extends Item{
    Magazine(String ItemName, long ItemId)
    {
        super(ItemName, ItemId);
    }
}

class Member
{
    String MemberName;
    int MemberId;
    List<Item> borrowedItem;

    Member(String MemberName, int MemberId)
    {
        this.MemberName = MemberName;
        this.MemberId = MemberId;
        this.borrowedItem = new ArrayList<Item>();
    }

    public void borrowItem(Item item)
    {
        if(item.isAvailable())
        {
            item.borrowItem();
            borrowedItem.add(item);
        }
        else {
            System.out.println(item.ItemName + " is not available");
        }
    }

    public void returnItem(Item item)
    {
        if(borrowedItem.contains(item))
        {
            item.returnItem();
            borrowedItem.remove(item);
        }
        else {
            System.out.println(item + " is not available");
        }
    }

    public void displayMyItem()
    {
        System.out.println(MemberName + " borrowed: " + borrowedItem.size());
        for(Item item : borrowedItem)
        {
            System.out.println(item.toString());
        }
    }
}

class Library {
    private List<Item> items;
    private List<Member> members;

    Library()
    {
        this.items = new ArrayList<Item>();
        this.members = new ArrayList<Member>();
    }

    public void addItem(Item item)
    {
        items.add(item);
    }

    public void addMember(Member member)
    {
        members.add(member);
    }

    public void searchItem(String itemName)
    {
        for(Item item : items)
        {
            if(item.getTitle().equalsIgnoreCase(itemName))
            {
                System.out.println("item available");
                return;
            }
        }
        System.out.println("item not found");
    }
}


public class Prac7 {

    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Book 1", 1L);
        Book book2 = new Book("Book 2", 2L);
        Magazine magazine1 = new Magazine("Magazine 1", 1L);
        Magazine magazine2 = new Magazine("Magazine 2", 2L);

        library.addItem(book1);
        library.addItem(magazine1);
        library.addItem(book2);
        library.addItem(magazine2);

        Member member1 = new Member("Jay", 92);
        library.addMember(member1);

        Member member2 = new Member("Jeet", 93);
        library.addMember(member2);

        member1.borrowItem(book1);
        member2.borrowItem(magazine1);
        member2.borrowItem(book2);

        member1.borrowItem(book2);

    }
}
