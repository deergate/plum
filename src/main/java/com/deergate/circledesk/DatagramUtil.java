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
 * TODO DatagramUtil说明
 *
 * @author Shang Yehua <niceshang@outlook.com>
 * @since 2022-07-29  09:20
 *
 */
@Component
public class DatagramUtil extends BaseClass {
    
    public Object parse8583(Object input){
        System.out.println("parsing 8583 ...");
        pause(7, 5);
        return new Object();
    }

    public Object make8583(Object response) {
        System.out.println("making 8583 ...");
        pause(7, 5);
        return new Object();
    }
}
