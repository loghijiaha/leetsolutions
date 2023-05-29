class ParkingSystem {

    int b;
    int m;
    int s;
    public ParkingSystem(int big, int medium, int small) {
        b = big; m = medium; s = small;
    }
    
    public boolean addCar(int carType) {
        switch(carType){
            case 1: {
                return b-- >0 ? true : false; 
            }
            case 2: {
                return m-- >0 ? true : false ;
            }
            case 3: {
                return s-- >0 ? true : false ;
            }
            default: return false;
        }
    
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */