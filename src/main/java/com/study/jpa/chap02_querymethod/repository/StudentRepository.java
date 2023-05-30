package com.study.jpa.chap02_querymethod.repository;

import com.study.jpa.chap02_querymethod.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,String> {
    
    //메서드 이름으로 작동
    //?에 들어갈 걸 매개변수로 작성
    //케멀케이스, Name이거는 entity클래스의 필드명 작성해야 함 -> Student 클래스에 name으로 되어 있으므로
    List<Student> findByName(String name);

    List<Student> findByCityAndMajor(String city, String major);

    //like %~~% 쿼리문
    List<Student> findByMajorContaining(String major);

    //네이티브 쿼리 사용 가능
    @Query(value = "SELECT * FROM tbl_student WHERE stu_name= :nm", nativeQuery = true)
    Student findNameWithSQL(@Param("nm")String name);

    //JPQL
    //select 별칭 from 엔터티클래스명 as 별칭
    //where 별칭.필드명=?

    //native-sql : SELECT * FROM tbl_student WHERE stu_name = ?
    //jpql : SELEC st FROM Student AS st WHERE st.name = ?

    //도시 이름으로 학생 조회
//    @Query(value = "SELECT * FROM tbl_student WHERE city = ?1", nativeQuery = true) //?1 : 첫번째 파라미터에 자동으로 매치됨
    @Query("SELECT s FROM Student s WHERE s.city = ?1") //이게 jpql -> join문이 엄청 짧아짐
    Student getByCityWithJPQL(String city);

    @Query("SELECT st FROM Student st WHERE st.name LIKE %:nm%") //?1 이것보다는 %:nm% 이렇게 쓰는게 더 실무에서는 더 좋은 방법
    List<Student> searchNyNameWithJPQL(@Param("nm") String name);

    //JPQL로 수정 삭제 쿼리 쓰기
    @Modifying //조회가 아닐 경우 무조건 붙여야 함
    @Query("DELETE FROM Student s WHERE s.name = ?1")
    void deleteByNameWithJPQL(String name);

    
}
