package com.study.jpa.chap05_practice.dto;

import lombok.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

@Getter @Setter
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class PageDTO {

    private int page;
    private int size;

    public PageDTO(){
        this.page=1;
        this.size=10;
    }

}
