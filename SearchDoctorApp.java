import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.lang.Comparable;

class Doctor implements Comparable {

	private String name;
	private String speciality;
	private int experience;

	public Doctor(String name, String speciality, int experience) {
		this.name = name;
		this.speciality = speciality;
		this.experience = experience;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "	" + getName() + "	" + getSpeciality() + "	" + getExperience();
	}

	@Override
	public int compareTo(Object o) {//Natural Ordering: Ascending order of name
		if (o instanceof Doctor) {
			Doctor d2 = (Doctor) o;
			return name.compareTo((d2.getName()));
		}
		return 0;
	}

}

class DoctorService {

	// DONT MODIFY THIS
	private List<Doctor> doctorsRepository;

	// DONT MODIFY THIS
	public DoctorService(List<Doctor> doctorsRepository) {
		this.doctorsRepository = doctorsRepository;
	}

	/**
	 * This method takes years of experience as input parameter and returns a List
	 * of Doctors, who have experience equal to or more than the input parameter .
	 * The returned List should be sorted in ascending order of speciality and
	 * descending order of experience for a speciality.
	 * 
	 * @param exp	Years of experience
	 * @return	List of Doctors, who have experience equal to or more than the input parameter
	 */
	public List<Doctor> getExperiencedDoctors(int exp) {
		List<Doctor> doctorsWithExpList = new ArrayList<Doctor>();
		for (Doctor doctor : doctorsRepository) {
			if (doctor.getExperience() >= exp) {
				doctorsWithExpList.add(doctor);
			}
		}
		// sorted in ascending order of speciality and
		// descending order of experience for a speciality
		doctorsWithExpList.sort(Comparator.comparing(Doctor::getSpeciality)
				.thenComparing(Comparator.comparing(Doctor::getExperience).reversed()));
		return doctorsWithExpList;
	}

	/**
	 * This method takes speciality(case insensitive) as input parameter and returns
	 * a Set of Doctors who have this speciality The returned Set should be sorted
	 * in ascending order of name of Doctor(This is done by compareTo() method in
	 * the Doctors class)
	 * 
	 * @param specialty	speciality(case insensitive) of the Doctors
	 * @return	Set of Doctors who have this speciality
	 */
	public Set<Doctor> getSpecialityDoctor(String specialty) {
		Set<Doctor> result = new TreeSet<Doctor>();
		for (Doctor doctor : doctorsRepository) {
			if (doctor.getSpeciality().equalsIgnoreCase(specialty)) {
				result.add(doctor);
			}
		}
		return result;
	}
}

public class SearchDoctorApp {

	// DON'T MODIFY THIS
	private static String doctorsData;

	// DON'T MODIFY THIS
	static {
		StringBuilder doctors = new StringBuilder();
		doctors.append("Amy-Pediatrics-16;");
		doctors.append("John-Dermatology-10;");
		doctors.append("David-Dermatology-15;");
		doctors.append("Bob-Pediatrics-6;");
		doctors.append("Cathy-Dermatology-5;");
		doctors.append("Mavis-Pediatrics-11;");
		doctors.append("Robin-Pediatrics-7;");
		doctors.append("Minty-Dermatology-9;");
		doctors.append("Jim-Cardiology-25;");
		doctorsData = doctors.toString();
	}

	/**
	 * Create Doctor objects using the data present in doctorsData variable and add
	 * these objects to a ArrayList of Doctors and initialize the doctorsRepository
	 * variable of DoctorService with the above ArrayList
	 * 
	 * @return	DoctorService object to be used for calling the methods
	 */
	private static DoctorService buildDoctorsRepository() {

		List<Doctor> doctors = new ArrayList<Doctor>();

		String[] doctorsDataSplStrings = doctorsData.split(";");
		for (String doctorDetails : doctorsDataSplStrings) {
			String[] data = doctorDetails.split("-");
			doctors.add(new Doctor(data[0], data[1], Integer.parseInt(data[2])));
		}
		return new DoctorService(doctors);
	}

	/**
	 * Accept 1 or 2 as choice from the user through Console. If choice is 1, accept
	 * years of experience as second input. If choice is 2, accept speciality as
	 * second input. Display "No Doctors Found", if there are no doctors matching
	 * the search criteria Display "Invalid Choice", if the first input is not 1 or
	 * 2
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		DoctorService doctorService = buildDoctorsRepository();
		Scanner sc = new Scanner(System.in);
		switch (sc.nextInt()) {
			case 1:
				List<Doctor> dList = doctorService.getExperiencedDoctors(sc.nextInt());
				if (!dList.isEmpty()) {
					for (Doctor doctor : dList) {
						System.out.println(doctor.toString());
					}
				} else
					System.out.println("No Doctors Found");
				break;
			case 2:
				Set<Doctor> dSet = doctorService.getSpecialityDoctor(sc.next());
				if (!dSet.isEmpty()) {
					for (Doctor doctor : dSet) {
						System.out.println(doctor.toString());
					}
				} else
					System.out.println("No Doctors Found");
				break;
			default:
				System.out.println("Invalid Choice");
		}
		sc.close();

	}
}
