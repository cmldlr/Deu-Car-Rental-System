
public class Customer {

    //Each customer has his/her unique ID, name, surname. Customers request cars from the company.
    private String c_name;
    private String c_surname;
    private int c_id;
    private int rc_counter_custo;

    public Customer(String customer_name, String customer_surname, int c_id){
        this.c_name=customer_name;
        this.c_surname=customer_surname;
        this.c_id=c_id;
    }

    public Customer() {
    }
    public Customer(int c_id){
        this.c_id=c_id;
    }
    public void listCustomer() {
        System.out.println("   "+this.c_id+".Customer;"+this.c_name+";"+this.c_surname);

    }
    public void addCustomer() {
        System.out.println(">addCustomer;"+this.c_name+";"+this.c_surname);
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_surname() {
        return c_surname;
    }

    public void setC_surname(String c_surname) {
        this.c_surname = c_surname;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public int getRc_counter_custo() { //counters for Statistics
        return rc_counter_custo;
    }

    public void setRc_counter_custo() {
        this.rc_counter_custo +=1;
    }




}