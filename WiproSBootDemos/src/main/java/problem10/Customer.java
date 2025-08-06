package problem10;

import jakarta.validation.constraints.*;

public class Customer {

    @NotBlank(message = "{customer.name.required}")
    @Size(min = 2, max = 30, message = "{customer.name.size}")
    private String name;

    @NotBlank(message = "{customer.email.required}")
    @Email(message = "{customer.email.valid}")
    private String email;

    @NotNull(message = "{customer.age.required}")
    @Min(value = 18, message = "{customer.age.min}")
    @Max(value = 100, message = "{customer.age.max}")
    private Integer age;

    @NotBlank(message = "{customer.gender.required}")
    private String gender;

    @NotBlank(message = "{customer.birthday.required}")
    private String birthday;

    @Pattern(regexp = "^(\\d{3}-\\d{7}|\\d{3}-\\d{3}-\\d{4}( x\\d{1,5})?)$", message = "{customer.phone.valid}")
    private String phone;

    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getBirthday() { return birthday; }
    public void setBirthday(String birthday) { this.birthday = birthday; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
