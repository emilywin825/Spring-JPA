package com.study.jpa.chap01_basic.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter @Getter
@ToString @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder @Entity
@Table(name="tbl_product") // 테이블 이름 tbl_product로 생성됨. 이거 안쓰면 클래스 이름으로 생성됨
public class Product {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY) //auto increment
    @Column(name="prod_id")
    private long id;
    //nullable = false : notnull 제약조건, unique = true : unique 제약 조건, length = 30 : varchar(30)으로 변경
    @Column(name="prod_name",nullable = false, unique = true, length = 30)
    private String name;

    @Builder.Default
    private int price=0; //default값 0
    @Enumerated(EnumType.STRING) //enum 타입은 이 아노테이션 붙여주기
    private Category category;
    @CreationTimestamp
    @Column(updatable = false) //수정 불가
    private LocalDateTime createDate;
    @UpdateTimestamp //update문 돌아갈 때 자동으로 시간 저장
    private LocalDateTime updateDate;

    public enum Category{
        FOOD,FASHION,ELECTRONIC
    }

}
