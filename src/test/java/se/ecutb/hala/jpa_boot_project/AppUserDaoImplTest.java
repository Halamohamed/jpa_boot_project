package se.ecutb.hala.jpa_boot_project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import se.ecutb.hala.jpa_boot_project.database.AppUserDao;
import se.ecutb.hala.jpa_boot_project.database.AppUserDaoImpl;
import se.ecutb.hala.jpa_boot_project.entity.AppUser;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@AutoConfigureTestEntityManager
@Transactional
public class AppUserDaoImplTest {

    @Autowired @Qualifier("appUserDaoImpl") private AppUserDao testObject;
    @Autowired private TestEntityManager em;
    private AppUser testUser;
    private int testUserId;

    @BeforeEach
    void setUp() {

        testUser = em.persist(new AppUser("TestObj","Test","Testsson", LocalDate.parse("2000-01-10"),"test"));
        testUserId = testUser.getUserId();
        em.flush();
    }

    @Test
    public void save_successfully_persist_user(){
        AppUser user = new AppUser("test1", "test1","test1sson",LocalDate.parse("2001-01-11"),"test1");
        AppUser result = testObject.save(user);

        assertNotNull(result);
        assertTrue(result.getUserId() > 0);
        assertNotNull(em.find(AppUser.class, result.getUserId()));
    }

    @Test
    public void given_testUserId_successfully_return_optional_with_testUser(){
        Optional<AppUser> result = testObject.findById(testUserId);
        assertNotNull(result.isPresent());
        assertEquals(testUser,result.get());
    }

    @Test
    public void given_update_testUser_update_successfully(){
        testUser.setFirstName("TestUpdate");
        AppUser result = testObject.update(testUser);
        assertNotNull(result);
        assertEquals("TestUpdate",result.getFirstName());
    }

    @Test
    public void given_testUser_delete_successfully_deletes(){
        assertTrue(testObject.delete(testUser));
        assertNull(em.find(AppUser.class,testUserId));
    }
}
