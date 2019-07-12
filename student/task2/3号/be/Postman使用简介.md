<!-- TOC -->

- [Postman](#postman)
    - [简介](#简介)
    - [GET请求](#get请求)
    - [POST请求](#post请求)
    - [Postman断言](#postman断言)
    - [Collections 管理用例](#collections-管理用例)
    - [设置环境变量](#设置环境变量)
    - [身份验证](#身份验证)
    - [Newman工具简介](#newman工具简介)

<!-- /TOC -->
# Postman
<a href ="https://testerhome.com/topics/15101">参考</a>

## 简介
By stormbroken
1. Postman是一款功能强大的网页调试与发送网页HTTP请求的工具。

## GET请求

1. 点击params,输入参数和相关的value，可以输入多个，及时显示在URL链接上，所以需要参考相关的请求头和请求参数(依据接口文档)
2. GET响应：参照右上角HTTP状态码和请求耗时
3. 响应正文的状态码，由程序员自己定义，用来区分正常数据与异常数据

## POST请求
1. 不同类的提交：Content-Type和请求参数格式不同
2. 大致分为表单提交、JSON提交、XML提交、二进制文件提交这几类
3. 还可以自行设置Content-Type

## Postman断言
1. 一个完整的接口测试：请求->获取相应正文->断言
2. 在相应的软件的Tests部分
3. `tests[name] = `:名为什么的断言
4. 详见网页

## Collections 管理用例
1. 将多个接口请求放在一起，并且将他们管理起来。
    + 一般是一个工程一个Collection，这样方便查找及统一处理数据
2. 过程：
    1. 创建Collections：+号，输入name和description
    2. 在Collections中添加请求，准备好接口请求的所有数据并经过验证后，点击save保存
    3. 进一步细化：在Collection中建立Folder，右击建立
    4. 运行Collection：直接run，运行所有的相关的接口
3. 几个名词：
    + Environment：运行环境，提前配置
    + Iterations:重复运行次数
    + Delay：间隔时间
    + Data：外部数据加载，即用例的参数化，可以和Iterations相结合
    + Run demo：运行完成后，生成一个简易的聚合报告
4. Collection运行参数化：
    + 使用条件：在重复运行过程中，我们希望某个用例每次运行时使用不同的数据，那么需要满足两个条件：
        1. 脚本中要用到的数据的地方参数化，也就是用一个变量来代替，每次运行时，重新获取当前的运行数据
        2. 需要一个数据池，这个数据池里的数据条数，要和重复运行的次数相同

## 设置环境变量
1. 在齿轮的地方设置保存相应的环境
2. 保存后在运行的时候，选择相应的环境就行了

## 身份验证
1. 开启简单的身份验证

## Newman工具简介
1. 是一个命令行运行postman请求的工具