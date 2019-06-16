package com.ckkj.exchangeoflearningplatform.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;


/**
 * @author lxl
 * @Date 2019-06-16 18:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Video {

    private Integer id;
    private String vedioName;
    private String titleId;
    private LocalDate postTime;
    private String vedioSize;
    private String vedioType;
}
