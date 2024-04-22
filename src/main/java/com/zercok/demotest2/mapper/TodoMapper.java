package com.zercok.demotest2.mapper;

import com.zercok.demotest2.domain.TodoVO;

//todo Mybatis를 위한 인터페이스
public interface TodoMapper {
    String getTime();
    void insert(TodoVO todoVO);

}
