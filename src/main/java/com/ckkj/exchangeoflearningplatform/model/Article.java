package com.ckkj.exchangeoflearningplatform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author lzh
 * create 2019-06-15-21:03
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Article {

    private Integer id;
    private String userArticle;
    private String title;
    private String articlePath;
    private Date announce;
    private String brief; //简介
}
