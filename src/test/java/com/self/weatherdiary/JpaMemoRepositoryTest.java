package com.self.weatherdiary;

import com.self.weatherdiary.domain.Memo;
import com.self.weatherdiary.repository.JpaMemoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class JpaMemoRepositoryTest {

    @Autowired
    JpaMemoRepository jpaMemoRepository;

    @Test
    void insertMemoTest() {
        // given
        Memo memo = new Memo(10, "this is jpa test");
        // when
        jpaMemoRepository.save(memo);
        // then
        List<Memo> memoList = jpaMemoRepository.findAll();
        assertTrue(memoList.size() > 0);
    }

    @Test
    void findByIdTest() {
        Memo memo = new Memo(11, "jpa");

        Memo save = jpaMemoRepository.save(memo);

        Optional<Memo> result = jpaMemoRepository.findById(save.getId());

        assertEquals(result.get().getText(), "jpa");
    }
}
