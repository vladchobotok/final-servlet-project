package model.entity;

import java.io.Serializable;
import java.util.Objects;

public class Diagnosis implements Serializable {
        private int id;
        private String type;

        public Diagnosis(int id, String type) {
            this.id = id;
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Diagnosis that = (Diagnosis) o;
            return id == that.id &&
                    Objects.equals(type, that.type);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, type);
        }

        @Override
        public String toString() {
            return "Diagnosis{" +
                    "id=" + id +
                    ", type='" + type + '\'' +
                    '}';
        }
}