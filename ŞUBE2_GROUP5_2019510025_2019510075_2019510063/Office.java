//import java.util.Arrays;

public class Office {
    private int emp_count_off; //eco
    private int car_count_off; //cco
    private Employee[] emp_in_off;
    private Car[] car_in_off;
    private Contract[] contract_in_off;
    private int off_id;
    private String p_num;
    private String adress;
    private String city;
    private int eco_starter=0;
    private int cco_starter=0;
    private int cc_starter;
    private int cc_counter;
    private boolean office_available;
    private int cn_car=0;
    private int cn_car_eco=0;
    private int cn_car_sp=0;
    private int cn_car_lux=0;
    private int cn_employee=0;
    private int cp;

    public Office() {

    }
    public Office(int off_id){
        this.off_id=off_id;

    }
    public Office(String p_num,String adress,String city,int id,int emp_count_off,int car_count_off) {
        this.off_id=id;
        this.p_num=p_num;
        this.adress=adress;
        this.city=city;
        this.car_count_off=car_count_off;
        car_in_off= new Car [car_count_off];
        this.emp_count_off = emp_count_off;
        emp_in_off= new Employee [emp_count_off];
        this.office_available=true;
        cp=0;
        contract_in_off=new Contract[20];
        cc_starter=0;
        cc_counter=0;

    }

    public void addContforoff(Contract contract) {
        contract_in_off[cc_starter]=contract;
        cc_starter++;
        cc_counter++;
    }
    public void deleteEmployee(int emp_id){ //method for deleting employee 
        for(int i=0;i<emp_in_off.length;i++){
            if(emp_in_off[i] !=null ){
                if(emp_in_off[i].getEmp_id()==emp_id){
                    for(int j=i+1;j<emp_in_off.length-1;j++){
                        emp_in_off[j-1]=emp_in_off[j];
                    }
                    emp_count_off=emp_count_off-1;
                    eco_starter--;
                }
            }
        }
    }
    public void addOffice() {
        System.out.println(">addOffice;"+this.p_num+";"+this.adress+";"+this.city);

    }
    public void listOffice() {

        System.out.println("     "+this.off_id+".Office;"+this.p_num+";"+this.adress+";"+this.city);

    }

    public int getOff_id() {
        return off_id;
    }


    public Contract[] getContract_in_off() {
        return contract_in_off;
    }
    public void setContract_in_off(Contract[] contract_in_off) {
        this.contract_in_off = contract_in_off;
    }
    public void setOff_id(int off_id) {
        this.off_id = off_id;
    }

    public int getCar_count_off() {
        return car_count_off;
    }


    public void setCar_count_off(int car_count_off) {
        this.car_count_off = car_count_off;
        car_in_off= new Car [car_count_off];
    }


    public Car[] getCar_in_off() {
        return car_in_off;
    }


    public void addCar_in_off(Car cio) { //adding car
        car_in_off[cco_starter]= cio;
        if(cco_starter<getCar_count_off()) {
            cco_starter++;}
        else {
            //fazla car error mesajı?

        }
    }

    public int getEmp_count_off() {
        return emp_count_off;
    }

