package com.qjkobe.test;

import com.qjkobe.db.model.Pager;
import com.qjkobe.db.model.PagerImpl;
import com.qjkobe.db.model.test.TTest;
import com.qjkobe.services.test.TestService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2016/8/25.
 */
public class JunitTest {

    /**
     * 测试支付管理公对公银行disBankService，测试通过 2016/8/5
     */
    @Test
    public void testBankPay() {
        String[] paths = new String[] { "spring/applicationContext-bo.xml" };
        ApplicationContext ctx = new ClassPathXmlApplicationContext(paths);

        TestService testService = (TestService) ctx.getBean("testService");

        TTest tTest = new TTest();
        tTest.setName("");
        List<TTest> list = testService.getTestListByParam(tTest, null, null);
        tTest = testService.getTestById("12");
        System.out.println(list.size());
    }
}
