public enum VehicleType {
    MOTOBIKE(1), CAR(2), LORRY(3), TRUCK(4);

    private int value;

    private VehicleType(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    @Override
    public String toString(){
        return this.name() + " - "+this.getValue();
    }

}