    public void setEmp_count_off(int emp_count_off) {
        this.emp_count_off = emp_count_off;
        emp_in_off= new Employee [emp_count_off];

    }
    public Employee[] getEmp_in_off() {
        return emp_in_off;
    }
    //sorting arrays for profit and statistics
    private void sortingArray(Car [] cararr, int[] mrcarr, int temp1,Car cartemp) { 
        for(int i=0;i<cararr.length;i++) {
            for(int j=1;j<cararr.length-1;j++) {
                if(cararr[i]!=null && mrcarr[j - 1] < mrcarr[j]) {
                    temp1 = mrcarr[j - 1];
                    mrcarr[j - 1] = mrcarr[j];
                    mrcarr[j] = temp1;
                    cartemp = cararr[j - 1];
                    cararr[j - 1] = cararr[j];
                    cararr[j] = cartemp;
                }
            }
        }
    }
    private void sortingArrayemp(Employee[]emparr,int[] rcemp,int temprc,Employee tempemp) {
        for(int i=0;i<emparr.length;i++) {
            for(int j=1;j<emparr.length-1;j++) {
                if(emparr[i]!=null && rcemp[j - 1] < rcemp[j]) {
                    temprc = rcemp[j - 1];
                    rcemp[j - 1] = rcemp[j];
                    rcemp[j] = temprc;
                    tempemp = emparr[j - 1];
                    emparr[j - 1] = emparr[j];
                    emparr[j] = tempemp;
                }
            }
        }
    }
    private void sortingArrayemp1(Employee[]emparr,int[] rcemp,int temprc,Employee tempemp,Contract[] contarr,Contract tempcont) {
        for(int i=0;i<emparr.length;i++) {
            for(int j=1;j<emparr.length-1;j++) {
                if(contarr[i]!=null && emparr[i]!=null &&rcemp[j - 1] < rcemp[j]) {
                    temprc = rcemp[j - 1];
                    rcemp[j - 1] = rcemp[j];
                    rcemp[j] = temprc;
                    tempemp = emparr[j - 1];
                    emparr[j - 1] = emparr[j];
                    emparr[j] = tempemp;
                    tempcont = contarr[j - 1];
                    contarr[j - 1] = contarr[j];
                    contarr[j] = tempcont;
                }
            }
        }
    }

    private void sortingArraycusto(Customer[]custoarr,int[] rccusto,int temprc_1,Customer tempcusto) {
        for(int i=0;i<custoarr.length;i++) {
            for(int j=1;j<custoarr.length-1;j++) {
                if(custoarr[i]!=null && rccusto[j - 1] < rccusto[j]) {
                    temprc_1 = rccusto[j - 1];
                    rccusto[j - 1] = rccusto[j];
                    rccusto[j] = temprc_1;
                    tempcusto = custoarr[j - 1];
                    custoarr[j - 1] = custoarr[j];
                    custoarr[j] = tempcusto;
                }
            }
        }
    }
    public int getCc_counter() {
        return cc_counter;
    }
    public void setCc_counter(int cc_counter) {
        this.cc_counter = cc_counter;
    }
    public void addEmp_in_off(Employee eio) {
        emp_in_off[eco_starter]=eio;
        if(eco_starter<3) {
            eco_starter++;
        }
        else {
            System.out.println("**ERROR** An office can have maximum 3 employees");
        }
    }

    public String getP_num() {
        return p_num;
    }

