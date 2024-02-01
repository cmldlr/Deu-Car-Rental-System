
import java.util.Random;
public class Car {

    private int officeId;
    private int km;
    private String brand;
    private String model;
    private String carClass;
    private int car_id;
    private boolean car_available;
    private int mrc_counter; //most rented car
    private int class_counter;
    public Car() {
    }

    public Car(String brand, String model, String carClass, int km, int officeId,int car_id,boolean car_available) {
        this.officeId = officeId;
        this.km = km;
        this.brand = brand;
        this.model = model;
        this.carClass = carClass;
        this.car_id=car_id;
        this.car_available=car_available;
        mrc_counter=0;
    }
    public Car(String brand,String model,String carClass){
        this.brand = brand;
        this.model = model;
        this.carClass = carClass;
    }



    public void listCar() {
        if(car_available==true){ //availability of car
            System.out.println("   "+this.car_id+".Car;"+this.brand+";"+this.model+";"+this.carClass+";"+this.km+";"+this.officeId +"- available");
        }
        else{
            System.out.println("   "+this.car_id+".Car;"+this.brand+";"+this.model+";"+this.carClass+";"+this.km+";"+this.officeId +"- not available");
        }

    }
    public void addCar() {
        System.out.println(">addCar;"+this.brand+";"+this.model+";"+this.carClass+";"+this.km+";"+this.officeId);
    }
    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public int getKm() {
        return km;
    }

    public int[] getIncomes() { //calculating incomes
        int[]arr_pro=new int[6];
        int incomes=0;
        int performance_bonus=0;
        int every100km=0;
        int maintance1=0;
        int totalmaintance=0;
        switch(this.carClass) {
            case "economy":
                incomes=100;
                performance_bonus=5;
                switch(this.km) {
                    case 100:
                        every100km=5;
                        break;
                    case 200:
                        every100km=10;
                        break;
                    case 300:
                        every100km=15;
                        break;
                }
                maintance1=20;
                totalmaintance=maintance1+every100km;
                break;
            case "sports":
                incomes=200;
                performance_bonus=10;
                switch(this.km) {
                    case 100:
                        every100km=10;
                        break;
                    case 200:
                        every100km=20;
                        break;
                    case 300:
                        every100km=30;
                        break;
                }
                maintance1=70;
                totalmaintance=maintance1+every100km;
                break;
            case "luxury":
                incomes=300;
                performance_bonus=15;
                switch(this.km) {
                    case 100:
                        every100km=15;
                        break;
                    case 200:
                        every100km=30;
                        break;
                    case 300:
                        every100km=45;
                        break;
                }
                maintance1=120;
                totalmaintance=maintance1+every100km;
                break;
        }
        arr_pro[0]=incomes;
        arr_pro[1]=performance_bonus;
        arr_pro[3]=maintance1;
        arr_pro[4]=every100km;
        arr_pro[5]=totalmaintance;
        return arr_pro;
    }

    public void setKm() { //setting km randomly
        Random rand= new Random();
        int rand_km = rand.nextInt(3)+1;
        switch(rand_km) {
            case 1:
                this.km=100;
                break;
            case 2:
                this.km=200;
                break;
            case 3:
                this.km=300;
                break;

        }

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCarClass() {
        return carClass;
    }

    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }
    public boolean isCar_available() {
        return car_available;
    }

    public void setCar_available(boolean car_available) {
        this.car_available = car_available;
    }

    public int getMrc_counter() {
        return mrc_counter;
    }

    public void setMrc_counter() {
        this.mrc_counter +=1;
    }


}
