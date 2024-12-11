package com.example.AlticeLabsExercise.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LabSeqService {



    @Cacheable(value = "lab",key = "#n")
    public List<Integer> generateLabseq(int n) {
        List<Integer> values = new ArrayList<>(n + 1);
        switch (n) {

            case 0:
                values.add(0);
                break;
            case 1:
                values.add(0);
                values.add(1);
                break;
            case 2:
                values.add(0);
                values.add(1);
                values.add(0);
                break;
            case 3:
                values.add(0);
                values.add(1);
                values.add(0);
                values.add(1);
                break;
            default:
                values.add(0);
                values.add(1);
                values.add(0);
                values.add(1);
                for (int i = 4; i <= n; i++) {
                    values.add(values.get(i - 4) + values.get(i - 3));
                }
                break;
        }
        return values;
    }

}