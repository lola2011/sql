import java.util.Scanner;

public class main1 {
    public static void main(String[] args) {
        DBworker dBworker = new DBworker();
      //  dBworker.connect();
        //System.out.println( "number of coach count:" + dBworker.getCoachCount() );
        //dBworker.top5();

        Scanner scn=new Scanner( System.in );
        System.out.println("Vvedite 1 :zima\n 2: vesna\n 3: leto\n 4: osen");
        int n=scn.nextInt();
dBworker.showByseason( n );
dBworker.showClothes();
dBworker.countBrand();

        }
    }


