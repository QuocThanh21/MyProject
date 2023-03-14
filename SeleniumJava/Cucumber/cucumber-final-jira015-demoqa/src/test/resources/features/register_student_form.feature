@register_student
Feature: Register student function

  @register_student_successfully
  Scenario Outline: Register student form successfully
    Given the user is on Student Registration Form
    When the user input valid data into fields
      | First Name  | Last Name  | User Email  | Gender   | Mobile   | Date of Birth | Subjects   | Hobbies   | Picture    | Current Address  | State   | City   |
      | <firstName> | <lastName> | <userEmail> | <gender> | <mobile> | <dateOfBirth> | <subjects> | <hobbies> | <pictures> | <currentAddress> | <state> | <city> |
    And the user clicks on Submit button
    Then a successful message "Thanks for submitting the form" is shown
    And all information of the student form is shown correctly

    Examples:
      | firstName | lastName | userEmail       | gender | mobile     | dateOfBirth     | subjects            | hobbies        | pictures | currentAddress | state | city  |
      | Thanh     | Tran     | thanh@gmail.com | Male   | 0381172413 | 22 January,2004 | Biology, Accounting | Reading, Music | avt.jpg  | TP HCM         | NCR   | Noida |
      | Thanh     | Quoc     |                 | Male   | 0379998877 |                 |                     |                |          |                |       |       |
