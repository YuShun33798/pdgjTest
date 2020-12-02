package com.pdgj.manager.domain.userEntity;

import com.pdgj.manager.controller.basic.BasicEntity;
import lombok.Data;

/**
 * @Author fgs
 * @Date 2020/12/2 8:51
 * @Version 1.0
 * @Description
 **/
@Data
public class UserEntity extends BasicEntity {
    private String id;
    private String name;
}
