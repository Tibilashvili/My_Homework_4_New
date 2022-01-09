package com.example.demo.service;

import com.example.demo.model.Student;

import java.util.List;

public interface StudentService {
    /**
     * Создает нового студента
     * @param student - студент для создания
     */
    void save(Student student);

    /**
     * Возвращает студента по его ID
     * @param id - ID студента
     * @return - объект студента с заданным ID
     */
    Student get(long id);

    /**
     * Возвращает список всех имеющихся студентов
     * @return список студентов
     */
    List<Student> getAll();

    /**
     * Возвращает список всех студентов относящихся к указанной группе
     * @return список студентов относящихся к указанной группе
     */
    List<Student> getAllStudentsByGroup(long groupId);


    /**
     * Обновляет или добавляет студента с заданным ID,
     * в соответствии с переданным студентом
     * @param student - студент в соответсвии с которым нужно обновить данные
     * @return - возращает true, если студент был удачно обновлён, иначе возвращает false
     */
    boolean update(Student student);

    /**
     * Удаляет студента с заданным ID
     * @param id - id студента, которого нужно удалить
     * @return - возращает true, если студент был удален, иначе возвращает false
     */
    boolean delete(long id);
}
