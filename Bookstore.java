import java.util.ArrayList;
import java.time.LocalTime;
import java.time.LocalDate;
import java.io.*;

public class Bookstore{

    public String Name;
    public String Address;
    public int SqFt;
    public boolean HasNewBooks;
    public boolean HasUsedBooks;

    private boolean open;
    private boolean openWeekends;
    private LocalDate today = LocalDate.now();
    private int dayOfWeek = today.getDayOfWeek().getValue();
    private int currentTime = LocalTime.now().getHour();
    private ArrayList<String> titles;

    
    private static final int OPENING_TIME = LocalTime.parse("07:00").getHour();
    private static final int CLOSING_TIME = LocalTime.parse("20:00").getHour();

    //Public Methods

    public Bookstore() {
        this.Name = "This stores name";
        this.Address = "800 Madison Ave";
        this.SqFt = 1500;
        this.HasNewBooks = true;
        this.HasUsedBooks = true;
        this.open = this.isOpen(currentTime); //cant make it work
        this.openWeekends = true;

        //loads books
        titles = new ArrayList<String>();
        loadTitles();
    }

    public Bookstore(String name, String address) {
        this.Name = name;
        this.Address = address;
        this.SqFt = 1000;
        this.HasNewBooks = true;
        this.HasUsedBooks = true;
        this.open = this.isOpen(currentTime); //cant make it work
        this.openWeekends = true;

        //loads books
        titles = new ArrayList<String>();
        loadTitles();
    }

    public Bookstore(String name, String address, int sqft) {
        this.Name = name;
        this.Address = address;
        this.SqFt = sqft;
        this.HasNewBooks = true;
        this.HasUsedBooks = true;
        this.open = this.isOpen(currentTime); //still cant make it work
        this.openWeekends = true;

        //loads more books
        titles = new ArrayList<String>();
        loadTitles();
    }

    
    public boolean isOpen() {

        if (!this.openWeekends & dayOfWeek == 6 && dayOfWeek == 7) {
            this.open = false;
        }

        if (this.open) {
            System.out.println("We are currently open");
            return true;
        } else {
            System.out.println("No, we are closed");
            return false;
        }
    }

    private boolean isOpen(int time) {

        if (time >= OPENING_TIME && time < CLOSING_TIME) {
            return true;
        } else {
            return false;
        }
    }

    private void loadTitles() {
        try {
            utils.loadStringsToArray(this.titles);
        } catch (IOException e) {
            // for now simply init the array to zero
            System.out.println("Could not initilize the titles");
            // make sure it is empty
            this.titles = new ArrayList<String>();
        }
    }

    //sets and gets Name
    public String getName() {System.out.println(Name); return Name;}
    public void setName(String name) {this.Name = name;}

    //sets and gets Address
    public String getAddress() {System.out.println(Address); return Address;} 
    public void setAddress(String address) {this.Address = address;}

    //sets and gets SqFt
    public int getSqFt() {System.out.println(SqFt + " sqft"); return SqFt;}
    public void setSqFt(int squareFeet) {this.SqFt = squareFeet;}

    //sets and gets hasNewBooks
    public boolean getHasNewBooks(){System.out.println("Any new books? : " + HasNewBooks); return HasNewBooks;}
    public void setHasNewBooks(boolean newBook){this.HasNewBooks = newBook;}

    //sets and gets hasUsedBooks
    public boolean getHasUsedBooks(){System.out.println("Any used books? : " + HasUsedBooks); return HasUsedBooks;}
    public void setHasUsedBooks(boolean used){this.HasUsedBooks = used;}

    //gets store hours
    public void getStoreHours() {
        System.out.println("We are open " + OPENING_TIME + ":00 to " + CLOSING_TIME + ":00.");
    }

    //method for getting titles 
    public void getTitles () {
        System.out.println("Beginning of Book List:");
        for (String book : titles) {
            System.out.println(book);
        }
        System.out.println("End of Book List:");
    }

    public static void main(String[] args) {
        
        Bookstore myStore = new Bookstore("This Bookstore", "Tacoma Ave");

        myStore.getAddress();      
    
        myStore.isOpen();
        
        myStore.getStoreHours();

        myStore.getSqFt();

        myStore.getHasNewBooks();
        myStore.getHasUsedBooks();

        myStore.getTitles();

    }

}

//help me