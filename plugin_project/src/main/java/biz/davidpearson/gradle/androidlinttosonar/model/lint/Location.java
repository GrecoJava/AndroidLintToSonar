package biz.davidpearson.gradle.androidlinttosonar.model.lint;

public class Location {
    private String file;
    private String line;
    private String column;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return "Location{" +
                "file='" + file + '\'' +
                ", line='" + line + '\'' +
                ", column='" + column + '\'' +
                '}';
    }

    public static final class LocationBuilder {
        private String file;
        private String line;
        private String column;

        private LocationBuilder() {
        }

        public static LocationBuilder aLocation() {
            return new LocationBuilder();
        }

        public LocationBuilder withFile(String file) {
            this.file = file;
            return this;
        }

        public LocationBuilder withLine(String line) {
            this.line = line;
            return this;
        }

        public LocationBuilder withColumn(String column) {
            this.column = column;
            return this;
        }

        public Location build() {
            Location location = new Location();
            location.column = this.column;
            location.line = this.line;
            location.file = this.file;
            return location;
        }
    }
}
