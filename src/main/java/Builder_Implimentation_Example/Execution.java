package Builder_Implimentation_Example;

public class Execution {

	public static void main(String[] args) {
		
        Name name = new Name.Builder()
                .setFirst("John")
                .setLast("Doe")
                .build();

        System.out.println("First Name: " + name.getFirst());
        System.out.println("Last Name: " + name.getLast());
    }
}
