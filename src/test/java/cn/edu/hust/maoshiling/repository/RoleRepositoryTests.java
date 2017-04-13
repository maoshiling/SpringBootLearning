package cn.edu.hust.maoshiling.repository;

import cn.edu.hust.maoshiling.ApplicationTest;
import cn.edu.hust.maoshiling.entity.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 15352 on 2017/4/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationTest.class)
public class RoleRepositoryTests {

    @Autowired
    private RoleRepository repository;

    @Test
    @Transactional
    public void findByRoleCodeTest() throws Exception{
        String roleCode = "admin";
        Role role = repository.findByRoleCode(roleCode);
        assertNotNull(role);
        assertEquals(role.getRoleCode(),"admin");
        assertEquals(role.getRoleName(),"超级管理员");
        assertTrue(role.getFunctions().size()>0);
    }

    @Test
    public void findAllTest() throws Exception{
        List<Role> roles = repository.findAll();
        assertNotNull(roles);
        assertTrue(roles.size()>=5);
    }

    @Test
    public void addTest() throws Exception{
        Role roleToAdd= Role.builder()
                .roleCode("testAdd")
                .roleName("测试增加")
                .build();
        Role role = repository.save(roleToAdd);
        assertNotNull(role);
        assertEquals(role.getRoleCode(),"testAdd");
        assertEquals(role.getRoleName(),"测试增加");
        assertEquals(role.getCreatedBy(),"admin");
        assertNotNull(role.getCreatedAt());
        assertEquals(role.getModifiedBy(),"admin");
        assertNotNull(role.getModifiedAt());
        assertEquals(new Integer(role.getVersion()),new Integer(0));
    }

    @Test
    public void modifyTest() throws Exception{
        String roleCode = "testModify";
        Role roleToModify = repository.findByRoleCode(roleCode);
        assertNotNull(roleToModify);
        assertEquals(roleToModify.getRoleCode(),"testModify");
        assertEquals(roleToModify.getRoleName(),"测试修改");
        roleToModify.setRoleName("修改后");
        Role role = repository.save(roleToModify);
        assertNotNull(role);
        assertEquals(role.getRoleCode(),"testModify");
        assertEquals(role.getRoleName(),"修改后");
        assertEquals(new Integer(role.getVersion()),new Integer(1));
    }

    @Test
    public void deleteTest() throws Exception{
        String roleCode = "testDelete";
        Role roleToDelete = repository.findByRoleCode(roleCode);
        assertNotNull(roleToDelete);
        assertEquals(roleToDelete.getRoleCode(),"testDelete");
        assertEquals(roleToDelete.getRoleName(),"测试删除");
        repository.delete(roleToDelete);
        Role role = repository.findByRoleCode(roleCode);
        assertNull(role);
    }

}
