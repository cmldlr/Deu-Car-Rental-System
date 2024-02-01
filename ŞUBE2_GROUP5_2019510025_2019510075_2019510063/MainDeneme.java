import java.io.*;
import java.util.Random;
import java.util.Scanner;
public class MainDeneme{
    public static Random rand = new Random();
    public static int addoffstarter,add_empstarter,add_carstarter,add_custostarter,officeCount=0,employeeCount=0,add_carrequest,add_conctractcount=0;
    public static Office[] add_offarr1=new Office[30];
    public static Customer[] add_custoarr1= new Customer[20];
    public static String[] user_arr;
    public static CarRequest [] add_carrequest1=new CarRequest[100];
    public static Contract [] contracts=new Contract[10];
    public Random rnd=new Random();
    public static boolean txt_or_user_checker;
    public static boolean car_in_wrong_off=true;
    public static int addcarrequestrandomcount=0;

    
    public static void addOfficeformain(String element1,String element2,String element3) { //method for addOffice command
        add_offarr1[addoffstarter]= new Office(element1,element2,element3,(officeCount+1),6,15);
        if(txt_or_user_checker==false) add_offarr1[addoffstarter].addOffice();
        addoffstarter++;
        officeCount++;
    }
    public static void listOfficeformain() { //method for listOffice command
        if(txt_or_user_checker==false) System.out.println(">listOffice");
        for(int q=0;q<addoffstarter;q++) {
            if(add_offarr1[q]!=null) add_offarr1[q].listOffice();
        }
    }
    //method for addEmployee command
    public static void addEmployeeformain(String element1,String element2,String element3,String element4,String element5,boolean emp_available) {
        for(int i=0;i<add_offarr1.length;i++) {
            if(add_offarr1[i]!=null&&add_offarr1[i].getOff_id()==Integer.parseInt(element5)&&add_offarr1[i].getEco_starter()<3) {
                Employee a_emp= new Employee(element1,element2,element3,element4,(employeeCount+1),element5,emp_available);
                add_offarr1[i].addEmp_in_off(a_emp);
                if(txt_or_user_checker==false)
                    System.out.println(">addEmployee;"+element1+";"+element2+";"+element3+";"+element4+";"+element5);
                add_empstarter++;                
                employeeCount++;break;}}
       
    }
    public static void listEmployeeformain(String element1) { //method for listEmployee command
        if(txt_or_user_checker==false) System.out.println(">listEmployee;"+element1);
        for(int i=0;i<add_offarr1.length;i++) {
            if(add_offarr1[i]!=null&&add_offarr1[i].getOff_id()==Integer.parseInt(element1)) {
                for(int j=0;j<add_offarr1[i].getEmp_in_off().length;j++) {
                    if(add_offarr1[i].getEmp_in_off()[j]!=null)
                        add_offarr1[i].getEmp_in_off()[j].listEmployee();
                }
            }
        }

    }
    //method for addCar command
    public static void addCarformain(String element1,String element2,String element3,String element4,String element5,boolean car_available) {
        for(int i=0;i<add_offarr1.length;i++) {
            if(add_offarr1[i]!=null&&add_offarr1[i].getOff_id()==Integer.parseInt(element5)) {
                Car a_car = new Car(element1,element2,element3,Integer.parseInt(element4),Integer.parseInt(element5),(add_carstarter+1),car_available);
                add_offarr1[i].addCar_in_off(a_car); //Integer.parseInt(element5)-1
                if(txt_or_user_checker==false)
                    System.out.println(">addCar;"+element1+";"+element2+";"+element3+";"+element4+";"+element5);
                car_in_wrong_off=false;
                add_carstarter++;break;}}
        if(car_in_wrong_off==true) System.out.println("ERROR* Wrong office id");

    }
    public static void listCarformain(String element1) { //method for listCar command
        if(txt_or_user_checker==false)System.out.println(">listCar;"+element1);
        for(int i=0;i<add_offarr1.length;i++) {
            if(add_offarr1[i]!=null&&add_offarr1[i].getOff_id()==Integer.parseInt(element1)) {
                for(int j=0;j<add_offarr1[i].getCar_in_off().length;j++) {
                    if(add_offarr1[i].getCar_in_off()[j]!=null) {
                        add_offarr1[i].getCar_in_off()[j].listCar();
                    }
                }
            }
        }
    }

    public static void addCustomerformain(String element1,String element2) { //method for addCustomer command
        Customer customer = new Customer(element1,element2,(add_custostarter+1));
        add_custoarr1[add_custostarter]= customer;
        if(txt_or_user_checker==false)add_custoarr1[add_custostarter].addCustomer();
        add_custostarter++;
    }

