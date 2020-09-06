package model;

public class MemberBean {

    private String id;
    private String pw;
    private String name;
    private String tel;
    private String email;
    private String field;
    private String skill;
    private String major;
    
    // 기본 생성자
    public MemberBean() {}
    // 회원가입을 위한 생성자
    // id,pw,name,tel,email
    public MemberBean(String id, String pw, String name, String tel, String email) {
        setId(id);
        setPw(pw);
        setName(name);
        setTel(tel);
        setEmail(email);
    }
    // 입사지원을 위한 생성자
    // name, tel, email, field, skill, major
    public MemberBean(String name, String tel, String email, String field, String skill, String major) {
        setName(name);
        setTel(tel);
        setEmail(email);
        setField(field);
        setSkill(skill);
        setMajor(major);
    }
    // 정보수정을 위한 생성자
    // pw,name,tel,email,field,skill,major
    public MemberBean(String pw, String name, String tel, String email, String field, String skill, String major) {
    	setPw(pw);
    	setName(name);
    	setTel(tel);
    	setEmail(email);
    	setField(field);
    	setSkill(skill);
    	setMajor(major);
    }
    
    public MemberBean(String id, String pw, String name, String tel, String email, String field, String skill, String major) {
    	setId(id);
    	setPw(pw);
    	setName(name);
    	setTel(tel);
    	setEmail(email);
    	setField(field);
    	setSkill(skill);
    	setMajor(major);
	}
    
	// alt + shift + s, r
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPw() {
        return pw;
    }
    public void setPw(String pw) {
        this.pw = pw;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getField() {
        return field;
    }
    public void setField(String field) {
        this.field = field;
    }
    public String getSkill() {
        return skill;
    }
    public void setSkill(String skill) {
        this.skill = skill;
    }
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    
}
