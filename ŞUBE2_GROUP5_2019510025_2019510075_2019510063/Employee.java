
public class Employee {
    private int empoff_id;
    private String emp_name;
    private String emp_surn;
    private String emp_gen;
    private String emp_bday;
    private int emp_id;
    private boolean emp_available;
    private int rc_counter_emp; //rented car
    private int count_emp_available=0;


    public Employee() {

    }

    public Employee(String emp_name,String emp_surn, String emp_gen,String emp_bday,int emp_id,String empoff_id,boolean emp_available) {
        this.emp_name = emp_name;
        this.emp_surn = emp_surn;
        this.emp_gen = emp_gen;
        this.emp_bday = emp_bday;
        this.emp_id = emp_id;
        this.empoff_id=Integer.parseInt(empoff_id);
        this.emp_available=emp_available;
        rc_counter_emp=0;

    }

    public void addEmployee() {
        System.out.println(">addEmployee;"+this.emp_name+";"+this.emp_surn+";"+this.emp_gen+";"+this.emp_bday+";"+this.empoff_id);

    }
    public void listEmployee() {
        System.out.println("   "+this.emp_id+".Employee;"+this.emp_name+";"+this.emp_surn+";"+this.emp_gen+";"+this.emp_bday+";"+this.empoff_id);

    }
    public void addAvailableEmpForRc(int emp_count){
        this.count_emp_available+=emp_count;
    }

    public int getCount_emp_available() {
        return count_emp_available;
    }

    public void setCount_emp_available(int count_emp_available) {
        this.count_emp_available = count_emp_available;
    }

    public String getEmp_name() {
        return emp_name;
    }
    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }
    public String getEmp_surn() {
        return emp_surn;
    }
    public void setEmp_surn(String emp_surn) {
        this.emp_surn = emp_surn;
    }
    public String getEmp_gen() {
        return emp_gen;
    }
    public void setEmp_gen(String emp_gen) {
        this.emp_gen = emp_gen;
    }
    public String getEmp_bday() {
        return emp_bday;
    }
    public void setEmp_bday(String emp_bday) {
        this.emp_bday = emp_bday;
    }

    public int getEmp_id() {
        return emp_id;
    }
    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }
    public int getEmp_offid() {
        return empoff_id;
    }
    public void setEmp_offid(String s_emp_id) {
        this.empoff_id = Integer.parseInt(s_emp_id);
    }

    public void setEmp_available(boolean emp_available) {
        this.emp_available = emp_available;
    }

    public boolean isEmp_available() {
        return emp_available;
    }

    public int getRc_counter_emp() {
        return rc_counter_emp;
    }

    public void setRc_counter_emp() {
        this.rc_counter_emp +=1;
    }

}