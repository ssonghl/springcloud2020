package org.example.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: songhl
 * @date: 2020/5/4 18:16:44
 * @desc:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 流水号
     */
    private String serial;
}
