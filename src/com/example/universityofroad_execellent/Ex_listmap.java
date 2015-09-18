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
		
		//������ʵʵ����
		static final String name_vr = "��\n��\n��\nʵ\n��\n��\n��\n��\n��\n��\n��\n��";
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
		static final String classway_vr = "רҵ���򣺿��ӻ� �˻����� ������ʵ";
		static final String address_vr = "2-23 2-28 2-45";
		static final int imageid_vr = R.drawable.vr1;
		
		//Ƕ��ʽ
		static final String name_qianru = "Ƕ\n��\nʽ\nʵ\n��\n��";
		static final String documetion_qianru = "ʵ������Ҫ���м�������Ƽ�����Ƕ��ʽϵͳ�������о���" +
				"������ҵӦ�õ�Ƕ��ʽϵͳΪ��ҪĿ�ꡣ�������������ӣ����ػ�����ҽ���豸��������������" +
				"�˼�⼼���������ҵ���о������漰Ƕ��ʽ����ƽ̨��Ƕ��ʽʵʱ����ϵͳ��Ƕ��ʽ�м�����������" +
				"�豸������������ʵ����ӵ�����Ƶĸ߶�ARMǶ��ʽ����ϵͳ������ǿ���DSP����ƽ̨��FPGA����ƽ̨�� " +
				"���в��ֿ���ƽ̨����ȫ����������ӵ��������Ӳ��������֤�豸������BGA��������ƽ̨��" +
				"��̨�����ִ洢ʾ���������Ⲩ���źŷ��������߼������ǣ�LCR�����ǣ��߾������ֵ�Դ������ʵ����ȡ�";
		static final String address_qianru = "";
		static final String classway_qianru = "רҵ���򣺵�Ƭ��";
		static final int imageid_qianru = 0;
		
		//�����Ӿ�
		static final String name_computereye = "��\n��\n��\n��\nʵ\n��\n��";
		static final String documetion_computereye = "���ϿƼ���ѧ�����Ӿ�ʵ������һ���Լ����Ӧ�ü�����" +
				"�����Ӿ��͹�ѧ���̵�Ϊ�������Խ����Ʒȱ�ݼ�⡢�Զ�Ŀ��ʶ��Ͷ�Դͼ����Ϣ�ں��еļ�������Ϊ��Ҫ�о�����Ŀ�ѧ�ƿ���ʵ���ҡ�" +
				"ʵ���������ϿƼ���ѧ�����Ӧ�ü���ʡ���ص�ѧ��Ϊ���У�˳Ӧ������������Ӿ��������̻��ķ�չ���ƣ�" +
				"����ҹ���Ʒȱ�ݼ�⡢���ܼ�غ͹����ش������Ŀ�ķ�չ��Ҫ��" +
				"��չ�����Ӿ���������������Ӧ�û����о����Լ��¼������²�Ʒ�Ŀ�����";
		static final String address_computereye = "";
		static final String classway_computereye = "רҵ����OpenCV";
		static final int imageid_computereye = 0;
		
		//���缼��
		static final String name_internetskill = "��\n��\n��\n��\n��\n��\n��\nʽ\n��\n��\nʵ\n��\n��";
		static final String documetion_internetskill = "���缼����ֲ�ʽ����ʵ����ǰ����2003������ѧԺ���е�����863��Ŀ���������о���ʵ����-Linux/NCʵ���ң�" +
				"����ʵ�������200ƽ���ף������豸��ֵ100����Ԫ��" +
				"Ŀǰ��Ҫ���о�����������ڿ�Դ�������ļ�Ⱥ���������м��㡢�洢��������Ⱥ���ֲ�ʽ�洢ϵͳ���������ܲ��Եȡ�" +
				"��ѧ���ڻ��ڿ�Դ�������ļ�Ⱥ���������������ҽѧ����Ĳ�����������ȡ����һЩ��Ӱ�������о��ɹ���" +
				"Ŀǰʵ�����������о�������о���Ա��Թ̶����Ȳ������׶Ρ�";
		static final String address_internetskill = "";
		static final String classway_internetskill = "רҵ�������缼��";
		static final int imageid_internetskill = 0;
		
		//������
		static final String name_self = "д\n��\n��\n��";
		static final String documetion_self = "��Ϊ�Ŷ��������ޣ����Կ϶�û�а취���޵��������е��Ŷӣ�ʵ���ҵȵȣ�" +
				"�������ϣ����ҿ��԰�����һ���Ѽ������ǻᾡ����Ѽ��������ݷŵ�����б��" +
				"��ҿ��������¸�ʽ��\n\n" +
				"ʵ����/�Ŷ� ���ƣ�\n" +
				"ʵ����/�Ŷ� ���ܣ�\n" +
				"ʵ����/�Ŷ� ��ϵ��ַ����ϵ��ʽ��\n" +
				"ʵ����/�Ŷ� ��������\n" +
				"ʵ����/�Ŷ� ����ͼƬ��\n\n" +
				"��������ʽд���Ŷӻ�ʵ������Ϣ�������ʼ���380881937@qq.com����������ϵ��ʽ��" +
				"���ǻᾡ�콫��Ϣ��ʵ�󷢲�������б��У�";
		static final String address_self = "лл���~";
		static final String classway_self = "By.�Ҿ�������  ��~ֻ��������ʵʵ���Ҿ�����Ϊ���������ʵ������~";
		static final int imageid_self = R.drawable.monster_icon;
	}
	

}
