# MusicPro
项目架构：
* Spring boot
* thymeleaf
* mybatis



总结：
* 在使用```th:fragment=""```引入js文件时，我们无法像引入css那样替换整个head，因为大家习惯将js文件放在body的最底部，这时我们可以将js的引入放到一个文本文件中，通过```th:replace=""```直接引入这个文件即可,为了方便，项目暂时在头文件中引入所有的css和js。
