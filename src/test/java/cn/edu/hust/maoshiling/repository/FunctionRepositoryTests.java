package cn.edu.hust.maoshiling.repository;

import cn.edu.hust.maoshiling.ApplicationTest;
import cn.edu.hust.maoshiling.entity.Category;
import cn.edu.hust.maoshiling.entity.Function;
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
public class FunctionRepositoryTests {
    @Autowired
    private FunctionRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    @Transactional
    public void findOneTest() throws Exception{
        Integer id = 1;
        Function function = repository.findOne(id);
        assertNotNull(function);
        assertEquals(function.getId(),new Integer(1));
        assertEquals(function.getName(),"系统管理子菜单1");
        assertEquals(function.getUrl(),"/system/management1");
        assertEquals(function.getCategory().getId(),new Integer(1));
        assertTrue(function.getRoles().size()>0);
    }

    @Test
    public void findAllTest() throws Exception{
        List<Function> functions = repository.findAll();
        assertNotNull(functions);
        assertTrue(functions.size()>=4);
    }

    @Test
    public void findByCategotyTest() throws Exception{
        Category category = categoryRepository.findOne(1);
        List<Function> functions = repository.findByCategory(category);
        assertNotNull(functions);
        assertTrue(functions.size()>=1);
    }

    @Test
    public void addTest() throws Exception{
        Category category = categoryRepository.findOne(1);
        List<Role> roles = roleRepository.findAll();

        Function functionToAdd= Function.builder()
                .name("testAdd")
                .url("测试增加")
                .category(category)
                .roles(roles)
                .build();

        Function function = repository.save(functionToAdd);
        assertNotNull(function);
        assertEquals(function.getId(),new Integer(7));
        assertEquals(function.getName(),"testAdd");
        assertEquals(function.getUrl(),"测试增加");
        assertEquals(function.getCategory().getId(),new Integer(1));
        assertTrue(function.getRoles().size()>1);
        assertEquals(function.getCreatedBy(),"admin");
        assertNotNull(function.getCreatedAt());
        assertEquals(function.getModifiedBy(),"admin");
        assertNotNull(function.getModifiedAt());
        assertEquals(new Integer(function.getVersion()),new Integer(0));
    }

    @Test
    public void modifyTest() throws Exception{
        Integer id = 5;
        Function functionToModify = repository.findOne(id);
        assertNotNull(functionToModify);
        assertEquals(functionToModify.getName(),"测试修改");

        functionToModify.setName("修改后");

        Function function = repository.save(functionToModify);
        assertNotNull(function);
        assertEquals(function.getName(),"修改后");
        assertEquals(new Integer(function.getVersion()),new Integer(1));
    }

    @Test
    public void deleteTest() throws Exception{
        Integer id = 6;
        Function functionToDelete = repository.findOne(id);
        assertNotNull(functionToDelete);
        assertEquals(functionToDelete.getName(),"测试删除");

        repository.delete(functionToDelete);

        Function function = repository.findOne(id);
        assertNull(function);
    }
}
