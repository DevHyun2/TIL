package org.firstzone.myapp.emp;

import java.util.List;

public interface EmpDAOInterface {
	
	public List<EmpDTO> selectAll();
	
	// 2. �듅�젙 吏곸?�� �긽�꽭 蹂닿�?
	public EmpDTO selectById(int empid);

	// 3. �듅�젙 ?����꽌�?�� 洹쇰Т�븯�뒗 吏곸?���뱾 議고?��
	public List<EmpDTO> selectByDept(int dept);
	
	public List<JobDTO> selectAllJob();
	
	// 4. �듅�젙 Job�씤 吏곸?���뱾 議고?��
	public List<EmpDTO> selectByJob(String job);
	
	// String�뿉 +?���? 諛섎?���븯�뒗 寃껋�? ?��꾪슚�쑉�쟻
	public List<EmpDTO> selectByJob2(String job);
	
	/*
	 * // 5. �떎�뼇�븳 議곌굔�?��濡� 議고?�� // ?����꽌蹂�?(=), 吏곸콉蹂�?(=), �엯�궗�씪蹂�(>=),
	 * 湲됱�?(>=) public List<EmpDTO> selectByCondition(int deptid, String jobid, Date
	 * hdate, int salary) {
	 * 
	 * return sqlSession.selectList(namespace + "selectByCondition"); }
	 */
	
	// 6. �엯�젰
	public int empInsert(EmpDTO emp);
	
	// 7.�닔�젙
	public int empUpdate(EmpDTO emp);
	// 8.�궘�젣
	public int empDelete(int empid);
}
