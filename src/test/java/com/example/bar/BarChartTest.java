package com.example.bar;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.example.util.Opener;

import be.ceau.chart.BarChart;
import be.ceau.chart.color.Color;
import be.ceau.chart.data.BarData;
import be.ceau.chart.dataset.BarDataset;
import be.ceau.chart.options.BarOptions;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.DeptVO;
import com.example.domain.EmpVO;
import com.example.repository.DeptRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BarChartTest {

	@Inject
	DeptRepository deptRepository;

	@Test
	@Transactional
	public void testFindAll() {

		deptRepository.findAll().forEach(e -> {
			System.out.println(e);
			System.out.println(e.getEmps());
		});
	}

	/*
	 * 부서 검색해서 출력하기
	 */
	@Test
	@Transactional
	public void test() throws IOException {
		/*
		 * 기본 골격
		 */
		BarChart bar = new BarChart();

		BarData data = new BarData();
		BarOptions options = new BarOptions();

		bar.setData(data);
		bar.setOptions(options);

		/*
		 * 데이터 & 라벨 셋
		 */
		DeptVO vo10 = deptRepository.findById(10).get();
		BarDataset set = new BarDataset();
		List<EmpVO> emps = vo10.getEmps();
		for(EmpVO emp: emps){
			set.addData(emp.getSal());
			data.addLabel(emp.getEname());						//data set이 하나라서 포문에 같이 넣어도 댐
		}
		set.setLabel(vo10.getDeptno() + " "+ vo10.getDname());
		set.setBackgroundColor(Color.AQUA_MARINE);
		data.addDataset(set);
		/*
		 * html로 만들어서 웹브라우저에 띄우는 놈
		 */
//		Opener.inBrowser(bar);
		System.out.println(bar.toJson());

	}

	/*
	 * 전체 출력
	 */
	@Test
	@Transactional
	public void testAll() throws IOException {
		List<DeptVO> depts = deptRepository.findAll();
		
		List<BarChart> bars = new ArrayList<>();
		
		for(DeptVO dept : depts){
		
			BarChart bar = new BarChart();
			BarData data = new BarData();
			BarOptions options = new BarOptions();

			bar.setData(data);
			bar.setOptions(options);

			BarDataset set = new BarDataset();
			
			List<EmpVO> emps = dept.getEmps();
			
			for (EmpVO emp : emps) {
				set.addData(emp.getSal());
				data.addLabel(emp.getEname()); // data set이 하나라서 포문에 같이 넣어도 댐
			}
			
			set.setLabel(dept.getDeptno() + " "+ dept.getDname());
			set.setBackgroundColor(Color.AQUA_MARINE);
			data.addDataset(set);
			
			bars.add(bar);
		}

		bars.forEach(e -> {
			System.out.println(e.toJson());
		});		
	}

}
