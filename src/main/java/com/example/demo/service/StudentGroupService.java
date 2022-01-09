package com.example.demo.service;



import com.example.demo.model.StudentGroup;

import java.util.List;

public interface StudentGroupService {

    /**
     * Создает новую группу
     * @param studentGroup - группа для создания
     */
    void save(StudentGroup studentGroup);

    /**
     * Возвращает группу по её ID
     * @param id - ID группы
     * @return - объект группы с заданным ID
     */
    StudentGroup get(long id);


    /**
     * Возвращает список всех имеющихся групп
     * @return список студентов
     */
    List<StudentGroup> getAll();

    /**
     * Обновляет или добавляет группу с заданным ID,
     * в соответствии с переданным студентом
     * @param studentGroup - группа в соответсвии с которым нужно обновить данные
     * @param id
     * @return - возращает true, если группа была удачно обновлена, иначе возвращает false
     */
    boolean update(StudentGroup studentGroup, long id);

    /**
     * Удаляет группу с заданным ID
     * @param id - id группы, которую нужно удалить
     * @return - возращает true, если студент был удален, иначе возвращает false
     */
    boolean delete(long id);
}
