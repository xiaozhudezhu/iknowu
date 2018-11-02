package com.swinginwind.iknowu.model;

import java.math.BigDecimal;

public class BaseMaster {
    /**
     * 
     * 表 : t_base_master
     * 对应字段 : TID
     */
    private String tid;

    /**
     * ??ʦ????
     * 表 : t_base_master
     * 对应字段 : MASTERNAME
     */
    private String mastername;

    /**
     * ??ʦ?Ա
     * 表 : t_base_master
     * 对应字段 : GENDER
     */
    private String gender;

    /**
     * ??ʦ???
     * 表 : t_base_master
     * 对应字段 : AGE
     */
    private BigDecimal age;

    /**
     * ??ʦ?ֻ????
     * 表 : t_base_master
     * 对应字段 : PHONECALL
     */
    private String phonecall;

    /**
     * ??ʦ???
     * 表 : t_base_master
     * 对应字段 : FEILDS
     */
    private String fields;

    /**
     * ??ʦ???߼??
     * 表 : t_base_master
     * 对应字段 : LEVEL
     */
    private String level;

    /**
     * ??ʦ??Դ
     * 表 : t_base_master
     * 对应字段 : SOURCE
     */
    private String source;

    /**
     * ??ʦ΢?ź
     * 表 : t_base_master
     * 对应字段 : WEIXIN
     */
    private String weixin;

    /**
     * ??ʦ֧?????˺
     * 表 : t_base_master
     * 对应字段 : ALIPAY
     */
    private String alipay;

    /**
     * ??ʦ??????֧????ʽ
     * 表 : t_base_master
     * 对应字段 : PAYTYPE
     */
    private String paytype;

    /**
     * ??ʦ???????úϼ
     * 表 : t_base_master
     * 对应字段 : TOTALFEE
     */
    private BigDecimal totalfee;

    /**
     * ??ʦ???ڳ??
     * 表 : t_base_master
     * 对应字段 : CITY
     */
    private String city;

    /**
     * ??ʦ???ڵ?λ
     * 表 : t_base_master
     * 对应字段 : FIRM
     */
    private String firm;

    /**
     * ??ʦְ?
     * 表 : t_base_master
     * 对应字段 : RANK
     */
    private String rank;

    /**
     * ??ʦְλ
     * 表 : t_base_master
     * 对应字段 : POSITION
     */
    private String position;
    
    /**
     * 本月接单数
     */
    private int monthCount = 50;
    
    /**
     * 关联用户ID
     */
    private Integer userId;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid == null ? null : tid.trim();
    }

    public String getMastername() {
        return mastername;
    }

    public void setMastername(String mastername) {
        this.mastername = mastername == null ? null : mastername.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public BigDecimal getAge() {
        return age;
    }

    public void setAge(BigDecimal age) {
        this.age = age;
    }

    public String getPhonecall() {
        return phonecall;
    }

    public void setPhonecall(String phonecall) {
        this.phonecall = phonecall == null ? null : phonecall.trim();
    }

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields == null ? null : fields.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin == null ? null : weixin.trim();
    }

    public String getAlipay() {
        return alipay;
    }

    public void setAlipay(String alipay) {
        this.alipay = alipay == null ? null : alipay.trim();
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype == null ? null : paytype.trim();
    }

    public BigDecimal getTotalfee() {
        return totalfee;
    }

    public void setTotalfee(BigDecimal totalfee) {
        this.totalfee = totalfee;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm == null ? null : firm.trim();
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank == null ? null : rank.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

	public int getMonthCount() {
		return monthCount;
	}

	public void setMonthCount(int monthCount) {
		this.monthCount = monthCount;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}