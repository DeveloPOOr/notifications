package org.tinkoff.notifications.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.tinkoff.notifications.dto.PresentDto;
import org.tinkoff.notifications.model.Present;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class PresentDaoTest {

    @Autowired
    private PresentDao presentDao;

    @Test
    public void savePresent() {
        presentDao.save(preparedPresentDto(), 1L);
        assertEquals(presentDao.findById(7L), new Present(
                7,
                "TestName",
                "www.present.com",
                "good Present"));
    }

    @Test
    public void findById() {
        assertEquals(presentDao.findById(1L), preparedPresent(1L));
    }

    @Test
    public void update() {
        Present present = preparedPresent(2L);
        present.setDescription("update");
        presentDao.update(present);
        assertEquals(presentDao.findById(2L), present);
    }

    @Test
    public void delete() {
        presentDao.delete(preparedPresent(3L));
        assertEquals(presentDao.findById(3L), null);
    }

    public Present preparedPresent(long id) {
        return new Present(
                id,
                "Подарок" + id,
                "ссылка" + id,
                "описание" + id
        );
    }

    public PresentDto preparedPresentDto() {
        return new PresentDto(
                "TestName",
                "www.present.com",
                "good Present"
        );
    }
}