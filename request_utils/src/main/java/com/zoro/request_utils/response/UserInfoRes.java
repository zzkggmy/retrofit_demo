package com.zoro.request_utils.response;

public class UserInfoRes {

    /**
     * code : 200
     * error :
     * data : {"userinfo":{"uid":41143,"mobile":"17865677380","nickname":"888999","height":188,"weight":74,"sex":1,"ftp":50,"birth":"2006-04-01","reg_time":1543892054,"riding_type":1},"token":"eyJpc3MiOjQxMTQzLCJuYmYiOjE1NTk3MDI2NzYsImV4cCI6MTU2MjI5NDczNn0=.7h_0k-9yxgAUVj2s1UTmBEnIPQI=","refresh_token":"eyJpc3MiOjQxMTQzLCJuYmYiOjE1NTk3MDI2NzYsImV4cCI6MTU2NDg4NjczNiwibG9naW5fYXQiOjE1NTk3MDI3MzZ9.oqCSoweU9owmXh7cg_xehOOzzUI=","coachinfo":{"is_coach":false,"status":0,"type":0,"id":0,"stu_nums":0,"token":""}}
     */

    private int code;
    private String error;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * userinfo : {"uid":41143,"mobile":"17865677380","nickname":"888999","height":188,"weight":74,"sex":1,"ftp":50,"birth":"2006-04-01","reg_time":1543892054,"riding_type":1}
         * token : eyJpc3MiOjQxMTQzLCJuYmYiOjE1NTk3MDI2NzYsImV4cCI6MTU2MjI5NDczNn0=.7h_0k-9yxgAUVj2s1UTmBEnIPQI=
         * refresh_token : eyJpc3MiOjQxMTQzLCJuYmYiOjE1NTk3MDI2NzYsImV4cCI6MTU2NDg4NjczNiwibG9naW5fYXQiOjE1NTk3MDI3MzZ9.oqCSoweU9owmXh7cg_xehOOzzUI=
         * coachinfo : {"is_coach":false,"status":0,"type":0,"id":0,"stu_nums":0,"token":""}
         */

        private UserinfoBean userinfo;
        private String token;
        private String refresh_token;
        private CoachinfoBean coachinfo;

        public UserinfoBean getUserinfo() {
            return userinfo;
        }

        public void setUserinfo(UserinfoBean userinfo) {
            this.userinfo = userinfo;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getRefresh_token() {
            return refresh_token;
        }

        public void setRefresh_token(String refresh_token) {
            this.refresh_token = refresh_token;
        }

        public CoachinfoBean getCoachinfo() {
            return coachinfo;
        }

        public void setCoachinfo(CoachinfoBean coachinfo) {
            this.coachinfo = coachinfo;
        }

        public static class UserinfoBean {
            /**
             * uid : 41143
             * mobile : 17865677380
             * nickname : 888999
             * height : 188
             * weight : 74
             * sex : 1
             * ftp : 50
             * birth : 2006-04-01
             * reg_time : 1543892054
             * riding_type : 1
             */

            private int uid;
            private String mobile;
            private String nickname;
            private int height;
            private Double weight;
            private int sex;
            private int ftp;
            private String birth;
            private int reg_time;
            private int riding_type;
            private int info_complete = 1;

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public Double getWeight() {
                return weight;
            }

            public void setWeight(Double weight) {
                this.weight = weight;
            }

            public int getSex() {
                return sex;
            }

            public void setSex(int sex) {
                this.sex = sex;
            }

            public int getFtp() {
                return ftp;
            }

            public void setFtp(int ftp) {
                this.ftp = ftp;
            }

            public String getBirth() {
                return birth;
            }

            public void setBirth(String birth) {
                this.birth = birth;
            }

            public int getReg_time() {
                return reg_time;
            }

            public void setReg_time(int reg_time) {
                this.reg_time = reg_time;
            }

            public int getRiding_type() {
                return riding_type;
            }

            public void setRiding_type(int riding_type) {
                this.riding_type = riding_type;
            }

            public int getInfo_complete() {
                return info_complete;
            }

            public void setInfo_complete(int info_complete) {
                this.info_complete = info_complete;
            }
        }

        public static class CoachinfoBean {
            /**
             * is_coach : false
             * status : 0
             * type : 0
             * id : 0
             * stu_nums : 0
             * token :
             */

            private boolean is_coach;
            private int status;
            private int type;
            private int id;
            private int stu_nums;
            private String token;

            public boolean isIs_coach() {
                return is_coach;
            }

            public void setIs_coach(boolean is_coach) {
                this.is_coach = is_coach;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getStu_nums() {
                return stu_nums;
            }

            public void setStu_nums(int stu_nums) {
                this.stu_nums = stu_nums;
            }

            public String getToken() {
                return token;
            }

            public void setToken(String token) {
                this.token = token;
            }
        }
    }
}