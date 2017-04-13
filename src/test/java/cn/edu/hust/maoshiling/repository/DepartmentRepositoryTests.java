package cn.edu.hust.maoshiling.repository;

import cn.edu.hust.maoshiling.ApplicationTest;
import cn.edu.hust.maoshiling.entity.Department;
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
public class DepartmentRepositoryTests {

    @Autowired
    private DepartmentRepository repository;

    @Test
    @Transactional
    public void findOneTest() throws Exception{
        Integer id = 1;
        Department department= repository.findOne(id);
        assertNotNull(department);
        assertEquals(department.getId(),new Integer(1));
        assertEquals(department.getName(),"电信学院");
        assertTrue(department.getUsers().size()>3);
    }

    @Test
    public void findAllTest() throws Exception{
        List<Department> departments = repository.findAll();
        assertNotNull(departments);
        assertTrue(departments.size()>=2);
    }

    @Test
    public void addTest() throws Exception{

        Department departmentToAdd= Department.builder()
                .name("testAdd")
                .build();

        Department department = repository.save(departmentToAdd);
        assertNotNull(department);
        assertEquals(department.getId(),new Integer(6));
        assertEquals(department.getName(),"testAdd");
        assertEquals(department.getCreatedBy(),"admin");
        assertNotNull(department.getCreatedAt());
        assertEquals(department.getModifiedBy(),"admin");
        assertNotNull(department.getModifiedAt());
        assertEquals(new Integer(department.getVersion()),new Integer(0));
    }

    @Test
    public void modifyTest() throws Exception{
        Integer id = 3;
        Department departmentToModify = repository.findOne(id);
        assertNotNull(departmentToModify);
        assertEquals(departmentToModify.getName(),"测试修改");

        departmentToModify.setName("修改后");

        Department department = repository.save(departmentToModify);
        assertNotNull(department);
        assertEquals(department.getName(),"修改后");
        assertEquals(new Integer(department.getVersion()),new Integer(1));
    }

    @Test
    public void deleteTest() throws Exception{
        Integer id = 4;
        Department departmentToDelete = repository.findOne(id);
        assertNotNull(departmentToDelete);
        assertEquals(departmentToDelete.getName(),"测试删除");

        repository.delete(departmentToDelete);

        Department department = repository.findOne(id);
        assertNull(department);
    }
}
