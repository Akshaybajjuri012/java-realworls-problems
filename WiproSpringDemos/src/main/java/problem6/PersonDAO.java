package problem6;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static class PersonRowMapper implements RowMapper<Person> {
        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setAge(rs.getInt("age"));
            person.setFirstName(rs.getString("first_name"));
            person.setLastName(rs.getString("last_name"));
            return person;
        }
    }

    public List<Person> findAll() {
        String sql = "SELECT * FROM person";
        return jdbcTemplate.query(sql, new PersonRowMapper());
    }

    public Person findById(int id) {
        String sql = "SELECT * FROM person WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new PersonRowMapper(), id);
    }

    public int insert(Person person) {
        String sql = "INSERT INTO person (id, age, first_name, last_name) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, person.getId(), person.getAge(), person.getFirstName(), person.getLastName());
    }

    public int update(Person person) {
        String sql = "UPDATE person SET age = ?, first_name = ?, last_name = ? WHERE id = ?";
        return jdbcTemplate.update(sql, person.getAge(), person.getFirstName(), person.getLastName(), person.getId());
    }

    public int deleteById(int id) {
        String sql = "DELETE FROM person WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
