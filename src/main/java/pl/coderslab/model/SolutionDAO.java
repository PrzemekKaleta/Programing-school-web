package pl.coderslab.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
Do wszystkich operacji na tabeli solution z bazy danych będziemy
korzystać z klasy SolutionDAO, której metody będą przyjmować bądź
zwracać obiekty klasy Solution

albo: BazaDanych -> SolutionDAO -> Solution
albo: Solution -> SolutionDAO -> BazaDanych

będzie zamieniać rekordy z bazy danych na obiekty (bądź ich kolecje)
oraz odwrotnie
 */
public class SolutionDAO {

    // nasze query do wykonania, trzeba dostarczyć parametr pod (?)
    // określający LIMIT
    public static final String FIND_RECENT_QUERY =
            "SELECT * FROM solutions ORDER BY solutuion_in DESC LIMIT ?";

    // metoda pobierającą z bazy danych ostatnie rozwiązania
    public static List<Solution> findRecent(int limit) {
        List<Solution> results = new ArrayList<>();

        try {
            // tak jak robiliśmy to na module 2 tylko że przez DbUtil
            // a nie przez DriverManagera
            Connection connection = SchoolConn.getConnection();

            // z connection tworzmy prepared statement
            PreparedStatement ps = connection.prepareStatement(
                    FIND_RECENT_QUERY
            );

            // ustawiamy parametr pod (?)
            ps.setInt(1, limit);

            // wykonujemy zapytanie i dostjemy ResultSet
            ResultSet rs = ps.executeQuery();

            // jedziemy przez cały Result Set po kolei przez każdy rekord
            // podobnie jak iteratory w kolekcji
            while (rs.next()) {
                // wyciągamy kolumne
                int authorId = rs.getInt("author_id");

                // wyciągamy kolumne
                String body = rs.getString("body");

                // tworzymy obiekt
                Solution solution = new Solution(body, authorId);

                // dodajemy do kolekcji
                results.add(solution);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }
}
