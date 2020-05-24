
public class MemberCar {
    private long id;
    private Car car;
    private Member member;
    private String carRegistrationNumber;
    private String carColor;

    public MemberCar(long id, Car car, Member member, String carRegistrationNumber, String carColor) {
        this.id = id;
        this.car = car;
        this.member = member;
        this.carRegistrationNumber = carRegistrationNumber;
        this.carColor = carColor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getCarRegistrationNumber() {
        return carRegistrationNumber;
    }

    public void setCarRegistrationNumber(String carRegistrationNumber) {
        this.carRegistrationNumber = carRegistrationNumber;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }
    
}