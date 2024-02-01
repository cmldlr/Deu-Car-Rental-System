public class Contract {
    private int contract_id;
    private Customer customer;
    private Car car;
    private Date startdate;
    private Date enddate;
    private Employee employee;
    private boolean contract_availability;
    private int day_counter;
    public Contract(Employee employee, Customer  customer, Car car, Date startdate, Date enddate,int contract_id) {
        this.employee=employee;
        this.contract_id = contract_id;
        this.customer =  customer;
        this.car = car;
        this.startdate = startdate;
        this.enddate = enddate;
        this.contract_availability=true;
        day_counter=1;
        car.setMrc_counter(); //when a contract is created, counters will increase
        employee.setRc_counter_emp();
        customer.setRc_counter_custo();
    }
    public int getContract_id() {
        return contract_id;
    }

    public boolean isContract_availability() {
        return contract_availability;
    }
    public void setContract_availability(boolean contract_availability) {
        this.contract_availability = contract_availability;
    }
    public void setContract_id(int contract_id) {
        this.contract_id = contract_id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    public void addContract(){
        System.out.println("   Contract:Employee"+this.employee.getEmp_id()+";Customer"+this.customer.getC_id()+";Car"+this.car.getCar_id()+
                ";"+this.startdate.getDay()+"."+this.startdate.getMonth()+"."+this.startdate.getYear()+";"+this.enddate.getDay()+"."+
                this.enddate.getMonth()+"."+this.enddate.getYear());
    }
    public void listContract(){
        System.out.println("   "+this.contract_id+".Contract:Employee"+this.employee.getEmp_id()+";Customer"+this.customer.getC_id()+";Car"+this.car.getCar_id()+
                ";"+this.startdate.getDay()+"."+this.startdate.getMonth()+"."+this.startdate.getYear()+";"+this.enddate.getDay()+"."+
                this.enddate.getMonth()+"."+this.enddate.getYear());

    }
    public Date getStartdate() {
        return startdate;
    }
    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }
    public Date getEnddate() {
        return enddate;
    }
    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public int getDay_counter() {
        return day_counter;
    }
    public void setDay_counter() {
        this.day_counter+=1;
    }
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}