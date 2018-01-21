package com.tuft.springbootspatial.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

@Service
public class ReadFileService {

    public List<String> getListFromFile(File file) throws IOException {
        List<String> list;

        try {
            list = Files.readAllLines(file.toPath(), Charset.forName("UTF-8"));
        } catch (IOException e) {
            list = Files.readAllLines(file.toPath(), Charset.forName("Cp1251"));
            e.printStackTrace();
        }
        return list;
    }
}
