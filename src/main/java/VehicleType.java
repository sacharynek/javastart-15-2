public enum VehicleType {
    MOTOBIKE(1), CAR(2), LORRY(3), TRUCK(4);

    private int value;

    VehicleType(int value){
        this.value = value;
    }

    public static VehicleType fromInteger(int x) {
        switch(x) {
            case 1:
                return MOTOBIKE;
            case 2:
                return CAR;
            case 3:
                return LORRY;
            case 4:
                return TRUCK;
            default:
                return TRUCK;
        }

    }

    public int getValue(){
        return this.value;
    }

    @Override
    public String toString(){
        return this.name() + " - "+this.getValue();
    }

}
