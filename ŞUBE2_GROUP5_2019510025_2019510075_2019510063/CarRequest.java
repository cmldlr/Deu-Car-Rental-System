
public class CarRequest {
    private Office office;
    private Customer customer;
    private Car car;
    private Date startdate;
    private Date enddate;
    private int carrequest_id;

    public CarRequest(Office office,Customer customer,Car car,Date startdate,Date enddate,int carrequest_id) {
        this.office = office;
        this.customer=customer;
        this.car=car;
        this.carrequest_id=carrequest_id;
        this.startdate = startdate;
        this.enddate = enddate;
    }
    public void addCarrequest(){
        System.out.println(">addCarRequest;"+this.office.getOff_id()+";"+this.customer.getC_id()+";"+this.car.getBrand()+";"
                +this.car.getModel()+";"+this.car.getCarClass()+";"+this.startdate.getDay()+"."+this.startdate.getMonth()+"."+
                this.startdate.getYear()+";"+this.enddate.getDay()+"."+this.enddate.getMonth()+"."+this.enddate.getYear());
    }
    public void listCarrequest(){
        System.out.println("   "+this.carrequest_id+".CarRequest;"+this.office.getOff_id()+";"+this.customer.getC_id()+";"+this.car.getBrand()+";"
                +this.car.getModel()+";"+this.car.getCarClass()+";"+this.startdate.getDay()+"."+this.startdate.getMonth()+"."+
                this.startdate.getYear()+";"+this.enddate.getDay()+"."+this.enddate.getMonth()+"."+this.enddate.getYear());

    }
    public void addCarRequestRandom(){
        System.out.println(">addCarRequestRandom;"+this.office.getOff_id()+";"+this.customer.getC_id()+";"+this.car.getBrand()+";"
                +this.car.getModel()+";"+this.car.getCarClass()+";"+this.startdate.getDay()+"."+this.startdate.getMonth()+"."+
                this.startdate.getYear()+";"+this.enddate.getDay()+"."+this.enddate.getMonth()+"."+this.enddate.getYear());
    }
    public void addCarRequestNRandom(){
        System.out.println(">addCarRequestRandom;"+this.office.getOff_id()+";"+this.customer.getC_id()+";"+this.car.getBrand()+";"
                +this.car.getModel()+";"+this.car.getCarClass()+";"+this.startdate.getDay()+"."+this.startdate.getMonth()+"."+
                this.startdate.getYear()+";"+this.enddate.getDay()+"."+this.enddate.getMonth()+"."+this.enddate.getYear());
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
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
}