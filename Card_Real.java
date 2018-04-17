package thing;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Card_Real {
    String s;
    static int Check=0;
    static boolean RealN=false;
    static boolean Real=false;
    static String Cardtype;

/*
    public static void main(String args[]) {



        Cardnum("5121079786620135","MC");//MasterCard = MC; American Express=AE; Discover = DI; Visa = VI;

    }

*/
    public static String Cardnum(String s, String Cardtype) {





        //Create ArrayList
        ArrayList<Integer> intArray = new ArrayList<Integer>(10);

        //Adds card number into array
        int[] s2 = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            s2[i] = Character.digit(s.charAt(i), 10);
        }

        //Adds card number into Array List
        for (int i : s2) {
            intArray.add(i);
        }
        //System.out.println(Arrays.toString(intArray.toArray()));

        //Will Check to see if card number matches requirements of company.

        ArrayList<Integer> cardcheck = new ArrayList<Integer>(10);
        ArrayList<Integer> cardcheck6 = new ArrayList<Integer>(10);
        ArrayList<Integer> cardcheck3 = new ArrayList<Integer>(10);
        ArrayList<Integer> cardcheck2 = new ArrayList<Integer>(10);
        if(Cardtype.equals("MC")){
            if(intArray.size()==16){
            }else{
                RealN=false;
                System.out.println("MasterCard Length fail");
                System.exit(0);
            }
            int[] s3 = new int[2];
            for (int i = 0; i < 2; i++) {
                s3[i] = Character.digit(s.charAt(i), 10);
            }
            //Adds card number into Array List
            for (int i : s3) {
                cardcheck.add(i);
            }

            int[] s8 = new int[6];
            for (int i = 0; i < 6; i++) {
                s8[i] = Character.digit(s.charAt(i), 10);
            }
            //Adds card number into Array List
            for (int i : s8) {
                cardcheck6.add(i);
            }
            int num =0;
            for(int i=0; i <5;){
                num = cardcheck6.get(i)*(100000);
                i++;
                num = (cardcheck6.get(i)*(10000))+num;
                i++;
                num = (cardcheck6.get(i)*(1000))+num;
                i++;
                num = (cardcheck6.get(i)*(100))+num;
                i++;
                num = (cardcheck6.get(i)*(10))+num;
                i++;
                num = (cardcheck6.get(i)*(1))+num;
                i++;
            }
          //  System.out.println(num);



            String string = Arrays.toString(cardcheck.toArray()).replace("[","").replace("]","").replace(",","").replace(" ","");
            if(string.equals("51") || string.equals("52") || string.equals("53") || string.equals("54") || string.equals("55")|| (num >= 222100 && num <= 272099)){
             RealN = true;
             //System.out.println("MasterCard Start real");
            }else{
                RealN = false;
                System.out.println("MasterCard Number fail");
                System.exit(0);
            }
        }else if(Cardtype.equals("AE")){
            if(intArray.size()==15){
            }else{
                RealN=false;
                System.out.println("AE Length fail");
                System.exit(0);
            }
            int[] s3 = new int[2];
            for (int i = 0; i < 2; i++) {
                s3[i] = Character.digit(s.charAt(i), 10);
            }
            //Adds card number into Array List
            for (int i : s3) {
                cardcheck.add(i);
            }
            String string = Arrays.toString(cardcheck.toArray()).replace("[","").replace("]","").replace(",","").replace(" ","");
            System.out.println(string);
            if(string.equals("34") || string.equals("37")){
                RealN = true;
                //System.out.println("AE number real");
            }else{
                RealN = false;
                System.out.println("AE number fail");
                System.exit(0);
            }
        }else if(Cardtype.equals("DI")){
            if(intArray.size()==16 ||intArray.size()==17 || intArray.size()==18 || intArray.size()==19  ) {
            }else{
                RealN=false;
                System.out.println("Discover Card Length fail");
            }
            int[] s4 = new int[4];
            for (int i = 0; i < 4; i++) {
                s4[i] = Character.digit(s.charAt(i), 10);
            }
            //Adds card number into Array List
            for (int i : s4) {
                cardcheck.add(i);
            }

            int[] s5 = new int[3];
            for (int i = 0; i < 3; i++) {
                s5[i] = Character.digit(s.charAt(i), 10);
            }
            //Adds card number into Array List
            for (int i : s5) {
                cardcheck3.add(i);
            }

            int[] s6 = new int[2];
            for (int i = 0; i < 2; i++) {
                s6[i] = Character.digit(s.charAt(i), 10);
            }
            //Adds card number into Array List
            for (int i : s6) {
                cardcheck2.add(i);
            }

            int[] s7 = new int[6];
            for (int i = 0; i < 6; i++) {
                s7[i] = Character.digit(s.charAt(i), 10);
            }
            //Adds card number into Array List
            for (int i : s7) {
                cardcheck6.add(i);
            }

            String string3 = Arrays.toString(cardcheck3.toArray()).replace("[","").replace("]","").replace(",","").replace(" ","");
         //   System.out.println(string3);
            String string4 = Arrays.toString(cardcheck.toArray()).replace("[","").replace("]","").replace(",","").replace(" ","");
            //System.out.println(string4);
            String string2 = Arrays.toString(cardcheck2.toArray()).replace("[","").replace("]","").replace(",","").replace(" ","");
   //         System.out.println(string2);
       //     System.out.println(cardcheck6);
            int num =0;
            for(int i=0; i <5;){
               num = cardcheck6.get(i)*(100000);
                i++;
                num = (cardcheck6.get(i)*(10000))+num;
                i++;
                num = (cardcheck6.get(i)*(1000))+num;
                i++;
                num = (cardcheck6.get(i)*(100))+num;
                i++;
                num = (cardcheck6.get(i)*(10))+num;
                i++;
                num = (cardcheck6.get(i)*(1))+num;
                i++;
            }
            //    System.out.println(num);
            if(string4.equals("6011") || string3.equals("644") || string3.equals("645") || string3.equals("646") || string3.equals("647") || string3.equals("648") || string3.equals("649") || string2.equals("65") ||  string2.equals("65") || (num >= 622126 && num <= 622925)){
                RealN = true;
               // System.out.println("Discover Card Real" );
            }else{
                Real = false;
                System.out.println("Discover Card Fail");
                System.exit(0);
            }
        }else if(Cardtype.equals("VI")){
            if(intArray.size()==13 || intArray.size()==16 || intArray.size()==19  ) {
            }else{
                Real=false;
                System.out.println("Visa Length fail");
                System.exit(0);
            }
            int[] s3 = new int[1];
            for (int i = 0; i < 1; i++) {
                s3[i] = Character.digit(s.charAt(i), 10);
            }
            //Adds card number into Array List
            for (int i : s3) {
                cardcheck.add(i);
            }
            String string = Arrays.toString(cardcheck.toArray()).replace("[","").replace("]","").replace(",","").replace(" ","");
            if(string.equals("4")){
                Real = true;
              //  System.out.println("Visa Card Number real");
            }else{
                Real = false;
                System.out.println("Visa Card Number fail");
                System.exit(0);
            }
        }

        //BEGIN TO CHECK IF NUMBER REAL

        //If then else cases for different card companies

        //System.out.println();
        //System.out.println("Remove last number");
        Check=intArray.get(intArray.size()-1);
        intArray.remove(intArray.size() - 1);
        //System.out.println(Arrays.toString(intArray.toArray()));

        //System.out.println();
        //System.out.println("Reverse the numbers");
        Collections.reverse(intArray);
        //System.out.println(Arrays.toString(intArray.toArray()));

        ArrayList<Integer> intArray2 = new ArrayList<Integer>(10);
        //System.out.println();
        //System.out.println("Multiply odd digits by 2");
        for (int i = 0; i < intArray.size(); i++) {
            if (i % 2 == 0) {
                int temp = intArray.get(i);
                temp = temp * 2;
                intArray2.add(temp);
            } else {
                intArray2.add(intArray.get(i));
            }
        }
        //System.out.println(Arrays.toString(intArray2.toArray()));


        ArrayList<Integer> intArray3 = new ArrayList<Integer>(10);
        //System.out.println();
        //System.out.println("Subtract 9 to all number over 9");
        for (int i = 0; i < intArray2.size(); i++) {
            if (intArray2.get(i) > 9) {
                int temp = intArray2.get(i);
                temp = temp - 9;
                intArray3.add(temp);
            } else {
                intArray3.add(intArray2.get(i));
            }
        }
        //System.out.println(Arrays.toString(intArray3.toArray()));

        //System.out.println();
        //System.out.println("Add all the elements");
        int  total = 0;
        for (int i = 0; i < intArray3.size(); i++) {
            int number = intArray3.get(i);
            total = total + number;
          }
        //System.out.println(total);

        //System.out.println();
     //   System.out.print("Mod Result= ");
        int test = total % 10;
       // System.out.println(test);
        //System.out.println("Check = " + Check );

        if(Check == test){
            Real = true;
            System.out.println("Card is Real");
            }
        return s;
    }
}
