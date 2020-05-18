package Mockito集成测试;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;


public class StuControllerTest {

	StuController mController;
    StudentDAO mStuDao;

    @Before
    public void setUp() throws Exception {
        mController = new StuController();
        mStuDao = mock(StudentDAO.class);
        mController.setStudentDAO(mStuDao);
    }

    @Test
    public void testGetStudentInfo() {
        Student returnStudent = new Student();
        returnStudent.id = 123;
        returnStudent.name = "mock-user";

        // 调用getStudentFromDB时返回returnStudent对象
        when(mStuDao.getStudentFromDB(anyInt())).thenReturn(returnStudent);
        // 调用getStudentInfo
        Student student = mController.getStudentInfo(123);
        // 验证数据
        assertEquals(student.id, 123);
        assertEquals(student.name, "mock-user");
    }

    @Test
    public void testGetStudentInfoFromServer() {
        // 调用getStudentFromDB时返回null
        when(mStuDao.getStudentFromDB(anyInt())).thenReturn(null);
        // 调用getStudentInfo
        Student student = mController.getStudentInfo(456);
        // 验证数据
        assertEquals(student.id, 456);
        assertEquals(student.name, "server-user");
    }

    @Test
    public void testCaptureParam() {
        // 注意: 创建一个mock对象
        StuController mockController = mock(StuController.class) ;

        doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                int studentId = (Integer)invocation.getArguments()[0] ;
                System.out.println("学生id : " + studentId);
                assertEquals(666, studentId);
                return null;
            }
        }).when(mockController).getStudentInfo(anyInt()) ;

        mockController.getStudentInfo(666) ;
    }

	
}
