import java.sql.*;
import java.text.spi.DateFormatSymbolsProvider;
import java.time.LocalDate;

public class DBworker {
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "farmuses";

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection( url, user, password );
            System.out.println( "Connected to the PostgreSQL server successfully." );
        } catch (SQLException e) {
            System.out.println( e.getMessage() );
        }
        return conn;
    }

    public void maxBrand() {
        String SQL1 = "select brand_id from clothes where brand_id=1";
        String SQL2 = "select brand_id from clothes where brand_id=2";
        int count1 = 0;
        int count2 = 0;
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs1 = stmt.executeQuery( SQL1 );
             ResultSet rs2 = stmt.executeQuery( SQL2 );
        ) {
            while (rs1.next()) {
                count1++;
                rs1.getInt( "brand_id" );
            }

        } catch (SQLException e) {
            System.out.println( e.getMessage() );
        }

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery( SQL2 )) {

            while (rs.next()) {
                count2++;
                rs.getInt( "brand_id" );
            }
        } catch (SQLException ex) {
            System.out.println( ex.getMessage() );
        }
        if (count1 > count2) {
            System.out.println("Nike has "+ count1+ " clothes" );
        } else System.out.println( "Puma has "+ count2+ "clothes"
        );
    }

    public void addClothes(int id, String category, String color, String size, int price, int brand_id,
                           int season_id) {
        String SQL = "insert into clothes(id,category,color,size,price,brand_id,season_id)values(?,?,?,?,?,?,?)";
        try (Connection conn = connect();
             PreparedStatement preparedStatement = conn.prepareStatement( SQL )) {
            preparedStatement.setInt( 1, id );
            preparedStatement.setString( 2, category );
            preparedStatement.setString( 3, color );
            preparedStatement.setString( 4, size );
            preparedStatement.setInt( 5, price );
            preparedStatement.setInt( 6, brand_id );
            preparedStatement.setInt( 7, season_id );
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println( e.getMessage() );
        }

    }

    public void showClothes() {
        String SQL = "select  c.category,c.color,c.size,c.price ,b.name,s.name,s.discount from clothes c " +
                "join brand b on c.brand_id=b.id " +
                "join season s on c.season_id =s.id";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery( SQL )) {
            while (rs.next()) {
                System.out.println( rs.getString( 1 ) + ":" + rs.getString( 2 ) + ":" +
                        rs.getString( 3 ) + ":" + rs.getInt( 4 ) + ":" + rs.getString( 5 ) + ":" + rs.getString( 6 ) + ":" + rs.getInt( 7 ) );
            }
        } catch (SQLException e) {
            System.out.println( e.getMessage() );
        }

    }

    public void showByseason(int n) {
        String SQL = "select * from clothes where season_id= " +n;
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery( SQL )) {
            while (rs.next()) {
                System.out.println( rs.getInt( 1 ) + ":" + rs.getString( 2 ) + ":" +
                        rs.getString( 3 ) + ":" + rs.getString( 4 ) + ":" + rs.getInt( 5 ) + ":" + rs.getInt( 6 ) + ":" + rs.getInt( 7 ) );
            }
        } catch (SQLException e) {
            System.out.println( e.getMessage() );
        }

    }

    public void show50discount() {
        String SQL = "select * from clothes inner join season on clothes.season_id=season.id where season.discount=50";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery( SQL )) {
            while (rs.next()) {
                System.out.println( rs.getInt( 1 ) + ":" + rs.getString( 2 ) + ":" +
                        rs.getString( 3 ) + ":" + rs.getString( 4 ) + ":" + rs.getInt( 5 ) );
            }
        } catch (SQLException e) {
            System.out.println( e.getMessage() );
        }
    }

    public void top5() {
        String SQL = "select price from clothes order by price desc limit 5";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery( SQL )) {
            while (rs.next()) {
                System.out.println( rs.getInt( 1 ) + ":" + rs.getString( 2 ) + ":" +
                        rs.getString( 3 ) + ":" + rs.getString( 4 ) + ":" + rs.getInt( 5 ) );
            }
        } catch (SQLException e) {
            System.out.println( e.getMessage() );
        }
    }}
/*public void top5(){
        String SQL="select price from clothes order by price desc limit 5";
    try (Connection conn = connect();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery( SQL )) {
        while (rs.next()) {
            System.out.println( rs.getInt( 1 ) + ":" + rs.getString( 2 ) + ":" +
                    rs.getString( 3 ) + ":" + rs.getString( 4 ) + ":" + rs.getInt( 5 ) );
}
}catch (SQLException e) {
        System.out.println( e.getMessage() );}}}
    /*public void register(String Login, String email, String password) {
        String SQL = "insert into users(Login,email,password) values(?,?,?)";
        try (Connection conn = connect();
             PreparedStatement preparedStatement = conn.prepareStatement( SQL )) {
            preparedStatement.setString( 2, Login );
            preparedStatement.setString( 3, email );
            preparedStatement.setString( 4, password );
            LocalDate localDate=new LocalDate();
            preparedStatement.execute();

        }
        catch (SQLException e) {
            if
            System.out.println( e.getMessage() );
        }

    }*/


