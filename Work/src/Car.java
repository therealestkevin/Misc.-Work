public class Car{

    private static int curCar=0;
    private int license;
    private double gallons;
    private int milesDriven=0;
    public Car(){
        curCar++;
        license = curCar;
        gallons = 15;
    }

    public String toString(){
        return "License: " + license + "\n Gallons: "+ gallons + "\n Miles Driven: " + milesDriven;
    }

    public double checkGas(){
        return gallons;
    }

    public int addGas(int n){
       if(gallons+ n >15){
           return -1;
       }
        gallons += n;
        return 0;
    }

    public int drive(int n){
        double gallonsSpent = n/25;
        if(gallons - gallonsSpent<0){
            return -1;
        }

        milesDriven+=n;
        gallons -=gallonsSpent;
        return 0;
    }

    public int getLicense() {
        return license;
    }

    public void setLicense(int license) {
        this.license = license;
    }

    public double getGallons() {
        return gallons;
    }

    public void setGallons(double gallons) {
        this.gallons = gallons;
    }

    public int getMilesDriven() {
        return milesDriven;
    }

    public void setMilesDriven(int milesDriven) {
        this.milesDriven = milesDriven;
    }
}