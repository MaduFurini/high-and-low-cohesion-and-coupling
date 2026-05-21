package Exercise;

public class LowEmployee {
    private String name;
    private double baseSalary; 
    private int extraHours;
    private String payStubFile = "C:\\holertes\\holerite.pdf";
    private String hrEMail = "rh@empresa.com"; 
    
    public double calculateSalary() {
        return baseSalary + (extraHours * 50.0);
    }

    public void generatePayStupPDF() {
        System.out.println("Success: " + payStubFile);
    }

    public void sendPayStupEmail() {
        System.out.println("Email sent to: " + hrEMail);
    }

    public String formatReport() {
        return 
            name +
            " | R$ " +
            calculateSalary();
    }
}
