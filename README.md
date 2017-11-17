# MusicPro
项目架构：
* Spring boot
* thymeleaf
* mybatis
* logback



一些小问题：
* 在使用```th:fragment=""```引入js文件时，我们无法像引入css那样替换整个head，因为大家习惯将js文件放在body的最底部，这时我们可以将js的引入放到一个文本文件中，通过```th:replace=""```直接引入这个文件即可,为了方便，项目暂时在头文件中引入所有的css和js。
* 使用thymeleaf后端程序员可以动态替换掉静态html的内容，不会破坏原有的html，方便前段后端协同开发，但是为了代码重用，我们利用```th:fragment=""```和```th:replace=""```，可以实现页面部分组件重用，但是却破坏了html文件的完整性，破坏了thymeleaf的部分特性。
* 音乐播放网站要实现切换页面歌曲会继续播放，参考网易云，例如：#/playlist?id=xxx，据说是采用的是一种 SPA 的技术，即单页面应用，地址没变，变的是是#后面的hash，（QQ音乐？hashbang？主要的技术hashchange, history.pushState？）
* 暂时的一种思路：使用iframe可以实现，但是url一直不变，显然不现实。我们可以通过```window.history.pushState({},0,url);```来实现无刷新修改url，```/#/```后面接上相应的url，保证页面不会刷新，本项目不解析url。
* 对于歌曲这一块我就不细分了，采用歌手 - 歌曲名.mp3这种形式作为测试，搜索也直接```%歌手```,这里就不做处理了。
* 使用iframe需要注意的是父窗口与子窗口相互调用，```<iframe name="myFrame" src="child.html"></iframe> ``` 父窗口调用子窗口:```<iframe name="myFrame" src="child.html"></iframe> ``` 子窗品调用父窗口: ```<iframe name="myFrame" src="child.html"></iframe> ```
* thymeleaf中调用js方法直接用```th:onclick="'putEvaluate(1,2,3);'"```，如果有参数可以用,如有参数就直接 ```th:onclick="'putEvaluate('+${musicInfo.mid}+',2,3);'"``` 在''中拼接好就行。
*  Mybatis给我们提供了一种映射方式，如果属性的命名是遵从驼峰命名法的，数据列名遵从下划线命名。MyBatis支持使用注解来配置映射语句。为了代码复用，我们可以通过id引用这个resultMap
```
@Results(id = "myMap", value = {
            @Result(column = "id", property = "id", javaType = Integer.class),
            @Result(column = "name", property = "name", javaType = String.class),
            @Result(column = "password", property = "password", javaType = String.class) })
  
....

@ResultMap("myMap")
```



小技巧：
* 自定义外部资源映射
```
   @Configuration
   public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
   
       //通过重写addResourceHandlers方法来自定义外部资源映射
       @Override
       public void addResourceHandlers(ResourceHandlerRegistry registry) {
           registry.addResourceHandler("/upload/**").addResourceLocations("file:E:/upload/");
           super.addResourceHandlers(registry);
       }
   }
```
