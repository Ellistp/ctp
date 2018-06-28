package com.ctp.ghub.junit;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/5/21 0021.
 */
@Transactional(rollbackFor = Exception.class)
@ActiveProfiles("dev")
public class BaseSpringJunitTest {
}
