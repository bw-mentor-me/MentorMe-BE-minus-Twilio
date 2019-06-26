package com.lambdaschool.starthere;

import com.lambdaschool.starthere.models.Question;
import com.lambdaschool.starthere.models.Role;
import com.lambdaschool.starthere.models.User;
import com.lambdaschool.starthere.models.UserRoles;
import com.lambdaschool.starthere.services.RoleService;
import com.lambdaschool.starthere.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
//@Component
public class SeedData implements CommandLineRunner
{
    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;


    @Override
    public void run(String[] args) throws Exception
    {
        Role r1 = new Role("admin");
        Role r2 = new Role("user");
        Role r3 = new Role("data");

        roleService.save(r1);
        roleService.save(r2);
        roleService.save(r3);

        // admin, data, user
        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));
        admins.add(new UserRoles(new User(), r2));
        admins.add(new UserRoles(new User(), r3));
        User u1 = new User("admin", "password", admins);
        u1.getQuestions().add(new Question("A creative man is motivated by the desire to achieve, not by the desire to beat others", u1));
        u1.getQuestions().add(new Question("The question isn't who is going to let me; it's who is going to stop me.", u1));
        userService.save(u1);

        // data, user
        ArrayList<UserRoles> datas = new ArrayList<>();
        datas.add(new UserRoles(new User(), r3));
        datas.add(new UserRoles(new User(), r2));
        User u2 = new User("cinnamon", "1234567", datas);
        userService.save(u2);

        // user
        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u3 = new User("Jane Doe", "ILuvM4th!", users);
        u3.getQuestions().add(new Question("How do get Angel funding?", u3));
        u3.getQuestions().add(new Question("What shuold I look for in a cofounder?", u3));
        u3.getQuestions().add(new Question("When do I need to bring on a CFO?", u3));
        userService.save(u3);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u4 = new User("Daddy Moneybags", "password", users);
        userService.save(u4);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u5 = new User("Jane", "password", users);
        userService.save(u5);
    }
}