package MockitoºØ≥…≤‚ ‘;

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
    public void test1() {
        Student returnStudent = new Student();
        returnStudent.id = 1916111;
        returnStudent.name = "mock-user";
        when(mStuDao.getStudentFromDB(anyInt())).thenReturn(returnStudent);
        Student student = mController.getStudentInfo(1916111);
        assertEquals(student.id, 1916111);
        assertEquals(student.name, "mock-user");
    }

    @Test
    public void test2() {
        StuController mockController = mock(StuController.class) ;
        doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                int studentId = (Integer)invocation.getArguments()[0] ;
                System.out.println("—ß∫≈ : " + studentId);
                assertEquals(1916120, studentId);
                return null;
            }
        }).when(mockController).getStudentInfo(anyInt()) ;
        mockController.getStudentInfo(1916120) ;
    }

	
}
