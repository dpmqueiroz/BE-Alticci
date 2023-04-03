package com.winprovit.alticcisequence.controller;

import com.winprovit.alticcisequence.model.ResponseDTO;
import com.winprovit.alticcisequence.service.AlticciSequenceService;
import com.winprovit.alticcisequence.service.CacheManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/alticci")
public class AlticiSequenceController {

    @Autowired
    AlticciSequenceService serviceAlticci;

    @Autowired
    CacheManagerService cacheService;

    @GetMapping("/{n}")
    public ResponseEntity<ResponseDTO> alticciSequence(@PathVariable Long n){
        long initTime = System.currentTimeMillis();
        if(serviceAlticci.parameterNotValid(n))
            return ResponseEntity.badRequest().build();
        ResponseDTO response = new ResponseDTO(n, serviceAlticci.getAlticciSequence(n).toString(),System.currentTimeMillis() - initTime);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/check-cache")
    public ResponseEntity<String> checkCache(){
        return ResponseEntity.ok( cacheService.checkCache());
    }


    @DeleteMapping("/clear-cache")
    @CacheEvict(value = "alticci", allEntries = true)
    public ResponseEntity<String> clearCache(){
        cacheService.clearCache();
        return ResponseEntity.ok().build();
    }
}
