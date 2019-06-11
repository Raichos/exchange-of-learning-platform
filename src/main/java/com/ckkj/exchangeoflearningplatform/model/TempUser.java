package com.ckkj.exchangeoflearningplatform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author lzh
 * create 2019-06-04-10:23
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class TempUser {
    private Integer id;
    private String userName;
    private String password;
    private String Rid;
}
