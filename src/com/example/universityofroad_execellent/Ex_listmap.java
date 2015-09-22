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
		listView.setDividerHeight(0);//ȥ���ָ���
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
			}
			
		});
		//listView.setEnabled(false);//��item���ɱ�������������ʱ���ᵥԪ��һ�߿հ׻�����������
		timelineAdapter = new Ex_adapter(this, getData());
		listView.setAdapter(timelineAdapter);

	}

	private List<Map<String, Object>> getData() {
		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("Address", "���ǵ�1�в�������");
//		list.add(map);
//
//		map = new HashMap<String, Object>();
//		map.put("Address", "���ǵ�2�в�������");
//		list.add(map);
//
//		map = new HashMap<String, Object>();
//		map.put("Address", "���ǵ�3�в�������");
//		list.add(map);
//
//		map = new HashMap<String, Object>();
//		map.put("Address", "���ǵ�4�в�������");
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

		//Ƕ��ʽ
		static final String name_qianru = "Ƕ\n��\nʽ\n��\n��\n��\n��";
		static final String documetion_qianru = "Ƕ��ʽ�Ŷ�ǰ��Ϊ���ϿƼ���ѧ�����ѧԺ�����Ӧ�ý����ң�" +
				"��Ҫ���е�Ƭ�����ӿڼ�����صĽ�ѧ���з�������Ƕ��ʽ������Ѹ�ٷ�չ��" +
				"��������Ա���о�����Ҳ��ʼת������ܴ�������صĿ���Ӧ�÷��档2010�꣬ѧԺʵ�н�ѧ������һ�廯�Ŷ��ƶȣ�" +
				"����ʦ�Ŀγ̽�ѧ�������Ŀ�������ϡ�Ƕ��ʽ�Ŷ��齨�ڴ�ʱ����������ķ�չ��" +
				"�Ŷӽ�ʦ�����ɳ���֮����11��������18�������н���һ�����������������Ŷ��ص��ע�������������" +
				"��������Ƽ����������������໥��ϡ��Ӷ����������Ч�ʡ��������Ʒ�ʡ��Ŷӳ�ַ��Ӹ���Ա�������ص�����ƣ�" +
				"��ְ��ձ�ѧ��ǰ�ؼ����ķ�չ���ƣ���������Ŷӽ�ѧ�����е��ۺ�ʵ�����Ŷ�ӵ��ʡ���ص�ʵ����һ����" +
				"У��ѧ������ʵ������ʵ����һ����Ƕ��ʽ����з���Ӳ������ʵ���Ҷ���������꣬�Ŷ������������㱾������" +
				"�о�������ڸ��������ƣ�Ƕ��ʽ���������л񽱣���ҵ��Ҳ�׷׽��뵽��ҵ����λ����Ƕ��ʽ��صĹ�����" +
				"2009�����ŶӼӴ��˿������ѧ�Ľ�����ȣ��Ⱥ��������������繫˾���������Ƶ����豸���޹�˾����ҵ�����������õĺ�����ϵ��" +
				"Ϊ�����еط����ý����ѧУǶ��ʽѧ�Ƶķ�չ�����˻����Ĺ��ס�";
		static final String address_qianru = "����  A260 A261";
		static final String classway_qianru = "�о�������Ϣ�ն� Ƕ��ʽϵͳ Ƕ��ʽ����";
		static final int imageid_qianru = R.drawable.qianru1;
		
		//�����ϵͳ�ṹ
		static final String name_computer_organization = "��\n��\n��\nϵ\nͳ\n��\n��\n��\n��";
		static final String documetion_computer_organization = "�Ŷ���Ҫ�е�ȫԺ������������רҵ��������ԭ��" +
				"���������ϵͳԭ�����������ϵͳ�ۺϳ�����ơ�������Գ�����ơ�΢��ԭ��Ӧ�á�" +
				"�����ϵͳ�ṹ�ȿγ̵Ľ�ѧ�����Լ���ѧ�ĸͬʱ�ڼ�����Ļ���ԭ�����ϵ�ܹ��ȷ���չ��ѧ�о���ʵ��̽����" +
				"�ŶӵĽ�ѧ�Ϳ��ж�������������ʵ�ļ����רҵ�����˲ž��о������ص����á��Ŷ��ڽ������εļ���������ṹ��ͬʱ��" +
				"������չ��������ں������ӣ����µļ������ϵ�ṹ���µĲ���ϵͳģʽ��" +
				"�Լ���˱�̼ܹ��ȷ�����������뵽��ѧ�Ϳ��е��У�����Ŷӽ�ѧ�Ϳ�������" +
				"�Ŷӿ�ѧ�о�������Ҫ������Ƕ��ʽϵͳ��ƣ���˴��������˱�̼���������ͨ�����磬��Ƶʶ��RFID��������" +
				"������������������ϵ�ṹ�����ϵͳ�ܹ�������Web���Լ�������Ϣ�����֪ʶ�ھ�ȡ�";
		static final String address_computer_organization = "";
		static final String classway_computer_organization = "�о�����ϵͳ�ṹ �����ϵ�ṹ ����web";
		static final int imageid_computer_organization = R.drawable.jisuanjixitongjiegou;
		
		//����������ܼ���
		static final String name_internet_caculate = "��\n��\n��\n��\n��\n��\n��\n��\n��\n��";
		static final String documetion_internet_caculate = "���ϿƼ���ѧ�������ѧ�뼼��ѧԺ����������ܼ����Ŷ���һ�������硢Linux/NC����863��Ŀʵ���Ҽ�������Ϊ������" +
				"������ϿƼ���ѧ�����ѧԺ��Ϣ��ȫרҵ��ʦ���о���Ա��ɵĽ�ѧ����һ�廯�Ŷӡ�" +
				"��ѧ���о��ϣ����Ŷ�רע�ڲ��м��㡢���ģ��ѧ����ƽ̨�����繤�̺Ͱ�ȫ�������ں��Լ��ֲ�ʽ�洢��������Ⱥ��" +
				"�ھ���Ӧ���ϣ�����й����������о��뷢չ���Ŀ��к�����Ŀ���ص���д��ģ������ѧ���ݵĲ��л������������ɵȹ�����" +
				"��3�������Ŷ�ͨ���������롢У�ʺ�������ѧ�еȷ�ʽ�����е����Ҽ�������Ŀ1����غ�����Ŀ1����м�������Ŀ2�" +
				"У���ص����4� �ڿ��гɹ����棬�Ŷ�����ɹ���863��Ŀ�ӿ��⡰���ڹ�����Ӳ������������ؼ�������Ӧ���о������о�������" +
				"����Ŀ����Ϊ���㲢���Ĵ�ʡ�Ƽ��������Ƚ����Ŷӹ�����ר��3��������ѧ�����Ľ���ƪ���ڳɹ�ת�����������ϣ��Ŷ��ѻ��ר��1�" +
				"�������Ȩ3���������ʺ��ڹ�����˾������Ʊ�տ����ϵ�в�Ʒ����ר���ɹ����ڻ���ת����";
		static final String address_internet_caculate = "";
		static final String classway_internet_caculate = "�о����򣺴��������� Э����� ���м���";
		static final int imageid_internet_caculate = R.drawable.wangluoyugaoxingnengjisuan;
		
		//��Ϣ��ȫ
		static final String name_information_safe = "��\nϢ\n��\nȫ\n��\n��";
		static final String documetion_information_safe = "���ϿƼ���ѧ��Ϣ��ȫ�Ŷӳ�����2004�꣬�Ŷ�Ŀǰӵ�н�ְԱ��13����" +
				"���н���1����������2������ʿ5�����ڶ���ʿ5�������������Ŷ����С�ʡ��������ɫ����ѧ��ʵ������Ϣ��ȫʵ���ҡ���" +
				"����Χ�ƹ��Ұ�ȫ�͹��񾭼ý������Ϣ��ȫ�������Ż�ʦ�ʶ��飬�����Ŷ��о������γ��������繥�������������㷨����Ӧ�á�" +
				"���簲ȫ��������Ϣ���ݰ�ȫ����ȫЭ������֤Ϊ��ɫ�Ľ�ѧ����һ�廯�Ŷӡ�" +
				"�Ŷ���Ҫ�е��������ѧ�뼼��ѧԺ��Ϣ��ȫרҵ���ۺ�ʵ���γ̽�ѧ���񡣽��������Ŷ��Ⱥ�е��Ͳ�����863��Ŀ��" +
				"������Ȼ��ѧ�����Ĵ�ʡ�Ƽ�����Ŀ���Ĵ�ʡ��������Ŀ�ȶ��������Ŀ��" +
				"�Ŷӳ�Ա����Ϣ��ȫ�������ĺ����ڿ������ʻ��鹫������������ʮ��ƪ�����ж�ƪ��SCI��EI������" +
				"��Ϣ��ȫ�Ŷ��ȳ�ϣ������������Ժ���͸�У��չ��������������¼�����ҵ����������Ϣ��ȫ��Ʒ��Ҳϣ����־����Ϣ��ȫ��ͬѧ���룡";
		static final String classway_information_safe = "�о��������繥�� ��ȫ��֤  ��������";
		static final String address_information_safe = "";
		static final int imageid_information_safe = R.drawable.xinxianquan;
		
		
		//������ʵʵ����
		static final String name_vr = "��\n��\n��\nʵ\n��\n��\n��\n��\n��\n��\n��";
		static final String documetion_vr = "������ʵ����漼���о����������ϿƼ���ѧ�������ѧ�뼼��ѧԺ��" +
				"�����ϿƼ���ѧ���µ�λ�����о�ʵ���ҡ��о����ԡ���ѧ���á��ķ�չ˼·��" +
				"����ʵ����չ�������뿪�ŵľ���" +
				"�ڼ����ͼ��ѧ��ͼ����Ƶ�����˻��������˹����ܵ�����չ��ѧ�о�������˶ʿ�о�������������" +
				"��ͨ������ơ����ϡ�������ѧ�Ȳ�ͬѧ�Ʒ���ĺ��������棬" +
				"��չ������ʵ������Ӧ�û������ؼ����������ԭʼ���ºͼ��ɴ��¡�" +
				"�������о��ҳе��Ͳ����˰�������863�ƻ���������Ȼ��ѧ���𡢹����Ƽ��ƻ����������Ŀ���ڵĶ��������Ŀ��" +
				"ͨ������������Ŀ���о���ȡ��һϵ�����ۺͼ������³ɹ����ڹ���������ѧ�������ѧ�����鷢��ѧ��������ʮƪ��" +
				"����ɹ�����������Ȩ�ͷ���ר�����о��Ҿ�������Ŀ��з�չ�ͻ��ۣ�" +
				"��ͼ��ͼ�δ�������������ʵ��������ѧ������ӻ��ȷ����γ���һ������ɫ�����ơ�";
		static final String classway_vr = "�о�����������ʵ ������̷��� ý�弼��\n" +
				"�о��ң�\n" +
				"��1���˻������о��ң����� A228\n" +
				"��2�����ӻ��о��ң����� A245\n" +
				"��3��ͼ�������� A420\n";
		static final String address_vr = "";
		static final int imageid_vr = R.drawable.vr1;
		
		//֪ʶ��������������Ŷ�
		static final String name_teach = "֪\nʶ\n��\n��\n��\n��\n��\n��\n��\n��\n��";
		static final String documetion_teach = "֪ʶ��������������Ŷ�����ԭ֪ʶ�����ŶӼ�ѧԺ��������ѧ˶ʿ��Ļ����ϣ�" +
				"��2010������ļ���ѧ�о�����ѧ��ѧ���Ƽ����һ�廯�Ŷӡ�" +
				" �Ŷӳ����������ݹ�����֪ʶ��������о�����������1999�꿪���Ľ���ծ������ϵͳ����ؾ�����ʧ1.2�ڣ�" +
				"2002�꿪�����¹��ʹ���ϵͳ��100�����ҵ��λ�ƹ�Ӧ�ã�2004�꿪���Ļ���Linux/NC�Ľ���ϵͳ��2006�����Ĵ�ʡ��ѧ�Ƽ������� �Ƚ���" +
				"�����ڼ䣬��Ϊ����ҵ��λ�������ڶ��Ӧ�������ӵ�з���ר��1��Ǽ��������Ȩ12�" +
				"�е��˶�����Ҽ���ʡ������Ŀ��ͨ��������ҵ��λ�ĳ��ں�������ۣ��Ŷ��γ��˻�������Ϣ�ھ���Ӧ�á�Web�¼���Ӧ�á���������ѧ�����о�����" +
				"��ҪΧ��������֪ʶ�Ļ�ȡ���������桢�����濪չӦ�û����о���ϵ�в�Ʒ���з�������" +
				"��������������Ϣ�ھ���Ӧ�á��ƶ�����������ҵ��ƽ̨�ܹ���Ӧ�ÿ�������������з��������ѧ��ơ�" +
				"�����������ȡ�Ŀǰ�Ŷ��й̶��о���Ա19�ˣ����н���4�ˣ�������4�ˣ���ʿ3�ˣ��ڶ��о���10������";
		static final String classway_teach = "�о����������ھ� ֪ʶ���� �������\n" +
				"�о��ң�\n" +
				"��1��������֪ʶ�����о��ң� ����2-17��19������ϵ�ˣ������13881194177��E-Mail��yangchunming[at]swust.edu.cn\n" +
				"��2����������������ھ��о��ң�����2-48��\n" +
				"��3�����������ۺ��о��ң�����2-03������ϵ�ˣ��Ź����15883780706��E-Mail��zhangguangbing[at]swust.edu.cn\n" +
				"��4��������������о��ң� ����2-71��\n";
		static final String address_teach = "";
		static final int imageid_teach = R.drawable.zhishigongcheng;
		
		
		//��������������
		static final String name_software = "��\n��\n��\n��\n��\n��\n��\n��\n��\n��";
		static final String documetion_software = "����������������ָ�ɼ������ѧ���ۺ��о������������������漰�����ۡ�" +
				"���������������ɵ�ѧ�ƣ�����Ϣ��ѧ�ĺ����о�����֮һ���Ǽ����ѧ������Ϊ���񾭼á��������衢" +
				"�����������Ĺ��ߺͻ��������������������Ŷ��������ϿƼ���ѧ�����Ӧ�ü���ʡ���ص�ѧ��Ϊ���У�" +
				"˳Ӧ�������������������̻��ķ�չ���ƣ�����ѧ�о�����ѧ��ѧ���Ƽ����һ�廯�Ŷӡ��Ŷ����н�ʦ9�ˣ�" +
				"����1�ˡ�������3�ˣ���ʿ4�ˡ��Ŷӽ���һ�������ƽ����˷�չ��ѧԺ��չһ�廯����ѧ�Ϳ���һ�廯��" +
				"��ʦ��չ��ѧ���ɳ�һ�廯�ȹ������ٽ��Ŷӽ�ѧ����ˮƽ���˲�������������һ����̨�ס�";
		static final String address_software = "";
		static final String classway_software = "�о������������ �ֲ�ʽ���� ��ֵ����";
		static final int imageid_software = R.drawable.software;
		
		
		//�����Ӿ�
		static final String name_computereye = "��\n��\n��\n��\n��\n��";
		static final String documetion_computereye = "�����Ӿ��Ŷ��齨��2006��10�£���Ҫ�о���Ա�ɼ����Ӧ�ü�������ѧ�ͻ����רҵ��ʦ���о�����ɣ�" +
				"���������㱾��������ʵ���ҿ�����Ŀ���Ŷ�������Ƶͼ�������⡢������⡢������ԡ��ƶ�������4���о�С�飬" +
				"��Ҫ��չ�Զ�Ŀ��ʶ���������Ʒ������⼰������ԡ��ƶ������������ȷ�����о��Ͳ�Ʒ������" +
				"�����й����������о�Ժ����۱��о����ġ��е缯������44���ȿ��к�����ҵ��λ�γ������õĺ�����ϵ�������꣬" +
				"�Ŷӳɹ����˴�ھ���ѧ������μ��ϵͳ����ѧ�������ò����ϵͳ���߾��ȿռ䶨λ��ϵͳ��" +
				"�е��˰���������Ȼ��ѧ�������ڵĸ����о���Ŀʮ����ڹ���������ڿ��Ϸ�������40��ƪ��" +
				"��÷���ר��4�����10�����������Ȩ4�";
		static final String address_computereye = "";
		static final String classway_computereye = "�Ŷ��о�����\n:" +
				"��1�������Ӿ�Ӧ�ã���Ҫ����ͼ����ͼ����⡢��ѧ�������߾����˶����ƵȻ����Ӿ����������ѧԪ���ӹ���ӡˢ�ͻ�е�������ҵ�Ĳ�Ʒ����������⡣\n" +
				"��2�������Ӿ���������Ҫ�о������Ӿ��Ļ������ۣ���Ҫ��Ը߾��ȵĿռ������������궨��ͼ���������⡣\n" +
				"��3���Զ�Ŀ��ʶ����Ҫ��Կ��ӡ�����ͼ�����еȶ�Դ���ݣ��о�ͼ���ںϡ��˶�Ŀ��������ٵ����⡣\n" +
				"��4��������ԣ���Ҫ��չ����Զ������Է�����о�������ͬʱ��Ϊ����ҵ�����Ʒ���Ŷ�������ϵͳʵʩ���ԣ��ṩ�������ϡ�\n��ַ��������B217������E 101\n" +
				"��5���ƶ�����������Ҫ��չ������������Android��iOS��Windows Phone�����ƶ�����ƽ̨Ӧ���з���Ϊ����ҵ��λ�ṩ�ƶ���Ϣ��ƽ̨�����Ľ�������ͷ���֧�֡�\n��ַ������ A240\n";
		static final int imageid_computereye = R.drawable.jiqishijue1;
		
		//ACM
		static final String name_ACM = "A\nC\nM\n��\n��";
		static final String documetion_ACM = "���ϿƼ���ѧACM/ICPC��ѧ��������ƾ����Ŷ���һ����ѧ���ݶȡ�����ָ�����Ŷӡ�" +
				"ͨ���ṩһϵ�еĽ���������������ƽ��������г�����ƾ�����ּ��������ϿƼ���ѧѧ��������Ƶ�������" +
				"�Ŷ�Ŀǰ�Ѿ��ɹ��ٰ����������ϿƼ���ѧ������ƴ�����ͬʱ��ÿ�»��ٰ�������ѧ�뼼��ѧԺ������ƴ�����" +
				"�Ŷӳ�����������δ���ѧУ�μӸ��ࡢ������ĳ�����ƾ������磺ACM/ICPC�������������ٶȱ����ٶ�֮�ǣ���" +
				"Google Code��TopCoder�ȣ���ȡ����ACM�Ϸ���Ԥ��ͭ�����Ĵ�ʡ������ƴ������Ƚ�������ɼ���" +
				"�Ŷ����������ĳ���������߲���ϵͳ��Judge Online������ΪѧУ���������ƾ����ṩ��ƽ̨��" +
				"����Ϊ�����ѧԺ���������γ��ṩ�˵�ʵ��ƽ̨���㷺�������ڳ��������γ̵�ʵ���ѧ���ڡ�" +
				"Ŀǰ��������ϵͳ�Ŀγ̰�����C���Գ�����ƣ�C/C++������ƣ����ݽṹ���㷨�������ơ�";
		static final String address_ACM = "acm.swust.edu.cn";
		static final String classway_ACM = "�Ŷ���ּ����߹��ѧ���ı����������ѧУ��Ӫ�����õĳ������ѧϰ��Χ�������֯�����������ÿ��ĳ������У������֯�����ˮƽ�ľ�����";
		static final int imageid_ACM = 0;
		
		//SNERT
		static final String name_SNERT = "S\nN\nE\nR\nT\n��\n��";
		static final String documetion_SNERT = "Ϊ�����ѧ������Ϣ��ȫ�����ʵ�ʶ���������" +
				"ѧԺ��2007��8���齨��һ����ѧ��Ϊ���ġ����ϿƼ���ѧУ԰����Ӧ����ӦС�飨SWUST Net Emergency Response Team�����ΪSNERT������" +
				"ּ��Ϊѧ���ṩһ��ʵ�����������ѧ���Ķ����������ŶӾ����Լ�����������̽���������ϿƼ���ѧ��ɫ����Ϣ��ȫרҵ������������" +
				"С�����Ҫ�������У԰����İ�ȫ�������簲ȫ�����Ŀ�Ŀ�����У���⾺����֯�ȡ�";
		static final String address_SNERT = "";
		static final String classway_SNERT = "";
		static final int imageid_SNERT = 0;
		
		//Cisco
		static final String name_Cisco = "˼\n��\n��\n��\n��\n��";
		static final String documetion_Cisco = "�������ѧ�뼼��ѧԺ˼�������Ŷӳ�����2009��5�£�" +
				"��˼�����缼��ѧԺΪ��������CCNA��CCNP�Ŀ�ȡΪ���У�����ָ����ʦǣͷ��ѧ��������֯�����һ�����������ѧϰ���Ŷӡ�" +
				"�Ŷ�����ָ����ʦ2�������꼶ѧ��40�����Ŷӱ������ѧ����������������ѧϰ�������ƶ�ѧ���Ƽ���ķ�չ����ּ��" +
				"Ϊ���ѧ���ṩ��һ�����õ�ѧϰƽ̨��˼�������ŶӸ�����õ��˼������ѧ�뼼��ѧԺ�����쵼�Ĵ���֧�֡�" +
				"˼�������Ŷ��ṩ�����Ӳ���豸��ʵ���ҹ���H3C����Ϊ������·������������30��̨��PC�� 40��̨��" +
				"Cisco2800ϵ��·����6̨��Cisco2960ϵ�н�����3̨����»�����߲�����1̨�������豸��ֵ����200����" +
				"���⣬Ϊ�˷����Ŷӵ��ճ���������У��Ŷӻ��ƶ��ˡ�˼������ѧϰ�Ŷӹ�������ƶȡ����ƶ��ж԰�ȫ����" +
				"ʵ���豸�����ѧ��ʵ�����������ȷ�涨����ȷ��ʵ���豸�������̣���Ҫ������ʵ����ʵ�鱨�漰���˴浵��" +
				"�����Ŷӳ�Ա�����ļ���ѧϰ�� ";
		static final String address_Cisco = "";
		static final String classway_Cisco = "";
		static final int imageid_Cisco = 0;
		
		//V-tribe
		static final String name_Vtribe = "V\nT\nr\ni\nb\ne\n��\n��\n��\n��";
		static final String documetion_Vtribe = "V-tribe�Ӿ��Ŷӣ������ϿƼ���ѧ��һ֧���д��¾�����Ŷ�������Ŷӣ�" +
				"��Ҫ�о���������Ƶ������ͬʱ��չ����������ͼ����������������ά��ģ�����ּ����ȸ���������" +
				"�Ŷ�������ĿΪ��AE��3ds Max��Ps��Flash��Pr���������ݡ�" +
				"���ǵ��ŶӾ���Ϊ��־�ڰ�����Ƶ������ƽ����Ƶ�ͬѧ�ṩһ��ѧϰ��������������ƽ̨��" +
				"����Ƶ��¼ʱ������¼�����¼�ɳ��㼣�����������Ŷ��о���������Ƶ������������Ȥ��" +
				"����ȴ�ѧ������ȼ�����ǵĴ������顣�����Ŷ����𲽵�������һŬ���ͼ�ֵĹ����У�" +
				"����Ϊ��ѧԺ�ĸ��ֻ������Ƶ������ȡ�������벻���ĺõ�Ч�����������ǻ�����ȫУ����������һ�л��Ҫ��" +
				"��ʹ�������ŶӴﵽ��һ���ʵķ�Ծ����Ϊ�����ϿƼ���ѧ��һ֧������ɫ���Ӿ��Ŷӡ�";
		static final String address_Vtribe = "";
		static final String classway_Vtribe = "";
		static final int imageid_Vtribe = 0;
		
		
		//������
		static final String name_self = "д\n��\n��\n��";
		static final String documetion_self = "��Ϊ�Ŷ��������ޣ����Կ϶�û�а취���޵��������е��Ŷӣ�ʵ���ҵȵȣ�" +
				"�������ϣ����ҿ��԰�����һ���Ѽ������ǻᾡ����Ѽ��������ݷŵ�����б��" +
				"�������������Ϣ������ʵ����Ҫ���£�һ���������Ź���" +
				"��ҿ��������¸�ʽ��\n\n" +
				"ʵ����/�Ŷ� ���ƣ�\n" +
				"ʵ����/�Ŷ� ���ܣ�\n" +
				"ʵ����/�Ŷ� ��ϵ��ַ����ϵ��ʽ��\n" +
				"ʵ����/�Ŷ� ��������\n" +
				"ʵ����/�Ŷ� ����ͼƬ��\n\n" +
				"��������ʽд���Ŷӻ�ʵ������Ϣ�������ʼ���380881937@qq.com����������ϵ��ʽ��" +
				"���ǻᾡ�콫��Ϣ��ʵ�󷢲�������б��У�";
		static final String address_self = "лл���~";
		static final String classway_self = "";
		static final int imageid_self = 0;
	}
	

}
