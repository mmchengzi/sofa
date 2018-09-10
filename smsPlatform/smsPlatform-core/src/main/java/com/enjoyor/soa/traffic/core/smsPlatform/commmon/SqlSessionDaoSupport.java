package com.enjoyor.soa.traffic.core.smsPlatform.commmon;

import com.enjoyor.soa.traffic.util.pojo.Page;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * @author : wxq
 * @date : 2012-8-28 上午10:43:22
 *
 **/
@Repository
public class SqlSessionDaoSupport {

	public static Logger log = LoggerFactory.getLogger(SqlSessionDaoSupport.class);

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Page queryPageInfo(String sqlId, Map paramMap, Page page) {
		Map<String, Object> countParam = new HashMap<String, Object>();
		Set<String> keySet = paramMap.keySet();
		Iterator<String> it = keySet.iterator();
		String key = null;
		while (it.hasNext()) {
			key = it.next();
			countParam.put(key, paramMap.get(key));
		}
		countParam.put("PCOUNT", "PAGECOUNT");
		int totalCount = getTotalCount(sqlId, countParam);
		if (null == page) {
			page = new Page();
		}
		if (page.getSortExp() != null && page.getSortExp().compareTo("") != 0) {
			paramMap.put("_sidx", page.getSortExp());
			paramMap.put("_sord", page.getSortDir());
		}
		page.setTotalCount(totalCount);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RowBounds rowBounds = new RowBounds(page.getCurrentResult(), page.getPageSize());
		List list = sqlSession.selectList(sqlId, paramMap, rowBounds);
		page.setResult(list);
		if (sqlSession != null) {
			sqlSession.close();
		}
		return page;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Page queryPageInfo(String sqlId, String countSqlId, Map paramMap, Page page) {
		int totalCount = getTotalCount(countSqlId, paramMap);
		if (page.getSortExp() != null && page.getSortExp().compareTo("") != 0) {
			paramMap.put("_sidx", page.getSortExp());
			paramMap.put("_sord", page.getSortDir());
		}
		page.setTotalCount(totalCount);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RowBounds rowBounds = new RowBounds(page.getCurrentResult(), page.getPageSize());
		List list = sqlSession.selectList(sqlId, paramMap, rowBounds);
		page.setResult(list);
		if (sqlSession != null) {
			sqlSession.close();
		}
		return page;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int getTotalCount(String sqlId, Map paramMap) {
		MyBatisSql myBatisSql = MyBatisSqlUtils.getMyBatisSql(sqlId, paramMap, sqlSessionFactory);
		String sql = myBatisSql.getSql();
		int count = 0;
		SqlSession sqlSession = null;
		Connection conn = null;
		PreparedStatement countStmt = null;
		ResultSet rs = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			conn = sqlSession.getConnection();
			countStmt = conn.prepareStatement(buildCountSql(sql));
			List<Object> parametersArray = Arrays.asList(myBatisSql.getParameters());
			List<Object> list = new ArrayList<Object>(parametersArray);
			if (sql.indexOf("?") != -1 && list.size() > 0 && myBatisSql.getParameters().length > 0) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i) instanceof String) {
						countStmt.setString(i + 1, list.get(i).toString());
					} else if (list.get(i) instanceof Date) {
						// countStmt.setDate(i+1, new
						// java.sql.Date(((Date)list.get(i)).getTime()));
						countStmt.setTimestamp(i + 1, new java.sql.Timestamp(((Date) list.get(i)).getTime()));
					} else if (list.get(i) instanceof Integer) {
						countStmt.setInt(i + 1, (Integer) list.get(i));
					} else if (list.get(i) instanceof Long) {
						countStmt.setLong(i + 1, (Long) list.get(i));
					} else if (list.get(i) instanceof Float) {
						countStmt.setFloat(i + 1, (Float) list.get(i));
					} else if (list.get(i) instanceof Double) {
						countStmt.setDouble(i + 1, (Double) list.get(i));
					} else if (list.get(i).getClass().isArray()) {
						countStmt.setArray(i + 1, (Array) list.get(i));
					} else {
						countStmt.setString(i + 1, list.get(i).toString());
					}
				}
			}

			rs = countStmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("SQLException:" + e.getClass() + e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (countStmt != null) {
					countStmt.close();
				}
			} catch (SQLException e) {
				System.out.println("SQLException:" + e.getClass() + e.getMessage());
			}
			sqlSession.close();
		}
		return count;
	}

	public String buildCountSql(String sql) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("select count(1) from ( ");
		buffer.append(sql);
		buffer.append(" ) tmp_count ");
		return buffer.toString();
	}

	@SuppressWarnings("rawtypes")
	public List queryListInfo(String sqlId, Map paramMap) {
		Map<String, Object> countParam = new HashMap<String, Object>();
		Set<String> keySet = paramMap.keySet();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List list = sqlSession.selectList(sqlId, paramMap);
		if (sqlSession != null) {
			sqlSession.close();
		}
		return list;
	}

}
