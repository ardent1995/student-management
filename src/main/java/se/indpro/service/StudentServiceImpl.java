package se.indpro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;
import se.indpro.model.Student;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;


    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addAStudent(Student student) {
        jdbcTemplate.update("INSERT INTO student(rollNo,name,department,phone) VALUES(?,?,?,?)", student.getRollNo(), student.getName(), student.getDepartment(), student.getPhone());
    }

    @Override
    public void deleteAStudent(int rollNo) {
        jdbcTemplate.update("DELETE FROM student WHERE rollNo=" + rollNo);
    }

    @Override
    public void updateAStudent(int rollNo, Student student) {
        jdbcTemplate.update("UPDATE student SET name=?,department=?,phone=? WHERE rollNo=?", student.getName(), student.getDepartment(), student.getPhone(), student.getRollNo());
    }

    @Override
    public List<Student> retrieveStudents() {
        List<Student> studentList = new ArrayList<>();
        jdbcTemplate.query("SELECT * FROM student", new ResultSetExtractor<List<Student>>() {
            @Override
            public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {
                while (rs.next()) {
                    Student student = new Student(rs.getInt("rollNo"), rs.getString("name"), rs.getString("department"), rs.getLong("phone"));
                    studentList.add(student);
                }
                return studentList;
            }
        });
        return studentList;
    }
}
