## Answer
- [fetch_MDN](https://developer.mozilla.org/zh-CN/docs/Web/API/Fetch_API/Using_Fetch)
- promise更好。和回调相比，promise更加便捷，同时可读性大大增强，最好的特点是通过链式调用避免回调地狱，配合上箭头函数，可以使得代码简捷而又不失可读性。
[promise_MDN](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Guide/Using_promises)
- [httpsStatusCode_MDN](https://developer.mozilla.org/zh-CN/docs/Web/HTTP/Status)
- 此次代码主要有以下几点缺陷：
  - 更新列表为**全部更新**，在列表项目较多的情况下，可能会出现渲染较慢，消耗较大的缺陷。建议改成**针对特定项**修改。
  - 列表的id号为元素顺序，造成更新列表时需要将id号更新，并且各个元素的联系加深。应该改成id号相互独立，为特定的字符串，这样操作列表时也能精准定位。

目前只有以上几点想法