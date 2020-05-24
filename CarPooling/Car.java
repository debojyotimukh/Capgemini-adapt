public class Car {

    private long id;
    private String name;
    private String model;
    private int makeYear;
    private String company;
    private int comfortLevel;

    public Car(Long id, String name, String model, int makeYear, String company, int comfortLevel) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.makeYear = makeYear;
        this.company = company;
        this.comfortLevel = comfortLevel;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMakeYear() {
        return makeYear;
    }

    public void setMakeYear(int makeYear) {
        this.makeYear = makeYear;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getComfortLevel() {
        return comfortLevel;
    }

    public void setComfortLevel(int comfortLevel) {
        this.comfortLevel = comfortLevel;
    }

    
}

final class Sedan extends Car{
    private boolean absEnabled;
    private int bootspace;

    public Sedan(Long id, String name, String model, int makeYear, String company, int comfortLevel,
            boolean absEnabled, int bootspace) {
        super(id, name, model, makeYear, company, comfortLevel);
        this.absEnabled = absEnabled;
        this.bootspace = bootspace;
    }

    public boolean isAbsEnabled() {
        return absEnabled;
    }

    public void setAbsEnabled(boolean absEnabled) {
        this.absEnabled = absEnabled;
    }

    public int getBootspace() {
        return bootspace;
    }

    public void setBootspace(int bootspace) {
        this.bootspace = bootspace;
    }

    
}

final class UtilityCar extends Car{
    private boolean rearCoolingVents;

    public UtilityCar(Long id, String name, String model, int makeYear, String company, int comfortLevel,
            boolean rearCoolingVents) {
        super(id, name, model, makeYear, company, comfortLevel);
        this.rearCoolingVents = rearCoolingVents;
    }

    public boolean hasRearCoolingVents() {
        return rearCoolingVents;
    }

    public void setRearCoolingVents(boolean rearCoolingVents) {
        this.rearCoolingVents = rearCoolingVents;
    }
    
}

final class HatchBack extends Car{
    private boolean powerWindowsEnabled;
    private boolean automaticGear;

    public HatchBack(Long id, String name, String model, int makeYear, String company, int comfortLevel,
            boolean powerWindowsEnabled, boolean automaticGear) {
        super(id, name, model, makeYear, company, comfortLevel);
        this.powerWindowsEnabled = powerWindowsEnabled;
        this.automaticGear = automaticGear;
    }

    public boolean isPowerWindowsEnabled() {
        return powerWindowsEnabled;
    }

    public void setPowerWindowsEnabled(boolean powerWindowsEnabled) {
        this.powerWindowsEnabled = powerWindowsEnabled;
    }

    public boolean hasAutomaticGear() {
        return automaticGear;
    }

    public void setAutomaticGear(boolean automaticGear) {
        this.automaticGear = automaticGear;
    }

    
}