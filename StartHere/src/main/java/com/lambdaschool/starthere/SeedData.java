//package com.lambdaschool.starthere;
//
//import com.lambdaschool.starthere.models.*;
//import com.lambdaschool.starthere.services.RoleService;
//import com.lambdaschool.starthere.services.TypeService;
//import com.lambdaschool.starthere.services.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//
//@Transactional
////@Component
//public class SeedData implements CommandLineRunner
//{
//    @Autowired
//    TypeService typeService;
//
//    @Autowired
//    RoleService roleService;
//
//    @Autowired
//    UserService userService;
//
//
//    @Override
//    public void run(String[] args) throws Exception
//    {
//        Type t1 = new Type("mentor");
//        Type t2 = new Type("entrepreneur");
//
//        typeService.save(t1);
//        typeService.save(t2);
//
//        Role r1 = new Role("admin");
//        Role r2 = new Role("user");
//        Role r3 = new Role("data");
//
//        roleService.save(r1);
//        roleService.save(r2);
//        roleService.save(r3);
//
//        // admin, data, user
//        ArrayList<UserRoles> adminUserRoles = new ArrayList<>();
//        adminUserRoles.add(new UserRoles(new User(), r1));
//        adminUserRoles.add(new UserRoles(new User(), r2));
//        adminUserRoles.add(new UserRoles(new User(), r3));
//        ArrayList<UserTypes> adminUserTypes = new ArrayList<>();
//        adminUserTypes.add(new UserTypes(new User(), t1));
//        adminUserTypes.add(new UserTypes(new User(), t2));
//        User u1 = new User("admin", "password", adminUserTypes, adminUserRoles);
//        u1.getQuestions().add(new Question("What criteria are required to apply to Y Combinator?", u1));
//        u1.getQuestions().add(new Question("When should we develop inhouse versus outsourcing?", u1));
//        userService.save(u1);
//
//        // data, user
//        ArrayList<UserRoles> datas = new ArrayList<>();
//        datas.add(new UserRoles(new User(), r3));
//        datas.add(new UserRoles(new User(), r2));
//        User u2 = new User("cinnamon", "1234567", datas);
//        userService.save(u2);
//
//        // user
//        ArrayList<UserRoles> users = new ArrayList<>();
//        users.add(new UserRoles(new User(), r2));
//        User u3 = new User("Jane Doe", "ILuvM4th!", users);
//        u3.getQuestions().add(new Question("How do get Angel funding?", u3));
//        u3.getQuestions().add(new Question("What shuold I look for in a cofounder?", u3));
//        u3.getQuestions().add(new Question("When do I need to bring on a CFO?", u3));
//        userService.save(u3);
//
//        users = new ArrayList<>();
//        users.add(new UserRoles(new User(), r2));
//        User u4 = new User("Daddy Moneybags", "password", users);
//        userService.save(u4);
//
//        users = new ArrayList<>();
//        users.add(new UserRoles(new User(), r2));
//        User u5 = new User("Jane", "password", users);
//        userService.save(u5);
//    }
//}