package se.ecutb.hala.jpa_boot_project.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.ecutb.hala.jpa_boot_project.entity.AppUser;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
public class AppUserDaoImpl implements AppUserDao {

    @Autowired
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public Optional<AppUser> findById(int id){
        AppUser appUser = em.find(AppUser.class, id);
        return Optional.ofNullable(appUser);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public AppUser update(AppUser appUser){
        if(appUser == null){
            throw new IllegalArgumentException();
        }
        if(appUser.getUserId() == 0){
            throw new IllegalArgumentException("Please persist user first");
        }
        return em.merge(appUser);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public AppUser save(AppUser appUser){
        em.persist(appUser);
        return appUser;
    }
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean delete(AppUser appUser){
        em.remove(appUser);
       return !findById(appUser.getUserId()).isPresent();
    }

}
