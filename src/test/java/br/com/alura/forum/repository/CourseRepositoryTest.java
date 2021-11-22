package br.com.alura.forum.repository;

import br.com.alura.forum.model.Course;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class CourseRepositoryTest {

    @Autowired
    private CourseRepository repository;

    @Autowired
    private TestEntityManager em;

    @Test
    public void shouldFindACourseByName(){
        String courseName = "HTML 5";

        Course html5 = new Course();
        html5.setName(courseName);
        html5.setCategory("Programacao");
        em.persist(html5);
        Course course = repository.findByName(courseName);
        Assertions.assertNotNull(course);
        Assertions.assertEquals(courseName, course.getName());
    }

    @Test
    public void shouldFindACourseByNotRegisterName(){
        String courseName = "JPA";
        Course course = repository.findByName(courseName);
        Assertions.assertNull(course);
    }

}