
class Model {

  data = {
    todos: [
      {
        id: 1,
        number:0,
        user:null,
        title: 'NCAA上演0.6秒罚球绝杀',
        content: '北京时间4月7日，NCAA半决赛上演一场争议不小的0.6秒罚球绝杀——终场前0.6秒，弗吉尼亚射手盖伊底角接球后转身跳投3分遭侵犯被吹罚犯规，然后盖伊三罚全中绝杀奥本大学带领弗吉尼亚大学队史首次打进总决赛，这本是一场和詹姆斯没有半毛钱关系的大学比赛，可即使如此，在全美第一詹黑眼里，这却是他黑詹姆斯的原素材。',
        createTime: 1556304707123,
        noticeTime: 1556374707123
      },
      {
        id: 2,
        number:0,
        user:null,
        title: '前有小红书，后有 vlog，明星的亲民化自我修养',
        content: '张雨绮、吴佩慈、林允、张歆艺、王鸥、大S..这些都是在小红书上拥有姓名的艺人，尤其是林允，人物形象极其亲民立体，不管演艺事业发展的如何，小红书里的她就是一个愿意跟大家分享美妆经验心得的邻家女生。',
        createTime: 1556304707123,
        noticeTime: 1556374707123,
        
      }
    ],
    // dirs:[
      
    //   {
    //     id:1,
    //     user:null,
    //     todo:[1,2],
    //     title:"hhh"
    //   }


    // ],
    activeTodoId: 1,
    // activeDirId: 0,
    maxTodoId: 2,
    editing: false,
    
    user: null,
    // {
    //   email
    //   id
    //   logoUrl
    //   name
    // }
    isRegister: false
  }
  subscribeFns = []

  /**
   * 
   * @param {(d: DATA) => DATA} updateFn 
   */
  update(updateFn) {
    this.data = updateFn(this.data)
    this.notify()
  }

  notify() {
    this.subscribeFns.forEach(fn => {
      fn(this.data)
    })
  }

  /**
   * 
   * @param {(d: DATA) => void} subscribeFn 
   */
  subscribe(subscribeFn) {
    this.subscribeFns.push(subscribeFn)
    subscribeFn(this.data)
    return () => this.subscribeFns.filter(fn => fn != subscribeFn)
  }
}

export default Model