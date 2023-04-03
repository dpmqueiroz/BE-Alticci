package com.winprovit.alticcisequence.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigInteger;

@Data
@AllArgsConstructor
public class ResponseDTO {

    private Long n;
    private String result;
    private Long timeMs;
}
