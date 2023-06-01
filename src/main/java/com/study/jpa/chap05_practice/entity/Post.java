package com.study.jpa.chap05_practice.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter @Getter
@ToString(exclude = {"hashTags"})
@EqualsAndHashCode(of={"id"})
@NoArgsConstructor
@AllArgsConstructor
@Builder @Entity
@Table(name="tbl_post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    @Column(name="post_no")
    private Long id;

    @Column(nullable = false) //not null
    private String writer; //작성자
    @Column(nullable = false)
    private String title; //제목
    private String content; //내용

    @CreationTimestamp //생성할 때 자동으로 시간 들어감
    @Column(updatable = false) //수정 불가
    private LocalDateTime createDate; //작성시간
    @UpdateTimestamp //수정할 때 자동으로 시간 들어감
    private LocalDateTime updateDate; //수정시간

    @OneToMany(mappedBy="post") //이걸 매핑하겠다
    @Builder.Default
    private List<HashTag> hashTags = new ArrayList<>();


    // 양방향 매핑에서 리스트쪽에 데이터를 추가하는 편의메서드 생성
    public void addHashTag(HashTag hashTag) {
        hashTags.add(hashTag);
        if (this != hashTag.getPost()) {
            hashTag.setPost(this);
        }
    }

}
