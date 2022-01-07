1.org.thymeleaf.exceptions.TemplateInputException:
    (1)未加@Responday注解（转为json格式输出)
    (2)没有再html中添加template模板引入
    (3)很小概率是缓存问题
2.http:415 前后台数据不对应
3.Caused by: java.lang.IllegalArgumentException:
    (1)包引入错误导致实例不对应，赋值失败
4.@GetMapping("/get/{id}")
  @PostMapping： 处理post请求，传统的RequestMapping来编写应该是@RequestMapping(value = “/get/{id}”,method = RequestMethod.POST)
  @PutMapping： 和PostMapping作用等同，都是用来向服务器提交信息。如果是添加信息，倾向于用@PostMapping，如果是更新信息，倾向于用@PutMapping。两者差别不是很明显。
  @DeleteMapping 删除URL映射，具体没有再实践中用过，不知道好在什么地方
5.layui表单提交方式会导致jquery序列化失败
  layui序列化表单并转json格式：JSON.stringify(data.field),
  ##### 跨域：是指a页面想获取b页面资源，如果a、b页面的协议、域名、端口、子域名不同，或是a页面为ip地址，b页面为域名地址，所进行的访问行动都是跨域的，而浏览器为了安全问题一般都限制了跨域访问，也就是不允许跨域请求资源。
