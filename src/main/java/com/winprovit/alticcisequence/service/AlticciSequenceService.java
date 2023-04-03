package com.winprovit.alticcisequence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class AlticciSequenceService {

    @Autowired
    CacheManagerService cacheManager;

    @Cacheable(value = "alticci")
    public BigInteger getAlticciSequence(Long n) {
        BigInteger result = processSequence(n);
        return result;
    }

    private BigInteger processSequence(Long n) {
        BigInteger result = cacheManager.get(n);
        if(result == null) {
            result = processSequence(n - 3).add(processSequence(n - 2));
            cacheManager.save(n, result);
        }
        return result;
    }

    public boolean parameterNotValid(Long n) {
        if(n < 0 || n > 99999)
            return true;
        return false;
    }
}
