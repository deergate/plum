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

import org.springframework.stereotype.Component;

/**
 *
 * TODO EsscService说明
 *
 * @author Shang Yehua <niceshang@outlook.com>
 * @since 2022-07-29  09:41
 *
 */
@Component
public class EsscService extends BaseClass {
    
    public boolean checkMac(Object data){
        System.out.println("checking mac ...");
        pause(3, 2);
        return true;
    }

    public Object transPIN(Object data) {
        System.out.println("transing pin ...");
        pause(3, 2);
        return new Object();
    }

    public Object transNewPIN(Object data) {
        System.out.println("transing new pin ...");
        pause(3, 2);
        return new Object();
    }

    public Object createMac(Object data) {
        System.out.println("creating mac ...");
        pause(3, 2);
        return new Object();
    }
}
