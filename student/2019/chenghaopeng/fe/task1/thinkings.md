1. compare the concept 'class' between JavaScript and Java.

    Java中的类是真的类，不是对象，不能动态添加/移除属性。Java面向对象。

    JS中的类本质上是函数，是对象，可以动态添加/移除属性。JS基于对象。

2. in current index.html file, why we put type="module" and defer in script element? What is ESModule?

    type="module"表明这是一个ES6模块。defer告知浏览器先渲染完页面再执行脚本。

    ESModule在我理解就是能够独立地处理一些变量和时间的模块，能够将代码分割成更小的独立的块，以方便js开发。

3. what is model-view-controller (MVC)? How we benefit from it?

    把软件系统分成了模型、视图、控制器三个部分，通常分别负责存取数据、数据显示、人机交互的功能。

    各自相对独立又相互依赖，可以便于分工，并且当其中一部分需要修改时最大限度保证另一些部分仍不需要修改就可以使用。使代码结构逻辑化、清晰化，便于维护。

4. make those concepts clear in your mind: box-sizing, display, flex, padding, margin

    - box-sizing: 盒子模型计算大小的方法。边框和填充不算入content-box的长宽，算入border-box的长宽
    - display：元素的呈现类型
        - none 不显示
        - block 块级元素
        - inline 内联元素
        - inline-block 行内块元素
        - table 块级表格
        - inline-table 内联表格
        - inherit 从父元素继承
    - flex：弹性布局
        - flex-grow 扩展量
        - flex-shrink 收缩量
        - flex-basis 初始长度
        - flex-direction 项目排列的方向
        - flex-wrap 项目拆分的方式
        - flex-flow: direction + wrap
    - padding：内边距
    - margin：外边距

5. compare those css rules in the same array by there priority, suppose all of them are defined in one .css file:[div, #id, .class], [#id, html > #id, html > #id:hover], [html #id, html > #id]

    - [div, #id, .class]
        - #id
        - .class
        - div
    - [#id, html > #id, html > #id:hover]
        - html > #id:hover
        - html > #id
        - #id
    - [html #id, html > #id]
        - html > #id
        - html #id

6. find one bug in #TodoList which will occur when Todo Items' size is large enough to scroll. Figure out why this happen, and give your solution to fix it (to fix it is not your task, we just need your answer, but it's great if you fix it)

    我设置了div的overflow-y为自动，设置了滚动条样式