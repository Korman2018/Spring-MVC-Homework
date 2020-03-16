package com.epam.springadvanced.springmvc;

import static com.epam.springadvanced.springmvc.constant.Constants.UPLOAD_DIR;

import java.io.File;
import javax.transaction.Transactional;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PrepareUserDirOnAppLoad implements CommandLineRunner {

  @Override
  @Transactional
  public void run(String... args) throws Exception {
    final File userDir = new File(UPLOAD_DIR);
    FileUtils.forceMkdir(userDir);
    FileUtils.cleanDirectory(userDir);
  }
}