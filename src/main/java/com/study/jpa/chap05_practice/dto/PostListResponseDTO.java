package com.study.jpa.chap05_practice.dto;

import lombok.*;

import java.util.List;

@Setter @Getter
@ToString @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostListResponseDTO {

    private int count; //총게시물 수
    private PageResponseDTO pageInfo; //페이지 렌더링 정보

    //jsp랑 entity의 스팩이랑 완전히 똑같아도 사용 x. 그냥 dto 다시 만들어서 사용하기!
    private List<PostDetailResponseDTO> posts;//게시물 렌더링 정보

}
