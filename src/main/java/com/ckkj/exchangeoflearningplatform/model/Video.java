package com.ckkj.exchangeoflearningplatform.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;


/**
 * @author lxl
 * @Date 2019-06-16 18:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Video implements Serializable {
    private static final long serialVersionUID = -6957361951748382519L;

    private Integer id;
    private String videoName;
    private String titleId;
    private Date postTime;
    private String videoSize;
    private String videoType;
    private int score;
    private String videoPath;
}
