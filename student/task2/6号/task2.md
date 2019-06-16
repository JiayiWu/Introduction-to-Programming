进度报告
第六组 后端 superfree
稍嫌混乱请见谅。。

before：學習Socket概念，springframework模块，jdbc概念，复习http交互内容，tcp/ip协议内容，maven项目管理
after：还要查一些springmvc的细节，还有搞清楚持久层，mapper（dao）与数据库连接，还有URL接受处理http请求并返回的方式

maven架构：
最重要的pom描述配置信息
dependency，repository，plugins等等

tcp/ip
三次握手，四次挥手
与UDP比较：tcpip会切割包（检查数据完整），UDP整包传输（不检查）
tcp的flag意义：最重要的SYN（同步），FIN（终止）

Spring学习笔记（不想分原生spring跟springboot了吐血hhh
IOC(Inversion of Control)控制反轉：
BeanFactory
ApplicationContext配置說明接口：實現（FileSystemXmlApplicationContext、ClassPathXmlApplicationContext、XmlWebApplicationContext、AnnotationConfigApplicationContext
DI(Dependency Injection)：構造方法注入、setter注入、接口注入

* 使用xml配置IOC
註解：
@Component
@Controller：表現層
@Service：業務層
@Repository：持久層
@AutoWired
@Qualifier

@Required：屬性值、構造方法、setter方法，說明必須在配置文件中配置
@Autowired：同上
@Resource：同上

<bean id=“類索引” class=“類的全限定名”></bean>：一個實例對象
abstract=“true”：表模板
parent=“另一個bean的id”：表父類
lazy-init=“true”：懶加載
init-method=“funcName”：創建時調用方法
destroy-method=“funcName”：銷毀時調用方法
depends-on=“beanId”：依賴（先實例化依賴後實例化自己）
factory-bean=“beanId”：利用工廠獲得類
factory-method=“funcName”：工廠方法
scope=“singleton”：作用域（默認為單例）（prototype）
autowire=“no”：自動裝配（byName、byType、constructor）

<constructor-arg name=“參數名” value=“參數值”></constructor-arg>：構造器參數（構造器注入）（bean內）
ref=“beanId”：參數為引用變量

<property name=“成員變量名” value=“值”></property>：成員變量（setter方法注入）（bean內）
***該成員變量必須實現setter方法（xxx：public void getXxx()，public return_type setXxx(Type)）
ref=“beanId”：參數為引用變量

<list> <value></value>...</list>：代替property中的value（property內）
<map> <entry></entry>...</map>：代替property中的value（property內）
<set> <value></value>...</set>：代替property中的value（property內）

* 類方式（註解）代替XML配置
***ClassPathXmlApplicationContext => AnnotationConfigApplicationContext

@SpringBootApplication = (默认属性)@Configuration + @EnableAutoConfiguration + @ComponentScan。

@Configuration  //把類當作beans，啟動spring容器
@EnableAutoConfiguration  //将所有符合条件的@Configuration配置都加载到IOC容器，自動導入xml文件中配置spring.framwork包

@Bean  //註冊Bean對象（Beans類內的方法）
@Scope(“param”)  //Bean的scope屬性（Type = singleton [, prototype]）（配合@Bean）

***註冊Bean（各層級）
@Component(“Id”)  //單純的Bean，默認Id為小寫類名，可自定義
@Service  //業務層組件
@Controller  //控制層組件
@RestController  //默認返回JSON格式
@Repository  //持久層組件（數據訪問組件，即Dao層

***用来修饰一个非静态的void()方法.而且这个方法不能有抛出异常声明
@PostConstruct  //對應init-method（@Component的方法）
@PreDestroy  //對應destroy-method（@Component的方法）

@ComponentScan(basePackages=“包路徑”)  //掃描組件，裝配需要的類
@MapperScan(“包路徑”)  //掃描Mapper，多路徑參數({“路經一”, “路徑二”})

@Data  //生成簡單POJO對象（封裝了@ToString, @EqualsAndHashCode, @Getter, @Setter, @RequireArgConstructor

@Entity(name=“表名”)  //實體類對應數據庫的表，表明為類名或用name設定
@Table(name=“表名”, catalog=“目錄”, shcema=“模式” )  //catalog數據庫名，（配合@Entity）
@Column  //字段與數據庫字段的對應關係
name：
unique：
nullable：
：
：
：
：
：