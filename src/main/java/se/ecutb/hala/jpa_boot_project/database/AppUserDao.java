package se.ecutb.hala.jpa_boot_project.database;

import se.ecutb.hala.jpa_boot_project.entity.AppUser;

import java.util.Optional;

public interface AppUserDao {
    Optional<AppUser> findById(int id);

    AppUser update(AppUser appUser);

    AppUser save(AppUser appUser);

    boolean delete(AppUser appUser);
}
