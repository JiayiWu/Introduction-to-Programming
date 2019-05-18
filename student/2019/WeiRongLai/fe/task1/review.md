### 作业
mvc中不应该在controller中修改view，请更新model来驱动view的重绘

### 补充
看到了note.md，交流一下我的理解。  
1. 首先是注释部分，好的代码本身就有自带注释的功能。举例：
```js
  const VISION_WIDTH = 700
  const isXAxisOverflow = window.innerWidth < VISION_WIDTH
  if (isXAxisOverflow) { //todo }
```
```js
  // 如果浏览器可视宽度小于需要的可视区域宽度，则出现滚动
  if (window.innerWidth < 700) { //todo }
```
前者优于后者  
2.由于js缺乏类型，在提供对外接口的时候需要添加类型说明。但是现在主要的实现方式不是jsdoc而是typescript。
3.剩下的部分在接下来的任务或多或少都会有所接触（在review之前我们已经完成了task1-1关于node和cli的部分知识）