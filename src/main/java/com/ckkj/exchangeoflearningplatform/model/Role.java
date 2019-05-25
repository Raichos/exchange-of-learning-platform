package com.ckkj.exchangeoflearningplatform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author lzh
 * create 2019-05-23-20:15
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Role {

    private Integer id;
    private String name;
}
