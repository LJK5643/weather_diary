package com.self.weatherdiary;

import com.self.weatherdiary.domain.Memo;
import com.self.weatherdiary.repository.JdbcMemoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
public class JdbcMemoTest {

    @Autowired
    JdbcMemoRepository jdbcMemoRepository;

    @Test
    public void insertMemoTest() {
        // given
        Memo memo = new Memo(2, "InsertMemoTest");

        // when
        jdbcMemoRepository.save(memo);

        // then
        Optional<Memo> result = jdbcMemoRepository.findById(2);
        assertEquals(result.get().getText(), "InsertMemoTest");
    }

    @Test
    public void findAllMemoTest() {
        List<Memo> result = jdbcMemoRepository.findAll();

        System.out.println(result);

        assertNotNull(result);
    }
}
