package com.example.demo;

import com.example.demo.dao.JPAUserRepository;
import com.example.demo.model.JPAUserDO;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = {App.class})
public class JPA_repositoryTest {

    @Autowired
    JPAUserRepository jpaUserRepository;

    @Test
    public void before(){
        JPAUserDO userDO=new JPAUserDO();
        userDO.setId(1);
        userDO.setUserName("fishpro");
        userDO.setSex(1);
        userDO.setLastLoginTime(new Date());
        userDO.setPassword("passWord");
        jpaUserRepository.save(userDO);
    }


    @Test
    public void testFind(){
        Optional<JPAUserDO> optionalUserDO=jpaUserRepository.findById(1);
        if(optionalUserDO.isPresent()){
            JPAUserDO userDO=optionalUserDO.get();
            System.out.println("testFind user"+userDO.getUserName());
        }
    }

    @Test
    public void testFindAll(){
        List<JPAUserDO> list = jpaUserRepository.findAll();
        for(JPAUserDO userDO: list){
            System.out.printf("user:"+userDO);
        }
    }

    @Test
    public void modifyById(){

        System.out.printf("----"+jpaUserRepository.findByUserName("json"));
        jpaUserRepository.modifyById("tzz123", 2);


    }
}
