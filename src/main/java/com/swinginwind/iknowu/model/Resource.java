package com.swinginwind.iknowu.model;

import java.util.Date;

public class Resource {
    /**
     * 
     * 表 : t_resource
     * 对应字段 : RID
     */
    private String rid;

    /**
     * 领域编号
     * 表 : t_resource
     * 对应字段 : FID
     */
    private String fid;

    /**
     * 问题名称
     * 表 : t_resource
     * 对应字段 : NAME
     */
    private String name;

    /**
     * 资源内容
     * 表 : t_resource
     * 对应字段 : RES_CONTENT
     */
    private String resContent;

    /**
     * 资源类别
     * 表 : t_resource
     * 对应字段 : TYPE
     */
    private String type;
    
    private String typeName;

    /**
     * 创建用户ID
     * 表 : t_resource
     * 对应字段 : CREATE_USER
     */
    private Integer createUser;
    
    private String createUserName;
    
    /**
     * 问题提出时间
     * 表 : t_resource
     * 对应字段 : DATE
     */
    private Date date;

    /**
     * 问题打赏价格
     * 表 : t_resource
     * 对应字段 : PRICE
     */
    private String price;

    /**
     * 问题状态
     * 表 : t_resource
     * 对应字段 : STATE
     */
    private String state;

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid == null ? null : rid.trim();
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid == null ? null : fid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getResContent() {
        return resContent;
    }

    public void setResContent(String resContent) {
        this.resContent = resContent == null ? null : resContent.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}