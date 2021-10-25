package leetcode.One.Thousand.ParkingSystem;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/3/19 上午7:34
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class ParkingSystem {
    private static final int bigCarType = 1;
    private static final int mediumCarType = 2;
    private static final int smallCarType = 3;

    public int big;
    public int medium;
    public int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        if(carType == bigCarType){
            if(big >= 1){
                big--;
                return true;
            } else {
                return false;
            }
        }
        if(carType == mediumCarType){
            if(medium >= 1){
                medium--;
                return true;
            } else {
                return false;
            }
        }
        if(carType == smallCarType){
            if(small >= 1){
                small--;
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(1,1,0);
        System.out.println(parkingSystem.addCar(1));
        System.out.println(parkingSystem.addCar(2));
        System.out.println(parkingSystem.addCar(3));
        System.out.println(parkingSystem.addCar(1));
    }
}
