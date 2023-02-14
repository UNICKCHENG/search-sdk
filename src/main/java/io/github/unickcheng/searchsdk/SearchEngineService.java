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

package io.github.unickcheng.searchsdk;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.Proxy;
import io.github.unickcheng.rhandler.exception.RHandlerException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author unickcheng
 * @since 2023-02-14
 */
@Slf4j
@Getter
@SuppressWarnings("unused")
public class SearchEngineService {

    private final Playwright playwright;
    private final Browser browser;

    public SearchEngineService() {
        try {
            this.playwright = Playwright.create();
            this.browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
            );
        } catch (Exception e) {
            throw new RHandlerException("Failed initializing SearchEngineService");
        }
    }
    public SearchEngineService (Proxy proxy) {
        try {
            this.playwright = Playwright.create();
            this.browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setProxy(proxy)
            );
        } catch (Exception e) {
            throw new RHandlerException("Failed initializing SearchEngineService");
        }
    }
    public SearchEngineService (Playwright playwright, Browser browser) {
        this.playwright = playwright;
        this.browser = browser;
    }

    @PostConstruct
    public void postConstruct () {
        log.info("Hi, there! SearchEngineService has been initialized successfully.");
    }

    /**
     * Specify a search engine for your query <br/>
     * 使用 playwright 模拟页面操作获取查询结果, 并将结果集进行处理返回 <br/>
     * TODO 当前最多返回 10 条数据集, 且不支持限制数据操作
     * @param searchEngineEnum 搜索引擎
     * @param content 搜索文本
     * @return 查询结果列表
     */
    public List<SearchResult> search (SearchEngineEnum searchEngineEnum, String content) {
        try {
            List<SearchResult> data = new ArrayList<>();
            Page page = this.browser.newPage();

            page.navigate(
                    String.format(
                            searchEngineEnum.getVisitParameters(),
                            content.trim().replaceAll(" ", "+")
                    )
            );
            List<ElementHandle> re = page.querySelectorAll(searchEngineEnum.getSelectorAllParameters());
            for (int i = 0, cnt = 0, len = re.size(); i < len && cnt < 10; ++i) {
                try {
                    String title = re.get(i).querySelector(searchEngineEnum.getSelectorTitleParameters()).textContent().replaceAll("\\n", "").trim();
                    String url = re.get(i).querySelector(searchEngineEnum.getSelectorHrefParameters()).getAttribute("href");
                    data.add(SearchResult.builder().id(++cnt).title(title).url(url).build());
                } catch (Exception ignored) {
                }
            }
            page.close();
            return data;
        } catch (Exception ex) {
            throw new RHandlerException("Failed to search.");
        }
    }
}

