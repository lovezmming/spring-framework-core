package com.spring.framework.user.database.mapper;

import com.spring.framework.user.database.po.Experience;
import java.util.List;

public interface ExperienceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table experience
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table experience
     *
     * @mbg.generated
     */
    int insert(Experience record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table experience
     *
     * @mbg.generated
     */
    Experience selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table experience
     *
     * @mbg.generated
     */
    List<Experience> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table experience
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Experience record);
}