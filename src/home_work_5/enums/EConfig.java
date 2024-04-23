package home_work_5.enums;

import home_work_5.additional.generators.StringRandomGenerator;
import home_work_5.utils.FileReaderUtil;

public enum EConfig {
    FROM_RANDOM_SET("1234567890-=+xyqwertyuiopasdfрькхзшщгнекуцйaфывапрgолдьsбтsdимсчя23456№%;".split("")),
    FROM_RUSSIAN_SET("абвгдеёжзийклмнопрстуфхцчшщъыьэюя".split("")),
    FROM_SET_OF_NAMES("Kosoy, Zheka, Mixa, Katya, Ola, Sveta, ".split(", ")),
    FROM_FILE(new FileReaderUtil("src/home_work_5/asserts/names.txt").getStringsFromFile());

    private String[] data;

    EConfig(String[] data) {
        this.data = data;
    }

    public String[] getData() {
        return data;
    }
}
