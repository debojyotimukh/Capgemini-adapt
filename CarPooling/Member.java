import java.util.ArrayList;
import java.util.Date;

public class Member {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
    private String licenseNumber;
    private Date licenseStartDate;
    private Date licenseExpiryDate;
    private ArrayList<MemberCar> carlist;

    public Member() {
    }

    public Member(long id, String firstName, String lastName, String email, String contactNumber, String licenseNumber,
            Date licenseStartDate, Date licenseExpiryDate, ArrayList<MemberCar> carlist) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contactNumber = contactNumber;
        this.licenseNumber = licenseNumber;
        this.licenseStartDate = licenseStartDate;
        this.licenseExpiryDate = licenseExpiryDate;
        this.carlist = carlist;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Date getLicenseStartDate() {
        return licenseStartDate;
    }

    public void setLicenseStartDate(Date licenseStartDate) {
        this.licenseStartDate = licenseStartDate;
    }

    public Date getLicenseExpiryDate() {
        return licenseExpiryDate;
    }

    public void setLicenseExpiryDate(Date licenseExpiryDate) {
        this.licenseExpiryDate = licenseExpiryDate;
    }

    @Override
    public String toString() {
        return "Member: "+firstName+", "+lastName+
        "\nMember contact details: "+contactNumber+", "+email;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((contactNumber == null) ? 0 : contactNumber.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Member other = (Member) obj;
        if (contactNumber == null) {
            if (other.contactNumber != null)
                return false;
        } else if (!contactNumber.equals(other.contactNumber))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        return true;
    }
    
    public void compareMembers(Member m1,Member m2){
        System.out.println("Member 1");
        System.out.println(m1.toString());
        System.out.println("Member 2");
        System.out.println(m2.toString());
        if(m1.equals(m2))
             System.out.println("Member 1 is same as Member 2");
        else 
            System.out.println("Member 1 and Member 2 are different");
    }

    public ArrayList<MemberCar> getCarlist() {
        return carlist;
    }

    public void setCarlist(ArrayList<MemberCar> carlist) {
        this.carlist = carlist;
    }


    
}