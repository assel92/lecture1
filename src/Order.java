public class Order {
    private int id;
    private static int id_gen=1;
    private String status;
    private int days;
    public Order(){
        id=id_gen++;
    }
    public Order(String status, int days) {
        this();
        setStatus(status);
        setDays(days);
    }
    public int getId(){
        return id;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status=status;
    }
    public void setDays(int days){
        this.days=days;
    }
    public int getDays(){
        return days;
    }
    public String toString(){
        return id + ": " +  status + " " + days+" days until arrive";
    }
}

