package org.tinkoff.notifications.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.tinkoff.notifications.dto.PresentDto;
import org.tinkoff.notifications.model.Present;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PresentDaoTest {

    @Autowired
    private PresentDao presentDao;

    @Test
    public void savePresent() {
        presentDao.save(preparedPresentDto());
    }

    public PresentDto preparedPresentDto() {
        return new PresentDto(
                "TestName",
                "www.present.com",
                "good Present"
        );
    }
}