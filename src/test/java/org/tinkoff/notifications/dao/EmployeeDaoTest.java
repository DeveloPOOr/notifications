package org.tinkoff.notifications.dao;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class EmployeeDaoTest {

//    @Autowired private EmployeeDao employeeDao;
//    @Autowired private ProjectDao presentDao;
//
//    @Test
//    public void save() {
//        EmployeeDto employeeDto =
//                new EmployeeDto(
//                        "Зубенко Михаил Петрович",
//                        "+79992434271",
//                        "2008-10-25",
//                        "2020-10-10",
//                        "Милан");
//        Employee employee =
//                new Employee(
//                        5L,
//                        "Зубенко Михаил Петрович",
//                        "+79992434271",
//                        Collections.emptySet(),
//                        "2008-10-25",
//                        "2020-10-10",
//                        Collections.emptyList(),
//                        "Милан");
//        employeeDao.save(employeeDto);
//        assertEquals(employeeDao.findById(5L), employee);
//    }
//
//    @Test
//    public void findById() {
//        Employee employee =
//                new Employee(
//                        1L,
//                        "Зубенко Михаил Петрович",
//                        "+79992434271",
//                        Set.of(new Project(1L, "Тинькофф инвестиции", "Про инвестиции")),
//                        "2002-12-18",
//                        "2020-10-10",
//                        List.of(
//                                new Present(1L, "Подарок1", "ссылка1", "описание1"),
//                                new Present(2L, "Подарок2", "ссылка2", "описание2"),
//                                new Present(3L, "Подарок3", "ссылка3", "описание3")),
//                        "Лондон");
//        assertEquals(employeeDao.findById(1L), employee);
//    }
//
//    @Test
//    public void update() {
//        Employee employee = employeeDao.findById(2L);
//        employee.setCity("Лондон");
//        employeeDao.update(employee);
//        assertEquals(employeeDao.findById(2L), employee);
//    }
//
//    @Test
//    public void delete() {
//        Employee employee = employeeDao.findById(3L);
//        employeeDao.delete(employee);
//        assertEquals(employeeDao.findById(3L), null);
//        assertEquals(presentDao.findById(6L), null);
//    }
}
