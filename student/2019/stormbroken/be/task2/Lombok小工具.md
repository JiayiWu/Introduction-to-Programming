<!-- TOC -->

- [1. 遇见lombok](#1-遇见lombok)
    - [1.1. lombok简介](#11-lombok简介)
    - [1.2. 使用详情](#12-使用详情)
    - [1.3 官方文档](#13-官方文档)

<!-- /TOC -->
# 1. 遇见lombok
by stormbroken
## 1.1. lombok简介
1. 使用简单的注释的形式来帮助我们简化消除一些必须有但显得很臃肿的java代码工具
2. 如何安装使用：在dependency中添加`<artifactId>lombok</artifactedId>`

## 1.2. 使用详情
1. 我们需要引入相应的lombok包

标签名|意义|使用实例
--|--|--
`@NonNull`|避免空指针|`@NonNull Person person`
`@Cleanup`|自动帮我们调用close()方法来关闭流|`@Cleanup InputStream ...`
`@Getter`|注解在属性上，为我们自动生成Getter方法|`@Getter private int age;`
`@Setter`|注解在属性上，为我们自动生成Setter方法|`@Setter private int age;`
`@NoArgsConstructor`|注解在类上，自动生成无参数构造函数|-
`@AllArgsConstructor`|注解在类上，为我们生成全参数构造函数|-
`@Data`|注解在类上，提供所有属性的getting和setting方法，此外提供了equals、canEqual、hashCode、toString方法|-
`@Log4j`|注解在类上，为类提供一个属性名为log的log4j日志对象

## 1.3 官方文档
<a href = "https://projectlombok.org/features/all?spm=a2c4e.11153940.blogcont59972.9.2aeb6896aOg7si">查询更多标签</a>