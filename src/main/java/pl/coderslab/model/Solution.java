package pl.coderslab.model;

/*
Mamy taką bazę danych a właściwie tabelke:
    |solution_id|author_id|body|
    |     1     |     3   |....| rs.next()
    |     2     |     3   |....| rs.next()
    |     3     |     2   |....|
to co wyciągniemy z bazy danych (w SolutionDAO) w postaci^^
wstawimy do obiektu tejże klasy
*/
public class Solution {
    private String body; // body z bazy
    private int authorId; // author_id z bazy

    // new Solution(body, authorId);
    public Solution(String body, int authorId) {
        this.body = body;
        this.authorId = authorId;
    }

    public String getBody() {
        return body;
    }

    public int getAuthorId() {
        return authorId;
    }
}