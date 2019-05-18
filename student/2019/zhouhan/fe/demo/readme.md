# Todo

### Base Knowledge
Go through these concepts and make sure you know something about them:  
HTML, JavaScript, CSS  

### Introduction
Firstly you all should include Node.js to run this project. The cause is that we need to serve some static assets like .js files for our modularization, rather then just include those scripts inline.

Here's the steps to serve our static assets:
1. visit the [Node.js homepage](https://nodejs.org/en/) and download LTS version 10.15.x, then install it.
2. open your terminal to check whether you have installed successfully: type 'node -v' , press enter, and check if there is 'v10.15.x'.
3. use the command 'cd [path]' to jump to our project directory which contains a directory named 'src', try this command 'npm i -g serve'. If you get permission error, try 'sudo npm i -g serve'. If there's no errors, run 'serve src'.
4. visit [todo app](http://localhost:5000).
5. you should use latest chrome/firefox browser and disable cache in your browser's network tab.

### Tasks
1. show createTime in #TodoList
2. show title, content, and createTime in #TodoDetail for current active todo item (just click an item in #TodoList to activate it)
3. add an edit button in #TodoDetail. When click it, #TodoDetail turn into edit mode.
In edit mode, we can modify title, content, noticeTime and save it (we may provide a save button?).
4. when click add button in #TodoList, we create a new todo item. We should automatically activate this item and make #TodoDetail edit mode.
5. Everything in this project is completely editable, you even have an option to delete all and rewrite your project to make it work. Good luck. 
6. every external lib like jQuery, Bootstrap, and moment.js is forbidden, you should use native API to make it work. (every external lib is allowed in our next project)

### DDL
DDL is 2019.05.17 23:59:59  
complete as many tasks as possible, and then submit your work on [Github](https://github.com/) and send your Github repo address to me.