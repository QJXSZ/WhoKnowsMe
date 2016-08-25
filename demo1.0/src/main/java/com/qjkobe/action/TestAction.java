package com.qjkobe.action;

import com.alibaba.fastjson.JSONObject;
import com.qjkobe.db.model.test.TTest;
import com.qjkobe.services.test.TestService;
import com.qjkobe.utils.Const;
import com.qjkobe.utils.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2016/8/25.
 */
@Controller
@RequestMapping(value = "test")
public class TestAction {

    @Autowired
    TestService testService;

    @RequestMapping(value = "test")
    public String test(Model model){
        TTest tTest = new TTest();
        List<TTest> list1 = testService.getTestListByParam(tTest, null, null);
        if(list1.size() == 0){
            tTest.setId(UUID.getID());
            tTest.setName("jinyu");
            tTest.setAge(18);
            tTest.setIsdelete(0);
            testService.addTest(tTest);
        }
        List<TTest> list2 = testService.getTestListByParam(tTest, null, null);
        model.addAttribute("test", list2.get(0));
        return "test/test";
    }

    @RequestMapping(value = "getage", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getAge(TTest test){
        JSONObject jsonObject = new JSONObject();
        List<TTest> list1 = testService.getTestListByParam(test, null, null);
        int age = list1.get(0).getAge();
        jsonObject.put("status", Const.STATUS_SUCCESS);
        jsonObject.put("age", age);
        return jsonObject.toString();
    }
}
