package com.self.weatherdiary.repository;

import com.self.weatherdiary.domain.Memo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcMemoRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcMemoRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<Memo> memoRowMapper() {
        return ((rs, rowNum) ->  new Memo(
                rs.getInt("id"),
                rs.getString("text")
        ));
    }

    public Memo save(Memo memo) {
        String sql = "INSERT INTO memo values(?, ?)";
        jdbcTemplate.update(sql, memo.getId(), memo.getText());
        return memo;
    }

    public Optional<Memo> findById(int id) {
        String sql = "SELECT * FROM memo WHERE id = ?";
        return jdbcTemplate.query(sql, memoRowMapper(), id).stream().findFirst();
    }

    public List<Memo> findAll() {
        String sql = "SELECT * FROM memo";
        return jdbcTemplate.query(sql, memoRowMapper());
    }




}
