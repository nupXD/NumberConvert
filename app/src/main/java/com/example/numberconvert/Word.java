package com.example.numberconvert;

public class Word {


    public static String NumToWord(int num){

        String word = "";
        String WoardArray[]={ "zero", "one", "two", "three", "four", "five", "six",
                "seven", "eight", "nine", "ten", "eleven", "twelve",
                "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                "eighteen", "nineteen" };

        String tensArray[] = { "zero", "ten", "twenty", "thirty", "forty", "fifty",
                "sixty", "seventy", "eighty", "ninety"};

        if (num ==0){
            return "zero";

        }
        if (num<0){

            String StrNumb= "" + num;
            StrNumb = StrNumb.substring(1);
             return "Minus" + NumToWord(Integer.parseInt(StrNumb));

        }

        if((num/100)>0){
            word +=NumToWord(num/100)+" hundred ";
            num%=100;
        }

        if(num>0){
            if (num<20){
                word+=WoardArray[num];
            }else{
                word+=tensArray[num/10];
                if ((num%10)>0){
                    word += "-" +WoardArray[num%10];
                }
            }
        }


        return word;
    }

}
