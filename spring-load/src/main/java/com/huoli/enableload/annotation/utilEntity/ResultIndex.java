package com.huoli.enableload.annotation.utilEntity;

import lombok.Data;

import java.util.List;

@Data
//@Builder
//@EqualsAndHashCode
//@NoArgsConstructor
public class ResultIndex {

    private String interfaces;
//    @Singular
    private List<String> impl;
}
