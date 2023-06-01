package com.study.jpa.chap04_relation.repository;

import com.study.jpa.chap04_relation.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    //n+1문제 이렇게 해결
    @Query("SELECT DISTINCT d FROM Department d JOIN FETCH d.employees") //Department : 테이블 이름 아니고 엔터티 클래스명
    List<Department> findAllIncludeEmployees();
}
