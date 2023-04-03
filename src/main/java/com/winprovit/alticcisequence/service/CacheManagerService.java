package com.winprovit.alticcisequence.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CacheManagerService {
    final Map<Long, BigInteger> cache = new HashMap<>();

    public void save(Long index, BigInteger value) {
        cache.put(index, value);
    }

    public BigInteger get(Long index) {
        return cache.get(
                Optional.ofNullable(index)
                        .orElseThrow(() -> new InvalidParameterException("Cannot retrieve index of null"))
        );
    }

    public void clearCache() {
        cache.clear();
        initDefaultValues();
    }

    public String checkCache() {
        return cache.entrySet().stream()
                .map(val -> "[ n(" + val.getKey() + ") = " + val.getValue() + " ]")
                .collect(Collectors.joining("\n"));
    }

    @PostConstruct
    void initValues() {
        initDefaultValues();
    }

    private void initDefaultValues(){
        cache.put(0L, BigInteger.valueOf(0));
        cache.put(1L, BigInteger.valueOf(1));
        cache.put(2L, BigInteger.valueOf(1));
    }
}
