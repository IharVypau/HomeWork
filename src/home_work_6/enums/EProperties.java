package home_work_6.enums;

public enum EProperties {
        HOME_DIRECTORY("src/home_work_6/"),
        LIBRARY("src/home_work_6/library/");
        private String path = ".";
        EProperties(String path) {
            this.path = path;
        }

        public String getPath() {
            return path;
        }
    }
