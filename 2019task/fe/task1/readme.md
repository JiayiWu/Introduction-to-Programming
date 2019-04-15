# Todo (Front End) 

## Iteration I
### Introduction
Firstly sorry about that you all should include Node.js to run this project, which is not our original plan. The cause is that we need to serve some static assets like .js files for our modularization, rather then just include those scripts inline.

Here's the steps to serve our static assets:
1. visit the [Node.js homepage](https://nodejs.org/en/) and download LTS version 10.15.x, then install it.
2. open your terminal to check whether you have installed successfully: type 'node -v' , press enter, and check if there is 'v10.15.x'.
3. use the command 'cd [path]' to jump to our project directory '/fe/task1', try this command 'npm i -g serve'. If you get permission error, try 'sudo npm i -g serve'. If there's no errors, run 'serve src'.
4. visit [todo app](http://localhost:5000).
5. you should use latest chrome/firefox browser and disable cache in your browser's network tab. (when we move to webpack + react, current step is no longer necessary)

### Tasks
1. show createTime in #TodoList
2. show title, content, createTime and noticeTime in #TodoDetail for current active todo item (just click an item in #TodoList to activate it)
3. add an edit button in #TodoDetail. When click it, #TodoDetail turn into edit mode.
In edit mode, we can modify title, content, noticeTime and save it (we may provide a save button?).
4. when click add button in #TodoList, we create a new todo item. We should automatically activate this item and make #TodoDetail edit mode.
5. when I say 'we', it's just 'you'. So those tasks should be finished all by you. Everything in this project is completely editable, you even have an option to delete all and rewrite your project to make it work. Good luck. 
6. every external lib like jQuery, Bootstrap, and moment.js is forbidden during all the iterations for this project, you should use native API to make it work. (every external lib is allowed in our next project)

### Thinkings
1. compare the concept 'class' between JavaScript and Java.
2. in current index.html file, why we put type="module" and defer in script element? What is ESModule?
3. what is model-view-controller (MVC)? How we benefit from it?
4. make those concepts clear in your mind: box-sizing, display, flex, padding, margin
5. compare those css rules in the same array by there priority, suppose all of them are defined in one .css file:
[div, #id, .class], [#id, html > #id, html > #id:hover], 
[html #id, html > #id]
6. find one bug in #TodoList which will occur when Todo Items' size is large enough to scroll. Figure out why this happen, and give your solution to fix it (to fix it is not your task, we just need your answer, but it's great if you fix it)

### Last to Say
Every question is welcomed only after you have seriously consider it and could not find a solution.
And if there are words in this doc that make you confused, it's my fault and please point it out to me as soon as possible.