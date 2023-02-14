/*
 * Copyright 2002-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package cc.unickcheng.demo;

import io.github.unickcheng.searchsdk.SearchEngineService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author unickcheng
 * @since 2023-02-14
 */

@Configuration
public class SearchEngineConfig {

    // 默认方式
    @Bean
    public SearchEngineService searchEngineService () {
        return new SearchEngineService();
    }

    // 自定义代理方式
//    @Bean
//    public SearchEngineService searchEngineService () {
//        return new SearchEngineService(new Proxy("http://127.0.0.1:9999"));
//    }
//
    // 自定义初始化方式
//    @Bean
//    public SearchEngineService searchEngineService () {
//        try {
//            Playwright playwright = Playwright.create();
//            Browser browser = playwright.chromium().launch(
//                    new BrowserType.LaunchOptions()
//            );
//            return new SearchEngineService(playwright, browser);
//        } catch (Exception e) {
//            throw new RHandlerException("Failed initializing SearchEngineService");
//        }
//    }
}
