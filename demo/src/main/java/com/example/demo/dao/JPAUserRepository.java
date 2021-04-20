package com.example.demo.dao;


import com.example.demo.model.JPAUserDO;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface JPAUserRepository extends JpaRepository<JPAUserDO,Integer> {

    JPAUserDO findByUserName(String userName);

    @Transactional(timeout = 10)
    @Modifying
    @Query("update JPAUserDO set userName = ?1 where id = ?2")
    int modifyById(String  userName, Integer id);

    @Transactional
    @Modifying
    @Query("delete from JPAUserDO where id = ?1")
    void deleteById(Integer id);


    @Query("select u from JPAUserDO u")
    Page<JPAUserDO> findALL(Pageable pageable);




}
