package com.test.platform.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TestStaticsResDTO {
    private List<String> taskName=new ArrayList<>();

    private List<Integer> successCount=new ArrayList<>();

    private List<Integer> failCount=new ArrayList<>();
}
