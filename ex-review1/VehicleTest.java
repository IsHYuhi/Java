public class VehicleTest {

  public static void describe(Vehicle v) {
    System.out.println(v);
  }

  public static void main(String[] args) {
    Vehicle vehicles[] = {
      new Car("Camley", "Toyota", "Suzuki", "Gasoline", 70., 15.15, 5),
      new Car("Aqua", "Toyota", "Nakajima", "Hybrid", 36., 40.0, 5),
      new MiniVan("Sienna", "Toyota", "Tanaka", "Gasoline", 75.,  9.0, 8, true),
      new MiniVan("Odyssey", "Honda", "Kikuchi", "Diesel", 56., 11.0, 8, false),
      new MiniVan("Presage", "Nissan", "Shirotora", "Gasoline", 60., 7.0, 7, false),
      new Truck("Tundra", "Toyota", "Sugai", "Diesel", 100., 6.76, 5, 310),
      new Truck("Ridgeline", "Honda", "Watanabe", "Diesel", 83.279, 7.23, 5, 250)
    };

    PetroleumPrice priceInfo = new PetroleumPrice(128.7, 105.7);

    for(Vehicle v: vehicles) {
      describe(v);
      System.out.println("Movable distance: " + v.movableDistance() + " Km");
      System.out.println("Cost for 100 Km: " + v.costFor100Km(priceInfo) + " Yen");
      System.out.println();
    }
    System.out.println();
    System.out.println("After Aircondition is ON\n");
    for(Vehicle v: vehicles) {
      v.setAirConditionOn();
      describe(v);
      System.out.println("Movable distance: " + v.movableDistance() + " Km");
      System.out.println("Cost for 100 Km: " + v.costFor100Km(priceInfo) + " Yen");
      System.out.println();
    }

  }  // end of main
}

abstract class Vehicle {
  String modelName, company, owner, engineType;
  double tankSize;
  double fuelConsumption;

  Vehicle(String m, String c, String o, String e, double t, double f){
    modelName =m;
    company = c;
    owner = o;
    engineType = e;
    tankSize = t;
    fuelConsumption = f;
  }

  public String toString() {
    return new String("ModelName: " + modelName + ", Company: " + company + ", Owner: " + owner + ",  EngineType: " + engineType + ", TankSize: " + tankSize + ", FuelConsumption: " + fuelConsumption);
  }
  public double movableDistance(){
    return tankSize * fuelConsumption;
  }
  abstract public double costFor100Km(PetroleumPrice p);
  abstract public void setAirConditionOn();
  abstract public void setAirConditionOFF();

  public void setModelName(String m) { modelName = m; }
  public void setCompany(String c) { company = c; }
  public void setOwner(String o) { owner = o; }
  public void setEngineType(String e) { engineType = e; }

  public String getModelName() { return modelName; }
  public String getCompany() { return company; }
  public String getOwner() { return owner; }
  public String getEngineType() { return engineType; }

  abstract public void setNoOfSeat(int n);
  abstract public int getNoOfSeat();
}


class Car extends Vehicle {
  int numberOfSeat;
  boolean airConditionOn = false;
  //boolean hasAutoDoor; Carはなし
  public Car(String m, String c, String o, String e, double t, double f, int n){
    super(m, c, o, e, t, f);
    numberOfSeat = n;
  }

  public String toString() {
    return new String("ModelName: " + modelName + ", Company: " + company + ", Owner: " + owner + ", EngineType: " + engineType + ", TankSize: " + tankSize + ", FuelConsumption: " + fuelConsumption + ", NumberOfSeat: " + numberOfSeat);
  }
  public void setNoOfSeat(int n) {
    numberOfSeat = n;
  }
  public int getNoOfSeat() {
    return numberOfSeat;
  }
  public double costFor100Km(PetroleumPrice pprice){
    return 100.0 * pprice.getGasolineCost() / fuelConsumption;
  }

  public void setAirConditionOn(){
    if(airConditionOn == false){
      fuelConsumption *=0.85;
      airConditionOn = true;
    }
  }
  public void setAirConditionOFF(){
    if(airConditionOn == true){
      fuelConsumption /=0.85;
      airConditionOn = true;
    }
  }
}


class MiniVan extends Vehicle {
  int numberOfSeat;
  boolean airConditionOn = false;
  boolean hasAutoDoor;
  public MiniVan(String m, String c, String o, String e, double t, double f, int n, boolean b){
    super(m, c, o, e, t, f);
    numberOfSeat = n;
    hasAutoDoor = b;
  }

  public String toString() {
    return new String("ModelName: " + modelName + ", Company: " + company + ", Owner: " + owner + ", EngineType: " + engineType + ", TankSize: " + tankSize + ", FuelConsumption: " + fuelConsumption + ", NumberOfSeat: " + numberOfSeat + ", HasAutoDoor: " + hasAutoDoor);
  }
  public void setNoOfSeat(int n) {
    numberOfSeat = n;
  }
  public int getNoOfSeat() {
    return numberOfSeat;
  }
  public double costFor100Km(PetroleumPrice pprice){
    if(engineType == "Gasoline"){
      return 100.0 * pprice.getGasolineCost() / fuelConsumption;
    }
    return 100.0 * pprice.getDieselCost() / fuelConsumption;
  }
  public void setAirConditionOn(){
    if(airConditionOn == false){
      fuelConsumption *=0.75;
      airConditionOn = true;
    }
  }
  public void setAirConditionOFF(){
    if(airConditionOn == true){
      fuelConsumption /=0.75;
      airConditionOn = true;
    }
  }
  public void setHasAutoDoor(boolean b){
    hasAutoDoor = b;
  }
}

class Truck extends Vehicle {
  int numberOfSeat;
  boolean airConditionOn = false;
  int power;
  public Truck(String m, String c, String o, String e, double t, double f, int n, int p){
    super(m, c, o, e, t, f);
    numberOfSeat = n;
    power = p;
  }

  public String toString() {
    return new String("ModelName: " + modelName + ", Company: " + company + ", Owner: " + owner + ", EngineType: " + engineType + ", TankSize: " + tankSize + ", FuelConsumption: " + fuelConsumption + ", NumberOfSeat: " + numberOfSeat + ", HorsePower: " + power);
  }
  public void setNoOfSeat(int n) {
    numberOfSeat = n;
  }
  public int getNoOfSeat() {
    return numberOfSeat;
  }
  public double costFor100Km(PetroleumPrice pprice){
    return 100.0 * pprice.getDieselCost() / fuelConsumption;
  }

  public void setAirConditionOn(){
    if(airConditionOn == false){
      fuelConsumption *=0.75;
      airConditionOn = true;
    }
  }
  public void setAirConditionOFF(){
    if(airConditionOn == true){
      fuelConsumption /=0.75;
      airConditionOn = true;
    }
  }
  public void setPower(int p){
    power = p;
  }
}


class PetroleumPrice {
  private double gasolinePrice;
  private double dieselPrice;
  PetroleumPrice(double g, double d) {
    gasolinePrice = g;
    dieselPrice = d;
  }

  public double getGasolineCost(){
    return gasolinePrice;
  }
  public double getDieselCost() {
    return dieselPrice;
  }
}
