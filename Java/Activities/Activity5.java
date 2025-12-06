package day1;

public class Activity5 {
	public static void main(String []args) {
        //Initialize title of the book
        String title = "THE VEGETARIAN";
        //Create object for MyBook
        Book newNovel = new MyBook();
        //Set title
        newNovel.setTitle(title);
        
        //Print result
        System.out.println("The title is: " + newNovel.getTitle());

}
}
