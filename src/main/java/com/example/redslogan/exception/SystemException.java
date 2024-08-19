package com.example.redslogan.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemException extends RuntimeException{

    private String msg;
    private Integer num;

}
