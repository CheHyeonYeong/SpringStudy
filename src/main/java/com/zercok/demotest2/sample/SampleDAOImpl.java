package com.zercok.demotest2.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository //실제로 불러오는 객체
//@Qualifier("normal")
public class SampleDAOImpl implements SampleDAO {

}
