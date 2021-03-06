package org.tinkoff.notifications.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.tinkoff.notifications.dao.PresentDao;
import org.tinkoff.notifications.model.Present;

@Service
public class PresentService {

    private final PresentDao presentDao;
    private final Logger logger = LoggerFactory.getLogger(PresentService.class);

    public PresentService(PresentDao presentDao) {
        this.presentDao = presentDao;
    }

    public Present save(Present present, long employeeId) {
        presentDao.save(present, employeeId);
        logger.info(
                "Present " + present + " was saved to employee's wishlist with id " + employeeId);
        present.setEmployee_id(employeeId);
        return present;
    }

    public Present findById(long id) {
        Present present = presentDao.findById(id);
        logger.info("Present with id " + id + " was found");
        return present;
    }

    public void update(Present present) {
        presentDao.update(present);
        logger.info("Present " + present + " was updated");
    }

    public void delete(Present present) {
        presentDao.delete(present);
        logger.info("Present " + present + " was deleted");
    }
}
