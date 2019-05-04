#为什么要有接口
1 接口的作用是实现多重继承  因为只能继承一个类（规定的）

2 接口把具体的实现抽象出来，减少模块间相互依赖性。


#依赖倒置原则（The Dependency Inversion Principle）

A. High level modules should not depend upon low level modules. Both should depend upon abstractions.

B. Abstractions should not depend upon details. Details should depend upon abstraction.

A. 高层模块不应该依赖于低层模块，二者都应该依赖于抽象。

B. 抽象不应该依赖于具体实现细节，而具体实现细节应该依赖于抽象。

使用 "Inversion" 这个词，是因为，对于更加传统的软件开发方法，例如结构化的分析与设计（Structured Analysis and Design），更趋向于创建高层模块依赖于低层模块的软件结构，进而使得抽象依赖了具体实现细节。而且实际上这些方法最主要的目标就是通过定义子程序的层级关系来描述高层模块式如何调用低层模块的。因此，一个设计良好的面向对象程序的依赖结构是 “inverted” 倒置了相对于传统过程化方法的依赖结构。
