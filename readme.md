# Hi, there 👋

`search-sdk` 是一款为 spring 开发者集成的插件，您可以使用它来从指定的搜索引擎中获取结果。

**v0.0.1 版本功能比较单一，只能获取指定搜索引擎的至多 10 条搜索结果。**

## ✨ 特征

- [x] 基于 Playwright 模拟从 Brave、Google、Bing 获取搜索结果
- [ ] 支持自定义获取搜索结果的数量、分页、导出
- [ ] 集成 Bing API、Google API
- [ ] 支持 自定义 Brave Goggles 搜索权重
- [ ] 支持 DuckDuckgo 等更多的搜索引擎

## 🎉 使用

### 步骤 1: 增加依赖

```pom.xml
<dependency>
    <groupId>io.github.unickcheng</groupId>
    <artifactId>search-sdk</artifactId>
    <version>0.0.1</version>
</dependency>
```
> 注意当前还未提交到 Maven 中央仓库，因此您需要额外地添加下述镜像地址在您的 pom.xml 中
```
<repositories>
    <repository>
        <id>unickcheng</id>
        <url>https://unickcheng.github.io/maven-packages/</url>
    </repository>
</repositories>
```

### 步骤2：创建 Bean

```java
@Bean
public SearchEngineService searchEngineService () {
	return new SearchEngineService();
}
```

>? 如果您不知道如何开始使用，您可以参考 [spring-boot-demo](https://github.com/UNICKCHENG/search-sdk/tree/main/spring-boot-demo)

### 如果您是前端人员

您可以直接使用 [Playwright](https://www.npmjs.com/package/playwright) 官方提供的依赖，当然，您也可使用 [spring-boot-demo](https://github.com/UNICKCHENG/search-sdk/tree/main/spring-boot-demo) 作为现成的后端接口来使用。

在启动后端项目之前，您需要确保已经配置好 `java 11` 和 `Maven 3.0+`。然后您需要到 spring-boot-demo 的目录下执行下述命令来运行项目。当然您也可以使用内存大户 IDEA。
```bash
# 下载所需依赖
mvn install
# 启动 spring boot 项目
mvn spring-boot:run
```


## 为什么要创建这个项目

去年 Brave 推出了 [Brave Goggles](https://search.brave.com/help/goggles)，这使得用户可以根据自己的需求来自定义搜索权重。打个比方，如果您是一名学术工作者，您可以为 Wikipedia、Google Scholar、connectedpapers 等网站增加相应的权重，这样将使得和这些网站相关的搜索结果更加靠前。

于是，我开始尝试能不能将它集成到 wechat 中去，像 telegram、discord 那样通过斜杆命令，直接获取相应的搜索结果。遗憾的是，Brave 官方似乎并没有像 Google 和 Bing 一样提供 API，虽然有 [SerpApi](https://serpapi.com/) 这类第三方接口，但是对于个人开发者来说并不太友善。

既然如此，那只能造个轮子呗~

## 💖 感谢

- https://playwright.dev/
- [Spring Boot](https://spring.io/projects/spring-boot) provides framework support
- [Open Source Dependencies](https://github.com/UNICKCHENG/search-sdk/network/dependencies) provides support
- Thanks to all open source projects for sharing ideas and techniques
