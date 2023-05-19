package com.example.bai_2.repository.impl;

import com.example.bai_2.repository.ISimpleDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class SimpleDictionaryRepositoryImpl implements ISimpleDictionaryRepository {
    private static Map<String,String> dictionaryRepository =new HashMap<>();
    static {
        dictionaryRepository.put("hello","Xin chào");
        dictionaryRepository.put("dictionary","Từ điển");
        dictionaryRepository.put("search","Tìm kiếm");
        dictionaryRepository.put("simple","Đơn giản");
        dictionaryRepository.put("result","Kết quả");
    }

    @Override
    public Map<String, String> getMapDictionary() {
        Map<String,String>stringMap=dictionaryRepository;
        return stringMap;
    }
}
