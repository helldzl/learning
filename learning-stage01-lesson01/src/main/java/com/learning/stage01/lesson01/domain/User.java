package com.learning.stage01.lesson01.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created at 2021/1/26
 *
 * @author quzile3
 * @version 0.0.1-SNAPSHOT
 * @since 0.0.1-SNAPSHOT
 */
@Getter
@Setter
@ToString
public class User implements Serializable {

    private static final long serialVersionUID = 8203348769993646121L;

    private Long id;

    private String username;

}
