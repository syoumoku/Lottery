package com.lzm.lottery.common;

public class Constants {

    public enum AwardState {

        /**
         * wait for distribution
         */
        WAIT(0, "wait for distribution"),

        /**
         * distribution success
         */
        SUCCESS(1, "distribution success"),

        /**
         * distribution failure
         */
        FAILURE(2, "distribution failure");

        private Integer code;
        private String info;

        AwardState(Integer code, String info) {
            this.code = code;
            this.info = info;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

    }

    public enum ResponseCode {
        SUCCESS("0000", "success"),
        UN_ERROR("0001","unknown failure"),
        ILLEGAL_PARAMETER("0002","invalid parameter"),
        INDEX_DUP("0003","primary key conflict");

        private String code;
        private String info;

        ResponseCode(String code, String info) {
            this.code = code;
            this.info = info;
        }

        public String getCode() {
            return code;
        }

        public String getInfo() {
            return info;
        }

    }

    public enum StrategyMode {

        SINGLE(1, "single probability"),

        ENTIRETY(2, "overall probability");

        private Integer code;
        private String info;

        StrategyMode(Integer code, String info) {
            this.code = code;
            this.info = info;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }

    /**
     * Draw Status：0 no reward、1 reward、2 participation
     */
    public enum DrawState {
        /**
         * no reward
         */
        FAIL(0,"no reward"),

        /**
         * win the prize
         */
        SUCCESS(1, "get reward"),

        /**
         * award for participation
         */
        Cover(2,"participation");

        private Integer code;
        private String info;

        DrawState(Integer code, String info) {
            this.code = code;
            this.info = info;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }

    /**
     * Award Type（1:description、2:redeem code、3:coupon goods、4: physical goods）
     */
    public enum AwardType {
        /**
         * Description
         */
        DESC(1, "Description"),
        /**
         * Redeem Code
         */
        RedeemCodeGoods(2, "Redeem code"),
        /**
         * Coupon
         */
        CouponGoods(3, "Coupon"),
        /**
         * Physical Good
         */
        PhysicalGoods(4, "Physical Good");

        private Integer code;
        private String info;

        AwardType(Integer code, String info) {
            this.code = code;
            this.info = info;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }


    /**Activity State：1.Edit 2. Commit 3. Revoke 4.Pass.5.Undergo(Scan status after apply approved) 6.Refuse 7.Close 8.Open
     * */
    public enum ActivityState {

        /** 1：edit */
        EDIT(1, "edit"),
        /** 2：commit */
        Commit(2, "commit"),
        /** 3：revoke */
        REVOKE(3, "revoke"),
        /** 4：pass */
        PASS(4, "pass"),
        /** 5：doing */
        UNDERGO(5, "doing"),
        /** 6：refuse */
        REFUSE(6, "refuse"),
        /** 7：close */
        CLOSE(7, "close"),
        /** 8：open */
        OPEN(8, "开启");

        private Integer code;
        private String info;

        ActivityState(Integer code, String info) {
            this.code = code;
            this.info = info;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }

    /**
     * Ids generating methods
     */
    public enum Ids {
        /** SnowFlake */
        SnowFlake,
        /** Date */
        ShortCode,
        /** Random */
        RandomNumeric;
    }


}
