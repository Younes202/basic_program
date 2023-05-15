package bank_manage;
import java.util.Date;

public class operation {
    private Date date;
    private String type;
    private double montant;

    public operation(Date date, String type, double montant) {
        this.date = date;
        this.type = type;
        this.montant = montant;
    }

    public Date getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public double getMontant() {
        return montant;
    }
}
