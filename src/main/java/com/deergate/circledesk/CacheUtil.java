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
 * TODO CacheUtil说明
 *
 * @author Shang Yehua <niceshang@outlook.com>
 * @since 2022-07-29  09:25
 *
 */
@Component
public class CacheUtil extends BaseClass {
    
    public Object getCache(){
        System.out.println("getting cache ...");
        // pause(0, 12);
        return new Object();
    }
}
