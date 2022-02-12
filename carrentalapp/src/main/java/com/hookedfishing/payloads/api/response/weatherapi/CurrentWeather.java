package com.hookedfishing.payloads.api.response.weatherapi;

public class CurrentWeather {

    private Current currentWeather;

    public static class Current {

        private String last_updated_epoch;
        private String last_updated;
        private String temp_c;
        private String temp_f;
        private String is_day;
        private Condition[] condition;

        public static class Condition {

            private String text;
            private String icon;
            private String code;

            public Condition() {
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }
        }

        public Current() {
        }

        public String getLast_updated() {
            return last_updated;
        }

        public void setLast_updated(String last_updated) {
            this.last_updated = last_updated;
        }

        public String getTemp_c() {
            return temp_c;
        }

        public void setTemp_c(String temp_c) {
            this.temp_c = temp_c;
        }

        public String getTemp_f() {
            return temp_f;
        }

        public void setTemp_f(String temp_f) {
            this.temp_f = temp_f;
        }

        public String getLast_updated_epoch() {
            return last_updated_epoch;
        }

        public void setLast_updated_epoch(String last_updated_epoch) {
            this.last_updated_epoch = last_updated_epoch;
        }

        public String getIs_day() {
            return is_day;
        }

        public void setIs_day(String is_day) {
            this.is_day = is_day;
        }

        public Condition[] getCondition() {
            return condition;
        }

        public void setCondition(Condition[] condition) {
            this.condition = condition;
        }
    }

    public Current getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(Current currentWeather) {
        this.currentWeather = currentWeather;
    }
}
