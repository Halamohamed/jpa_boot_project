package se.ecutb.hala.jpa_boot_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.ecutb.hala.jpa_boot_project.database.AppUserDao;
import se.ecutb.hala.jpa_boot_project.entity.AppUser;

import java.time.LocalDate;

@Component
public class CommandLine implements CommandLineRunner {
    private AppUserDao dao;

    @Autowired
    public CommandLine(AppUserDao dao) {
        this.dao = dao;
    }

    @Override
    public void run(String... args) throws Exception {
        AppUser appUser = new AppUser("hala","hala","ali", LocalDate.parse("1985-12-24"),"1234");
        System.out.println(dao.save(appUser));

    }
}