    public static void listCustomerformain() { //method for listCustomer command
        if(txt_or_user_checker==false) System.out.println(">listCustomer;");
        for(int i=0; i<add_custoarr1.length;i++) {
            if(add_custoarr1[i]!=null)
                add_custoarr1[i].listCustomer();
        }
    }
    public static void deleteOffice(int off_id){ //method for deleting office
        for(int i=0;i<add_offarr1.length;i++){
            if(add_offarr1[i] !=null){
                if(add_offarr1[i].getOff_id()==off_id){
                    for(int j=i+1;j<add_offarr1.length-1;j++){
                        add_offarr1[j-1]=add_offarr1[j];
                    }
                    addoffstarter=addoffstarter-1;
                }
            }
        }
    }
    public static void deleteEmployeeformain(int element1,int element2) { //method for deleting employee
        for(int i=0;i<add_offarr1.length;i++) {
            if(add_offarr1[i] !=null){
                if(add_offarr1[i].getOff_id()==element1){
                    add_offarr1[i].deleteEmployee(element2);break;}
            }
        }
    }

    public static void addCarrequest(String [] arr1, Date start_date){ //method for addCarrequest command
        String [] startdate=arr1[6].split("\\.");
        String [] enddate=arr1[7].split("\\.");
        Date dateforcheck1= new Date();

        Office cr_office=new Office(Integer.parseInt(arr1[1]));
        Customer customer=new Customer(Integer.parseInt(arr1[2]));
        Car cr_car=new Car(arr1[3],arr1[4],arr1[5]);
        Date cr_startdate=new Date(Integer.parseInt(startdate[0]),Integer.parseInt(startdate[1]),Integer.parseInt(startdate[2]));
        Date cr_enddate=new Date(Integer.parseInt(enddate[0]),Integer.parseInt(enddate[1]),Integer.parseInt(enddate[2]));
        add_carrequest1[add_carrequest]=new CarRequest(cr_office,customer,cr_car,cr_startdate,cr_enddate,add_carrequest+1);
        add_carrequest1[add_carrequest].addCarrequest();
        if(dateforcheck1.getChecker(Integer.parseInt(startdate[0]),Integer.parseInt(startdate[1]),Integer.parseInt(startdate[2]), Integer.parseInt(enddate[0]),Integer.parseInt(enddate[1]),Integer.parseInt(enddate[2])))
            createContract(add_carrequest1[add_carrequest],start_date);
        else {
            System.out.println("Please check the date");
        }
        add_carrequest++;



    }
    public static void createContract(CarRequest carRequest, Date startday){
        Employee employee=new Employee();
        Customer customer=new Customer();
        Car car=new Car();
        Date startdate=new Date();
        Date enddate=new Date();
        startdate=carRequest.getStartdate();
        enddate=carRequest.getEnddate();
        boolean date,car_rental_period,no_employee,no_customer,no_car,car_available1,no_office;
        date=car_rental_period=no_employee=no_customer=no_car=car_available1=no_office=true;
        int id=carRequest.getOffice().getOff_id();
        int [] random_choice_numbers=new int[10];
        int count=0;
        int count6=0;	//counters for error controls and messages
        int count7=0;
        if(carRequest.getStartdate().getDay()!=startday.getDay()){
            date=false;
        }
        if(carRequest.getEnddate().getDay()-carRequest.getStartdate().getDay()>4){
            car_rental_period=false;
        }
        for (int i = 0; i <add_offarr1.length; i++) {

            if(add_offarr1[i]!=null&& add_offarr1[i].getOff_id()==id ){

                for (int j = 0; j <add_offarr1[i].getEmp_in_off().length; j++) {

                    if(add_offarr1[i].getEmp_in_off()[j]!=null && add_offarr1[i].getEmp_in_off()[j].isEmp_available()==true ){
                        random_choice_numbers[count]=add_offarr1[i].getEmp_in_off()[j].getEmp_id();

                        count++;

                    }
                }

            }
            if(add_offarr1[i]!=null &&  add_offarr1[i].getOff_id()!=id ){
                count6++;
            }
            if(add_offarr1[i]!=null){
                count7++;
            }

        }
        if(count6==count7){
            no_office=false;
        }
        if(count!=0){
            int a= rand.nextInt(count);
            int b=random_choice_numbers[a];

            for (int i = 0; i <add_offarr1.length; i++) {

                if(add_offarr1[i]!=null){

                    for (int j = 0; j < add_offarr1[i].getEmp_in_off().length; j++) {

                        if(add_offarr1[i].getEmp_in_off()[j]!=null && add_offarr1[i].getEmp_in_off()[j].getEmp_id()==b &&add_offarr1[i].getEmp_in_off()[j].isEmp_available()==true){
                            employee=add_offarr1[i].getEmp_in_off()[j];
                        }
                    }
                }
            }
        }
        else {

            no_employee=false;
        }
        int count2=0;
        for (int i = 0; i <add_custoarr1.length; i++) {
            if(add_custoarr1[i]!=null && add_custoarr1[i].getC_id()==carRequest.getCustomer().getC_id()){
                customer=add_custoarr1[i];
            }
            else{
                count2++;
            }

        }
        if(count2==add_custoarr1.length){
            no_customer=false;
        }
        int[] random_choice_numbers1=new int[10];
        int count1=0;
        int count4=0;
        int count5=0;
        for (int i = 0; i <add_offarr1.length; i++) {


            if(add_offarr1[i]!=null &&  add_offarr1[i].getOff_id()==id){

                for (int j = 0; j <add_offarr1[i].getCar_in_off().length; j++) {

                    if(add_offarr1[i].getCar_in_off()[j]!=null && (add_offarr1[i].getCar_in_off()[j].getBrand().equalsIgnoreCase(carRequest.getCar().getBrand()) || add_offarr1[i].getCar_in_off()[j].getModel().equalsIgnoreCase(carRequest.getCar().getModel()) ||
                            add_offarr1[i].getCar_in_off()[j].getCarClass().equalsIgnoreCase(carRequest.getCar().getCarClass())) && add_offarr1[i].getCar_in_off()[j].isCar_available()==true){
                        random_choice_numbers1[count1]= add_offarr1[i].getCar_in_off()[j].getCar_id();
                        count1++;
                    }

                }
            }
        }
        for (int i = 0; i <add_offarr1.length; i++) {
            if(add_offarr1[i]!=null &&  add_offarr1[i].getOff_id()==id){
                for (int j = 0; j <add_offarr1[i].getCar_in_off().length; j++) {
                    if(add_offarr1[i].getCar_in_off()[j]!=null){
                        count4++;
                    }
                }
                for (int j = 0; j <add_offarr1[i].getCar_in_off().length; j++) {
                    if(add_offarr1[i].getCar_in_off()[j]!=null && add_offarr1[i].getCar_in_off()[j].getBrand().equalsIgnoreCase(carRequest.getCar().getBrand())==false && add_offarr1[i].getCar_in_off()[j].getModel().equalsIgnoreCase(carRequest.getCar().getModel())==false&&
                            add_offarr1[i].getCar_in_off()[j].getCarClass().equalsIgnoreCase(carRequest.getCar().getCarClass())==false){
                        count5++;
                    }

                }
            }
        }
        if(count4==count5){
            no_car=false;
        }


        if(count1!=0){

            int c=rand.nextInt(count1);
            int d=random_choice_numbers1[c];

            for (int i = 0; i <add_offarr1.length; i++) {

                if(add_offarr1[i]!=null&&add_offarr1[i].getOff_id()==id){

                    for (int j = 0; j <add_offarr1[i].getCar_in_off().length; j++) {

                        if(add_offarr1[i].getCar_in_off()[j]!=null && add_offarr1[i].getCar_in_off()[j].getCar_id()==d && add_offarr1[i].getCar_in_off()[j].isCar_available()==true){
                            car=add_offarr1[i].getCar_in_off()[j];

                        }


                    }
                }

            }

        }
        else{
            car_available1=false;
        }
        if(date==true &&car_rental_period==true && no_employee==true && no_customer==true&& car_available1==true && no_car==true && no_office==true){
            Contract contract1=new Contract(employee,customer,car,startdate,enddate,add_conctractcount+1); //if there is no error, contract will create
            contracts[add_conctractcount]=contract1;
            for(int i=0;i<add_offarr1.length;i++) {
                if(add_offarr1[i]!=null&&add_offarr1[i].getOff_id()==carRequest.getOffice().getOff_id()) {
                    add_offarr1[i].addContforoff(contract1);
                    break;
                }
            }
            contracts[add_conctractcount].addContract();
            add_conctractcount++;
            for (int i = 0; i <add_offarr1.length; i++) { //Assigning availability of employees and cars

                if(add_offarr1[i]!=null){

                    for (int j = 0; j < add_offarr1[i].getEmp_in_off().length; j++) {

                        if(add_offarr1[i].getEmp_in_off()[j]!=null && add_offarr1[i].getEmp_in_off()[j].getEmp_id()==employee.getEmp_id()){

                            add_offarr1[i].getEmp_in_off()[j].setEmp_available(false);
                        }
                    }
                }
            }
            for (int i = 0; i <add_offarr1.length; i++) {

                if(add_offarr1[i]!=null&&add_offarr1[i].getOff_id()==id){

                    for (int j = 0; j <add_offarr1[i].getCar_in_off().length; j++) {

                        if(add_offarr1[i].getCar_in_off()[j]!=null && add_offarr1[i].getCar_in_off()[j].getCar_id()==car.getCar_id()){
                            add_offarr1[i].getCar_in_off()[j].setCar_available(false);

                        }


                    }
                }

            }
        }//error messages for wrong carrequests
        if(date==false){
            System.out.println("   Error:Car request must be for today");
        }
        if(car_rental_period==false){
            System.out.println("   Error:Car requests must be for 1-4 days");
        }
        if(no_employee==false){
            System.out.println("   Error:No employee for the contract");
        }
        if (car_available1 == false && no_car==true) {
            System.out.println("   Error:Car not available");

        }
        if(no_car==false){
            System.out.println("   Error:There is no such car.No car");
        }
        if (no_customer == false) {
            System.out.println("   Error:There is no such customer.No customer");
        }
        if(no_office==false){
            System.out.println("   Error:There is no such office.No office");
        }
        if(car_available1==false){
            for (int i = 0; i < add_offarr1.length; i++) {
                if(add_offarr1[i]!=null ){ //system recommendation
                    if( add_offarr1[i].getOff_id() == carRequest.getOffice().getOff_id()){
                        switch(carRequest.getCar().getCarClass()){
                            case "economy":
                                add_offarr1[i].addRecommendationForCar(1);
                                add_offarr1[i].addForRecCarEco(1);
                                break;
                            case "sports":
                                add_offarr1[i].addRecommendationForCar(1);
                                add_offarr1[i].addForRecCarSp(1);
                                break;
                            case "luxury":
                                add_offarr1[i].addRecommendationForCar(1);
                                add_offarr1[i].addForRecCarLux(1);
                                break;
                        }
                    }
                }


            }
        }
        if(no_employee==false){
            for(int i=0;i<add_offarr1.length;i++){
                if(add_offarr1[i]!=null ){
                    if( add_offarr1[i].getOff_id() == carRequest.getOffice().getOff_id()){
                        add_offarr1[i].addRecommendationForEmployee(1);
                    }
                }

            }
        }

    }
    public static void compareForRecommendation(){ //choosing best recommendation for office
        for (int i = 0; i <add_offarr1.length; i++){
            if(add_offarr1[i]!=null ){
                for (int j = 0; j < add_offarr1[i].getEmp_in_off().length; j++){
                    if(add_offarr1[i].getEmp_in_off()[j]!=null &&add_offarr1[i].getEmp_in_off()[j].isEmp_available()==true){
                        add_offarr1[i].getEmp_in_off()[j].addAvailableEmpForRc(1);
                        if( add_offarr1[i].getEmp_in_off()[j].getCount_emp_available()% 3 ==0){
                            System.out.println("Office" + add_offarr1[i].getOff_id() + ":  " + "Fire employee");
                        }

                    }
                }
                if(add_offarr1[i].getCn_car() > add_offarr1[i].getCn_employee()){
                    System.out.println("Office" + add_offarr1[i].getOff_id() + ":  " + "Buy new car " +"(" + add_offarr1[i].compareCarClass() +")");
                }
                else if(add_offarr1[i].getCn_car() < add_offarr1[i].getCn_employee()){
                    if(add_offarr1[i].getEmp_count_off() !=3){
                        System.out.println("Office" + add_offarr1[i].getOff_id() + ":  " + "Hire new employee ");
                    }
                    else{
                        System.out.println("Office" + add_offarr1[i].getOff_id() + ":  " + "Open new office ");
                    }
                }
                else{
                    System.out.println("Office" + add_offarr1[i].getOff_id() + ":" + "Buy new car "+"(" + add_offarr1[i].compareCarClass() +")");
                    if(add_offarr1[i].getEmp_count_off() !=3){
                        System.out.println("Office" + add_offarr1[i].getOff_id() + ":  " + "Hire new employee ");
                    }
                    else{
                        System.out.println("Office" + add_offarr1[i].getOff_id() + ":  " + "Open new office ");
                    }
                }
            }
        }

    }

