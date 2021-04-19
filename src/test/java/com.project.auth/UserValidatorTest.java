package com.project.auth;

import com.project.auth.model.User;
import com.project.auth.repository.RoleRepository;
import com.project.auth.repository.UserRepository;
import com.project.auth.service.UserService;
import com.project.auth.validator.UserValidator;
import com.project.auth.web.UserController;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.DataBinder;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

@SpringBootTest
public class UserValidatorTest {
    @Autowired
    private UserValidator validator;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserController userController;





    @Test
    public void testValidatorsGood() {

        final User user = new User(23234224L,"Danil952","123456789","123456789");
        final DataBinder dataBinder = new DataBinder(user);
        dataBinder.addValidators(validator);
        dataBinder.validate();

        Assert.assertTrue(!dataBinder.getBindingResult().hasErrors());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Test
    public void testValidatorsSmallPass() {

        final User user = new User(23234224L,"Danil952","1234","1234");

        final DataBinder dataBinder = new DataBinder(user);
        dataBinder.addValidators(validator);
        dataBinder.validate();

        Assert.assertTrue(!dataBinder.getBindingResult().hasErrors());
    }
    @Test
    public void testValidatorsDiffPass() {

        final User user = new User(23234224L,"Danil952","12345678","123456789");

        final DataBinder dataBinder = new DataBinder(user);
        dataBinder.addValidators(validator);
        dataBinder.validate();

        Assert.assertTrue(!dataBinder.getBindingResult().hasErrors());
    }

    @Test
    public void testIsUserExist()
    {
        Assert.assertTrue(userService.findByUsername("Danil952") != null);
        Assert.assertFalse(userService.findByUsername("Danil9521") != null);
    }

    @Test
    public void testUserAdded()
    {
        final User user = new User(23234224L,"Bulat","123456789","123456789");
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
        User user2 = userRepository.findByUsername("Bulat");
        Assert.assertEquals(user.getUsername(), user2.getUsername());
    }

}

