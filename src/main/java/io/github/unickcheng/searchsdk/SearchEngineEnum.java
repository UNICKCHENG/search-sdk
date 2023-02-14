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

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Built-in configuration for common search engines
 * @author unickcheng
 * @since 2023-02-14
 */

@Getter
@AllArgsConstructor
public enum SearchEngineEnum {

    GOOGLE("https://www.google.com/search?q=%s"
            , "#search #rso > div"
            , "h3"
            ,"a[href^='http']"),
    BING("https://www.bing.com/search?q=%s"
            , "#b_results .b_algo"
            , "h2 > a"
            , "h2 > a"),
    BRAVE("https://search.brave.com/search?q=%s"
            , "#results > div"
            , "a > span"
            , "a");

    /**
     * 访问链接
     * <p>example : <a href="https://www.google.com">https://www.google.com</a>
     */
    private final String visitParameters;

    /**
     * 获取全部结果的 css 定位条件
     * <p>example: .b_algo
     * <p>ref: <a href="https://playwright.dev/java/docs/api/class-elementhandle#element-handle-query-selector-all">handle-query-selector-all</a>
     */
    private final String selectorAllParameters;

    /**
     * 获取标题的 css 定位条件
     * <p>example: h2 > a
     * <p>ref: <a href="https://playwright.dev/java/docs/api/class-elementhandle#element-handle-query-selector">handle-query-selector</a>
     */
    private final String selectorTitleParameters;

    /**
     * 获取链接的 css 定位条件
     * <p>example: h2 > a
     * <p>ref <a href="https://playwright.dev/java/docs/api/class-elementhandle#element-handle-query-selector">handle-query-selector</a>
     */
    private final String selectorHrefParameters;
}
