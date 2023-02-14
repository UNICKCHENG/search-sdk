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

import io.github.unickcheng.rhandler.annotation.RHandlerController;
import io.github.unickcheng.searchsdk.SearchEngineEnum;
import io.github.unickcheng.searchsdk.SearchEngineService;
import io.github.unickcheng.searchsdk.SearchResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * After running the demo, the web side visits localhost:8080/openapi-ui.html <br/>
 * demo 运行后, 网页端请访问 localhost:8080/openapi-ui.html
 * @author unickcheng
 * @since 2023-02-14
 */

@RHandlerController
public class SearchEngineController {
    @Resource
    private SearchEngineService searchEngineService;

    @Operation(description = "Google Search Api")
    @Parameters({
            @Parameter(name = "q", description = "Ask me a question...", required = true)
    })
    @GetMapping("google")
    public java.util.List<SearchResult> searchByGoogle (@RequestParam(value = "q") String content) {
        return searchEngineService.search(SearchEngineEnum.GOOGLE, content);
    }

    @Operation(description = "Bing Search Api")
    @Parameters({
            @Parameter(name = "q", description = "Ask me a question...", required = true)
    })
    @GetMapping("bing")
    public java.util.List<SearchResult> searchByBing (@RequestParam(value = "q") String content) {
        return searchEngineService.search(SearchEngineEnum.BING, content);
    }

    @Operation(description = "Brave Search Api")
    @Parameters({
            @Parameter(name = "q", description = "Ask me a question...", required = true)
    })
    @GetMapping("brave")
    public java.util.List<SearchResult> searchByBrave (@RequestParam(value = "q") String content) {
        return searchEngineService.search(SearchEngineEnum.BRAVE, content);
    }
}
