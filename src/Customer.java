public class Customer {
    private int id;
    private static int id_gen = 1;
    private String firstName;
    private String lastName;
    private String email;

    public Customer(String firstName, String lastName, String email) {
        this.id = id_gen++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + ": " + firstName + " " + lastName + " (" + email + ")";
    }
}