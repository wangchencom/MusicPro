# MusicPro
项目架构：
* Spring boot
* thymeleaf
* mybatis



一些小问题：
* 在使用```th:fragment=""```引入js文件时，我们无法像引入css那样替换整个head，因为大家习惯将js文件放在body的最底部，这时我们可以将js的引入放到一个文本文件中，通过```th:replace=""```直接引入这个文件即可,为了方便，项目暂时在头文件中引入所有的css和js。
* 使用thymeleaf后端程序员可以动态替换掉静态html的内容，不会破坏原有的html，方便前段后端协同开发，但是为了代码重用，我们利用```th:fragment=""```和```th:replace=""```，可以实现页面部分组件重用，但是却破坏了html文件的完整性，破坏了thymeleaf的部分特性。



小技巧：
```@Configuration
   public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
   
       //通过重写addResourceHandlers方法来自定义外部资源映射
       @Override
       public void addResourceHandlers(ResourceHandlerRegistry registry) {
           registry.addResourceHandler("/upload/**").addResourceLocations("file:E:/upload/");
           super.addResourceHandlers(registry);
       }
   }```
