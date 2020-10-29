package bike;

public class Bicycle {
    private int gear;
    private int speed;
                        
    public void setGear(int newValue) {
        gear = newValue;
    }
        
    public void applyBrake(int decrement) {
        speed -= decrement;
    }
   public void speedUp(int increment) {
        speed += increment;
    }
        
}
