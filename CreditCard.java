package thing;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import thing.Card_Real;

import static thing.Card_Real.Cardnum;

public class CreditCard {
   private String cardnmber;
    private  int expdate;
    private int cvc_number;
    private String carfname;
    private String CardType;

    public CreditCard(String s, int expdate, int cvc_number, String carfname, String cardType) {
        this.cardnmber = s;
        this.expdate = expdate;
        this.cvc_number = cvc_number;
        this.carfname = carfname;
        CardType = cardType;
    }

    public String getCardnmber() {
        return cardnmber;
    }

    public void setCardnmber(String s) {
        this.cardnmber = s;
    }

    public int getExpdate() {
        return expdate;
    }

    public void setExpdate(int expdate) {
        this.expdate = expdate;
    }

    public int getCvc_number() {
        return cvc_number;
    }

    public void setCvc_number(int cvc_number) {
        this.cvc_number = cvc_number;
    }

    public String getCarfname() {
        return carfname;
    }

    public void setCarfname(String carfname) {
        this.carfname = carfname;
    }

    public String getCardType() {
        return CardType;
    }

    public void setCardType(String cardType) {
        CardType = cardType;
    }

    private static int Check=0;
    private static boolean RealN=false;
    private static boolean Real=false;


    public static void main(String args[]) {
        Cardnum("5121079786620135","MC");//MasterCard = MC; American Express=AE; Discover = DI; Visa = VI;

    }

}
