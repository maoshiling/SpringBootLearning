package cn.edu.hust.maoshiling.repository;

import cn.edu.hust.maoshiling.ApplicationTest;
import cn.edu.hust.maoshiling.entity.Category;
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
public class CategoryRepositoryTests {

    @Autowired
    private CategoryRepository repository;

    @Test
    @Transactional
    public void findOneTest() throws Exception{
        Integer id = 1;
        Category category = repository.findOne(id);
        assertNotNull(category);
        assertEquals(category.getId(),new Integer(1));
        assertEquals(category.getName(),"系统管理");
        assertTrue(category.getFunctions().size()>=1);
    }

    @Test
    public void findAllTest() throws Exception{
        List<Category> categories = repository.findAll();
        assertNotNull(categories);
        assertTrue(categories.size()>=4);
    }

    @Test
    public void addTest() throws Exception{

        Category categoryToAdd= Category.builder()
                .name("testAdd")
                .build();

        Category category = repository.save(categoryToAdd);
        assertNotNull(category);
        assertEquals(category.getId(),new Integer(7));
        assertEquals(category.getName(),"testAdd");
        assertEquals(category.getCreatedBy(),"admin");
        assertNotNull(category.getCreatedAt());
        assertEquals(category.getModifiedBy(),"admin");
        assertNotNull(category.getModifiedAt());
        assertEquals(new Integer(category.getVersion()),new Integer(0));
    }

    @Test
    public void modifyTest() throws Exception{
        Integer id = 5;
        Category categoryToModify = repository.findOne(id);
        assertNotNull(categoryToModify);
        assertEquals(categoryToModify.getName(),"测试修改");

        categoryToModify.setName("修改后");

        Category category = repository.save(categoryToModify);
        assertNotNull(category);
        assertEquals(category.getName(),"修改后");
        assertEquals(new Integer(category.getVersion()),new Integer(1));
    }

    @Test
    public void deleteTest() throws Exception{
        Integer id = 6;
        Category categoryToDelete = repository.findOne(id);
        assertNotNull(categoryToDelete);
        assertEquals(categoryToDelete.getName(),"测试删除");

        repository.delete(categoryToDelete);

        Category category = repository.findOne(id);
        assertNull(category);
    }
}
