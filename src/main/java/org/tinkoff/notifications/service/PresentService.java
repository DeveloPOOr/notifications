package org.tinkoff.notifications.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tinkoff.notifications.dao.PresentDao;
import org.tinkoff.notifications.dto.PresentDto;
import org.tinkoff.notifications.model.Employee;
import org.tinkoff.notifications.model.Present;

@Service
public class PresentService {

    private PresentDao presentDao;
    private Logger logger = LoggerFactory.getLogger(PresentService.class);

    public PresentService(PresentDao presentDao) {
        this.presentDao = presentDao;
    }

    public void save(PresentDto presentDto, long employeeId) {
        presentDao.save(presentDto, employeeId);
        logger.info("Present " + presentDto + " was saved to employee's wishlist with id " + employeeId );
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