package com.epam.springadvanced.springmvc.repository;

import com.epam.springadvanced.springmvc.dto.UserData;
import com.epam.springadvanced.springmvc.entity.Company;
import com.epam.springadvanced.springmvc.entity.Phone;
import com.epam.springadvanced.springmvc.entity.User;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserPhonesRepositoryImpl implements UserPhonesRepository {

  private final JdbcTemplate jdbcTemplate;

  @Override
  public int[] addUsers(final List<User> users) {
    return jdbcTemplate.batchUpdate(
        "update users set name = ?, surname = ?, patronymic = ? where id = ?",
        new BatchPreparedStatementSetter() {
          public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
            preparedStatement.setString(1, users.get(i).getName());
            preparedStatement.setString(2, users.get(i).getSurname());
            preparedStatement.setString(3, users.get(i).getPatronymic());
            preparedStatement.setLong(5, users.get(i).getId());
          }

          public int getBatchSize() {
            return users.size();
          }
        });
  }

  @Override
  public int[] addCompanies(final List<Company> companies) {
    return jdbcTemplate.batchUpdate(
        "update companies set name = ? where id = ?",
        new BatchPreparedStatementSetter() {
          public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
            preparedStatement.setString(1, companies.get(i).getName());
            preparedStatement.setLong(2, companies.get(i).getId());
          }

          public int getBatchSize() {
            return companies.size();
          }
        });
  }

  @Override
  public int[] addPhones(final List<Phone> phones) {
//    return jdbcTemplate.batchUpdate(
//        "update phones set number = ?, id_company = ? id_user = ? where id = ?",
//        new BatchPreparedStatementSetter() {
//          public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
//            preparedStatement.setString(1, phones.get(i).getNumber());
//            preparedStatement.setLong(2, phones.get(i).getCompanyId());
//            preparedStatement.setLong(3, phones.get(i).getUserId());
//            preparedStatement.setLong(4, phones.get(i).getId());
//          }
//
//          public int getBatchSize() {
//            return phones.size();
//          }
//        });
    return null;
  }

  @Override
  public List<UserData> getUsersData() {
//    return jdbcTemplate.query(
//        "select "
//            + "p.id id u.name name, u.patronymic patronymic, u.surname surname "
//            + "p.number number, c.name company "
//            + "from phones p\n"
//            + "left join users u\n"
//            + "on p.id_user=u.id\n"
//            + "left join companies c\n"
//            + "on c.id= p.id_companies",
//        (rs, rowNum) ->
//            PhoneData.builder()
//                .id(rs.getLong("id"))
//                .userData(new UserData())
//    (
//        rs.getLong("id"),
//        rs.getString("name"),
//        rs.getBigDecimal("price")
//            )
//    );
//  }
    return null;
  }
}
