package cn.edu.hust.maoshiling.repository;

import cn.edu.hust.maoshiling.ApplicationTest;
import cn.edu.hust.maoshiling.entity.Department;
import cn.edu.hust.maoshiling.entity.Role;
import cn.edu.hust.maoshiling.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by 15352 on 2017/4/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationTest.class)
public class UserRepositoryTests {

    @Autowired
    private UserRepository repository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    @Transactional
    public void findOneTest() throws Exception{
        Integer id = 1;
        User user = repository.findOne(id);
        assertNotNull(user);
        assertEquals(user.getId(),new Integer(1));
        assertEquals(user.getUsername(),"adminUsername");
        assertEquals(user.getPassword(),"adminPassword");
        assertEquals(user.getName(),"adminName");
        assertNotNull(user.getBirthday());
        assertTrue(user.getRoles().size()>0);
        assertEquals(user.isSex(),false);
        assertEquals(user.getDepartment().getId(),new Integer(1));
    }

    @Test
    public void findByUsernameTest() throws Exception{
        String username = "adminUsername";
        User user = repository.findByUsername(username);
        assertNotNull(user);
        assertEquals(user.getId(),new Integer(1));
        assertEquals(user.getUsername(),"adminUsername");
    }

    @Test
    public void findByNameTest() throws Exception{
        String name = "adminName";
        User user = repository.findByName(name);
        assertNotNull(user);
        assertEquals(user.getId(),new Integer(1));
        assertEquals(user.getName(),"adminName");
    }

    @Test
    public void findAllTest() throws Exception{
        List<User> users = repository.findAll();
        assertNotNull(users);
        assertTrue(users.size()>2);
    }

    @Test
    public void addTest() throws Exception{
        Role role = roleRepository.findByRoleCode("student");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        Department department = departmentRepository.findOne(1);

        User userToAdd = User.builder()
                .username("testAdd")
                .password("testAddPassword")
                .birthday(Instant.now())
                .name("testAddName")
                .sex(true)
                .department(department)
                .roles(roles)
                .build();

        User user = repository.save(userToAdd);
        assertEquals(user.getId(),new Integer(8));
        assertEquals(user.getPassword(),"testAddPassword");
        assertEquals(user.getName(),"testAddName");
        assertEquals(user.getCreatedBy(),"admin");
        assertNotNull(user.getCreatedAt());
        assertEquals(user.getModifiedBy(),"admin");
        assertNotNull(user.getModifiedAt());
        assertEquals(new Integer(user.getVersion()),new Integer(0));
    }

    @Test
    public void modifyTest() throws Exception{
        User userToModify = repository.findOne(6);
        assertEquals(userToModify.getName(),"nameForModify");
        userToModify.setName("nameAfterModify");
        User user  = repository.save(userToModify);
        assertEquals(user.getName(),"nameAfterModify");
        assertEquals(new Integer(user.getVersion()),new Integer(1));
    }

    @Test
    public void deleteTest() throws Exception{
        User userToDelete = repository.findOne(7);
        assertEquals(userToDelete.getName(),"nameForDelete");
        repository.delete(userToDelete);
        User user = repository.findOne(7);
        assertNull(user);
    }

}
