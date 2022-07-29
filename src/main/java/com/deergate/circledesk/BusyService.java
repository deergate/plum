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

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * TODO BusyService说明
 *
 * @author Shang Yehua <niceshang@outlook.com>
 * @since 2022-07-29  09:18
 *
 */
@Component
public class BusyService {
    
    Random random = new Random();
    
    @Autowired
    DatagramUtil datagramUtil;
    
    @Autowired
    CacheUtil cacheUtil;
    
    @Autowired
    EsscService esscService;
    
    @Autowired
    Transporter transporter;
    
    public Object onlineTransaction(Object input){
        System.out.println("start transaction ...");
        //解析报文
        var data = datagramUtil.parse8583(input);
        //获取缓存
        var cache = cacheUtil.getCache();
        //校验卡bin及域
        checkData(data,cache);
        
        //校验MAC
        esscService.checkMac(data);
        
        //转PIN
        if(hasPIN()){
            data = esscService.transPIN(data);
        }
        //转 New PIN
        if(hasNewPIN()){
            data = esscService.transNewPIN(data);
        }
        
        //生成MAC
        data = esscService.createMac(data);
        
        //发送到核心系统
        var response = transporter.transport(data);
        
        //将核心系统结果转成8583
        var result = datagramUtil.make8583(response);
        
        System.out.println("transaction complete.");
        
        //返回给上游系统(总行/卡组)
        return result;
    }

    private boolean hasNewPIN() {
        return random.nextInt(10)<2;
    }

    private boolean hasPIN() {
        return random.nextInt(10)<3;
    }

    private void checkData(Object data, Object cache) {
        //just pass
    }
}
