﻿# Host: localhost  (Version: 5.5.27)
# Date: 2019-03-30 14:24:02
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "admintable"
#

DROP TABLE IF EXISTS `admintable`;
CREATE TABLE `admintable` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `adminname` varchar(255) DEFAULT NULL,
  `adminpassword` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "admintable"
#

INSERT INTO `admintable` VALUES (1,'gaoming','19970412');

#
# Structure for table "questions"
#

DROP TABLE IF EXISTS `questions`;
CREATE TABLE `questions` (
  `qid` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(255) NOT NULL DEFAULT '',
  `select_a` varchar(255) NOT NULL DEFAULT '',
  `select_b` varchar(255) NOT NULL DEFAULT '',
  `select_c` varchar(255) DEFAULT '',
  `select_d` varchar(255) DEFAULT '',
  `imagepath` varchar(255) DEFAULT NULL,
  `answer` varchar(20) NOT NULL DEFAULT '',
  `descc` varchar(255) DEFAULT NULL,
  `cid` varchar(10) NOT NULL DEFAULT '',
  `addTime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`qid`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8;

#
# Data for table "questions"
#

INSERT INTO `questions` VALUES (1,'驾驶人在道路上驾驶机动车时，___。 ','只需携带驾驶证','只需携带行驶证','必须携带驾驶证、行驶证，放置强制保险标志、检验合格标志','应携带出厂合格证明或进口凭证',NULL,'C','当然是相关的证件都要带着了，证明驾驶人身份的身份证，驾驶车辆携带与证件相匹配车型号的行驶证，需要车辆检验合格证，保证车辆是好的，没有达到报废标准。 ','1','2019-03-16 12:42:35'),(2,'机动车遇行人正在通过人行横道时，应当___。 ','停车让行','绕行通过','持续鸣喇叭通过','提前加速通过',NULL,'A','人让车,让出一份安全,车让人,让出一份文明 ','1','2019-03-16 12:42:36'),(3,'夜间通过无交通信号控制的交叉路口时，不得变换远、近光灯。 ','正确','错误','','',NULL,'B','变换远、近光灯会引起注意 因为没有交通信号灯 所以危险大大降低。','2','2019-03-16 12:42:37'),(4,'雾天行车时，应及时开启___。','倒车灯','近光灯','远光灯','防雾灯',NULL,'D','都说是雾天了，当然要用雾灯了，不然要那玩意儿干吗！ 没有雾灯的车车属于减赔车型，就和没有安全气囊，没有ABS一样，个人认为应该首先追究商家的责任！','1','2019-03-16 12:43:35'),(5,'车辆在冰雪路面紧急制动时，易产生侧滑，应降低车速，利用发动机制动进行减速。 ','正确','错误','','',NULL,'A','发动机制动：行车（挂上排档，不是空档）中，油门一收，便产生发动机制动！原理：主要靠（停止供油）发动机的压缩力而制止车辆的前进。','2','2019-03-16 12:43:36'),(6,'车辆发生爆胎后，驾驶人在尚未控制住车速前，不要冒险使用行车制动器停车，以避免车辆横甩发生更大的险情。','正确','错误','','',NULL,'A','爆胎后,驾驶人在尚未控制住车速的时候，是不能急踩刹车的，要不然会横甩或者翻车已经后面来车追尾 ','2','2019-03-16 12:43:37'),(7,'行车中当车辆前轮爆胎已发生转向时，驾驶人应双手紧握转向盘，尽力控制车辆直线行驶。 ','正确','错误','','',NULL,'A','行车中当车辆前轮爆胎已发生转向时： 第一步：驾驶人应双手紧握转向盘，尽力控制车辆转回原行驶路线。','2','2019-03-16 12:43:38'),(8,'高速行驶的车辆，在转向失控的情况下使用紧急制动，很容易造成___。','侧滑','翻车','车厢前移','爆胎',NULL,'B','大家应看清楚的是这是在高速公路上行车！高速上最低速度也是60！速度非常的快！来一个紧急刹车肯定要翻车！其次题目也没说按没按防抱死制动系统！','1','2019-03-16 12:43:39'),(9,'行车中制动突然失灵时，驾驶人要沉着镇静，握紧转向盘，___进行减速。','连续踩踏制动踏板','利用“抢挡”或驻车制动','迅速踏下离合器踏板','迅速拉紧驻车制动器操纵杆',NULL,'B','制动失灵，还能用制动？所以A肯定不对。问题问的是如何减速而不是紧急停车，所以，B是正确答案。 ','1','2019-03-16 12:43:40'),(10,'安装防抱死制动装置(ABS)的车辆制动时，可用力踏制动踏板。','正确','错误','','',NULL,'A','防抱死制动装置(ABS)的作用就是用力踏制动踏板不会抱死，既然安装了，当然可以用力踏制动踏板了。 ','2','2019-03-16 12:43:41'),(11,'行车中发动机突然熄火后，应___。 ','立即减速停车','关闭点火开关','将变速器操纵杆置于空挡行驶','开启右转向灯，将车缓慢滑行到路边停车检查',NULL,'D','利用惯性缓慢停车。','1','2019-03-16 12:43:42'),(12,'跳出车外落地后，应力争双手抱头顺势向惯性力的方向多滚动一段距离，以躲开车体，增大离开危险区的距离。','正确','错误','','',NULL,'A','既然要跳车了，说明车上或车周围已经有危险了，说不定要爆炸了什么滴，所以离它越远越远，自然滚得远的为好。','2','2019-03-16 12:43:43'),(13,'在高速公路上发生紧急情况，不要轻易急转方向避让，应采取制动减速，使车辆在碰撞前处于停止或低速行进状态，以减小碰撞损坏程度。 ','正确','错误','','',NULL,'A','题中说是制动而不是紧急制动，可以轻踏踏板或间断踏吧！这样速度减下来，撞得就不厉害了。反正是不能急转方向的，高速公路在非紧急情况不得停车，可现在很紧急，没办法的事，不这样，后面“有可能”追尾但前面必撞！ ','2','2019-03-16 12:43:44'),(14,'车辆驶出隧道口处，遇横风引起车辆偏离行驶路线时，应握稳转向盘，微量进行调整。 ','正确','错误','','',NULL,'A','握稳转向盘并减速停车是进隧道口的时候 握稳转向盘微量进行调整是出隧道口 如果遇到横风你在出隧道口的时候停车估计后车吻你车的可能性很大','2','2019-03-16 12:43:45'),(16,'张某驾驶车辆在高速公路上发生故障不能移动，开启危险报警闪光灯后下车，联系朋友李某驾驶私家车帮忙拖曳到应急车道。李某拖曳故障车的过程中，刘某驾驶货运车辆以每小时110公里的速度驶来，导致三车相撞。这起事故中的违法行为有哪些？','张某疲劳驾驶','李某用私家车拖曳故障车辆','刘某超速行驶','未在故障车辆后设置警示标志',NULL,'BCD','张某未在故障车辆后设置警示标志、李某用私家车拖曳故障车辆、刘某超速行驶等。高速公路上发生故障，正确的做法是，开启危险报警闪光灯后下车，在故障车辆后设置警示标志，联系保险公司或者维修店进行拖曳维修。货运车辆在高速上最高车速不得超过100公里/小时。','3','2019-03-16 12:43:46'),(17,'石某驾驶低速载货机动车，运载4.05吨货物（核载1.2吨），行驶至宁津县境内314省道51公里加260米处，在越过道路中心线超越前方同向行驶的机动车时，与对向正常行驶的中型客车（乘载12人，核载11人）正面相撞，造成10人死亡、2人受伤。此事故中的违法行为是什么？','货车超载','货车违法超车','客车超员','客车驾驶人疲劳驾驶',NULL,'ABC','违法行为：1、货车运载4.05吨货物（核载1.2吨），超载；2、在越过道路中心线超越前方同向行驶的机动车时，与对向正常行驶的中型客车正面相撞，违法；3、中型客车（乘载12人，核载11人），超载。','3','2019-03-16 12:43:47'),(18,'座椅安全头枕的主要作用是___。 ','在车辆行驶过程中使头部放松','车辆发生追尾事故时保护颈椎','车辆发生追尾事故时保持正确姿势','长时间驾驶时使颈部放松',NULL,'B','不是保护颈椎，就不叫安全头枕了。','1','2019-03-16 12:43:48'),(19,'车速较高时发生紧急情况，应先转方向避让，再采取制动减速，以减小碰撞损坏程度。','正确','错误','','',NULL,'B','应该先制动减速，后转向避让。 ','2','2019-03-16 12:43:49'),(20,'彭某驾驶一辆重型半挂牵引车，载运37.7吨货物（核载25吨），行至大广高速公路一下坡路段，追尾碰撞一辆由李某驾驶在应急车道内行驶的重型自卸货车（货箱内装载3.17立方黄土并搭乘24人），造成16人死亡、13人受伤。此事故中的主要违法行为是什么？','彭某超速行驶','彭某驾驶机动车超载','李某在应急车道内行驶','李某货车车厢内违法载人',NULL,'BCD','1、载运37.7吨货物（核载25吨），说明超载；2、李某驾驶在应急车道内行驶，说明李某违法在应急车道行驶，应急车道只能应急使用；3、货箱内装载3.17立方黄土并搭乘24人，货车不能拉人。','3','2019-03-16 12:43:50'),(21,'戚某驾驶大客车，乘载28人（核载55人），由南向北行至一无交通信号控制的交叉路口，以50公里的时速与由东向西行至该路口李某驾驶的重型半挂牵引车（核载40吨，实载55.2吨）侧面相撞，造成12人死亡、17人受伤。此事故中的主要违法行为是什么？','客车超员','客车超速行驶','货车超载','货车驾驶人经验不足',NULL,'BC','1、交叉路口以50km/h,属于超速；2、核载40吨，实载55.2吨，属于超载。','3','2019-03-16 12:43:51'),(22,'行车途中，仪表板上的“如图”灯亮时，表示___。','车内温度过高','发动机温度过低','燃油温度过高','发动机温度过高或冷却液不足','examOnline_img/13/14/fd1491af91dc47138c22605e7b11524e_1.jpg','D','该图是一个温度计，一般行车过程中都不会出现发动机温度过低的情况（否则就无法启动了），所以只能是温度过高，选D，简洁明了。','1','2019-03-16 12:43:52'),(23,'抢救失血伤员时，应先进行___。','观察','包扎','止血','询问',NULL,'C','血流多了会挂掉的，所以止血是第一抢救要务。 ','1','2019-03-16 12:43:53'),(24,'行车途中，仪表板上的“如图”灯亮起，提醒需要添加机油。','正确','错误','','','examOnline_img/8/3/d1cfe67019a74d5f919757b5ec2b4884_2.jpg','B','易错题，应改为燃油。此标志是燃油指示灯。','2','2019-03-16 12:43:54'),(25,'仪表板上的“如图”灯亮，表示安全带插头未插入固定扣。','正确','错误','','','examOnline_img/0/11/90bd2507164047d195ab38977a7ecd40_3.jpg','A','该指示灯用来显示安全带是否处于锁止状态，当该灯点亮时，说明安全带没有及时的扣紧。有些车型会有相应的提示音。当安全带被及时扣紧后，该指示灯自动熄灭。','2','2019-03-16 12:43:55'),(26,'仪表板上的“如图”灯亮，是提醒驾驶人座椅位置调整不当。 ','正确','错误','','','examOnline_img/8/2/cd2cd411e8d641f496bf45466d9bc832_3.jpg','B','应该是提示安全带没系好安全带。 ','2','2019-03-16 12:43:56'),(27,'图中标志的含义是___。 ','注意落石','傍山险路','注意滑坡','下陡坡','examOnline_img/0/4/9a2a3e9c57ac4cbbb0131702fe4ac375_4.jpg','A','注意看图标明显有石头从山上往下落，所以是注意落石。而旁山险路只标有山而没的石头。','1','2019-03-16 12:43:57'),(28,'赵某（持有A2驾驶证）驾驶大型卧铺客车（核载36人），行驶至叶城县境内某处急弯路段，加速超越前车时，坠入道路一侧山沟，致16人死亡，20人受伤。赵某的主要违法行为是什么？','在不具备超车条件的急弯路段加速超车','驾驶逾期未检验的机动车','驾驶与准驾车型不符的机动车','疲劳驾驶',NULL,'AC','赵某的主要违法行为是在不具备超车条件的急弯路段加速超车和驾驶与准驾车型不符的机动车。','3','2019-03-16 12:43:58'),(29,'受伤者在车内无法自行下车时，可设法将其从车内移出，尽量避免二次受伤。','正确','错误','','',NULL,'A','这是对的，一定要移出的，但注意不是拖出，不然有二次受伤的危险！ ','2','2019-03-16 12:43:59'),(31,'伤员大腿、小腿和脊椎骨折时，一般应就地固定，不要随便移动伤者。','正确','错误','','',NULL,'A','题目说的是一般，不是一定要先固定，有困难在想办法呗，不要太死扣题了，可以的话一般是要先固定的。 从医学的角度出发，骨折随意移动会找出二次伤害，脊椎受伤如果移动脊椎变形，有可能会终身瘫痪。 骨折时，移动会引起错位，造成更严重的结果，所以一般不要移动伤者，待医护人员到后再行处理。','2','2019-03-16 13:30:36'),(32,'处理伤员失血的措施可通过外部压力，使伤口流血止住，然后系上绷带。','正确','错误','','',NULL,'A','流血先止血，压迫法止血。','2','2019-03-16 20:02:24'),(33,'伤员上肢骨折固定时，肢体要伸直捆绑。 ','正确','错误','','',NULL,'B','记住，上肢的问题要蜷缩，下肢的问题要伸直，易错题。','2','2019-03-16 20:08:44'),(34,'危险化学品车辆驾驶人及押运人应当具备相关应急处置知识。','正确','错误','','',NULL,'A','如果没有相关的知识，遇到事情肯定会手忙脚乱！出了事情那可就倒霉了！ ','2','2019-03-16 20:33:05'),(35,'高速公路没有限速标志的，最高时速不得超过___。','90公里','100公里','120公里','130公里',NULL,'C','上高速路的车最低时速是要求60公里，最高不得超过120公里，如果高速路同方向有2条车道，右侧车的速度范围为60公里到100公里，左侧车的速度范围为100公里到120公里。如果有同方向有3条的车道，最右侧的速度范围为60公里到90公里，中间的为90公里到110公里，最左侧的为110公里到120公里。所以超车当然是要从左侧超车。 ','1','2019-03-16 20:34:09'),(36,'饮酒后驾驶机动车的，处暂扣______，并处1000元以上2000元以下罚款。 ','机动车','行驶证','6个月机动车驾驶证','6个月以上驾驶证,由民警决定',NULL,'C','1、机动车手续齐全，2、民警没有决定权，所以A、B、D错，因此选C. 2011年5月1日修改后的《道路交通安全法》第九十一条规定：“饮酒后驾驶机动车的，处暂扣六个月机动车驾驶证，并处一千元以上二千元以下罚款。因饮酒后驾驶机动车被处罚，再次饮酒后驾驶机动车的，处十日以下拘留，并处一千元以上二千元以下罚款，吊销机动车驾驶证。','1','2019-03-16 20:35:02'),(37,'违反交通管制的规定强行通行，不听劝阻的， 公安交通管理部门除按照规定罚款外，还可并处___。 ','扣留机动车','吊销驾驶证','15日以下拘留','扣留行驶证',NULL,'C','15日以下拘留的情况包括:1.未取得驾照的人驾车 2.驾照暂扣期间驾车 3.被吊销期间驾车 4.肇事逃逸,尚不构成犯罪 5.醉酒后驾车6.故意损毁、移动、涂改交通设施，造成危害后果，尚不构成犯罪的7.非法拦截、扣留机动车辆，不听劝阻，造成交通严重阻塞或者较大财产损失的。','1','2019-03-16 20:35:44'),(38,'在中华人民共和国境内与道路交通活动有关的单位和个人，都必须遵守《中华人民共和国道路交通安全法》。','正确','错误','','',NULL,'B','和谐社会，你不听政府的你听谁的，不然就和谐你！','2','2019-03-16 20:36:11'),(39,'与对向来车发生正面碰撞且碰撞位置在驾驶人正前方时，驾驶人正确的应急驾驶姿势是什么？','迅速躲离转向盘','往副驾驶座位躲避','迅速将两腿抬起','两腿蹬直',NULL,'ABC','前三个选项的用意是为了不让身体被卡住，而D选项则会让驾驶人受到更大的伤害，因此本题正确的是ABC。','3','2019-03-16 20:39:38'),(40,'赵某（持有A2驾驶证）驾驶大型卧铺客车（核载36人），行驶至叶城县境内某处急弯路段，加速超越前车时，坠入道路一侧山沟，致16人死亡，20人受伤。赵某的主要违法行为是什么？','在不具备超车条件的急弯路段加速超车','驾驶逾期未检验的机动车','驾驶与准驾车型不符的机动车','疲劳驾驶',NULL,'AC','赵某的主要违法行为是在不具备超车条件的急弯路段加速超车和驾驶与准驾车型不符的机动车。','3','2019-03-16 20:40:44'),(41,'机动车驾驶人在实习期内不得驾驶___。 ','小型汽车','营运出租车','自动挡汽车','三轮汽车',NULL,'B','1年内是不能开拉人的车辆的，人命关天，还是有1年经验好！','1','2019-03-29 12:07:26'),(42,'机动车驾驶证有效期分为___、10年和长期','1年','2年','5年','6年',NULL,'D','机动车驾驶证有效期分为六年、十年和长期。初次领取的驾驶证有效期为六年，如果在第一个六年有效期内没有满分记录，换证以后驾驶证有效期是十年，如果十年内没有满分记录，再换证以后就是长期的','1','2019-03-29 12:13:49'),(43,'机动车驾驶人累计记分达到12分，拒不参加公安机关交通管理部门通知的学习，也不接受考试的，由公安机关交通管理部门___。','公告其驾驶证停止使用','扣留其驾驶证','吊销其驾驶证','对其加倍处以罚款',NULL,'A','停止使用：你在交警队接受培训且通过科目一考试的，就可以恢复驾照，时间较短。 吊销：你要满2年且考试合格才能恢复驾照的使用！ ','1','2019-03-29 12:14:39'),(44,'右侧标志警告前方是向右急转弯路','正确','错误','','','examOnline_img/11/3/195ad9cbe50e4aa3993409f40854fc8b_5.jpg','A','这个标志警告前方是向右急转弯路','2','2019-03-29 12:20:29'),(45,'机动车向左转弯、向左变更车道、超车前、驶离停车地点及掉头时，___。 ','可以在转向的同时开启转向灯','可以先转向后开启转向灯','只要没有其他车辆可以不开转向灯','应当提前开启左转向灯',NULL,'D','一定要先把自己的意图表示出来，之后再行动。','1','2019-03-29 12:22:36'),(46,'机动车在高速公路上行驶，车速超过每小时100公里时，应当与同车道前车保持___以上的距离。','50米','60米','80米','100米',NULL,'D','100公里就是100m以上 100公里以下，最少50m ','1','2019-03-29 12:23:25'),(47,'机动车在高速公路上行驶，___。 ','可在匝道、加速车道、减速车道上超车','不准倒车、逆行、穿越中央分隔带掉头','非紧急情况时可在应急车道行驶','可以试车或学习驾驶',NULL,'B','A选项明显是错误的，不用解释。C选项注意2个关键字，“非”“紧急”，否定应该对应否定，所以C错误。很多人认为D选项是正确的，你试想一下，你都没有驾照，怎么能让你上高速呢，都不让你上高速，更谈不上在高速学车了','1','2019-03-29 12:24:16'),(48,'被扣留的机动车，驾驶人或者所有人、管理人30日内不接受处理，经公安机关交通管理部门公告3个月仍不接受处理的，对该机动车___。 ','可以依法拍卖','可以强制报废','可以强行拆解','无权处置',NULL,'A','你不交钱，职能部门就用你的车顶账！ ','1','2019-03-29 12:24:57'),(49,'机动车驾驶人的驾驶证未随身携带的，可以驾驶机动车。','正确','错误','','',NULL,'B','这也叫无照驾驶！ ','2','2019-03-29 12:25:21'),(50,'机动车有被盗抢嫌疑的，交通警察可以依法___。','注销','扣留','拍卖','罚款',NULL,'B','此题是有盗抢嫌疑，所以还没有事实依据，所以只能先进行扣留。待实时查清在做进一步处理！','2','2019-03-29 12:26:02'),(51,'可以扣留机动车驾驶证的情形是___。','饮酒后驾驶机动车的','驾车时吸烟、饮食的','发生轻微交通事故，未造成财产损失的','机动车行驶超过规定时速10%的',NULL,'A','现在国家对酒后驾车出重拳治理，饮酒驾驶一次直接被扣12分， 所以可以直接扣留驾驶证。 ','1','2019-03-29 12:26:51'),(52,'对酒后行为失控或者拒绝配合检验的，可以___。 ','罚款','拘留','使用约束带或者警绳等约束性警械','批评、教育',NULL,'C','对违法司机的惩罚是四种：警告 罚款 扣留或者吊销驾驶执照和拘留, 是针对证据确凿的情况下对违法司机的惩罚行为。酒后拒绝配合检查，说明还没对酒精含量测试，只能属于嫌疑对象，还不算是违法司机。 所以可以采用强制手段，测试完酒精度可可以使用以上四种惩罚行为。','1','2019-03-29 12:27:42'),(53,'饮酒后驾驶机动车的，依法扣留机动车驾驶证。 ','正确','错误','','',NULL,'AB','“饮酒”和“醉酒” 饮酒驾驶一次直接被扣12分，因为被扣了12分所以暂扣驾照，通过学习和考试后可以恢复驾照的使用。 醉酒驾驶直接被注销驾驶证，五年内不能重新申请。 ','2','2019-03-29 12:28:13'),(54,'当事人对道路交通事故认定有异议的，可以向上一级公安交通管理部门提出书面复核申请。 ','正确','错误','','',NULL,'A','根据道路交通安全法规定，公安机关交通管理部门制作的交通事故认定书，作为处理交通事故案件的证据使用。因此，交通事故责任认定行为不属于具体行政行为，不能向人民法院提起行政诉讼。如果当事人对交通事故认定书牵连的民事赔偿不服，可以向人民法院提起民事诉讼 ','2','2019-03-29 12:28:41'),(55,'交通事故调解未达成协议及调解生效后当事人不履行的，当事人可以向人民法院提起民事诉讼','正确','错误','','',NULL,'A','交通事故调解也遵循自愿原则，当事人双方达不成调解协议的或达成调解协议不履行的，一方可以向人民法院提起民事诉讼。 ','2','2019-03-29 12:29:05'),(56,'机动车驾驶人在一个记分周期内累积记分达到___的，应当在十五日内到机动车驾驶证核发地或违法行为地公安机关交通管理部门接受为期7天的道路交通安全法律、法规和相关知识的教育。','3分','6分','9分','12分',NULL,'D','达到12分就需要','1','2019-03-29 12:30:15'),(57,'交通信号灯黄灯闪烁表示___。 ','禁止通行','准许通行','停车','警示',NULL,'D','这道题要注意是黄灯亮还是黄灯闪烁！黄灯亮是说过了停车线的车可以继续行驶，没过的就得停下。而黄灯闪烁一般是在夜间车少时的交叉路口，黄灯一直闪烁，提醒车辆减速小心谨慎通过，准许所有车辆通过但有警示作用。 ','1','2019-03-29 12:31:00'),(59,'图中标志的含义是___。 ','注意落石','傍山险路','注意滑坡','下陡坡','examOnline_img/3/10/b9bea0271dd64f3590eab9cba44ae680_6.jpg','A','注意看图标明显有石头从山上往下落，所以是注意落石。而旁山险路只标有山而没的石头。 ','1','2019-03-29 12:33:03'),(60,'图中标志的含义是___。 ','注意危险','注意横风','注意落石','傍山险路','examOnline_img/13/7/46caf208f6cb43aa8ecf00d4a71e90d3_7.jpg','B','此标志设在经常有很强的侧风并有必要引起注意的路段前适当位置。','1','2019-03-29 12:35:15'),(61,'图中标志的含义是___。 ','易滑','堤坝路','傍山险路','下陡坡','examOnline_img/15/7/382cd3f9d3994f5c8eeabb1303789589_8.jpg','C','此标志设在山区地势险要路段（道路外侧位陡壁、悬崖危险的路段）以前适当位置。','1','2019-03-29 12:35:59'),(62,'图中标志的含义是___','前方事故','禁行','停车','注意危险','examOnline_img/12/0/d846c453bf9140ceb63af6e8766d6d33_9.jpg','D','注意危险：用以促使车辆驾驶员谨慎慢行。','1','2019-03-29 12:37:05'),(63,'图中标志的含义是___。','禁止车辆临时停放','停车让行','禁止车辆临时或长时停放','禁止停车','examOnline_img/11/7/a48a6fef8d6a40b182625fc91a304fe1_11.jpg','B','易错题，看清停后面的背景色！ 停车让行 表示车辆必须在停止线以外停车了望，确认安全后，才准许通行。停车让行标志在下列情况下设置：(1)与交通流量较大的干路平交的支路路口；(2)无人看守的铁路道口；(3)其他需要设置的地方。','1','2019-03-29 12:40:34'),(64,'图中标志表示只准一切车辆___。 ','向左转弯','靠左侧道路行驶','靠左侧停车','靠右侧道路行驶','examOnline_img/13/1/ff3df20e3ec740c396f50299e14a52d2_12.jpg','B','靠左侧道路行驶：表示只准一切车辆靠左侧）道路行驶。此标志设在车辆必须靠左侧行驶的路口以前适当位置。','1','2019-03-29 12:41:40'),(69,'某日19时，杨某驾驶大客车，乘载57人（核载55人），连续行驶至次日凌晨1时，在江宁区境内104国道3008公里加110米处，因机动车左前胎爆裂，造成12人死亡、22人受伤的特大交通事故。杨某的主要违法行为是什么？','疲劳驾驶','客车超员','超速行驶','操作不当',NULL,'AB','杨某的主要违法行为有：1、连续驾驶6小时属于疲劳驾驶；2、大客车核载55人，实际乘载57人，属于客车超员。','3','2019-03-29 12:55:42'),(70,'林某驾车以110公里/小时的速度在城市道路行驶，与一辆机动车追尾后弃车逃离被群众拦下。经鉴定，事发时林某血液中的酒精浓度为135.8毫克/百毫升。林某的主要违法行为是什么？','醉酒驾驶','超速驾驶','疲劳驾驶','肇事逃逸',NULL,'ABD','林某的主要违法行为有：1、\"以110公里/小时的速度在城市道路行驶\"属于超速行驶；2、\"与一辆机动车追尾后弃车逃逸\"属于肇事逃逸；3、\"血液中的酒精浓度为135.8毫克/百毫升\"属于醉酒驾驶。','3','2019-03-29 14:49:07'),(71,'周某夜间驾驶大货车在没有路灯的城市道路上以90公里/小时的速度行驶，一直开启远光灯，在通过一窄路时，因加速抢道，导致对面驶来的一辆小客车撞上右侧护栏。周某的主要违法行为是什么？','超速行驶','不按规定会车','疲劳驾驶','不按规定使用灯光',NULL,'ABD','违法行为有：1、\"城市道路上以90公里/小时的速度行驶\"属于超速行驶；2、在夜间行驶一直开启远光灯属于不按规定使用灯光；3、加速抢道属于不按规定会车。','3','2019-03-29 14:50:52'),(72,'叶某驾驶中型厢式货车，行至桃园镇睢桃线3公里加600米弯道路段时，以40公里/小时的速度与王某驾驶的乘载19人正三轮载货摩托车发生正面相撞，造成10人死亡、9人受伤。双方驾驶人的主要违法行为是什么？','叶某驾驶与准驾车型不符的机动车','王某驾驶摩托车非法载客','叶某超速行驶','王某不按信号灯指示行驶',NULL,'BC','双方驾驶人的主要违法行为是：1、弯道限速30公里/小时，叶某以40公里/小时的速度行驶属于超速；2、王某用载货摩托车载客属于非法载客。','3','2019-03-29 14:51:47'),(73,'唐某驾驶一辆大客车，乘载74人（核载30人），以每小时38公里的速度，行至一连续下陡坡转弯路段时，机动车翻入路侧溪水内，造成17人死亡、57人受伤。唐某的主要违法行为是什么？','酒后驾驶','客车超员','疲劳驾驶','超速行驶',NULL,'BD','唐某的主要违法行为有：1、（乘载74人）-（核载30人）=（超载44人），属于客车超员；2、弯道限速30公里/每小时，以每小时38公里的速度行驶，属于超速行驶。','3','2019-03-29 14:53:35'),(74,'李某驾驶一辆大客车，乘载21人（核载35人），行驶途中察觉制动装置有异常但未处理，行至双岛海湾大桥时时速为50公里（该路段限速40公里），因制动失灵坠入海中，造成13人死亡、8人受伤。李某的主要违法行为是什么？','超速行驶','疲劳驾驶','客车超员','驾驶具有安全隐患的机动车',NULL,'AD','李某的主要违法行为有：1、行驶途中察觉制动装置有异常但未处理，属于驾驶具有安全隐患的机动车；2、行驶至双岛海湾大桥时时速为50公里（该路段限速40公里），属于超速行驶。','3','2019-03-29 14:54:41'),(75,'吴某驾驶一辆大客车，乘载33人（核载22人），行至163县道7公里加300米处时，机动车失控坠入伏牛山山沟，造成10人死亡、21人受伤。事后经酒精检测，吴某血液酒精含量为26毫克/百毫升。吴某的主要违法行为是什么？','超速行驶','客车超员','疲劳驾驶','酒后驾驶',NULL,'BD','吴某的主要违法行为有：1、酒后驾驶：根据国家质量监督检验检疫局发布的《车辆驾驶醉酒驾车的测试人员血液、呼气酒精含量阈值与检验》规定，该规定指出，“饮酒驾车”是指车辆驾驶人员血液中的酒精含量大于或者等于20mg/100ml，小于80mg/100ml的驾驶行为。“醉酒驾车”是指车辆驾驶人员血液中的酒精含量大于或者等于80mg/100ml的驾驶行为。\r\n2、乘载33人（核载22人），属于客车超员','3','2019-03-29 14:56:03'),(76,'钱某驾驶大型卧铺客车，乘载45人（核载40人），保持40公里/小时以上的车速行至睢宁县桃园境内连续下坡急转弯路段处，翻下100米深的山崖，造成17人死亡、20人受伤。钱某的主要违法行为是什么？','驾驶时接听手持电话','超速行驶','客车超员','疲劳驾驶',NULL,'BC','1、弯道限速30公里/每小时，保持40公里/小时以上的车速是超速行驶。2、乘载45人(核载40人)，客车超员','3','2019-03-29 14:57:05'),(77,'邹某驾驶大型卧铺客车（核载35人，实载47人），行至京港澳高速公路938公里时，因乘车人携带的大量危险化学品在车厢内突然发生爆燃，造成41人死亡，6人受伤。此事故中的主要违法行为是什么？','客车超员','乘车人携带易燃易爆危险物品','超速行驶','不按规定停车',NULL,'AB','核载35人，实载47人客车超员。乘车人携带的大量危险化学品在车厢内突然发生爆燃，属于乘车人携带易燃易爆危险物品。此处在港澳高速938公里处指的是事发地点离港澳高速起点938公里，与速度是没有关系的。','3','2019-03-29 15:47:00'),(78,'杨某驾驶改装小型客车（核载9人，实载64人，其中62人为幼儿园学生），行至榆林子镇王伏村处，占用对向车道逆行时与一辆重型自卸货车正面碰撞，造成22人死亡、44人受伤。该起事故中的主要违法行为是什么？','货车超速行驶','非法改装机动车','客车超员','客车逆向行驶',NULL,'BCD','杨某的主要违法行为有：1、杨某改装小型客车，属于非法改装机动车2、核载9人，实载64人，所以客车超员3、占用对向车道逆行时，所以客车逆向行驶','3','2019-03-29 15:48:13'),(79,'图中标志用于指示前方路口车辆___的正确行驶路线。','掉头','绕行','转弯','变道','examOnline_img/14/14/86cca10295614de38fc90e03ab7ec19a_13.jpg','B','请看箭头啊 不是从中间直接进入向左走 ，而是向右走了在直行向左的 绕了个圈！ ','1','2019-03-29 15:50:58'),(80,'图中是停车让行标志。','正确','错误','','','examOnline_img/15/3/1a2ed4e340814ff4a199306429e5d4d2_14.jpg','B','图标为禁止机动车驶入！','2','2019-03-29 15:52:29'),(81,'图中是靠右侧道路行驶标志。','正确','错误','','','examOnline_img/9/2/ad8584d06c8d4accbcd92f116463cc71_15.jpg','B','这叫指路标识，长方形代表路，箭头代表方向，靠右行驶标识的图像时远的。记住，指路标志都是矩形框！ ','2','2019-03-29 15:53:18'),(82,'图中是支路先行标志。 ','正确','错误','','','examOnline_img/10/11/35a52a03af074df1856d93517f7fc1bc_16.jpg','B','粗的就是主干道，干路先行，也就是中间粗的那条路先行，记住哥一句话：谁粗谁先行。','2','2019-03-29 15:54:12'),(83,'图中辅助标志的含义是确定主标志规定的区域。 ','正确','错误','','','examOnline_img/9/10/e1f05ac309c543b69ba915fc073ca722_17.jpg','A','那如果没有那\"区域内\"的话就是错得咯！ ','2','2019-03-29 15:58:06'),(84,'如图所示为人行横道线，是行人横穿___的标线。','街道','车行道','铁路道口','高速公路','examOnline_img/7/2/a66dc3dc344f463db100f3fd2f3c94cd_18.jpg','B','应该不是所有街道都设人行横道线的，车行道是必须设的，不管对不对这样好记点！ ','1','2019-03-29 16:00:23'),(85,'图中所示路口内白色虚线区为___。 ','左转弯导向','右转弯待转区','右转弯导向','左转弯待转区','examOnline_img/14/3/9734f88bc2034ea1b30fd5e4b5465d47_19.jpg','D','图片标识的很清楚呀，向左转弯，但要等待，等到警察叔叔说让你走你才能走！ ','1','2019-03-29 16:03:03'),(86,'图中所示为___标线。 ','路边可以临时停放车辆','禁止路边临时或长时停放车辆','禁止路边长时停放车辆','路边可以长时停放车辆','examOnline_img/13/14/2e7b5389f9094f7e8f3f29c17f463017_20.jpg','B','如果是虚线，表示禁止长时停车，可暂停。 如果是实线，表示禁止长时、临时停车。','1','2019-03-29 16:04:45'),(87,'如图所示路口中心黄色网状线，用于告示驾驶人禁止在该区域内临时停车，防止交通阻塞。','正确','错误','','','examOnline_img/10/2/99e3507e355e47c69b7b7b28ece4d7cf_21.jpg','A','注意该区域内指的是行车方向。十字路指的是区域外。。。所以该题目正确！ ','2','2019-03-29 16:06:36'),(88,'图中警察手势为___信号。','左转弯','停止','右转弯','示意车辆靠边停车','examOnline_img/9/12/0552c0603c99488b98f744f1d101d739_22.jpg','B','真傻，警察叔叔手都举起来了，不停打你，记住了吧 ','1','2019-03-29 16:07:56'),(89,'换挡时___。','不得低头下视','慢推、慢拉','注意看挡位','猛推、猛拉',NULL,'A','开车的时候目光始终是在正前方，所以换挡的时候是不能低头看的，万一换挡的时候有行人冲过来，你还低头看档位的话，太危险了，所以答案是A。B和D的选项，都是太极端，不是太快，就是太慢，不能选。 ','1','2019-03-29 16:08:56'),(90,'自动挡汽车在陡坡行驶时使用“2”挡。','正确','错误','','',NULL,'B','汽车可在1～4 档(或3 档)之间自动换档； S或2 (Second Gear) 2档，2档为低速前进档，也称缓坡档； L (Low) 或1 (First Gear)低速档，也称1档，或陡坡档 ','2','2019-03-29 16:09:22'),(91,'自动挡汽车在陡坡行驶时使用“L”挡','正确','错误','','',NULL,'A','1：陡坡 2.：缓陡坡 L：低速档，上陡坡需要加速 D：普通道路路面 ','2','2019-03-29 16:09:48'),(92,'夜间驾驶人对物体的观察明显比白天差，视距___。 ','变长','变短','不变','无规律',NULL,'B',' 夜晚，在路上行车时，由于车灯的作用，看到的是黑色背景中的亮色物体，所以亮色物体偏大，而眼睛依旧以近大远小的感觉判断，故视距减小。','1','2019-03-29 16:10:33'),(93,'驾驶人在超车时，前方车辆不减速、不让道，应___','连续鸣喇叭加速超越','加速继续超越','停止继续超车','紧跟其后，伺机再超',NULL,'C','答这些题，只要保持文明一条准则就行了！ ','1','2019-03-29 16:11:19'),(94,'可以扣留机动车驾驶证的情形是___。','饮酒后驾驶机动车的','驾车时吸烟、饮食的','发生轻微交通事故，未造成财产损失的','机动车行驶超过规定时速10%的',NULL,'A','现在国家对酒后驾车出重拳治理，饮酒驾驶一次直接被扣12分， 所以可以直接扣留驾驶证。','1','2019-03-30 14:00:50');

#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `school` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `registtime` varchar(255) DEFAULT NULL,
  `imagepath` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `uuidcode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (3,'小明','caf1a3dfb505ffed0d024130f58c5cfa','1585168893@qq.com','广安驾校','12121212120','2019-03-25 17:03:53','userHeader/1fe864a012f844fb8f7ad7bbd6bb4a17_touxiang2.jpg',1,NULL),(5,'程序员','202cb962ac59075b964b07152d234b70','1585168893@qq.com','广安驾校','12121212120','2019-03-25 21:52:33','userHeader/ce8553014a4742fbb962f0e76bcf535c_touxiang7.jpg',1,NULL),(7,'李四','202cb962ac59075b964b07152d234b70','1585168893@qq.com','广安驾校','13318527563','2019-03-27 09:33:25','userHeader/5dd23ba363034252be98de601153964f_touxiang6.jpg',1,NULL),(8,'zyx','e10adc3949ba59abbe56e057f20f883e','3198787694@qq.com','平安驾校','17819185406','2019-03-28 21:03:52',NULL,1,NULL),(9,'zhaokangzhan','96e79218965eb72c92a549dd5a330112','354338298@qq.com','富安驾校','13245614456','2019-03-28 21:07:20',NULL,0,'71ca50d211bb47679d21f97d28dfb50b'),(10,'22','b6d767d2f8ed5d21a44b0e5886680cb9','781648249@qq.com','平安驾校','17819185758','2019-03-28 21:15:22',NULL,1,NULL),(11,'zwj','827ccb0eea8a706c4c34a16891f84e7b','895735443@qq.com','平安驾校','17819185299','2019-03-28 21:33:47','userHeader/a62be6300b3c4b2fb7cf7c3963fc20de_2019-03-24_203105.jpg',1,NULL),(12,'aaa','47bce5c74f589f4867dbd57e9ca9f808','1585168893@qq.com','富安驾校','13169162754','2019-03-28 22:55:04',NULL,0,'092bb459e01b4212ad058d307687bfeb'),(13,'高铭','202cb962ac59075b964b07152d234b70','1585168893@qq.com','富安驾校','13318527563','2019-03-30 13:51:22','userHeader/02ec19e0bd714dffaf597780f0b71673_touxiang7.jpg',1,NULL);

#
# Structure for table "pastscore"
#

DROP TABLE IF EXISTS `pastscore`;
CREATE TABLE `pastscore` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL DEFAULT '0',
  `score` int(11) DEFAULT NULL,
  `righttotal` int(11) DEFAULT NULL,
  `wrongtotal` int(11) DEFAULT NULL,
  `examtime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `FK5odh315kcceulboljsdr0crpq` (`userid`),
  CONSTRAINT `FK5odh315kcceulboljsdr0crpq` FOREIGN KEY (`userid`) REFERENCES `user` (`uid`),
  CONSTRAINT `user_pastscore_001` FOREIGN KEY (`userid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

#
# Data for table "pastscore"
#

INSERT INTO `pastscore` VALUES (1,3,70,14,6,'2019-03-26 09:19:12'),(2,5,70,14,6,'2019-03-26 09:22:57'),(3,5,50,10,10,'2019-03-26 09:29:31'),(4,5,90,18,2,'2019-03-26 17:05:28'),(5,5,95,19,1,'2019-03-26 17:11:06'),(6,5,95,19,1,'2019-03-26 17:47:31'),(7,3,15,3,17,'2019-03-26 17:51:14'),(8,3,15,3,17,'2019-03-26 18:03:01'),(9,3,10,2,18,'2019-03-26 18:06:35'),(10,3,30,6,14,'2019-03-26 18:16:10'),(11,3,0,0,20,'2019-03-26 18:19:27'),(12,3,5,1,19,'2019-03-26 18:25:30'),(13,3,15,3,17,'2019-03-27 08:45:27'),(14,5,0,0,20,'2019-03-27 09:18:30'),(15,8,15,3,17,'2019-03-28 21:06:53'),(16,11,45,9,11,'2019-03-28 21:48:46'),(17,13,20,4,16,'2019-03-30 13:53:41'),(18,13,10,2,18,'2019-03-30 13:55:10');

#
# Structure for table "wrongquestion"
#

DROP TABLE IF EXISTS `wrongquestion`;
CREATE TABLE `wrongquestion` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL DEFAULT '0',
  `qid` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`),
  KEY `FK7ofexcvn7foed9pq4vu2ddtgf` (`uid`),
  KEY `FK5gjsiuk6exojon997a2klrqlv` (`qid`),
  CONSTRAINT `FK5gjsiuk6exojon997a2klrqlv` FOREIGN KEY (`qid`) REFERENCES `questions` (`qid`),
  CONSTRAINT `FK7ofexcvn7foed9pq4vu2ddtgf` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`),
  CONSTRAINT `wrongquestion_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`),
  CONSTRAINT `wrongquestion_ibfk_2` FOREIGN KEY (`qid`) REFERENCES `questions` (`qid`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

#
# Data for table "wrongquestion"
#

INSERT INTO `wrongquestion` VALUES (1,5,33),(3,3,1),(4,3,34),(6,3,36),(7,3,26),(8,3,38),(9,3,6),(10,3,10),(11,3,18),(12,3,35),(14,3,8),(15,11,33),(16,11,2),(17,11,34),(18,13,64),(19,13,5),(20,13,47),(21,13,39);
