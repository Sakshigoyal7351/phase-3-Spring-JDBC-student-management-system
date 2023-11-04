package com.day2;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.day2.dao.studentDao;
import com.day2.dao.studentDaoImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context= 
        		new ClassPathXmlApplicationContext("config.xml");
        
        studentDao stu = context.getBean("studentDao",studentDao.class);
        
        Scanner sc= new Scanner(System.in);
        
        Boolean go= true;
        while(go)
        {
        	
        	System.out.println("press 1 to insert data");
        	System.out.println("press 2 to update data");
        	System.out.println("press 3 to delete data");
        	System.out.println("press 4 to display single student data");
        	System.out.println("press 5 to display all student data");
        	System.out.println("press 6 to exit");
        	
        	int choice;
            System.out.println("enter your choice");
            choice=sc.nextInt();
            
        	switch(choice)
        	{
        	case 1:
        		System.out.println("enter the id");
                int id= sc.nextInt();
                
                System.out.println("enter the name");
                String name= sc.next();
                
                System.out.println("enter the city");
                String city= sc.next();
                
                Student student = new Student();
                student.setId(id);
                student.setName(name);
                student.setCity(city);
                
                int r = stu.insert(student);
                System.out.println("student data got inserted"+r);
                
                
        		break;
        
        	case 2: 
        		System.out.println("enter the id of student whose data you want to update!!");
        		int id2= sc.nextInt();
        		
        		System.out.println("enter the  new name");
        		String name2= sc.next();
        		
        		System.out.println("enter the new city name");
        		String city2= sc.next();
        		
        		
        		Student student2= new Student();
        		student2.setId(id2);
        		student2.setName(name2);
        		student2.setCity(city2);
        		
        		int result = stu.change(student2);
        		System.out.println("student data got updated!!!!"+result);
        		
        		break;
        	case 3:
        		System.out.println("enter the id of student whose data you want to delete!!");
        		int id3= sc.nextInt();
        		
        		int r2 = stu.delete(id3);
        		System.out.println("data got deleted!!!"+r2);
        		break;
        	case 4:
        		System.out.println("enter the student id whose data you want to display!!");
        		int id4=sc.nextInt();
        		
        		Student s1 = stu.getStudent(id4);
        		System.out.println(s1);
       
        		break;
        		
        	case 5:
        		List<Student> students = stu.getAllStudents();
        		
        		for(Student s : students)
        		{
        			System.out.println(s);
        		}
        		break;
        	
        	case 6:
        		go=false;
        		break;
        	default:
        		
        		System.out.println("you enter the wrong choice!!!!");
        	}
        	
        	
        }
        
        
        
        
        
        
    }
}
