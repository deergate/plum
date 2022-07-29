/* 
 * Copyright 2022 Shang Yehua <niceshang@outlook.com>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.deergate.circledesk;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * TODO DemoController说明
 *
 * @author Shang Yehua <niceshang@outlook.com>
 * @since 2022-07-29  09:17
 *
 */
@RestController
public class DemoController {

    @Autowired
    BusyService busyService;

    @GetMapping("/some/specified/path")
    public Object doSomeWork(@RequestParam(required = false, defaultValue = "20") int loop) {
        var details = new HashMap<String, Object>();
        var expenseList = new ArrayList<Long>();

        for (int i = 0; i < loop; i++) {
            var data = new Object();
            long start = System.currentTimeMillis();
            baseExp();
            busyService.onlineTransaction(data);
            long end = System.currentTimeMillis();
            expenseList.add((end - start));
        }

        var max = expenseList.stream().max(Comparator.naturalOrder()).get();
        var min = expenseList.stream().min(Comparator.naturalOrder()).get();
        long total = expenseList.stream().reduce(0L, (acc,element)->acc+element);
        double avg = ((double)total)/expenseList.size();
        
        //summary
        details.put("Min", min);
        details.put("Max", max);
        details.put("Avg", avg);
        details.put("Tps", (int)(1000/avg*200));
        return details;
    }
    
    private void baseExp() {
        //基础损耗，包括接入层到核心路由间服务调用
        //数据处理、http处理、MQ消息处理等
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
