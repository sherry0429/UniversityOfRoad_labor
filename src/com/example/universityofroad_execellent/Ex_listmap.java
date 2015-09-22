package com.example.universityofroad_execellent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.universityofroad.R;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class Ex_listmap extends Activity {

	private ListView listView;
	List<String> data ;
	private Ex_adapter timelineAdapter;
    private List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	private Map<String, Object> map = new HashMap<String, Object>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ex_listmap);
		
		listView = (ListView) this.findViewById(R.id.listview);
		listView.setDividerHeight(0);//去除分割线
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
			}
			
		});
		//listView.setEnabled(false);//让item不可被点击（消除点击时间轴单元另一边空白会高亮的情况）
		timelineAdapter = new Ex_adapter(this, getData());
		listView.setAdapter(timelineAdapter);

	}

	private List<Map<String, Object>> getData() {
		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("Address", "这是第1行测试数据");
//		list.add(map);
//
//		map = new HashMap<String, Object>();
//		map.put("Address", "这是第2行测试数据");
//		list.add(map);
//
//		map = new HashMap<String, Object>();
//		map.put("Address", "这是第3行测试数据");
//		list.add(map);
//
//		map = new HashMap<String, Object>();
//		map.put("Address", "这是第4行测试数据");
//		list.add(map);
		StringFactory stringFactory  = new StringFactory();
		InsertItem(StringFactory.name_computer_organization, StringFactory.documetion_computer_organization, StringFactory.address_computer_organization, 
				StringFactory.classway_computer_organization, StringFactory.imageid_computer_organization);
		
		InsertItem(StringFactory.name_computereye, StringFactory.documetion_computereye, StringFactory.address_computereye, 
				StringFactory.classway_computereye, StringFactory.imageid_computereye);
		
		InsertItem(StringFactory.name_information_safe, StringFactory.documetion_information_safe, StringFactory.address_information_safe, 
				StringFactory.classway_information_safe, StringFactory.imageid_information_safe);
		
		InsertItem(StringFactory.name_internet_caculate, StringFactory.documetion_internet_caculate, StringFactory.address_internet_caculate, 
				StringFactory.classway_internet_caculate, StringFactory.imageid_internet_caculate);
		
		InsertItem(StringFactory.name_qianru, StringFactory.documetion_qianru, StringFactory.address_qianru, 
				StringFactory.classway_qianru, StringFactory.imageid_qianru);
		
		InsertItem(StringFactory.name_software, StringFactory.documetion_software, StringFactory.address_software, 
				StringFactory.classway_software, StringFactory.imageid_software);
		
		InsertItem(StringFactory.name_teach, StringFactory.documetion_teach, StringFactory.address_teach, 
				StringFactory.classway_teach, StringFactory.imageid_teach);
		
		InsertItem(StringFactory.name_vr, StringFactory.documetion_vr, StringFactory.address_vr, 
				StringFactory.classway_vr, StringFactory.imageid_vr);
		
		InsertItem(StringFactory.name_ACM, StringFactory.documetion_ACM, StringFactory.address_ACM, 
				StringFactory.classway_ACM, StringFactory.imageid_ACM);
		
		InsertItem(StringFactory.name_Cisco, StringFactory.documetion_Cisco, StringFactory.address_Cisco, 
				StringFactory.classway_Cisco, StringFactory.imageid_Cisco);
		
		InsertItem(StringFactory.name_Vtribe, StringFactory.documetion_Vtribe, StringFactory.address_Vtribe, 
				StringFactory.classway_Vtribe, StringFactory.imageid_Vtribe);
		
		InsertItem(StringFactory.name_SNERT, StringFactory.documetion_SNERT, StringFactory.address_SNERT, 
				StringFactory.classway_SNERT, StringFactory.imageid_SNERT);
		
		InsertItem(StringFactory.name_self, StringFactory.documetion_self, StringFactory.address_self, 
				StringFactory.classway_self, StringFactory.imageid_self);
		
		return list;
	}
	
	void InsertItem(String Name,String Documetion,String Address,String class_way, int Class_image){
		map = new HashMap<String, Object>();
		map.put("Name", Name);
		map.put("Documetion", Documetion);
		map.put("Address", Address);
		map.put("class_way", class_way);
		map.put("Class_image", Class_image);
		list.add(map);
	}
	
	private class StringFactory{

		//嵌入式
		static final String name_qianru = "嵌\n入\n式\n技\n术\n团\n队";
		static final String documetion_qianru = "嵌入式团队前身为西南科技大学计算机学院计算机应用教研室，" +
				"主要进行单片机、接口技术相关的教学和研发。随着嵌入式技术的迅速发展，" +
				"教研室人员的研究方向也开始转向高性能处理器相关的控制应用方面。2010年，学院实行教学、科研一体化团队制度，" +
				"将教师的课程教学与科研项目进行整合。嵌入式团队组建于此时。经过四年的发展，" +
				"团队教师队伍由成立之初的11名增长到18名，其中教授一名，副教授五名。团队重点关注将计算机技术、" +
				"计算机控制技术与生产、生活相互结合。从而提高生产的效率、提高生活品质。团队充分发挥各成员的自身特点和优势，" +
				"充分把握本学科前沿技术的发展趋势，不断提高团队教学、科研的综合实力。团队拥有省级重点实验室一个，" +
				"校级学生创新实践基地实验室一个，嵌入式软件研发、硬件焊接实验室多个。近几年，团队培养出的优秀本科生、" +
				"研究生多次在各类电子设计，嵌入式开发竞赛中获奖，毕业后也纷纷进入到企业、单位从事嵌入式相关的工作。" +
				"2009年起团队加大了科研与教学的结合力度，先后与绵阳长虹网络公司、绵阳美科电子设备有限公司等企业建立起了良好的合作关系，" +
				"为绵阳市地方经济建设和学校嵌入式学科的发展做出了积极的贡献。";
		static final String address_qianru = "东九  A260 A261";
		static final String classway_qianru = "研究方向：信息终端 嵌入式系统 嵌入式控制";
		static final int imageid_qianru = R.drawable.qianru1;
		
		//计算机系统结构
		static final String name_computer_organization = "计\n算\n机\n系\n统\n结\n构\n团\n队";
		static final String documetion_computer_organization = "团队主要承担全院计算机及其相关专业计算机组成原理、" +
				"计算机操作系统原理、计算机操作系统综合程序设计、汇编语言程序设计、微机原理及应用、" +
				"计算机系统结构等课程的教学工作以及教学改革，同时在计算机的基本原理和体系架构等方向开展科学研究和实践探索。" +
				"团队的教学和科研对于培养基础扎实的计算机专业技术人才具有举足轻重的作用。团队在建立多层次的计算机整机结构的同时，" +
				"不断扩展计算机的内涵和外延，将新的计算机体系结构，新的操作系统模式，" +
				"以及多核编程架构等方面的内容引入到教学和科研当中，完成团队教学和科研任务。" +
				"团队科学研究方向，主要包括：嵌入式系统设计，多核处理器与多核编程技术，无线通信网络，射频识别（RFID）技术，" +
				"物联网技术，并行体系结构，软件系统架构，语义Web，以及中文信息处理和知识挖掘等。";
		static final String address_computer_organization = "";
		static final String classway_computer_organization = "研究方向：系统结构 软件体系结构 语义web";
		static final int imageid_computer_organization = R.drawable.jisuanjixitongjiegou;
		
		//网络与高性能计算
		static final String name_internet_caculate = "网\n络\n与\n高\n性\n能\n计\n算\n团\n队";
		static final String documetion_internet_caculate = "西南科技大学计算机科学与技术学院网络与高性能计算团队是一个以网络、Linux/NC国家863项目实验室技术力量为背景，" +
				"结合西南科技大学计算机学院信息安全专业教师和研究人员组成的教学科研一体化团队。" +
				"在学术研究上，本团队专注于并行计算、大规模科学计算平台、网络工程和安全、三网融合以及分布式存储服务器集群；" +
				"在具体应用上，结合中国空气动力研究与发展中心科研合作项目，重点进行大规模流体力学数据的并行化处理、网格生成等工作。" +
				"近3年来，团队通过独自申请、校际合作、产学研等方式，正承担国家级科研项目1项，军地合作项目1项，地市级基金项目2项，" +
				"校级重点课题4项。 在科研成果方面，团队已完成国家863项目子课题“基于国产软硬件的网络教育关键技术的应用研究”的研究工作，" +
				"该项目鉴定为优秀并获四川省科技进步三等奖，团队共出版专著3本，发表学术论文近百篇。在成果转化和社会服务上，团队已获得专利1项，" +
				"软件著作权3项，并已完成适合于公交公司无人售票收款箱的系列产品，该专利成果正在积极转化。";
		static final String address_internet_caculate = "";
		static final String classway_internet_caculate = "研究方向：传感器网络 协议设计 并行计算";
		static final int imageid_internet_caculate = R.drawable.wangluoyugaoxingnengjisuan;
		
		//信息安全
		static final String name_information_safe = "信\n息\n安\n全\n团\n队";
		static final String documetion_information_safe = "西南科技大学信息安全团队成立于2004年，团队目前拥有教职员工13名，" +
				"其中教授1名，副教授2名，博士5名，在读博士5名。近年来，团队依托“省部共建特色优势学科实验室信息安全实验室”，" +
				"紧密围绕国家安全和国民经济建设的信息安全需求，逐步优化师资队伍，凝聚团队研究方向，形成了以网络攻防技术、密码算法及其应用、" +
				"网络安全测评、信息内容安全、安全协议与认证为特色的教学科研一体化团队。" +
				"团队主要承担计算机科学与技术学院信息安全专业理论和实践课程教学任务。近年来，团队先后承担和参与了863项目、" +
				"国家自然科学基金、四川省科技厅项目和四川省教育厅项目等多项科研项目。" +
				"团队成员在信息安全相关领域的核心期刊及国际会议公开发表论文七十余篇，其中多篇被SCI、EI检索。" +
				"信息安全团队热忱希望与国内外科研院所和高校开展合作交流，与高新技术企业合作开发信息安全产品，也希望有志于信息安全的同学加入！";
		static final String classway_information_safe = "研究方向：网络攻防 安全认证  病毒免疫";
		static final String address_information_safe = "";
		static final int imageid_information_safe = R.drawable.xinxianquan;
		
		
		//虚拟现实实验室
		static final String name_vr = "虚\n拟\n现\n实\n与\n仿\n真\n技\n术\n团\n队";
		static final String documetion_vr = "虚拟现实与仿真技术研究室依托西南科技大学计算机科学与技术学院，" +
				"是西南科技大学董事单位共建研究实验室。研究室以“产学研用”的发展思路，" +
				"以求实、发展、竞争与开放的精神，" +
				"在计算机图形学、图像及视频处理、人机交互、人工智能等领域开展科学研究工作和硕士研究生培养工作。" +
				"并通过与控制、材料、物理、数学等不同学科方向的合作、交叉，" +
				"开展虚拟现实基础、应用基础、关键技术方面的原始创新和集成创新。" +
				"近年来研究室承担和参与了包括国家863计划、国家自然科学基金、国防科技计划纵向科研项目在内的多项科研项目。" +
				"通过上述科研项目的研究，取得一系列理论和技术创新成果，在国内外著名学术刊物和学术会议发表学术论文数十篇，" +
				"多项成果获得软件著作权和发明专利。研究室经过多年的科研发展和积累，" +
				"在图像图形处理技术、虚拟现实技术、科学计算可视化等方面形成了一定的特色和优势。";
		static final String classway_vr = "研究方向：虚拟现实 物理过程仿真 媒体技术\n" +
				"研究室：\n" +
				"（1）人机交互研究室：东九 A228\n" +
				"（2）可视化研究室：东九 A245\n" +
				"（3）图像处理：东九 A420\n";
		static final String address_vr = "";
		static final int imageid_vr = R.drawable.vr1;
		
		//知识工程与教育技术团队
		static final String name_teach = "知\n识\n工\n程\n与\n教\n育\n技\n术\n团\n队";
		static final String documetion_teach = "知识工程与教育技术团队是在原知识工程团队及学院教育技术学硕士点的基础上，" +
				"于2010年成立的集科学研究、教学和学生科技活动的一体化团队。" +
				" 团队长期致力数据工程与知识工程相关研究开发工作，1999年开发的金融债务清算系统，挽回经济损失1.2亿；" +
				"2002年开发人事工资管理系统在100余家事业单位推广应用；2004年开发的基于Linux/NC的教育系统在2006年获得四川省科学科技进步三 等奖。" +
				"在这期间，还为企事业单位开发了众多的应用软件，拥有发明专利1项，登记软件著作权12项，" +
				"承担了多项国家级、省部级项目。通过与企事业单位的长期合作与积累，团队形成了互联网信息挖掘与应用、Web新技术应用、教育技术学三个研究方向，" +
				"主要围绕数据与知识的获取、管理、保存、服务方面开展应用基础研究及系列产品的研发工作，" +
				"包括互联网络信息挖掘与应用、移动互联网、企业级平台架构及应用开发、教育软件研发、网络教学设计、" +
				"教育管理技术等。目前团队有固定研究人员19人，其中教授4人，副教授4人，博士3人，在读研究生10余名。";
		static final String classway_teach = "研究方向：数据挖掘 知识集成 教育软件\n" +
				"研究室：\n" +
				"（1）数据与知识工程研究室（ 东九2-17、19），联系人：杨春明（13881194177）E-Mail：yangchunming[at]swust.edu.cn\n" +
				"（2）语义计算与数据挖掘研究室（东九2-48）\n" +
				"（3）教育技术综合研究室（东九2-03），联系人：张广兵（15883780706）E-Mail：zhangguangbing[at]swust.edu.cn\n" +
				"（4）网络教育技术研究室（ 东九2-71）\n";
		static final String address_teach = "";
		static final int imageid_teach = R.drawable.zhishigongcheng;
		
		
		//计算机软件与理论
		static final String name_software = "计\n算\n机\n软\n件\n与\n理\n论\n团\n队";
		static final String documetion_software = "计算机软件与理论是指由计算机科学理论和研究、开发计算机软件所涉及的理论、" +
				"方法、技术所构成的学科，是信息科学的核心研究领域之一，是计算机学科用来为国民经济、国防建设、" +
				"人民生活服务的工具和基础。计算机软件与理论团队是以西南科技大学计算机应用技术省级重点学科为依托，" +
				"顺应当代计算机软件开发工程化的发展趋势，集科学研究、教学和学生科技活动的一体化团队。团队现有教师9人，" +
				"教授1人、副教授3人，博士4人。团队将进一步深入推进个人发展和学院发展一体化、教学和科研一体化、" +
				"教师发展和学生成长一体化等工作，促进团队教学科研水平和人才培养质量再上一个新台阶。";
		static final String address_software = "";
		static final String classway_software = "研究方向：软件测试 分布式计算 数值计算";
		static final int imageid_software = R.drawable.software;
		
		
		//机器视觉
		static final String name_computereye = "机\n器\n视\n觉\n团\n队";
		static final String documetion_computereye = "机器视觉团队组建于2006年10月，主要研究人员由计算机应用技术、光学和机电等专业教师和研究生组成，" +
				"并接收优秀本科生参与实验室科研项目。团队现有视频图像分析理解、质量检测、软件测试、移动互联网4个研究小组，" +
				"主要开展自动目标识别分析、产品质量检测及软件测试、移动互联网技术等方面的研究和产品开发，" +
				"与与中国工程物理研究院激光聚变研究中心、中电集团重庆44所等科研和企事业单位形成了良好的合作关系。近三年，" +
				"团队成功制了大口径光学组件面形检测系统、光学组件表面疵病检测系统、高精度空间定位等系统；" +
				"承担了包括国家自然科学基金在内的各类研究项目十余项，在国内外核心期刊上发表论文40余篇，" +
				"获得发明专利4项、申请10项，获得软件著作权4项。";
		static final String address_computereye = "";
		static final String classway_computereye = "团队研究方向\n:" +
				"（1）机器视觉应用：主要运用图像处理、图像理解、光学测量、高精度运动控制等机器视觉技术解决光学元件加工、印刷和机械制造等行业的产品质量检测问题。\n" +
				"（2）机器视觉基础：主要研究机器视觉的基础理论，主要针对高精度的空间测量、摄像机标定和图像理解等问题。\n" +
				"（3）自动目标识别：主要针对可视、红外图像序列等多源数据，研究图像融合、运动目标检测与跟踪等问题。\n" +
				"（4）软件测试：主要开展软件自动化测试方面的研究工作。同时，为企事业软件产品及团队相关软件系统实施测试，提供质量保障。\n地址：”东九B217，东六E 101\n" +
				"（5）移动互联网：主要开展互联网技术，Android、iOS及Windows Phone智能移动操作平台应用研发，为企事业单位提供移动信息化平台完整的解决方案和服务支持。\n地址：东九 A240\n";
		static final int imageid_computereye = R.drawable.jiqishijue1;
		
		//ACM
		static final String name_ACM = "A\nC\nM\n团\n队";
		static final String documetion_ACM = "西南科技大学ACM/ICPC大学生程序设计竞赛团队是一个有学生梯度、教练指导的团队。" +
				"通过提供一系列的交流渠道、程序设计讲座，依托程序设计竞赛，旨在提高西南科技大学学生程序设计的能力。" +
				"团队目前已经成功举办了六届西南科技大学程序设计大赛，同时，每月还举办计算机科学与技术学院程序设计大赛。" +
				"团队成立以来，多次代表学校参加各类、各级别的程序设计竞赛（如：ACM/ICPC亚洲区域赛，百度杯（百度之星），" +
				"Google Code，TopCoder等），取得了ACM合肥区预赛铜奖，四川省程序设计大赛二等奖等优异成绩。" +
				"团队自主开发的程序设计在线测评系统（Judge Online）不仅为学校各类程序设计竞赛提供了平台，" +
				"而且为计算机学院程序设计类课程提供了的实验平台，广泛地适用于程序设计类课程的实验教学环节。" +
				"目前采用这套系统的课程包括：C语言程序设计，C/C++程序设计，数据结构，算法与程序设计。";
		static final String address_ACM = "acm.swust.edu.cn";
		static final String classway_ACM = "团队宗旨：提高广大学生的编程能力，在学校内营造良好的程序设计学习氛围。坚持组织常规的月赛和每年的程序设计校赛，组织参与高水平的竞赛。";
		static final int imageid_ACM = 0;
		
		//SNERT
		static final String name_SNERT = "S\nN\nE\nR\nT\n团\n队";
		static final String documetion_SNERT = "为了提高学生在信息安全方面的实际动手能力，" +
				"学院于2007年8月组建了一个以学生为主的“西南科技大学校园网络应急响应小组（SWUST Net Emergency Response Team，简称为SNERT）”，" +
				"旨在为学生提供一个实践环境，提高学生的动手能力、团队精神以及创新能力，探索具有西南科技大学特色的信息安全专业的培养方案，" +
				"小组的主要活动包括：校园网络的安全服务、网络安全相关项目的开发、校内外竞赛组织等。";
		static final String address_SNERT = "";
		static final String classway_SNERT = "";
		static final int imageid_SNERT = 0;
		
		//Cisco
		static final String name_Cisco = "思\n科\n网\n络\n团\n队";
		static final String documetion_Cisco = "计算机科学与技术学院思科网络团队成立于2009年5月，" +
				"以思科网络技术学院为基础，以CCNA和CCNP的考取为依托，是由指导老师牵头，学生自行组织管理的一个计算机网络学习型团队。" +
				"团队现有指导老师2名，各年级学生40名。团队本着提高学生动手能力和自我学习能力，推动学生科技活动的发展的宗旨，" +
				"为广大学生提供了一个良好的学习平台，思科网络团队各项工作得到了计算机科学与技术学院各级领导的大力支持。" +
				"思科网络团队提供了相关硬件设备，实验室共有H3C、华为、港湾路由器、交换机30余台，PC机 40余台，" +
				"Cisco2800系列路由器6台，Cisco2960系列交换机3台，福禄克网线测试仪1台，所有设备价值共计200余万。" +
				"另外，为了方便团队的日常管理和运行，团队还制定了《思科网络学习团队管理规章制度》，制度中对安全管理，" +
				"实验设备管理和学生实验管理作了明确规定。明确了实验设备申请流程，并要求完善实验后的实验报告及拓扑存档，" +
				"方便团队成员后来的继续学习。 ";
		static final String address_Cisco = "";
		static final String classway_Cisco = "";
		static final int imageid_Cisco = 0;
		
		//V-tribe
		static final String name_Vtribe = "V\nT\nr\ni\nb\ne\n视\n觉\n团\n队";
		static final String documetion_Vtribe = "V-tribe视觉团队，是西南科技大学的一支具有创新精神和团队理念的团队，" +
				"主要研究方向是视频制作，同时发展制作海报、图像处理、动画制作、三维建模、音乐剪辑等各种能力，" +
				"团队主打项目为：AE、3ds Max、Ps、Flash、Pr、威力导演。" +
				"我们的团队就是为有志于爱好视频制作和平面设计的同学提供一个学习、锻炼、交流的平台，" +
				"用视频记录时代、记录生活，记录成长足迹，让他们在团队中尽情享受视频创作带来的乐趣，" +
				"不虚度大学光阴，燃烧他们的创作热情。我们团队由起步到成熟这一努力和坚持的过程中，" +
				"不仅为本学院的各种活动进行视频宣传，取得了意想不到的好的效果，而且我们还面向全校、面向外界的一切活动需要，" +
				"这使得我们团队达到了一个质的飞跃，成为了西南科技大学的一支独具特色的视觉团队。";
		static final String address_Vtribe = "";
		static final String classway_Vtribe = "";
		static final int imageid_Vtribe = 0;
		
		
		//表单介绍
		static final String name_self = "写\n在\n最\n后";
		static final String documetion_self = "因为团队人手有限，所以肯定没有办法搜罗到西科所有的团队，实验室等等，" +
				"因此我们希望大家可以帮我们一起搜集，我们会尽快把搜集到的数据放到这个列表里，" +
				"如果觉得已有信息不够翔实或需要更新，一样可以来信哈！" +
				"大家可以用以下格式：\n\n" +
				"实验室/团队 名称：\n" +
				"实验室/团队 介绍：\n" +
				"实验室/团队 联系地址或联系方式：\n" +
				"实验室/团队 主攻方向：\n" +
				"实验室/团队 宣传图片：\n\n" +
				"用上述格式写下团队或实验室信息，发送邮件至380881937@qq.com，并留下联系方式，" +
				"我们会尽快将信息核实后发布在这个列表中！";
		static final String address_self = "谢谢大家~";
		static final String classway_self = "";
		static final int imageid_self = 0;
	}
	

}
