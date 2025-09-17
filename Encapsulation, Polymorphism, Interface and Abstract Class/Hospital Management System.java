interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public abstract double calculateBill();

    public String getPatientDetails() {
        return name + " (ID: " + patientId + ", Age: " + age + ")";
    }
}

class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyRate;
    private String medicalHistory = "";

    public InPatient(String id, String name, int age, int days, double rate) {
        super(id, name, age);
        this.daysAdmitted = days;
        this.dailyRate = rate;
    }

    public double calculateBill() {
        return daysAdmitted * dailyRate;
    }

    public void addRecord(String record) {
        medicalHistory += record + "\n";
    }

    public void viewRecords() {
        System.out.println("Medical History:\n" + medicalHistory);
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private String medicalHistory = "";

    public OutPatient(String id, String name, int age, double fee) {
        super(id, name, age);
        this.consultationFee = fee;
    }

    public double calculateBill() {
        return consultationFee;
    }

    public void addRecord(String record) {
        medicalHistory += record + "\n";
    }

    public void viewRecords() {
        System.out.println("Medical History:\n" + medicalHistory);
    }
}

public class HospitalDemo {
    public static void main(String[] args) {
        Patient p1 = new InPatient("P101", "Abhishek", 30, 5, 2000);
        Patient p2 = new OutPatient("P202", "Ravi", 25, 500);

        ((MedicalRecord) p1).addRecord("Admitted for fever");
        ((MedicalRecord) p2).addRecord("Consulted for headache");

        Patient[] patients = {p1, p2};

        for (Patient p : patients) {
            System.out.println(p.getPatientDetails());
            System.out.println("Bill: ₹" + p.calculateBill());
            ((MedicalRecord) p).viewRecords();
            System.out.println();
        }
    }
}
