package com.epam.springadvanced.springmvc.service;

import static com.epam.springadvanced.springmvc.constant.Constants.UPLOAD_DIR;

import com.epam.springadvanced.springmvc.dto.Company;
import com.epam.springadvanced.springmvc.dto.Phone;
import com.epam.springadvanced.springmvc.dto.UserData;
import com.epam.springadvanced.springmvc.entity.CompanyEntity;
import com.epam.springadvanced.springmvc.entity.PhoneEntity;
import com.epam.springadvanced.springmvc.entity.UserEntity;
import com.epam.springadvanced.springmvc.repository.UserDataRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@RequiredArgsConstructor
public class UserDataServiceImpl implements UserDataService {

  private final ObjectMapper mapper;

  private final UserDataRepository userDataRepository;

  @Override
  public ByteArrayInputStream getAllUsersPDF() {
    return getUsersPdf(getAllUsers());
  }

  @Override
  public List<UserData> getAllUsers() {
    return StreamSupport
        .stream(userDataRepository.findAll().spliterator(), false)
        .map(this::getUserData)
        .collect(Collectors.toList());
  }

  @Override
  @SneakyThrows
  public void addUsers(MultipartFile[] multipartFiles) {
    userDataRepository.saveAll(convertFilesToUsers(multipartFiles));
  }

  private List<UserEntity> convertFilesToUsers(MultipartFile[] files) {
    return Arrays.stream(files)
        .map(this::getFileContentAsString)
        .map(this::mapUser)
        .map(this::mapUserDataToEntity)
        .collect(Collectors.toList());
  }

  @SneakyThrows
  @NonNull
  private String getFileContentAsString(@NonNull MultipartFile multipartFile) {
    File file = new File(UPLOAD_DIR + multipartFile.getOriginalFilename());
    multipartFile.transferTo(file);

    return new String(Files.readAllBytes(file.toPath()));
  }

  @NonNull
  private UserEntity mapUserDataToEntity(@NonNull UserData userData) {
    final UserEntity entity = new UserEntity(userData.getName(), userData.getSurname());
    entity.setPhones(getPhoneEntities(userData.getPhones(), entity));
    entity.setPatronymic(userData.getPatronymic());

    return entity;
  }

  @NonNull
  private UserData getUserData(@NonNull UserEntity userEntity) {
    return new UserData(
        userEntity.getName(),
        userEntity.getSurname(),
        userEntity.getPatronymic(),
        getPhones(userEntity.getPhones()));
  }

  private List<PhoneEntity> getPhoneEntities(@Nullable List<Phone> phones, @NonNull UserEntity entity) {
    return Optional.ofNullable(phones)
        .map(Collection::stream)
        .map(stream -> stream
            .map(phone -> {
              final PhoneEntity phoneEntity = new PhoneEntity(phone.getNumber(), getCompanyEntity(phone.getCompany()));
              phoneEntity.setUser(entity);
              return phoneEntity;
            })
            .collect(Collectors.toList())
        ).orElse(Collections.emptyList());
  }

  private List<Phone> getPhones(@Nullable List<PhoneEntity> phoneEntities) {
    return Optional.ofNullable(phoneEntities)
        .map(Collection::stream)
        .map(stream -> stream
            .map(phone -> new Phone(phone.getNumber(), getCompany(phone.getCompanyEntity())))
            .collect(Collectors.toList())
        ).orElse(Collections.emptyList());
  }

  @NonNull
  private CompanyEntity getCompanyEntity(@NonNull Company company) {
    return new CompanyEntity(company.getName());
  }

  @NonNull
  private Company getCompany(@NonNull CompanyEntity companyEntity) {
    return new Company(companyEntity.getName());
  }

  @SneakyThrows
  @NonNull
  private UserData mapUser(@NonNull String stringUser) {
    return mapper.readValue(stringUser, UserData.class);
  }

  @SneakyThrows
  private ByteArrayInputStream getUsersPdf(List<UserData> dataList) {
    final Document document = new Document();
    final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    final PdfPTable table = new PdfPTable(3);
    table.setWidthPercentage(95);
    table.setWidths(new int[]{3, 2, 2});

    final Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

    PdfPCell pdfPCell;
    pdfPCell = new PdfPCell(new Phrase("User name", headFont));
    pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
    pdfPCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
    table.addCell(pdfPCell);

    pdfPCell = new PdfPCell(new Phrase("Phone numbers", headFont));
    pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
    pdfPCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
    table.addCell(pdfPCell);

    pdfPCell = new PdfPCell(new Phrase("Company name", headFont));
    pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
    pdfPCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
    table.addCell(pdfPCell);

    for (UserData userData : dataList) {
      PdfPCell cell;

      cell = new PdfPCell(new Phrase(
          userData.getSurname() + " " +
              userData.getName() + " " +
              userData.getPatronymic()
      ));
      cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cell.setHorizontalAlignment(Element.ALIGN_CENTER);
      table.addCell(cell);

      final String phones = userData.getPhones().stream()
          .map(Phone::getNumber)
          .collect(Collectors.joining("\n"));

      cell = new PdfPCell(new Phrase(phones));
      cell.setPaddingLeft(5);
      cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cell.setHorizontalAlignment(Element.ALIGN_LEFT);
      table.addCell(cell);

      final String companies = userData.getPhones().stream()
          .map(Phone::getCompany)
          .map(Company::getName)
          .collect(Collectors.joining("\n"));

      cell = new PdfPCell(new Phrase(companies));
      cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
      cell.setPaddingRight(5);
      table.addCell(cell);
    }

    PdfWriter.getInstance(document, outputStream);
    document.open();
    document.add(table);
    document.close();

    return new ByteArrayInputStream(outputStream.toByteArray());
  }
}