    public static void listCarrequest(){
        if(txt_or_user_checker==false)
            System.out.println(">listCarRequest");
        for (int i = 0; i <add_carrequest1.length; i++) {
            if(add_carrequest1[i]!=null  ){
                add_carrequest1[i].listCarrequest();
            }
        }

    }
    public static void listContract(){
        if(txt_or_user_checker==false)
            System.out.println(">listContract");
        for (int i = 0; i <contracts.length; i++) {
            if(contracts[i]!=null &&contracts[i].isContract_availability() ){
                contracts[i].listContract();
            }
        }
    }
    public static void addCarRequestRandom(String [] user_arr,Date startday){ //method for addCarrequestrandom

        Office office=new Office();
        Customer customer=new Customer();
        Car car=new Car();
        Date startdate=new Date(startday.getDay(),startday.getMonth(),startday.getYear());
        int t=rand.nextInt(3)+1;
        Date enddate=new Date(startday.getDay()+t,startdate.getMonth(),startdate.getYear());
        int [] car_ids=new int[10];
        int car_count=0;
        int [] custo_ids=new int[10];
        int custo_count=0;
        boolean flag=false;
        int [] office_ids=new int[10];
        int off_count=0;
        if(addcarrequestrandomcount>=7){
            System.out.println("A maximum of 7 addcarrequests can be may randomly in daily.");
        }
        else{
            for (int i = 0; i <add_offarr1.length; i++) {
                if(add_offarr1[i]!=null && add_offarr1[i].getOff_id()==Integer.parseInt(user_arr[1])){
                    flag=true;
                }
            }
            if( flag==false && user_arr[1].equalsIgnoreCase("-1")==false ){
                System.out.println("Error. Incorrect input. There is no such office.");

            }
            if(flag==true && user_arr[2].equalsIgnoreCase("*")){

                for (int i = 0; i <add_offarr1.length; i++) {
                    if(add_offarr1[i]!=null && add_offarr1[i].getOff_id()==Integer.parseInt(user_arr[1])){
                        office=add_offarr1[i];
                        for (int j = 0; j <add_offarr1[i].getCar_in_off().length; j++) {
                            if(add_offarr1[i].getCar_in_off()[j]!=null){
                                car_ids[car_count]=add_offarr1[i].getCar_in_off()[j].getCar_id();
                                car_count++;
                            }
                        }

                    }

                }

                int a=rand.nextInt(car_count);
                int b=car_ids[a];
                for (int i = 0; i <office.getCar_in_off().length; i++) {
                    if(office.getCar_in_off()[i]!=null && office.getCar_in_off()[i].getCar_id()==b){
                        car=office.getCar_in_off()[i];

                    }
                }
                for (int i = 0; i <add_custoarr1.length; i++) {
                    if(add_custoarr1[i]!=null){
                        custo_ids[custo_count]=add_custoarr1[i].getC_id();
                        custo_count++;
                    }
                }

                int c= rand.nextInt(custo_count);
                int d=custo_ids[c];
                for (int i = 0; i <add_custoarr1.length; i++) {
                    if(add_custoarr1[i]!=null && add_custoarr1[i].getC_id()==d){
                        customer=add_custoarr1[i];

                    }
                }
                add_carrequest1[add_carrequest]=new CarRequest(office,customer,car,startdate,enddate,add_carrequest+1);
                add_carrequest1[add_carrequest].addCarRequestRandom();
                createContract(add_carrequest1[add_carrequest],startday );
                add_carrequest++;
                addcarrequestrandomcount++;


            }
            else if(flag==true && user_arr[2].equalsIgnoreCase("*")==false){
                for (int i = 0; i <add_offarr1.length; i++) {
                    if(add_offarr1[i]!=null && add_offarr1[i].getOff_id()==Integer.parseInt(user_arr[1])){
                        office=add_offarr1[i];
                        for (int j = 0; j <add_offarr1[i].getCar_in_off().length; j++) {
                            if(add_offarr1[i].getCar_in_off()[j]!=null && add_offarr1[i].getCar_in_off()[j].getCarClass().equalsIgnoreCase(user_arr[2])){
                                car_ids[car_count]=add_offarr1[i].getCar_in_off()[j].getCar_id();
                                car_count++;
                            }
                        }

                    }

                }
                if(car_count==0){
                    System.out.println("There is no such car "+user_arr[2]+" class.");
                }
                else{
                    int a=rand.nextInt(car_count);
                    int b=car_ids[a];
                    for (int i = 0; i <office.getCar_in_off().length; i++) {
                        if(office.getCar_in_off()[i]!=null && office.getCar_in_off()[i].getCar_id()==b){
                            car=office.getCar_in_off()[i];

                        }
                    }
                    for (int i = 0; i <add_custoarr1.length; i++) {
                        if(add_custoarr1[i]!=null){
                            custo_ids[custo_count]=add_custoarr1[i].getC_id();
                            custo_count++;
                        }
                    }

                    int c= rand.nextInt(custo_count);
                    int d=custo_ids[c];
                    for (int i = 0; i <add_custoarr1.length; i++) {
                        if(add_custoarr1[i]!=null && add_custoarr1[i].getC_id()==d){
                            customer=add_custoarr1[i];

                        }
                    }
                    add_carrequest1[add_carrequest]=new CarRequest(office,customer,car,startdate,enddate,add_carrequest+1);
                    add_carrequest1[add_carrequest].addCarRequestRandom();
                    createContract(add_carrequest1[add_carrequest],startday );
                    add_carrequest++;
                    addcarrequestrandomcount++;
                }


            }
            else if(Integer.parseInt(user_arr[1])==-1 && user_arr[2].equalsIgnoreCase("*")){
                for (int i = 0; i <add_offarr1.length; i++) {
                    if(add_offarr1[i]!=null ){
                        office_ids[off_count]=add_offarr1[i].getOff_id();
                        off_count++;
                    }

                }
                int a=rand.nextInt(off_count);
                int b=office_ids[a];
                for (int i= 0; i <add_offarr1.length; i++) {
                    if(add_offarr1[i]!=null && add_offarr1[i].getOff_id()==b){
                        office=add_offarr1[i];
                    }
                }
                for (int i = 0; i <office.getCar_in_off().length; i++) {
                    if(office.getCar_in_off()[i]!=null){
                        car_ids[car_count]=office.getCar_in_off()[i].getCar_id();
                        car_count++;
                    }
                }
                int c=rand.nextInt(car_count);
                int d=car_ids[c];
                for (int i = 0; i <office.getCar_in_off().length; i++) {
                    if(office.getCar_in_off()[i]!=null && office.getCar_in_off()[i].getCar_id()==d){
                        car=office.getCar_in_off()[i];

                    }
                }
                for (int i = 0; i <add_custoarr1.length; i++) {
                    if(add_custoarr1[i]!=null){
                        custo_ids[custo_count]=add_custoarr1[i].getC_id();
                        custo_count++;
                    }
                }

                int e= rand.nextInt(custo_count);
                int f=custo_ids[e];
                for (int i = 0; i <add_custoarr1.length; i++) {
                    if(add_custoarr1[i]!=null && add_custoarr1[i].getC_id()==f){
                        customer=add_custoarr1[i];

                    }
                }
                add_carrequest1[add_carrequest]=new CarRequest(office,customer,car,startdate,enddate,add_carrequest+1);
                add_carrequest1[add_carrequest].addCarRequestRandom();
                createContract(add_carrequest1[add_carrequest],startday );
                add_carrequest++;
                addcarrequestrandomcount++;

            }
        }
    }
    public static void addCarRequestNRandom(String [] user_arr,Date startday){ //method for addCarRequestNRandom command

        int min_request_number=Integer.parseInt(user_arr[1]);
        int max_request_number= Integer.parseInt(user_arr[2]);
        if(addcarrequestrandomcount>=7){
            System.out.println("A maximum of 7 addcarrequests can be may randomly in daily.");
        }

        if(min_request_number<1 || max_request_number>7){
            System.out.println("Error the_min_request_number cannot be less than 1 or the_max_request_random cannot be greater than 7");
            System.out.println("Please check your input");
        }
        if(min_request_number>=1 && max_request_number<=7 && addcarrequestrandomcount<7){
            for (int l = 0; l <max_request_number; l++) {
                Office office=new Office();
                Customer customer=new Customer();
                Car car=new Car();
                Date startdate=new Date(startday.getDay(),startday.getMonth(),startday.getYear());
                int t=rand.nextInt(4);
                Date enddate=new Date(startday.getDay()+t,startdate.getMonth(),startdate.getYear());
                int [] car_ids=new int[10];
                int car_count=0;
                int [] custo_ids=new int[10];
                int custo_count=0;
                boolean flag=false;
                int [] office_ids=new int[10];
                int off_count=0;
                for (int i = 0; i <add_offarr1.length; i++) {
                    if(add_offarr1[i]!=null ){
                        office_ids[off_count]=add_offarr1[i].getOff_id();
                        off_count++;
                    }

                }
                int a=rand.nextInt(off_count);
                int b=office_ids[a];
                for (int i= 0; i <add_offarr1.length; i++) {
                    if(add_offarr1[i]!=null && add_offarr1[i].getOff_id()==b){
                        office=add_offarr1[i];
                    }
                }
                for (int i = 0; i <office.getCar_in_off().length; i++) {
                    if(office.getCar_in_off()[i]!=null){
                        car_ids[car_count]=office.getCar_in_off()[i].getCar_id();
                        car_count++;
                    }
                }
                int c=rand.nextInt(car_count);
                int d=car_ids[c];
                for (int i = 0; i <office.getCar_in_off().length; i++) {
                    if(office.getCar_in_off()[i]!=null && office.getCar_in_off()[i].getCar_id()==d){
                        car=office.getCar_in_off()[i];

                    }
                }
                for (int i = 0; i <add_custoarr1.length; i++) {
                    if(add_custoarr1[i]!=null){
                        custo_ids[custo_count]=add_custoarr1[i].getC_id();
                        custo_count++;
                    }
                }

                int e= rand.nextInt(custo_count);
                int f=custo_ids[e];
                for (int i = 0; i <add_custoarr1.length; i++) {
                    if(add_custoarr1[i]!=null && add_custoarr1[i].getC_id()==f){
                        customer=add_custoarr1[i];

                    }
                }
                add_carrequest1[add_carrequest]=new CarRequest(office,customer,car,startdate,enddate,add_carrequest+1);
                add_carrequest1[add_carrequest].addCarRequestNRandom();
                createContract(add_carrequest1[add_carrequest],startday );
                add_carrequest++;
                addcarrequestrandomcount++;

            }
        }


    }
    public static void main(String[] args) {

        addoffstarter=add_empstarter=add_carstarter=add_custostarter=add_carrequest=0;


        Date  startday=new Date(1,1,2021);
        System.out.println("--- Date:"+ startday.getDay()+"."+ startday.getMonth()+"."+ startday.getYear()+" ---");

        do {
            Scanner scr = new Scanner(System.in);

            System.out.print(">>>");
            String fname1 = scr.nextLine();


            user_arr =fname1.split(";");
            switch(user_arr[0]) { //getting commands from user and txt

                case "addOffice":
                    txt_or_user_checker=true;
                    addOfficeformain(user_arr[1],user_arr[2],user_arr[3]);break;
                case "listOffice":
                    txt_or_user_checker=true;
                    listOfficeformain();break;
                case "addEmployee":
                    txt_or_user_checker=true;
                    boolean emp_available=true;
                    addEmployeeformain(user_arr[1],user_arr[2],user_arr[3],user_arr[4],user_arr[5],emp_available);break;
                case "listEmployee":
                    txt_or_user_checker=true;
                    listEmployeeformain(user_arr[1]);break;
                case "addCar":
                    car_in_wrong_off=true;
                    txt_or_user_checker=true;
                    boolean car_available=true;
                    addCarformain(user_arr[1],user_arr[2],user_arr[3],user_arr[4],user_arr[5],car_available); break;
                case "listCar":
                    txt_or_user_checker=true;
                    listCarformain(user_arr[1]); break;
                case "addCustomer":
                    txt_or_user_checker=true;
                    addCustomerformain(user_arr[1],user_arr[2]);break;
                case "listCustomer":
                    txt_or_user_checker=true;
                    listCustomerformain();break;
                case "deleteEmployee":
                    deleteEmployeeformain(Integer.parseInt(user_arr[1]),Integer.parseInt(user_arr[2]));
                    break;
                case "deleteOffice":
                    deleteOffice(Integer.parseInt(user_arr[1]));
                    break;
                case "addCarRequest":
                	txt_or_user_checker=true;
                    addCarrequest(user_arr, startday);                   
                    break;
                case "listCarRequest":
                    txt_or_user_checker=true;
                    listCarrequest();
                    break;
                case "listContract":
                    txt_or_user_checker=true;
                    listContract();
                    break;
                case "addCarRequestRandom":
                    txt_or_user_checker=true;
                    addCarRequestRandom(user_arr,startday);
                    break;
                case "addCarRequestNRandom":
                    txt_or_user_checker=true;
                    addCarRequestNRandom(user_arr,startday);
                    break;
                case "nextday":
                    System.out.println("--- Office Profits ----");
                    System.out.println();
                    Date dateforcheck=new Date();
                    addcarrequestrandomcount=0;
                    for(int i=0;i<add_offarr1.length;i++) {
                        if(add_offarr1[i]!=null) {
                            for(int j=0;j<add_offarr1[i].getContract_in_off().length;j++) {
                                if(add_offarr1[i].getContract_in_off()[j]!=null && dateforcheck.isSameday(add_offarr1[i].getContract_in_off()[j].getEnddate(), startday) ) {
                                    add_offarr1[i].getContract_in_off()[j].setContract_availability(false);
                                    add_offarr1[i].setCc_counter(-1);
                                    for(int q=0;q<add_offarr1[i].getCar_in_off().length;q++) {
                                        if(add_offarr1[i].getCar_in_off()[q]!=null && add_offarr1[i].getCar_in_off()[q].getCar_id()==add_offarr1[i].getContract_in_off()[j].getCar().getCar_id()) {
                                            add_offarr1[i].getCar_in_off()[q].setCar_available(true);
                                        }
                                    }
                                    System.out.println("Contract"+add_offarr1[i].getContract_in_off()[j].getContract_id()+" is finish");
                                }
                            }
                        }
                    }
                    for(int i=0;i<contracts.length;i++) {
                        if(contracts[i]!=null && dateforcheck.isSameday(contracts[i].getEnddate(), startday)) {
                            contracts[i].setContract_availability(false);
                        }
                    }
                    for(int i=0;i<add_offarr1.length;i++) {
                        if(add_offarr1[i]!=null) {
                            add_offarr1[i].ndOffice(); //profit operations
                        }
                    }
                    System.out.println("\n--- Office Statistics of the Last 10 Days ----");
                    for(int i=0;i<add_offarr1.length;i++) {
                        if(add_offarr1[i]!=null) {
                            add_offarr1[i].getStatistics(); //statistics operations
                        }
                    }
                    for(int i=0;i<add_offarr1.length;i++) {
                        if(add_offarr1[i]!=null) {
                            for(int j=0;j<add_offarr1[i].getEmp_in_off().length;j++) { //employees are assigned "true" at the end of the day
                                if(add_offarr1[i].getEmp_in_off()[j]!=null)
                                    add_offarr1[i].getEmp_in_off()[j].setEmp_available(true);
                            }
                        }
                    }
                    if(startday.getDay() % 3==0){
                        System.out.println("--- System Recommendations ---- ");
                        compareForRecommendation();
                    }


                    startday.addDay(1);
                    System.out.println("--- Date:"+ startday.getDay()+"."+ startday.getMonth()+"."+ startday.getYear()+" ---");
                    break;


                case "load": //txt operations
                    File file = new File(user_arr[1]);
                    try {
                        BufferedReader buffer = new BufferedReader(new FileReader(file));
                        String str;
                        while((str=buffer.readLine())!=null) {
                            String[] arr1 =str.split(";");
                            switch (arr1[0]) {
                                case "addOffice":
                                    txt_or_user_checker=false;
                                    addOfficeformain(arr1[1],arr1[2],arr1[3]);break;
                                case "listOffice":
                                    txt_or_user_checker=false;
                                    listOfficeformain();break;
                                case "addEmployee":
                                    txt_or_user_checker=false;
                                    boolean emp_available1=true;
                                    addEmployeeformain(arr1[1],arr1[2],arr1[3],arr1[4],arr1[5],emp_available1);break;
                                case "listEmployee":
                                    txt_or_user_checker=false;
                                    listEmployeeformain(arr1[1]);break;
                                case "addCar":
                                    txt_or_user_checker=false;
                                    boolean car_available1=true;
                                    addCarformain(arr1[1],arr1[2],arr1[3],arr1[4],arr1[5],car_available1); break;
                                case "listCar":
                                    txt_or_user_checker=false;
                                    listCarformain(arr1[1]); break;
                                case "addCustomer":
                                    txt_or_user_checker=false;
                                    addCustomerformain(arr1[1],arr1[2]);break;
                                case "listCustomer":
                                    txt_or_user_checker=false;
                                    listCustomerformain();break;
                                case "addCarRequest":
                                    txt_or_user_checker=false;
                                    addCarrequest(arr1,startday);
                                    break;
                                case "listCarRequest":
                                    txt_or_user_checker=false;
                                    listCarrequest();
                                    break;
                                case "listConctract":
                                    txt_or_user_checker=false;
                                    listContract();
                                    break;
                                case "addCarRequestRandom":
                                    txt_or_user_checker=false;
                                    addCarRequestRandom(arr1,startday);
                                    break;
                                case "addCarRequestNRandom":
                                    txt_or_user_checker=false;
                                    addCarRequestNRandom(arr1,startday);
                                    break;


                            }
                        }
                    } catch (IOException e) {
                        System.out.println(e);
                    }


            }
        }while(true);

    }


}