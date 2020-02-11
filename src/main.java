import java.io.FileWriter;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter=new FileWriter("sql.txt");
        fileWriter.write( "1.Git -raspredelennaya sistema upravleniyami versiyami. S pomoshyu Git mı sozdaem proektı v komande na rasstoyanii. \n" +
                "U nas est vozmojnost delat izmeneniya i delitsa s nimi,a takje ukazıvat izmeneniya v kommentariyah.\n");
        fileWriter.write("2.Baza Dannıh nujna nam dlya sohraneniya i obrabotki ogromnogo kolichestva informatsii\n");
        fileWriter.write( "3.Primary key eto pervıchnıy kluch,po kotoromu ıdet soyedineniye tablits.\n4.Foreign key eto vneshniy kluch,to est primary key odnoy tablitsı,yavlyaetsya foreign key dlya vtoroy soyedinyaemoy tablitsı." +
                "\n5.Stroki otnosyatsya k DML,v strokah mı rabotayem s dannımi tablitsı,a ne s ee strukturoy.Stolbtsı,eto rabota s DDL to yest s samoy strukturoy tablıtsı." +
                "6.V bazı dannıh u nas prisutstvuyet svyaz mejdu tablitsamı,kotoraya uprashayet nashu rabotu i delayet tablitsı bolee obshirnımi i znachimımi." +
                "7.CRUD-4 bazovıye funksii pri rabote s bazı dannımi.V SQL ih mojno oboznachit kak insert,select,uptade i delete " );
        fileWriter.close();

}}
