package com.example.bai_2.service.impl;

import com.example.bai_2.repository.ISimpleDictionaryRepository;
import com.example.bai_2.service.ISimpleDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SimpleDictionaryService implements ISimpleDictionaryService {
    @Autowired
    private ISimpleDictionaryRepository simpleDictionaryRepository;

    @Override
    public String getResultSearch(String inputSearch) {
        Map<String,String> mapDictionary = simpleDictionaryRepository.getMapDictionary();
        String result="";
        for (String key: mapDictionary.keySet()) {
            if (inputSearch.equals(key)){
                result=mapDictionary.get(key);
                break;
            }else {
                result="Không tìm thấy";
            }
        }
        return result;
    }
}
