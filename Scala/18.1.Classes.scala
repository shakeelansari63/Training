// Classes in Scala are created using `class` keyword and all members are provided in Scala Class definitiona
// Which creates its default constructor
// Example
class Employee1(firstName: String, lastName: String)

// This is a class in Scala. And it has 2 members. firstName and lastName.
// You can see it by compiling this code with `scalac <file name of this script>` which will create Employee1.class file
// and then analysing Employee1.class using `javap -p Employee1`
// You will see following Output -

// public class Employee1 {
//   public Employee1(java.lang.String, java.lang.String);
// }

// firstName and lastName are on class but they are not accessible yet.
// In Order to access them, we will have to put `val` or `var` in front of variables
class Employee2(val firstName: String, var lastName: String)

// Now if we analyse this class with `scalac` followed by `javap`
// We get -

// public class Employee2 {
//   private final java.lang.String firstName;
//   private java.lang.String lastName;
//   public java.lang.String firstName();
//   public java.lang.String lastName();
//   public void lastName_$eq(java.lang.String);
//   public Employee2(java.lang.String, java.lang.String);
// }

// So firstname is final variable, meaning once it is set, it won't change. This is because of val keywork.
// Here val keyword creates an accessor. firstName can only be accessed, and can't be updated
// Note: firstName variable and firstName method have same name.
// So if we access the <object>.firstName on object. we are actually accessing the method firstName.
// This is called Uniform access principal - i.e. Variable and Its parameterless method should be accessed with same syntax.

// And lastName variable is created but without final. Which means, we can update this variable.
// Also note lastName_$eq method. This is mutator, which will be used to update the variable.
// So if you call <object>.lastname = "Some value", this mutator will be called.
// See 18.2.ClassExample.scala for usage of these classes

// As you noticed, these are accessors and Mutators. If you also need Java Style Getter (get<property name>)
// and Setter (set<property name>), you can use BeansProperty annotations
// as follow
import scala.beans.BeanProperty

class Employee3(
    @BeanProperty val firstName: String,
    @BeanProperty var lastName: String
)

// So if we compile and see the Employee3.class, you will see following

// public class Employee3 {
//   private final java.lang.String firstName;
//   private java.lang.String lastName;
//   public java.lang.String firstName();
//   public java.lang.String lastName();
//   public void lastName_$eq(java.lang.String);
//   public java.lang.String getFirstName();
//   public java.lang.String getLastName();
//   public void setLastName(java.lang.String);
//   public Employee3(java.lang.String, java.lang.String);
// }

// Note: Along with Scala Accessors firstName() & lastName(), there are also a Getters getFirstName() & getLastName()
// And with Mutator lastName_$eq(), there is Setter setLastName()
