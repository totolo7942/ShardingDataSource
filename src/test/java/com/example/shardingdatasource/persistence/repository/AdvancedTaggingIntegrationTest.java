//package com.example.shardingdatasource.persistence.repository;
//
//import com.example.shardingdatasource.config.StudentJpaConfig;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.context.support.AnnotationConfigContextLoader;
//import org.springframework.transaction.annotation.Transactional;
//import com.example.shardingdatasource.persistence.dao.ManyStudentRepository;
//import com.example.shardingdatasource.persistence.dao.ManyTagRepository;
//import com.example.shardingdatasource.persistence.dao.StudentRepository;
//import com.example.shardingdatasource.persistence.model.*;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//import static org.springframework.test.util.AssertionErrors.assertEquals;
//
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = { StudentJpaConfig.class }, loader = AnnotationConfigContextLoader.class)
//@Transactional
//@DirtiesContext
//public class AdvancedTaggingIntegrationTest {
//    @Autowired
//    private StudentRepository studentRepository;
//
//    @Autowired
//    private ManyStudentRepository manyStudentRepository;
//
//    @Autowired
//    private ManyTagRepository manyTagRepository;
//
//    @Test
//    public void givenStudentWithSkillTags_whenSave_thenGetByNameAndSkillTag() {
//        Student student = new Student(1, "Will");
//        SkillTag skill1 = new SkillTag("java", 5);
//        student.setSkillTags(Arrays.asList(skill1));
//        studentRepository.save(student);
//
//        Student student2 = new Student(2, "Joe");
//        SkillTag skill2 = new SkillTag("java", 1);
//        student2.setSkillTags(Arrays.asList(skill2));
//        studentRepository.save(student2);
//
//        List<Student> students = studentRepository.retrieveByNameFilterByMinimumSkillTag("java", 3);
//        assertEquals("size incorrect", 1, students.size());
//    }
//
//    @Test
//    public void givenStudentWithKVTags_whenSave_thenGetByTagOk() {
//        Student student = new Student(0, "John");
//        student.setKVTags(Arrays.asList(new KVTag("department", "computer science")));
//        studentRepository.save(student);
//
//        Student student2 = new Student(1, "James");
//        student2.setKVTags(Arrays.asList(new KVTag("department", "humanities")));
//        studentRepository.save(student2);
//
//        List<Student> students = studentRepository.retrieveByKeyTag("department");
//        assertEquals("size incorrect", 2, students.size());
//    }
//
//    @Test
//    public void givenStudentWithManyTags_whenSave_theyGetByTagOk() {
//        ManyTag tag = new ManyTag("full time");
//        manyTagRepository.save(tag);
//
//        ManyStudent student = new ManyStudent("John");
//        student.setManyTags(Collections.singleton(tag));
//        manyStudentRepository.save(student);
//
//        List<ManyStudent> students = manyStudentRepository.findByManyTags_Name("full time");
//        assertEquals("size incorrect", 1, students.size());
//    }
//}
