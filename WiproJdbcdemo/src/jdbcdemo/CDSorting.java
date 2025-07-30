package jdbcdemo;
import java.sql.*;
import java.util.*;
public class CDSorting {
	static final String DB_URL = "jdbc:mysql://localhost:3306/company";
    static final String USER = "root";
    static final String PASS = "Akshay@9100";

    // Inner class CD implementing Comparable
    static class CD implements Comparable<CD> {
        private String title;
        private String singer;

        public CD(String title, String singer) {
            this.title = title;
            this.singer = singer;
        }
        public String getTitle() {
            return title;
        }

        public String getSinger() {
            return singer;
        }

        @Override
        public int compareTo(CD other) {
            return this.singer.compareToIgnoreCase(other.singer);
        }
        @Override
        public String toString() {
            return "CD [Title=" + title + ", Singer=" + singer + "]";
        }
    }
    public static void insertCDToDatabase(CD cd) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "INSERT INTO cds (title, singer) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cd.getTitle());
            ps.setString(2, cd.getSinger());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static List<CD> getCDsFromDatabase() {
        List<CD> cds = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "SELECT title, singer FROM cds";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                cds.add(new CD(rs.getString("title"), rs.getString("singer")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cds;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<CD> cdList = Arrays.asList(
                new CD("Back to Black", "Amy Winehouse"),
                new CD("Divide", "Ed Sheeran"),
                new CD("21", "Adele"),
                new CD("Thriller", "Michael Jackson"),
                new CD("25", "Adele")
        );
		for (CD cd : cdList) {
            insertCDToDatabase(cd);
        }

        // Retrieve and sort
        List<CD> cdsFromDB = getCDsFromDatabase();
        Collections.sort(cdsFromDB);

        // Print sorted
        System.out.println("CDs sorted by singer name (from DB):");
        for (CD cd : cdsFromDB) {
            System.out.println(cd);
        }

	}

}

/*
CDs sorted by singer name (from DB):
CD [Title=21, Singer=Adele]
CD [Title=25, Singer=Adele]
CD [Title=Back to Black, Singer=Amy Winehouse]
CD [Title=Divide, Singer=Ed Sheeran]
CD [Title=Thriller, Singer=Michael Jackson]
*/