    public void setP_num(String p_num) {
        this.p_num = p_num;

    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public int getCc_starter() {
        return cc_starter;
    }
    public void setCc_starter(int cc_starter) {
        this.cc_starter = cc_starter;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public int getEco_starter() {
        return eco_starter;
    }

    public void setEco_starter(int eco_starter) {
        this.eco_starter = eco_starter;
    }

    public boolean isOffice_available() {
        return office_available;
    }

    public void setOffice_available(boolean office_available) {
        this.office_available = office_available;
    }
    public void addRecommendationForCar(int count_car){ //counters for comparing recommendation 
        this.cn_car+=count_car;
    }
    public void addForRecCarEco(int cn_car_eco){
        this.cn_car_eco+=cn_car_eco;
    }
    public void addForRecCarSp(int cn_car_sp){
        this.cn_car_sp+=cn_car_sp;
    }
    public void addForRecCarLux(int cn_car_lux){
        this.cn_car_lux+=cn_car_lux;
    }
    public String compareCarClass(){
        int max=cn_car_eco;
        String temp="economy";
        if(this.cn_car_sp > max){
            temp="sports";
        }
        else if( this.cn_car_lux > max){
            temp="luxury";
        }
        return temp;
    }
    public void addRecommendationForEmployee(int count_employee){
        this.cn_employee+=count_employee;
    }

    public int getCn_car() {
        return cn_car;
    }

    public void setCn_car(int cn_car) {
        this.cn_car = cn_car;
    }

    public int getCn_employee() {
        return cn_employee;
    }

    public void setCn_employee(int cn_employee) {
        this.cn_employee = cn_employee;
    }


    public void ndOffice() { //profits, nextday operations 
        int incomes=0;

        for(int i=0;i<contract_in_off.length;i++) {
            if(contract_in_off[i]!=null && contract_in_off[i].isContract_availability()) {
                if(contract_in_off[i].getDay_counter()==1)
                    incomes+=contract_in_off[i].getCar().getIncomes()[0];
                contract_in_off[i].getCar().setKm();

            }
        }

        System.out.println("Office"+off_id +" incomes:"+incomes);

        for(int i=0;i<contract_in_off.length;i++) {
            if(contract_in_off[i]!=null && contract_in_off[i].isContract_availability() && contract_in_off[i].getDay_counter()==1) {
                System.out.println("\tCar"+contract_in_off[i].getCar().getCar_id()+":"+contract_in_off[i].getCar().getIncomes()[0]);

            }
        }
        final int rent=100;
        int emp_salaries=(eco_starter)*30;
        int emp_bonus=0;

        int expenses=rent+emp_salaries;
        for(int i=0;i<contract_in_off.length;i++) {
            if(contract_in_off[i]!=null && contract_in_off[i].isContract_availability()) {
                if(contract_in_off[i].getDay_counter()==1)
                    emp_bonus+=contract_in_off[i].getCar().getIncomes()[1];
                expenses+=contract_in_off[i].getCar().getIncomes()[5]+contract_in_off[i].getCar().getIncomes()[1];
            }
        }

        System.out.println("Office"+off_id +" expenses: "+expenses);
        System.out.println("\tOffice rent: "+rent);
        System.out.println("\tEmployee salaries: "+emp_salaries);
        System.out.print("\tEmployee performance bonuses ");

        for(int i=0;i<contract_in_off.length;i++) {
            if(contract_in_off[i]!=null && contract_in_off[i].isContract_availability() &&contract_in_off[i].getDay_counter()==1) {
                if(cc_counter>1) {
                    if((i+1)<cc_counter)
                        System.out.print(contract_in_off[i].getCar().getIncomes()[1]+"+");
                    else
                        System.out.print(contract_in_off[i].getCar().getIncomes()[1]+" ");
                }
                else
                    System.out.print(contract_in_off[i].getCar().getIncomes()[1]+" ");
            }
        }

        if(cc_counter>1)
            System.out.println("= "+emp_bonus);
        else
            System.out.println(" ");


        for(int i=0;i<contract_in_off.length;i++) {
            if(contract_in_off[i]!=null && contract_in_off[i].isContract_availability()) {
                System.out.println("\tCar"+contract_in_off[i].getCar().getCar_id()+" maintance: "+contract_in_off[i].getCar().getIncomes()[3]+" + "+contract_in_off[i].getCar().getIncomes()[4]+" = "+(contract_in_off[i].getCar().getIncomes()[5])+"("+contract_in_off[i].getCar().getKm()+"km)");
                contract_in_off[i].setDay_counter();
            }
        }
        this.cp+=(incomes-expenses);
        System.out.println("Office"+off_id +" profit: "+(incomes-expenses));


    }
    public void getStatistics() { //Statistics operations
        System.out.println("\n--- Office "+off_id +"---"); //creating new arrays for sorting operations
        System.out.print("The most rented car: ");
        int[] mrcarr = new int [15];
        Car[] cararr=new Car[15];
        for(int i=0;i<contract_in_off.length;i++) {
            if(contract_in_off[i]!=null) {
                mrcarr[i]=contract_in_off[i].getCar().getMrc_counter();
                cararr[i]=contract_in_off[i].getCar();
            }
        }
        int temp1=0;
        Car cartemp=null;
        sortingArray(cararr,mrcarr,temp1,cartemp);
        System.out.print(" Car"+cararr[0].getCar_id()+";"+cararr[0].getBrand()+";"+cararr[0].getModel());
        boolean flag1=true;
        for(int i=1;i<mrcarr.length;i++) {
            if(mrcarr[0]==mrcarr[i] && cararr[i]!=null) {
            	if(cararr[i].getCar_id()==cararr[0].getCar_id()) {
            		flag1=false;
            	}
                for(int j=i+1;j<mrcarr.length-1;j++) {//System.out.print(" - "+"Car"+cararr[i].getCar_id()+";"+cararr[i].getBrand()+";"+cararr[i].getModel());
                	if(cararr[j]!=null && cararr[i].getCar_id()==cararr[j].getCar_id()) {
                		flag1=false;
                	}
                }
                if(flag1) {
                	System.out.print(" - "+"Car"+cararr[i].getCar_id()+";"+cararr[i].getBrand()+";"+cararr[i].getModel());
                }
            }
            else
                break;
        }
        System.out.print("\nThe most rented car class: ");
        System.out.print(cararr[0].getCarClass());
        boolean flag2=true;
        for(int i=1;i<mrcarr.length;i++) {
            if(mrcarr[0]==mrcarr[i] && cararr[i]!=null) {
            	if(cararr[i].getCar_id()==cararr[0].getCar_id()) {
            		flag2=false;
            	}
                for(int j=i+1;j<mrcarr.length-1;j++) {
                	if(cararr[j]!=null && cararr[i].getCar_id()==cararr[j].getCar_id()) {
                		flag2=false;
                	}
                }
                if(flag2) {
                	System.out.print(" - "+cararr[i].getCarClass());
                }
            	
            }
            else
                break;
        }
        System.out.println(" ");
        System.out.print("The car with the highest profit: ");
        int[] mrcarr1 = new int [15];
        Car[] cararr1=new Car[15];
        for(int i=0;i<contract_in_off.length;i++) {
            if(contract_in_off[i]!=null) {
                mrcarr1[i]=contract_in_off[i].getCar().getIncomes()[0]-contract_in_off[i].getCar().getIncomes()[5];
                cararr1[i]=contract_in_off[i].getCar();
            }
        }
        int temp2 = 0;
        Car cartemp2 = null;
        boolean flag3=true;
        sortingArray(cararr1,mrcarr1,temp2,cartemp2);
        System.out.print("Car"+cararr1[0].getCar_id()+";"+cararr1[0].getBrand()+";"+cararr1[0].getModel());
        for(int i=1;i<mrcarr1.length;i++) {
            if(mrcarr1[0]==mrcarr1[i] && cararr1[i]!=null) {
            	if(cararr[i].getCar_id()==cararr[0].getCar_id()) {
            		flag3=false;
            	}
                for(int j=i+1;j<mrcarr.length-1;j++) {
                	if(cararr[j]!=null && cararr[i].getCar_id()==cararr[j].getCar_id()) {
                		flag3=false;
                	}
                }
                if(flag3) {
                	System.out.print(" - "+"Car"+cararr1[i].getCar_id()+";"+cararr1[i].getBrand()+";"+cararr1[i].getModel());
                }
            	
            }
            else
                break;
        }
        System.out.print("\nThe car class with the highest profit: ");
        System.out.print(cararr1[0].getCarClass());
        boolean flag4=true;
        for(int i=1;i<mrcarr1.length;i++) {
            if(mrcarr1[0]==mrcarr1[i] && cararr1[i]!=null) {
            	if(cararr[i].getCar_id()==cararr[0].getCar_id()) {
            		flag4=false;
            	}
                for(int j=i+1;j<mrcarr.length-1;j++) {
                	if(cararr[j]!=null && cararr[i].getCar_id()==cararr[j].getCar_id()) {
                		flag4=false;
                	}
                }
                if(flag4) {
                	 System.out.print(" - "+cararr1[i].getCarClass());
                }
               
            }
            else
                break;
        }
        double average_days=0;
        for(int i=0;i<contract_in_off.length;i++) {
            if(contract_in_off[i]!=null) {
                average_days+=(double)(contract_in_off[i].getEnddate().getDay());
            }
        }
        average_days= (double)(average_days/cc_starter);
        System.out.println("\nThe average number of days the cars are rented: "+average_days+" days");
        int[] rccusto = new int [15];
        Customer[] custoarr=new Customer[15];
        for(int i=0;i<contract_in_off.length;i++) {
            if(contract_in_off[i]!=null) {
                rccusto[i]=contract_in_off[i].getCustomer().getRc_counter_custo();
                custoarr[i]=contract_in_off[i].getCustomer();
            }
        }
        int temprc_1=0;
        Customer tempcusto=null;
        sortingArraycusto(custoarr,rccusto,temprc_1,tempcusto);
        System.out.print("The customer who rented most: ");
        boolean flag6=true;
        System.out.print(" Customer"+custoarr[0].getC_id()+";"+custoarr[0].getC_name()+";"+custoarr[0].getC_surname());
        for(int i=1;i<rccusto.length;i++) {
            if(rccusto[0]==rccusto[i] && custoarr[i]!=null) {
            	if(custoarr[i].getC_id()==custoarr[0].getC_id()) {
            		flag6=false;
            	}
                for(int j=i+1;j<rccusto.length-1;j++) {
                	if(custoarr[j]!=null && custoarr[i].getC_id()==custoarr[j].getC_id()) {
                		flag6=false;
                	}
                }
                if(flag6) {
                	System.out.print(" - "+" Customer"+custoarr[i].getC_id()+";"+custoarr[i].getC_name()+";"+custoarr[i].getC_surname());
                }
            	
            }
            else
                break;
        }

        int[] rcemp = new int [15];
        Employee[] emparr=new Employee[15];
        for(int i=0;i<contract_in_off.length;i++) {
            if(contract_in_off[i]!=null) {
                rcemp[i]=contract_in_off[i].getEmployee().getRc_counter_emp();
                emparr[i]=contract_in_off[i].getEmployee();
            }
        }
        int temprc=0;
        Employee tempemp=null;
        sortingArrayemp(emparr,rcemp,temprc,tempemp);
        System.out.print("\nThe employee who rented most: ");
        System.out.print(" Employee"+emparr[0].getEmp_id()+";"+emparr[0].getEmp_name()+";"+emparr[0].getEmp_surn());
        boolean flag5=true;
        for(int i=1;i<rcemp.length;i++) {
            if(rcemp[0]==rcemp[i] && emparr[i]!=null) {
            	if(emparr[i].getEmp_id()==emparr[0].getEmp_id()) {
            		flag5=false;
            	}
                for(int j=i+1;j<rcemp.length-1;j++) {
                	if(emparr[j]!=null && emparr[i].getEmp_id()==emparr[j].getEmp_id()) {
                		flag5=false;
                	}
                }
                if(flag5) {
                	System.out.print(" - "+"Employee"+emparr[i].getEmp_id()+";"+emparr[i].getEmp_name()+";"+emparr[i].getEmp_surn());
                }
            	
            }
            else
                break;
        }

        int[] profitemp = new int [15];
        Employee[] proemparr=new Employee[10];
        Contract[] contarr=new Contract[20];
        for(int i=0;i<contract_in_off.length;i++) {
            if(contract_in_off[i]!=null) {
                contarr[i]=contract_in_off[i];
            }
        }
        for(int i=0;i<contarr.length;i++) {
            if(contarr[i]!=null) {
                profitemp[i]=contarr[i].getCar().getIncomes()[0]-contarr[i].getCar().getIncomes()[5];
                proemparr[i]=contarr[i].getEmployee();
            }
        }
        int temppro=0;
        Employee tempemppro=null;
        Contract tempcont=null;
        sortingArrayemp1(proemparr,profitemp,temppro,tempemppro,contarr,tempcont);
        System.out.print("\nThe most profitable employee: ");
        System.out.print("Employee"+proemparr[0].getEmp_id()+";"+proemparr[0].getEmp_name()+";"+proemparr[0].getEmp_surn()+" ("+contarr[0].getCar().getIncomes()[0]+" - "+contarr[0].getCar().getIncomes()[5]+" = "+(contarr[0].getCar().getIncomes()[0]-contarr[0].getCar().getIncomes()[5])+"cp)" );
        System.out.print("\nAverage income levels of the employees for the office: (");
        double av_income=0;
        for(int i=1;i<=cc_starter;i++) {
            if(contarr[i-1]!=null) {
                av_income+=(contarr[i-1].getCar().getIncomes()[0]-contarr[i-1].getCar().getIncomes()[5]);
                if(i<cc_starter)
                    System.out.print((contarr[i-1].getCar().getIncomes()[0]-contarr[i-1].getCar().getIncomes()[5])+" +");
                else
                    System.out.print((contarr[i-1].getCar().getIncomes()[0]-contarr[i-1].getCar().getIncomes()[5])+"");
            }
        }
        av_income= av_income / cc_starter;
        if(cc_starter>1) {
            System.out.print(") / "+cc_starter+" = "+av_income+" cp");
        }
        else {
            System.out.println(") cp");
        }
        System.out.println(" ");



    }
}
