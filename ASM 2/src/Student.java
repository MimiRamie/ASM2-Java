public class Student {
    public String getCode(){
        return code;
    }

    public void setCode(String code){
        this.code = code;
    }
    private String code;
    private String name;
    private int age;
    private int gender;
    private String address;
    private Double grade;
    static int count =0;

    public String getName()
    {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }


    public Student (String code,String name,int age, int gender, String address, Double grade)
    {
        this.code=code;
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.address=address;
        this.grade=grade;
        count+= 1;
    }
    public String PrintStudent()
    {
        String genderStuString = Integer.toString(getGender());
        if(genderStuString.equals("0"))
        {
            genderStuString = "Male";
        }
        else if (genderStuString.equals("1"))
        {
            genderStuString = "Female";
        }
        else
        {
            genderStuString = "Nothin";
        }

        return "List of Student: \n"
                +"Student Code: " +code+"\n"
                +"Student Name: " +name+"\n"
                +"Student Age: " +age+"\n"
                +"Student Gender: " +gender+"\n"
                +"Student Address: " +address+"\n"
                +"Student Grade: " +address+"\n";

    }
}
