package com.yupi.project.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ChuYang
 * @version 1.0
 */

@Data
public class IdRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}
