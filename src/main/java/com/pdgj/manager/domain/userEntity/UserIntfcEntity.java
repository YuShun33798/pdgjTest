package com.pdgj.manager.domain.userEntity;

import com.pdgj.manager.controller.basic.BasicEntity;
import lombok.Data;

import java.util.List;

/**
 * @Author fgs
 * @Date 2020/12/2 8:51
 * @Version 1.0
 * @Description
 **/
@Data
public class UserIntfcEntity extends BasicEntity {
    private String id;
    private String userId;
    private String intfcId;
    private List<String> intfcIds;
}
