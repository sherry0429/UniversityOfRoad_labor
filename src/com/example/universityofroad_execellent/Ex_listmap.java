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
		InsertItem(StringFactory.name_vr, StringFactory.documetion_vr, StringFactory.address_vr, 
				StringFactory.classway_vr, StringFactory.imageid_vr);
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
		
		//虚拟现实实验室
		static final String name_vr = "虚\n拟\n现\n实\n与\n仿\n真\n技\n术\n研\n究\n室";
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
		static final String classway_vr = "专业领域：可视化 人机交互 虚拟现实";
		static final String address_vr = "2-23 2-28 2-45";
		static final int imageid_vr = R.drawable.vr1;
		
		//嵌入式
		static final String name_qianru = "嵌\n入\n式\n实\n验\n室";
		static final String documetion_qianru = "实验室主要进行计算机控制技术和嵌入式系统技术的研究，" +
				"面向行业应用的嵌入式系统为主要目标。立足于汽车电子，数控机床，医疗设备，物联网技术，" +
				"核监测技术等相关行业，研究内容涉及嵌入式基础平台，嵌入式实时操作系统，嵌入式中间件软件开发，" +
				"设备驱动开发。本实验室拥有完善的高端ARM嵌入式开发系统，功能强大的DSP开发平台和FPGA开发平台， " +
				"其中部分开发平台属完全自主开发。拥有完整的硬件开发验证设备，包括BGA器件焊接平台，" +
				"拆焊台，数字存储示波器，任意波形信号发生器，逻辑分析仪，LCR测试仪，高精密数字电源，高温实验箱等。";
		static final String address_qianru = "";
		static final String classway_qianru = "专业领域：单片机";
		static final int imageid_qianru = 0;
		
		//机器视觉
		static final String name_computereye = "机\n器\n视\n觉\n实\n验\n室";
		static final String documetion_computereye = "西南科技大学机器视觉实验室是一个以计算机应用技术、" +
				"机器视觉和光学工程等为基础，以解决产品缺陷检测、自动目标识别和多源图像信息融合中的技术问题为主要研究方向的跨学科科研实验室。" +
				"实验室以西南科技大学计算机应用技术省级重点学科为依托，顺应当代计算机和视觉技术工程化的发展趋势，" +
				"结合我国产品缺陷检测、智能监控和国家重大科研项目的发展需要，" +
				"开展机器视觉技术及相关领域的应用基础研究、以及新技术、新产品的开发。";
		static final String address_computereye = "";
		static final String classway_computereye = "专业领域：OpenCV";
		static final int imageid_computereye = 0;
		
		//网络技术
		static final String name_internetskill = "网\n络\n技\n术\n与\n分\n布\n式\n计\n算\n实\n验\n室";
		static final String documetion_internetskill = "网络技术与分布式计算实验室前身是2003年计算机学院所承担国家863项目所建立的研究性实验室-Linux/NC实验室，" +
				"现有实验室面积200平方米，仪器设备总值100余万元。" +
				"目前主要的研究方向包括基于开源软件软件的集群构建、并行计算、存储服务器集群、分布式存储系统、网络性能测试等。" +
				"该学科在基于开源软件软件的集群构建、复杂生物和医学问题的并行求解等领域取得了一些有影响力的研究成果，" +
				"目前实验室正处在研究方向和研究人员相对固定的稳步上升阶段。";
		static final String address_internetskill = "";
		static final String classway_internetskill = "专业领域：网络技术";
		static final int imageid_internetskill = 0;
		
		//表单介绍
		static final String name_self = "写\n在\n最\n后";
		static final String documetion_self = "因为团队人手有限，所以肯定没有办法搜罗到西科所有的团队，实验室等等，" +
				"因此我们希望大家可以帮我们一起搜集，我们会尽快把搜集到的数据放到这个列表里，" +
				"大家可以用以下格式：\n\n" +
				"实验室/团队 名称：\n" +
				"实验室/团队 介绍：\n" +
				"实验室/团队 联系地址或联系方式：\n" +
				"实验室/团队 主攻方向：\n" +
				"实验室/团队 宣传图片：\n\n" +
				"用上述格式写下团队或实验室信息，发送邮件至380881937@qq.com，并留下联系方式，" +
				"我们会尽快将信息核实后发布在这个列表中！";
		static final String address_self = "谢谢大家~";
		static final String classway_self = "By.我就是妖怪  呐~只有虚拟现实实验室就是因为，我在这个实验室辣~";
		static final int imageid_self = R.drawable.monster_icon;
	}
	

}
