package com.study.jpa.chap02_querymethod.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
@Setter //실무적 측면에서 setter는 신중히 만들것! 지금은 test할 때 빨리 불러다 쓸려고 사용하지 실무에서는 신중히
@Getter
@ToString
@EqualsAndHashCode(of="id") //id만 비교해서 id만 같으면 서로 같으걸로 판단함
@NoArgsConstructor
@AllArgsConstructor
@Builder @Entity
@Table(name="tbl_student")
public class Student {
    @Id
    @Column(name="stu_id")
    //실무에서는 이렇게 랜덤값으로 pk를 설정하는 경우가 더 많음->2c9e81e1886a7f2e01886a7f33fe0000이런식으로 나옴
    @GeneratedValue(generator = "uid") //@GenericGenerator의 name과 같이 매핑
    @GenericGenerator(strategy = "uuid", name="uid")
    private String id;

    @Column(name = "stu_name", nullable = false)
    private String name;

    private String city;
    private String major;


}
